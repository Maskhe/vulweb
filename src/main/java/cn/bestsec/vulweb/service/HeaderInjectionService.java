package cn.bestsec.vulweb.service;

import javax.servlet.http.HttpServletResponse;

/**
 * http响应头注入漏洞
 * @author hjx
 * @since 2024/1/30
 */
public interface HeaderInjectionService {
    /**
     * 设置响应头
     * @param response http响应对象
     * @param value 响应头的值
     * @return http响应对象
     */
    HttpServletResponse setHeader(HttpServletResponse response, String value);

    /**
     * 设置响应头
     * @param response http响应对象
     * @param value 响应头的值
     * @return http响应对象
     */
    HttpServletResponse addHeader(HttpServletResponse response, String value);

}
