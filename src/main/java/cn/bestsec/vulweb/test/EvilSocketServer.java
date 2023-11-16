package cn.bestsec.vulweb.test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EvilSocketServer {
    public static void main(String[] args){
        int serverPort = 8888;
        String evilFilePath = "C:\\Users\\hjx\\IdeaProjects\\vulweb\\test.ser";
        byte[] buffer = new byte[1024];
        int bytesRead;
        try {
            // 创建服务器Socket并绑定到指定端口
            ServerSocket serverSocket = new ServerSocket(serverPort);
            System.out.println("Server listening on port " + serverPort);

            // 等待客户端连接
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected: " + clientSocket.getInetAddress());

            // 获取输出流
            OutputStream outputStream = clientSocket.getOutputStream();

            // 发送响应给客户端
            FileInputStream fileInputStream = new FileInputStream(evilFilePath);
            while((bytesRead = fileInputStream.read(buffer)) != -1){
                outputStream.write(buffer, 0, bytesRead);
            }
            System.out.println("响应发送成功！");
            // 关闭连接
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
