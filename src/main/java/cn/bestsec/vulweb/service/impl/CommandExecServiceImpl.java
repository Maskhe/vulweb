package cn.bestsec.vulweb.service.impl;

import cn.bestsec.vulweb.service.CommandExecService;
import org.apache.commons.exec.*;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;

/**
 * @author hjxin
 * @since 2023/11/13
 */
@Service
public class CommandExecServiceImpl implements CommandExecService {
    @Override
    public String level1(String cmd) {

        try {
            String newLine = System.getProperty("line.separator");
            Process process = Runtime.getRuntime().exec(cmd);
            process.waitFor();
            BufferedReader bf = new BufferedReader(new InputStreamReader(process.getInputStream(), "GBK"));
            String line;
            StringBuilder res = new StringBuilder();
            while((line = bf.readLine()) != null){
                res.append(line);
                res.append(newLine);
            }
            bf.close();
            return res.toString();
        } catch (Exception e) {
            return e.toString();
        }

    }

    @Override
    public String level2(String cmd) {
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

    @Override
    public String level3(String cmd) {
        try {

            // 创建命令行对象
            CommandLine cmdLine = CommandLine.parse(cmd);

            // 创建执行器
            DefaultExecutor executor = new DefaultExecutor();

            // 设置超时时间（可选）
            executor.setWatchdog(new ExecuteWatchdog(60000)); // 60秒
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            PumpStreamHandler pumpStreamHandler = new PumpStreamHandler(outputStream);
            executor.setStreamHandler(pumpStreamHandler);
            executor.execute(cmdLine);
            return outputStream.toString("GBK");
        } catch (IOException e) {
            return e.toString();
        }
    }
}
