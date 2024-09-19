package cn.bestsec.vulweb.service;

/**
 * 路径穿越漏洞代码
 * @author hjxin
 * @since 2023/11/10
 */
public interface PathTraversalService {
    /**
     * Paths.get() 任意文件读取漏洞
     * @param path 文件路径
     * @return String 文件内容
     * payload:
     * ../../../../../../../../../../../../Windows/win.ini
     * ../../../../../../../../../../../../etc/passwd
     */
    String level1(String path);

    /**
     * FileReader() 任意文件读取漏洞
     * @param path 文件路径
     * @return String 文件内容
     * payload:
     * ../../../../../../../../../../../../Windows/win.ini
     * ../../../../../../../../../../../../etc/passwd
     */
    String level2(String path);

    /**
     * Paths.get 任意文件读取漏洞，仅能控制文件目录，无法控制文件名
     * @param path 文件目录
     * @return String 文件内容
     * payload:
     * ../../../../../../../../../../../../Windows/win.ini
     * ../../../../../../../../../../../../etc/passwd
     */
    String level3(String path);

    /**
     * new File() 任意文件读取漏洞
     * @param path 文件路径
     * @return String 文件内容
     * payload:
     * ../../../../../../../../../../../../Windows/win.ini
     * ../../../../../../../../../../../../etc/passwd
     */
    String level4(String path);

    /**
     * RandomAccessFile 任意文件读取漏洞
     * @param path 文件路径
     * @return String 文件内容
     * payload:
     * ../../../../../../../../../../../../Windows/win.ini
     * ../../../../../../../../../../../../etc/passwd
     */
    String level5(String path);

    /**
     * FileOutputStream 任意文件写入漏洞
     * @param path 文件路径
     * @return String 写入结果
     * payload: 主机上任意当前用户有权限访问路径，测试时注意不要传入重要文件路径，防止文件内容被覆盖
     */
    String level6(String path);

    String level7(String path, String file);
}
