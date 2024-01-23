package cn.bestsec.vulweb.controller;


import cn.bestsec.vulweb.service.XStreamVulService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * xstream漏洞接口
 */
@RestController
@RequestMapping("/xstream")
public class XStreamVulController {
    private final XStreamVulService xStreamVulService;

    public XStreamVulController(XStreamVulService xStreamVulService) {
        this.xStreamVulService = xStreamVulService;
    }

    @RequestMapping("/fromxml")
    public String fromXML(String p) {
        return xStreamVulService.fromXML(p);
    }

    @RequestMapping("/fromxmlurl")
    public String fromXMLURL(String p) {
        return xStreamVulService.fromURL(p);
    }

    @RequestMapping("/fromstream")
    public String fromStream(String p) {
        return xStreamVulService.fromStream(p);
    }

}
