package cn.bestsec.vulweb.service.impl;

import cn.bestsec.vulweb.service.JNDIService;
import org.springframework.stereotype.Service;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * @author hjxin
 * @since 2023/12/6
 */
@Service
public class JNDIServiceImpl implements JNDIService {
    @Override
    public String lookup(String name) {
        try {
            Context context = new InitialContext();
            context.lookup(name);
            return "JNDI lookup发送成功！";
        } catch (NamingException e) {
            return e.toString();
        }
    }
}
