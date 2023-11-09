package cn.bestsec.vulweb.controller;

import cn.bestsec.vulweb.service.SSRFService;
import cn.bestsec.vulweb.service.SSRFService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ssrf")
public class SSRFController {

    private final SSRFService ssrfService;
    private final SSRFService2 ssrfService2;
    @Autowired
    public SSRFController(SSRFService ssrfService, SSRFService2 ssrfService2) {
        this.ssrfService = ssrfService;
        this.ssrfService2 = ssrfService2;
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
    public String level3(String p) {
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

    @RequestMapping("/level7")
    public String level7(String p){
        return ssrfService.level7(p);
    }

    @RequestMapping("/level8")
    public String level8(String p){
        return ssrfService.level8(p);
    }

    @RequestMapping("/level9")
    public String level9(String p){
        return ssrfService2.level9(p);
    }

    @RequestMapping("/level10")
    public String level10(String p){
        return ssrfService2.level10(p);
    }

    @RequestMapping("/level11")
    public String level11(String p){
        return ssrfService2.level11(p);
    }

    @RequestMapping("/level12")
    public String level12(String p){
        return ssrfService2.level12(p);
    }

    @RequestMapping("/level13")
    public String level13(String p){
        return ssrfService2.level13(p);
    }
}
