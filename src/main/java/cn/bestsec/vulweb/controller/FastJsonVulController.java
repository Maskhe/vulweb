package cn.bestsec.vulweb.controller;

import cn.bestsec.vulweb.service.FastJsonVulService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author hjx
 * @since 2024/1/10
 */
@RestController
@RequestMapping("/fastjson")
public class FastJsonVulController {
    private final FastJsonVulService fastJsonVulService;

    public FastJsonVulController(FastJsonVulService fastJsonVulService) {
        this.fastJsonVulService = fastJsonVulService;
    }

    @RequestMapping("/parse")
    public String parse(String p) {
        return this.fastJsonVulService.parse(p);
    }

    @RequestMapping("/parseObj")
    public String parseObj(String p) {
        return this.fastJsonVulService.parseObj(p);
    }

    @RequestMapping("/parseArr")
    public String parseArr(String p) {
        return this.fastJsonVulService.parseArr(p);
    }

    @RequestMapping("/parseBytes")
    public String parseBytes(String p) {
        return this.fastJsonVulService.parseBytes(p);
    }
}
