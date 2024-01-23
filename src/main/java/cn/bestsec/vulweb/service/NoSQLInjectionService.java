package cn.bestsec.vulweb.service;


/**
 * nosql注入漏洞
 * @author hjx
 * @since 2023/1/10
 * 漏洞验证方式：搭建mongodb，创建数据库test,创建collection名为cl，并插入测试数据，测试数据内容无特殊要求
 * 使用下面的方法查询能正常返回结果则存在漏洞
 */
public interface NoSQLInjectionService {
    /**
     * 使用用户指定的语句查询mongodb
     * @param query 查询语句
     * @return 查询结果
     */
    String query(String query);

    /**
     * 不存在漏洞的查询方式
     * @param query 查询条件
     * @return 查询结果
     */
    String queryNotVul(String query);

    /**
     * 根据用户指定信息删除特定数据
     * @param filter 用户指定条件
     * @return 删除语句执行结果
     */
    String delete(String filter);

    /**
     * 使用用户指定语句查询mongodb
     * @param filter 查询语句
     * @return 查询结果
     */
    String distinct(String filter);

    /**
     * 执行用户指定的mongodb命令
     * @param key 命令的key
     * @param value 命令的value
     * @return 命令执行的结果
     */
    String runCommand(String key, String value);
}
