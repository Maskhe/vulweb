package cn.bestsec.vulweb.controller;


import cn.bestsec.vulweb.service.ReDosService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redos")
public class ReDosController {
    ReDosService service;
    public ReDosController(ReDosService service){
        this.service = service;
    }
    @RequestMapping("/level1")
    public String level1(String p){
        return service.patternMatcher(p);
    }
}
