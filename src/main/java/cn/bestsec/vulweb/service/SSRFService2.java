package cn.bestsec.vulweb.service;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.client5.http.ssl.NoopHostnameVerifier;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.ssl.SSLContexts;
import org.apache.hc.core5.ssl.TrustStrategy;
import org.springframework.stereotype.Service;

import javax.net.ssl.SSLContext;

@Service
public class SSRFService2 {
    public String level9(String url){
        String responseContent = "";
        try {
            SSLContext sslContext = SSLContexts.custom()
                    .loadTrustMaterial(new TrustStrategy() {
                        @Override
                        public boolean isTrusted(java.security.cert.X509Certificate[] chain, String authType) {
                            return true;
                        }
                    })
                    .build();

            CloseableHttpClient httpClient = HttpClients.custom()
                    .build();
            HttpGet httpGet = new HttpGet(url);
            CloseableHttpResponse response = httpClient.execute(httpGet);

            try {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    responseContent = EntityUtils.toString(entity);
                    System.out.println(responseContent);
                }
            } finally {
                response.close();
            }
            httpClient.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseContent;
    }
}
