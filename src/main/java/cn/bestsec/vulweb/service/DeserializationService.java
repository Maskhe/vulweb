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
    public String level1(String file);
}
