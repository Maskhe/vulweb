package cn.bestsec.vulweb.service.impl;

import cn.bestsec.vulweb.service.UnsafeReadlineService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.Socket;

/**
 * @author hjx
 * @since 2024/1/30
 */
@Service
@Slf4j
public class UnsafeReadlineServiceImpl implements UnsafeReadlineService {
    @Override
    public String readLine(String host) {
        String line;
        try (Socket socket = new Socket(host, 9999)) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // readLine是阻塞方法，读取不到换行符会一直等待，所以读取网络连接的数据流时此处可能造成阻塞
            while ((line = bufferedReader.readLine()) != null) {
                log.info(line);
            }
        } catch (Exception ignored){
            log.error("网络错误");
        }

        return "readLine执行完成！";
    }
}
