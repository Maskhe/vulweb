package cn.bestsec.vulweb.service.impl;

import cn.bestsec.vulweb.service.DeserializationService;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * @author hjxin
 * @since 2023/11/14
 */
@Service
public class DeserializationServiceImpl implements DeserializationService {

    @Override
    public String level1(String file) {
        try (FileInputStream fileInputStream = new FileInputStream(file);){
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Object obj = objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return e.toString();
        }
        return "反序列化完成！";
    }
}
