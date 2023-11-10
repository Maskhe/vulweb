package cn.bestsec.vulweb.service;

public interface SSRFService {
    String level1(String url);

    String level2(String protocol, String host, String file);

    String level3(String url);

    String level4(String url);

    String level5(String url);

    String level6(String url);

    String level7(String url);

    String level8(String url);
}
