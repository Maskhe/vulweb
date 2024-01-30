package cn.bestsec.vulweb.service;

/**
 * 不安全的readline漏洞代码示例
 */
public interface UnsafeReadlineService {

    /**
     * readline调用
     * @param host 主机地址
     * @return readline执行是否完成
     * 漏洞验证方法：本机使用netcat监听9999端口，然后请求该接口，host传值“localhost”，若本接口阻塞则证明漏洞存在
     */
    String readLine(String host);
}
