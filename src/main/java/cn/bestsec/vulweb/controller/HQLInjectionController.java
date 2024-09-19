//package cn.bestsec.vulweb.controller;
//
//
//import cn.bestsec.vulweb.service.HQLInjectionService;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.cors.CorsConfiguration;
//
////@CrossOrigin(originPatterns={"test.com"})
//@RestController
//@RequestMapping("/hql")
//public class HQLInjectionController {
//    HQLInjectionService hqlInjectionService;
//
//    public HQLInjectionController(HQLInjectionService hqlInjectionService) {
//        this.hqlInjectionService = hqlInjectionService;
//    }
//
//    @RequestMapping("/createquery")
//    public String createQuery(String p) {
//        return this.hqlInjectionService.createQuery(p);
//    }
//
//    @GetMapping("/createCriteria")
//    public String createCriteria(String p) {
//        return this.hqlInjectionService.createCriteria(p);
//    }
//}
