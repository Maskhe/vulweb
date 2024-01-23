package cn.bestsec.vulweb.test;

import lombok.Getter;

import java.io.*;

/**
 * 预埋的恶意类
 * @author hjx
 * @since 2024/1/10
 */
@Getter
public class Evil implements Serializable {
    Evil(){}

    Evil(String payload) {
        this.payload = payload;
    }

    private String payload;

    /**
     * fastjson反序列化会触发当前方法造成命令执行
     * @param payload 攻击载荷
     * @throws IOException
     */
    public void setPayload(String payload) throws IOException {
        this.payload = payload;
        Process process = Runtime.getRuntime().exec(payload);
        InputStream inputStream = process.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "GBK");
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String line;
        StringBuilder result = new StringBuilder();
        while ((line = bufferedReader.readLine()) != null) {
            result.append(line);
        }

        System.out.println(result);
    }

    @Override
    public String toString() {
        return this.payload;
    }
}
