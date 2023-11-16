package cn.bestsec.vulweb.controller;

import cn.bestsec.vulweb.service.UnsafeReflectionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reflection")
public class UnsafeReflectionController {
    private UnsafeReflectionService service;
    public UnsafeReflectionController(UnsafeReflectionService service){
        this.service = service;
    }

    @RequestMapping("/level1")
    public String level1(String className, String arg){
        return service.invoke(className, arg);
    }
}
