package cn.bestsec.vulweb.controller;


import cn.bestsec.vulweb.service.XMLDecoderVul;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/xml")
public class XMLDecoderController {
    private XMLDecoderVul xmlDecoderVul;

    public XMLDecoderController(XMLDecoderVul xmlDecoderVul) {
        this.xmlDecoderVul = xmlDecoderVul;
    }

    @RequestMapping("decode")
    public String parse(String p) {
        return xmlDecoderVul.parse(p);
    }
}
