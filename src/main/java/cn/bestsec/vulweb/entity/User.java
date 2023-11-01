package cn.bestsec.vulweb.entity;

import lombok.Data;

@Data
public class User {
    private String name;
    private String password;

    @Override
    public String toString(){
        return this.name + ":" + this.password;
    }
}
