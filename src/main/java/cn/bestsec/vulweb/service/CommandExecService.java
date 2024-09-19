package cn.bestsec.vulweb.service;


/**
 * @author hjxin
 * @since 2023/11/13
 * 命令执行相关漏洞代码段
 */
public interface CommandExecService {

    /**
     * Runtime.getRuntime().exec()执行命令并获取结果
     * @param cmd 命令
     * @return 命令执行结果
     */
    String level1(String cmd, String[] env);

    /**
     * ProcessBuilder执行命令并获取结果
     * @param cmd 命令
     * @return 命令执行结果
     */
    String level2(String cmd);

    /**
     * Apache Commons Exec 执行命令并获取结果
     * @param cmd 命令
     * @return 命令执行结果
     */
    String level3(String cmd);

    String level4(String cmd);

}
