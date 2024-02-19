package cn.bestsec.vulweb.test;

import java.beans.XMLEncoder;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class XMLTests {
    public static void main(String[] args) throws FileNotFoundException {
        Person person = new Person();
        person.setName("axin");
        person.setAge(1);
        FileOutputStream fileOutputStream = new FileOutputStream("xml.xml");
        XMLEncoder xmlEncoder = new XMLEncoder(fileOutputStream);
        xmlEncoder.writeObject(person);
        xmlEncoder.close();
        System.out.println("序列化结束！");
    }
}


