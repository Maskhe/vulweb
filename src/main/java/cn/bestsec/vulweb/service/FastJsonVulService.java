package cn.bestsec.vulweb.service;

/**
 * fastjson反序列化漏洞代码
 * @author hjx
 * @since 2024/1/11
 */
public interface FastJsonVulService {
    /**
     * fastjson parse方法反序列化
     * @param json 恶意构造的json字符串
     * @return 反序列化结果
     */
    String parse(String json);

    /**
     * fastjson parseObj方法反序列化
     * @param json 恶意构造的json字符串
     * @return 反序列化结果
     */
    String parseObj(String json);

    /**
     * fastjson parseArray方法反序列化
     * @param json 恶意构造的json字符串
     * @return 反序列化结果
     */
    String parseArr(String json);

    /**
     * fastjson 反序列化
     * @param json 恶意构造的json字符串
     * @return 反序列化结果
     */
    String parseBytes(String json);
}
