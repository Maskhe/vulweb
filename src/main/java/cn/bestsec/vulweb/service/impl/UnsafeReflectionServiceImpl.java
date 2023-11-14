package cn.bestsec.vulweb.service.impl;

import cn.bestsec.vulweb.service.UnsafeReflectionService;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;

@Service
public class UnsafeReflectionServiceImpl implements UnsafeReflectionService {
    @Override
    public String level1(String className, String arg) {
        try {
            // 使用反射加载类
            Class<?> clazz = Class.forName(className);
            // 实例化对象
            Object obj = clazz.getDeclaredConstructor().newInstance();
            // 获取 processData 方法
            Method toStringMethod = clazz.getDeclaredMethod("toString", java.lang.String.class);

            return (String)toStringMethod.invoke(obj, arg);
        } catch (Exception e) {
            return e.toString();
        }
    }
}
