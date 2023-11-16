package cn.bestsec.vulweb.service;

/**
 * @author hjxin
 * @since 2023/11/14
 */
public interface DeserializationService {
    /**
     * 从指定文件中读取数据流并进行反序列化
     * @param file 文件路径
     * @return 反序列化执行情况
     */
    String fileDeserialize(String file);

    /**
     * 从指定url地址读取数据流并进行反序列化
     * @param url url地址
     * @return String 反序列化执行情况
     */
    String httpDeserialize(String url);

    /**
     * 从指定host读取tcp数据流并进行反序列化
     * @param host 主机地址，eg: localhost、127.0.0.1
     * @return String 反序列化执行情况
     */
    String tcpDeserialize(String host);
}
