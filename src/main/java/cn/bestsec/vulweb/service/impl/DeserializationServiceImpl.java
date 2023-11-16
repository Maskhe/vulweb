package cn.bestsec.vulweb.service.impl;

import cn.bestsec.vulweb.service.DeserializationService;
import org.springframework.stereotype.Service;
import sun.net.www.protocol.http.HttpURLConnection;

import java.io.*;
import java.net.Socket;
import java.net.URL;

/**
 * @author hjxin
 * @since 2023/11/14
 */
@Service
public class DeserializationServiceImpl implements DeserializationService {

    @Override
    public String fileDeserialize(String file) {
        try (FileInputStream fileInputStream = new FileInputStream(file)){
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Object obj = objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return e.toString();
        }
        return "反序列化完成！";
    }

    @Override
    public String httpDeserialize(String url) {
        try{
            URL uri = new URL(url);
            HttpURLConnection urlConnection = (HttpURLConnection) uri.openConnection();
            urlConnection.setRequestMethod("GET");
            int responseCode = urlConnection.getResponseCode();
            if (responseCode == java.net.HttpURLConnection.HTTP_OK){
                InputStream inputStream = urlConnection.getInputStream();
                ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
                objectInputStream.readObject();
            }
        } catch (Exception e){
            return e.toString();
        }

        return "反序列化完成！";
    }

    @Override
    public String tcpDeserialize(String host) {
        int serverPort = 8888; // 服务器端口

        try {
            Socket socket = new Socket(host, serverPort);

            // 获取输入流
            InputStream inputStream = socket.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            objectInputStream.readObject();
            // 关闭连接
            socket.close();
        } catch (Exception e) {
            return e.toString();
        }
        return "反序列化完成！";
    }


}
