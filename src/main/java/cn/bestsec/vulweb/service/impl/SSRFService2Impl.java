package cn.bestsec.vulweb.service.impl;

import cn.bestsec.vulweb.service.SSRFService2;
import com.squareup.okhttp.OkHttpClient;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.fluent.Request;
import org.apache.hc.client5.http.fluent.Response;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.message.BasicNameValuePair;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author hjxin
 * @since 2023/11/10
 */

@Service
public class SSRFService2Impl implements SSRFService2 {
    @Override
    public String level9(String url){
        /*
        httpclient5 get请求
         */
        String responseContent = "";
        try {
            CloseableHttpClient httpClient = HttpClients.custom()
                    .build();
            HttpGet httpGet = new HttpGet(url);
            CloseableHttpResponse response = httpClient.execute(httpGet);

            try {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    responseContent = EntityUtils.toString(entity);
                }
            } finally {
                response.close();
            }
            httpClient.close();
        } catch (Exception e) {
            return e.toString();
        }
        return responseContent;
    }

    @Override
    public String level10(String url){
        /*
        httpclient5 fluent api写法
         */
        String result;
        try {
            Response response = Request.get(url).execute();
            result = response.returnContent().asString();
        } catch (Exception e) {
            return e.toString();
        }
        return result;
    }

    @Override
    public String level11(String url){
        /*
        httpclient5 fluent api post请求
         */
        String result = null;
        Request request = Request.post(url);
        // POST 请求参数
        request.bodyForm(
                new BasicNameValuePair("username", "test"),
                new BasicNameValuePair("password", "test"));
        try {
            result = request.execute().returnContent().asString();
        } catch (Exception e) {
            return e.toString();
        }
        return result;
    }

    @Override
    public String level12(String url){
        /*
        okhttp2 发起同步请求
         */
        OkHttpClient client = new OkHttpClient();
        com.squareup.okhttp.Request request = new com.squareup.okhttp.Request.Builder()
                .url(url)
                .build();
        String responseBody = "";
        try {
            com.squareup.okhttp.Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                responseBody = response.body().string();
            } else {
                return "请求失败: " + response.code();
            }
        } catch (Exception e) {
            return e.toString();
        }
        return responseBody;
    }

    @Override
    public String level13(String url){
        /*
        okhttp2 发起异步请求
         */
        OkHttpClient client = new OkHttpClient();
        com.squareup.okhttp.Request request = new com.squareup.okhttp.Request.Builder()
                .url(url)
                .build();

        // 异步执行请求
        com.squareup.okhttp.Call call = client.newCall(request);
        call.enqueue(new com.squareup.okhttp.Callback() {
            @Override
            public void onFailure(com.squareup.okhttp.Request request, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(com.squareup.okhttp.Response response) throws IOException {
                if (response.isSuccessful()) {
                    String responseBody = response.body().string();
                    System.out.println("Response Body: " + responseBody);
                } else {
                    System.out.println("Request failed with code: " + response.code());
                }
            }
        });
        return "异步请求已发出";
    }
}
