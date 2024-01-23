package cn.bestsec.vulweb.service;


/**
 * hql注入漏洞代码示例
 * @author hjx
 * @since 2024/1/16
 */
public interface HQLInjectionService {
    /**
     * hibernate使用hql语句查询数据库
     * @param p 用户可控数据
     * @return 数据库查询结果
     */
    String createQuery(String p);

}
