package cn.bestsec.vulweb.service;

/**
 * JNDI注入漏洞代码
 * @author hjxin
 * @since 2023/12/6
 */
public interface JNDIService {
    /**
     * JNDI获取远程对象
     * @param name 远程对象名
     * @return string JNDI lookup执行情况
     * 漏洞验证方式：输入 rmi://域名，查看dnslog平台是否有dns记录，如果有则证明存在漏洞，<a href="http://www.dnslog.cn/">常用的dnslog平台</a>
     */
    String lookup(String name);
}
