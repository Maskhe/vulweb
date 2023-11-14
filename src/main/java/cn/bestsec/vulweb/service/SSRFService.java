package cn.bestsec.vulweb.service;

/**
 * @author hjxin
 * @since 2023/11/10
 * SSRF漏洞相关代码段
 */
public interface SSRFService {
    /**
     * HttpURLConnection 发起get请求
     * @param url 目标url
     * @return 响应内容 | 异常信息
     */
    String level1(String url);

    /**
     * HttpURLConnection 发起get请求
     * @param protocol 协议
     * @param host 主机地址
     * @param file 请求路径
     * @return 响应内容 | 异常信息
     */
    String level2(String protocol, String host, String file);

    /**
     * HttpClient 发起get请求
     * @param url 目标url
     * @return 响应内容 | 异常信息
     */
    String level3(String url);

    /**
     * HttpClient 发起post请求
     * @param url 目标url
     * @return 响应内容 | 异常信息
     */
    String level4(String url);

    /**
     * HttpClient 发起get请求，采用URIBuilder方式
     * @param url 目标url
     * @return 响应内容 | 异常信息
     */
    String level5(String url);

    /**
     * HttpClient 发起get请求，带参数
     * @param url 目标url
     * @return 响应内容 | 异常信息
     */
    String level6(String url);

    /**
     * OkHttp3 发起同步get请求
     * @param url 目标url
     * @return 响应内容 | 异常信息
     */
    String level7(String url);

    /**
     * OkHttp3 发起异步get请求
     * @param url 目标url
     * @return 响应内容 | 异常信息
     */
    String level8(String url);
}
