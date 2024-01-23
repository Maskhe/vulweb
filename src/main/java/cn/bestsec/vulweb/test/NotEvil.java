package cn.bestsec.vulweb.test;

import lombok.Data;

@Data
public class NotEvil {
    private String payload;
    NotEvil(){}
    NotEvil(String payload) {
        this.payload = payload;
    }
}
