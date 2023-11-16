package cn.bestsec.vulweb.controller;


import cn.bestsec.vulweb.service.DeserializationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/deser")
public class DeserializationController {
    DeserializationService deserializationService;
    public DeserializationController(DeserializationService deserializationService){
        this.deserializationService = deserializationService;
    }
    @RequestMapping("/level1")
    public String level1(String p){
        return deserializationService.level1(p);
    }

    @RequestMapping("/level2")
    public String level2(String p){
        return deserializationService.level2(p);
    }

    @RequestMapping("/level3")
    public String level3(String p){
        return deserializationService.level3(p);
    }
}
