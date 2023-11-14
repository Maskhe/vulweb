package cn.bestsec.vulweb.entity;

import lombok.Data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 一个恶意类，toString方法可以用来执行命令
 * @author hjxin
 * @since 2023/11/14
 */
@Data
public class EvilClass {
    public void EvilClass(){

    }
    public String toString(String cmd){
        try {
            ProcessBuilder processBuilder = new ProcessBuilder(cmd);
            processBuilder.redirectErrorStream(true); // 将错误流合并到输出流
            Process process = processBuilder.start();

            // 读取命令执行结果
            StringBuilder res = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream(), "GBK"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    res.append(line);
                    res.append("\n");
                }
            }
            int exitCode = process.waitFor();
            return res.toString();
        } catch (IOException | InterruptedException e) {
            return e.toString();
        }
    }
}
