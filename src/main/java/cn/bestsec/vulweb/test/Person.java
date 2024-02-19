package cn.bestsec.vulweb.test;

import java.io.Serializable;

public class Person {
    String name = "";
    int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void sayHello(){
        System.out.println("Hello, my name is "+name);
    }
}