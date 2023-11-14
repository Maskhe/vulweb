package cn.bestsec.vulweb.service.impl;

import cn.bestsec.vulweb.service.SSRFService;
import cn.bestsec.vulweb.utils.HttpClientUtil;
import okhttp3.*;
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
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.HashMap;

/**
 * @author hjxin
 * @since 2023/11/10
 */

@Service
public class SSRFServiceImpl implements SSRFService {
    @Override
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

    @Override
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

    @Override
    public String level3(String url){
        /*
        httpclient
         */
        try(CloseableHttpClient httpClient = HttpClients.createDefault()){
            HttpGet httpGet = new HttpGet(url);
            CloseableHttpResponse response = httpClient.execute(httpGet);
            return EntityUtils.toString(response.getEntity(), "utf-8");
        }catch(Exception e){
            return e.getMessage();
        }
    }

    @Override
    public String level4(String url){
        /*
        不hook HttpPost类，仅仅hook URI构造函数的情况下是否能够发现此处漏洞
         */
        try(CloseableHttpClient httpClient = HttpClients.createDefault()){
            HttpPost httpPost = new HttpPost(url);
//            httpPost.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36");
            CloseableHttpResponse response = httpClient.execute(httpPost);
            return EntityUtils.toString(response.getEntity(), "utf-8");
        }catch(Exception e){
            return e.getMessage();
        }
    }

    @Override
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

    @Override
    public String level6(String url){
        /*
        httpclient get请求，带参数
         */
        try{
            HttpClient connection = HttpClientUtil.getConnection();
            HttpUriRequest request = HttpClientUtil.getRequestMethod(new HashMap<String, String>(){{put("p", "123");}}, url, "get");

            HttpResponse response = connection.execute(request);
            return EntityUtils.toString(response.getEntity(), "utf-8");

        }catch (Exception e){
            return e.getMessage();
        }
    }

    @Override
    public String level7(String url){
        /*
        okhttp3 同步get请求
         */
        OkHttpClient client = new OkHttpClient();
        String responseBodyString = "未获取到响应";
        try {
            Request request = new Request.Builder()
                    .url(url)
                    .build();
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                ResponseBody responseBody = response.body();
                if (responseBody != null) {
                    responseBodyString = responseBody.string();
                }
            } else {
                responseBodyString = "Request failed with code: " + response.code();
            }
            response.close();
        } catch (Exception e) {
            return e.toString();
        }
        return responseBodyString;
    }

    @Override
    public String level8(String url){
        /*
        okhttp3 异步get请求
         */
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url) // 指定要访问的 URL
                .build();

        // 异步执行请求
        Call call = client.newCall(request);
        call.enqueue(new okhttp3.Callback() {
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    String responseBody = response.body().string();
                    System.out.println("Response Body: " + responseBody);
                } else {
                    System.out.println("Request failed with code: " + response.code());
                }
            }

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }
        });
        return "异步请求已发出";
    }
    // todo: okhttp4采用kotlin语言开发，也需要找解决方案。


}
