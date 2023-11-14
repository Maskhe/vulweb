package cn.bestsec.vulweb.test;

import java.io.*;
import java.util.EventListener;

public class DeserTests {
    public static class EvilObj implements Serializable {
        private String command;
        public EvilObj(String cmd){
            this.command = cmd;
        }
        private void readObject(ObjectInputStream inputStream){
            try {
                inputStream.defaultReadObject();
                Process process = Runtime.getRuntime().exec(this.command);
                InputStreamReader inputStreamReader = new InputStreamReader(process.getInputStream());
                BufferedReader bf = new BufferedReader(inputStreamReader);
                String line;
                while((line = bf.readLine()) != null){
                    System.out.println(line);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

        }
    }
    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("./test.ser");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
        outputStream.writeObject(new EvilObj("ipconfig"));
    }
}
