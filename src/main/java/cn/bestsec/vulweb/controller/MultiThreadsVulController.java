package cn.bestsec.vulweb.controller;

import cn.bestsec.vulweb.service.MultiThreadsVulService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hjx
 * @since 2024/1/10
 */
@RestController
@RequestMapping("/multi")
public class MultiThreadsVulController {
    MultiThreadsVulService multiThreadsVulService;
    MultiThreadsVulController(MultiThreadsVulService multiThreadsVulService){
        this.multiThreadsVulService = multiThreadsVulService;
    }

    @RequestMapping("/level1")
    public String level1(String p) {
        multiThreadsVulService.cmdExec(p);
        return "命令执行成功";
    }
}
