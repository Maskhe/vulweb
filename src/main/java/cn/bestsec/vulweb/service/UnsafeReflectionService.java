package cn.bestsec.vulweb.service;

/**
 * 不安全的反射漏洞代码
 * @author hjxin
 * @since 2023/11/14
 */
public interface UnsafeReflectionService {
    /**
     * 通过类名实例化对应类，并调用其toString方法
     * @param className 类名
     * @param arg toString方法接受的参数
     * @return
     */
    String level1(String className, String arg);
}
