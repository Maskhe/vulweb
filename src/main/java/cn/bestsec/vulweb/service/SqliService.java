package cn.bestsec.vulweb.service;

import java.util.List;

/**
 * sql注入漏洞代码
 * @author hjx
 * @since 2023/11/10
 */
public interface SqliService {
    String level1(String p);

    List<?> level2(String p);

    String level3(String p);

    List<?> level4(String p);

    String level5(String p);

    String level6(String p);

    String level7(String p);

    String level8(String p);

    String level9(String p);

    String level10(String p);

    String level11(String p);

    String level12(String p);

    String level13(String p);

    String level14(String p);

    String level15(int p);

    String level16(String p);

    String level17(String p);

    String level18(String p);

    /**
     * jpa createNativeQuery方法执行sql语句
     * @param p 用户输入
     * @return 数据库查询结果
     */
    String level19(String p);
}
