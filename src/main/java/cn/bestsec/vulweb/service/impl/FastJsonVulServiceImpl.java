package cn.bestsec.vulweb.service.impl;

import cn.bestsec.vulweb.service.FastJsonVulService;
import cn.bestsec.vulweb.test.Evil;
import cn.bestsec.vulweb.test.NotEvil;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

/**
 * @author hjx
 * @since 2024/1/10
 */
@Service
public class FastJsonVulServiceImpl implements FastJsonVulService {
    @Override
    public String parse(String json) {
        JSON.parse(json);
        return "fastjson反序列化执行成功！";
    }

    @Override
    public String parseObj(String json) {
        JSON.parseObject(json);
        return "fastjson反序列化执行成功！";
    }

    @Override
    public String parseArr(String json) {
        JSON.parseArray(json);
        return "fastjson反序列化执行成功";
    }

    @Override
    public String parseBytes(String json) {
        byte[] bytes;
        bytes = json.getBytes(StandardCharsets.UTF_8);
        JSON.parse(bytes);
        return "fastjson反序列化成功";
    }
}
