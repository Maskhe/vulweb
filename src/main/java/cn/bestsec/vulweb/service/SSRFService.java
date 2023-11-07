package cn.bestsec.vulweb.service;

import cn.bestsec.vulweb.utils.HttpClientUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;


@Service
public class SSRFService {
    public String level1(String url){
        /*
        HttpURLConnection
         */
        try{
            URL uri = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) uri.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            int responseCode = connection.getResponseCode();
            if(responseCode == HttpURLConnection.HTTP_OK){
                InputStream inputStream = connection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String line = "";
                StringBuilder response = new StringBuilder();
                while((line = bufferedReader.readLine()) != null){
                    response.append(line).append("\n");
                }
                return response.toString();
            }
            return "状态码异常！";
        }catch(Exception e){
            return e.getMessage();
        }
    }

    public String level2(String protocol, String host, String file){
        /*
        HttpURLConnection
         */
        try{
            URL uri = new URL(protocol, host, file);
            HttpURLConnection connection = (HttpURLConnection) uri.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            return connection.getResponseMessage();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String level3(String url){
        try(CloseableHttpClient httpClient = HttpClients.createDefault()){
            HttpGet httpGet = new HttpGet(url);
            CloseableHttpResponse response = httpClient.execute(httpGet);
            return EntityUtils.toString(response.getEntity(), "utf-8");
        }catch(Exception e){
            return e.getMessage();
        }
    }

    public String level4(String url){
        /*
        不hook HttpPost类，仅仅hook URI构造函数的情况下是否能够发现此处漏洞
         */
        try(CloseableHttpClient httpClient = HttpClients.createDefault()){
            HttpPost httpPost = new HttpPost(url);
            httpPost.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36");
            CloseableHttpResponse response = httpClient.execute(httpPost);
            return EntityUtils.toString(response.getEntity(), "utf-8");
        }catch(Exception e){
            return e.getMessage();
        }
    }

    public String level5(String url){
        /*
        URIBuilder底层是调用了java.net.URI构造函数，不用再hook它
         */
        try(CloseableHttpClient httpClient = HttpClients.createDefault()){
            URI uri = new URIBuilder(url).setParameter("wd", "java").build();
            HttpGet httpGet = new HttpGet(uri);

            CloseableHttpResponse response = httpClient.execute(httpGet);
            return EntityUtils.toString(response.getEntity(), "utf-8");
        }catch(Exception e){
            return e.getMessage();
        }
    }

    public String level6(String url){
        try{
            HttpClient connection = HttpClientUtil.getConnection();
            HttpUriRequest request = HttpClientUtil.getRequestMethod(new HashMap<String, String>(){{put("p", "123");}}, url, "get");

            HttpResponse response = connection.execute(request);
            return EntityUtils.toString(response.getEntity(), "utf-8");

        }catch (Exception e){
            return e.getMessage();
        }

    }
}
