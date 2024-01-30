package cn.bestsec.vulweb.controller;


import cn.bestsec.vulweb.service.UnsafeReadlineService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
