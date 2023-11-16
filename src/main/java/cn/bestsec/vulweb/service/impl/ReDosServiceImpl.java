package cn.bestsec.vulweb.service.impl;

import cn.bestsec.vulweb.service.ReDosService;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * @author hjxin
 * @since 2023/11/14
 */
@Service
public class ReDosServiceImpl implements ReDosService {
    @Override
    public String patternMatcher(String content) {
        String maliciousRegex = "(a+)+";

        // 输入字符串，包含大量的 'a'
//        String input = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaX";

        // 匹配正则表达式
        try {
            Pattern pattern = Pattern.compile(maliciousRegex);
            Matcher matcher = pattern.matcher(content);
            matcher.matches();  // 这里将会导致性能问题
        } catch (PatternSyntaxException e) {
            return e.toString();
        }
        return "正则执行完成！";
    }
}
