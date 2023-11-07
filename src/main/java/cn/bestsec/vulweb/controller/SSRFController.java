package cn.bestsec.vulweb.controller;

import cn.bestsec.vulweb.service.SSRFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ssrf")
public class SSRFController {

    private final SSRFService ssrfService;
    @Autowired
    public SSRFController(SSRFService ssrfService) {
        this.ssrfService = ssrfService;
    }

    @RequestMapping("/level1")
    public String level1(String p){
        return ssrfService.level1(p);
    }

    @RequestMapping("/level2")
    public String level2(String protocol, String host, String file){
        return ssrfService.level2(protocol, host, file);
    }

    @RequestMapping("/level3")
    public String level3(String p) throws ClassNotFoundException {
        Class<?> cl = Class.forName("org.apache.http.HttpRequest");

        return ssrfService.level3(p);
    }

    @RequestMapping("/level4")
    public String level4(String p){
        return ssrfService.level4(p);
    }

    @RequestMapping("/level5")
    public String level5(String p){
        return ssrfService.level5(p);
    }

    @RequestMapping("/level6")
    public String level6(String p){
        return ssrfService.level6(p);
    }
}
