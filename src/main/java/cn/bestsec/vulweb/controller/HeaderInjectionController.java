package cn.bestsec.vulweb.controller;

import cn.bestsec.vulweb.service.HeaderInjectionService;
import org.apache.http.HttpResponse;
import org.apache.http.message.BasicHttpResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/crlf")
public class HeaderInjectionController {
    private final HeaderInjectionService headerInjectionService;

    public HeaderInjectionController(HeaderInjectionService headerInjectionService) {
        this.headerInjectionService = headerInjectionService;
    }

    @RequestMapping("/level1")
    public String level1(HttpServletResponse httpServletResponse, String value){
        this.headerInjectionService.setHeader(httpServletResponse, value);
        return "test";
    }

}
