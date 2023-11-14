package cn.bestsec.vulweb.service;

/**
 * @author hjxin
 * @since 2023/11/10
 * SSRF漏洞相关代码段
 */
public interface SSRFService2 {
    /**
     * HttpClient5 发起get请求
     * @param url 目标url
     * @return 响应内容 | 异常信息
     */
    String level9(String url);

    /**
     * HttpClient5 Fluent API 方式发起get请求
     * @param url 目标url
     * @return 响应内容 | 异常信息
     */
    String level10(String url);

    /**
     * HttpClient5 Fluent API 方式发起post请求
     * @param url 目标url
     * @return 响应内容 | 异常信息
     */
    String level11(String url);

    /**
     * OkHttp2 发起同步get请求
     * @param url 目标url
     * @return 响应内容 | 异常信息
     */
    String level12(String url);

    /**
     * OkHttp3 发起异步get请求
     * @param url 目标url
     * @return 响应内容 | 异常信息
     */
    String level13(String url);
}
