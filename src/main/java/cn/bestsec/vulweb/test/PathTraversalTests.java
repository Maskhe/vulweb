package cn.bestsec.vulweb.test;

import org.apache.commons.io.FilenameUtils;

public class PathTraversalTests {
    public static void main(String[] args) {
        String file = "../../../../etc/passwd";
        String fileName = FilenameUtils.getName(file);
        System.out.println(fileName);
    }
}
