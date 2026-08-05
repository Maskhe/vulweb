package cn.bestsec.vulweb.controller;

import cn.bestsec.vulweb.service.CommandExecService;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

public class TestController {
    CommandExecService commandExecService;

    public TestController(CommandExecService commandExecService){
        this.commandExecService = commandExecService;
    }
    @RequestMapping("/level1")
    public String level1(String p, String d){
//        Stream.of(Thread.currentThread().getStackTrace()).forEach(System.out::println);
//        HashMap hashMap1 = new HashMap<>();
//        hashMap1.put("test", p);
//        HashMap hashMap2 = new HashMap<>();
//        hashMap2.putAll(hashMap1);
        ArrayList<String> arr1 = new ArrayList<>();
        arr1.add(d);
        Object[] env = arr1.toArray();
        String[] arr = new String[] {d};
        return commandExecService.level1("ipconfig", arr);
    }

    @RequestMapping("/level2")
    public String level2(String p){
        return commandExecService.level2(p);
    }

    @RequestMapping("/level3")
    public String level3(String p){
        return commandExecService.level3(p);
    }

    @RequestMapping("/level4")
    public String level4(String p) {
        return this.commandExecService.level4(p);
    }
}
