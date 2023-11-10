package cn.bestsec.vulweb.service.impl;

import cn.bestsec.vulweb.service.PathTraversalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
@Slf4j
public class PathTraversalServiceImpl implements PathTraversalService {
    @Override
    public String level1(String path){
        log.info(path);
        Path filePath = Paths.get(path);
        StringBuilder content = new StringBuilder();
        try {
            List<String> lines = Files.readAllLines(filePath, StandardCharsets.UTF_8);
            for(String line: lines){
                content.append(line);
            }
        } catch (IOException e) {
            log.error(e.toString());
            return e.toString();
        }
        return content.toString();
    }

    @Override
    public String level2(String path){
        StringBuilder content = new StringBuilder();
        try {
            FileReader fileReader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                content.append(line);
            }
            bufferedReader.close();
        } catch (IOException e) {
            return e.toString();
        }
        return content.toString();
    }

    @Override
    public String level3(String path){
        log.info(path);
        Path filePath = Paths.get(path, "123.txt");
        StringBuilder content = new StringBuilder();
        try {
            List<String> lines = Files.readAllLines(filePath, StandardCharsets.UTF_8);
            for(String line: lines){
                content.append(line);
            }
        } catch (IOException e) {
            log.error(e.toString());
            return e.toString();
        }
        return content.toString();
    }

    @Override
    public String level4(String path){
        StringBuilder content = new StringBuilder();
        try {
            File file = new File(path);
            FileReader fileReader = new FileReader(file);
            int chr;

            while ((chr = fileReader.read()) != -1) {
                System.out.print((char) chr);
                content.append((char) chr);
            }
            fileReader.close();
        } catch (IOException e) {
            return e.toString();
        }
        return content.toString();
    }

    @Override
    public String level5(String path){
        String content = "";
        try {
            RandomAccessFile raf = new RandomAccessFile(path, "r");
            raf.seek(0);
            byte[] buffer = new byte[1024];
            int bytesRead = raf.read(buffer);
            content = new String(buffer, 0, bytesRead);
            raf.close();
        } catch (IOException e) {
            return e.toString();
        }
        return content;
    }

    @Override
    public String level6(String path) {
        String data = "写入的内容";
        try (FileOutputStream fos = new FileOutputStream(path)) {
            // 将字符串转换为字节数组并写入文件
            byte[] bytes = data.getBytes();
            fos.write(bytes);

        } catch (IOException e) {
            return e.toString();
        }
        return "内容成功写入" + path;
    }


}
