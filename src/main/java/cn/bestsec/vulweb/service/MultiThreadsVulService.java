package cn.bestsec.vulweb.service;

/**
 * 多线程场景下的命令注入漏洞
 */
public interface MultiThreadsVulService {
    /**
     * 执行用户传入的命令
     * @param cmd 待执行的命令
     */
    void cmdExec(String cmd);
}
