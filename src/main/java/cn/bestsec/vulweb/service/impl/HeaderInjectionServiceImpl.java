package cn.bestsec.vulweb.service.impl;

import cn.bestsec.vulweb.service.HeaderInjectionService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;

/**
 * @author hjx
 * @since 2024/1/30
 */
@Service
public class HeaderInjectionServiceImpl implements HeaderInjectionService {
    @Override
    public HttpServletResponse setHeader(HttpServletResponse response, String value) {
        response.setHeader("test", value); //xxx \r\n Set-Cookie: www.baidu.com
        return response;
    }

    @Override
    public HttpServletResponse addHeader(HttpServletResponse response, String value) {
        response.addHeader("test", value);
        return response;
    }
}
