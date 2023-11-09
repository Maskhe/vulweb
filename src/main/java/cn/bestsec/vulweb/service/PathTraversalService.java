package cn.bestsec.vulweb.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class PathTraversalService {
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
}
