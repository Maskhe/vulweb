package cn.bestsec.vulweb.controller;


import cn.bestsec.vulweb.service.JNDIService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author hjxin
 * @since 2023/12/6
 */
@RestController
@RequestMapping("/jndi")
public class JNDIController {

    private JNDIService jndiService;

    public JNDIController(JNDIService jndiService) {
        this.jndiService = jndiService;
    }
    @RequestMapping("/lookup")
    public String lookup(String p) {
        return jndiService.lookup(p);
    }
}
