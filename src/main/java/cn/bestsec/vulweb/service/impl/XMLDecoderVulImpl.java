package cn.bestsec.vulweb.service.impl;

import cn.bestsec.vulweb.service.XMLDecoderVul;
import cn.bestsec.vulweb.test.Person;
import org.springframework.stereotype.Service;

import java.beans.XMLDecoder;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * XMLDecoder反序列化漏洞代码
 * @author hjxin
 * @since 2023/12/8
 */
@Service
public class XMLDecoderVulImpl implements XMLDecoderVul {
    @Override
    public String parse(String document) {
        InputStream inputStream = new ByteArrayInputStream(document.getBytes(StandardCharsets.UTF_8));
        System.out.println(document);
        XMLDecoder xmlDecoder = new XMLDecoder(inputStream);
        Person person = (Person)xmlDecoder.readObject();
        System.out.println(person.getName());
        xmlDecoder.close();
        return "xmldecoder反序列化执行！";
    }
}
