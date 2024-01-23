package cn.bestsec.vulweb.service.impl;

import cn.bestsec.vulweb.service.XStreamVulService;
import com.thoughtworks.xstream.XStream;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.net.URL;

/**
 * @author hjx
 * @since 2024/1/16
 */
@Service
public class XStreamVulServiceImpl implements XStreamVulService {
    @Override
    public String fromXML(String xml) {
        try {
            XStream xStream = new XStream();
            xStream.fromXML(xml);
        } catch (Exception ignored) {

        }

        return "xStream执行完成！";
    }

    @Override
    public String fromURL(String url) {
        URL target;
        try {
            target = new URL(url);
            XStream xStream = new XStream();
            xStream.fromXML(target);
        } catch (Exception ignored) {

        }

        return "xStream执行完成！";
    }

    @Override
    public String fromStream(String url) {
        URL target;
        InputStream inputStream = null;
        try {
            target = new URL(url);
            inputStream = target.openStream();
            XStream xStream = new XStream();
            xStream.fromXML(inputStream);
            inputStream.close();
        } catch (Exception ignored) {

        }
        return "xStream执行完成！";
    }
}
