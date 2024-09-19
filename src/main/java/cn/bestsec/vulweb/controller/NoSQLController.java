//package cn.bestsec.vulweb.controller;
//
//import cn.bestsec.vulweb.service.NoSQLInjectionService;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * @author hjx
// * @since 2024/1/10
// */
//@RestController
//@RequestMapping("/nosql")
//public class NoSQLController {
//    NoSQLInjectionService noSQLInjectionService;
//
//    public NoSQLController(NoSQLInjectionService noSQLInjectionService) {
//        this.noSQLInjectionService = noSQLInjectionService;
//    }
//
//    @RequestMapping("/query")
//    public String query(String p) {
//        return this.noSQLInjectionService.query(p);
//    }
//
//    @RequestMapping("/querynotvul")
//    public String queryNotVul(String p) {
//        return this.noSQLInjectionService.queryNotVul(p);
//    }
//    @RequestMapping("/delete")
//    public String delete(String p) {
//        return this.noSQLInjectionService.delete(p);
//    }
//
//    @RequestMapping("/distinct")
//    public String distinct(String p) {
//        return this.noSQLInjectionService.distinct(p);
//    }
//
//    @RequestMapping("/runcommand")
//    public String runCommand(String key, String value) {
//        return this.noSQLInjectionService.runCommand(key, value);
//    }
//}
