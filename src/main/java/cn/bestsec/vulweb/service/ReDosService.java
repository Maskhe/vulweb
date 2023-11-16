package cn.bestsec.vulweb.service;

/**
 * 正则拒绝服务漏洞代码
 * @author hjxin
 * @since 2023/11/14
 */
public interface ReDosService {
    /**
     * 匹配用户输入
     * @param content 用户输入
     * @return 正则表达式执行状态
     */
    public String patternMatcher(String content);
}
