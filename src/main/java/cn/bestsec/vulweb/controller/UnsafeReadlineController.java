package cn.bestsec.vulweb.controller;


import cn.bestsec.vulweb.service.UnsafeReadlineService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @author hjx
 * @since 2024/1/30
 */
@RestController
@RequestMapping("/readline")
public class UnsafeReadlineController {
    private final UnsafeReadlineService unsafeReadlineService;

    public UnsafeReadlineController(UnsafeReadlineService unsafeReadlineService) {
        this.unsafeReadlineService = unsafeReadlineService;
    }

    @RequestMapping("/level1")
    public String readline(String host) {
        return this.unsafeReadlineService.readLine(host);
    }

    @RequestMapping("/level2")
    public String readline2(String host) throws IOException {
        Socket socket = new Socket(host, 9999);
        String line = "123";
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        // readLine是阻塞方法，读取不到换行符会一直等待，所以读取网络连接的数据流时此处可能造成阻塞
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
        return line;
    }
}
