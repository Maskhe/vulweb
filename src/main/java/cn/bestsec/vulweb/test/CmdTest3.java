package cn.bestsec.vulweb.test;

import java.io.IOException;

public class CmdTest3 {
    public static void main(String[] args) throws IOException {
        Runtime.getRuntime().exec(args[1]);
    }
}