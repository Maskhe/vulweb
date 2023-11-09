package cn.bestsec.vulweb.controller;


import cn.bestsec.vulweb.service.PathTraversalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/file")
public class PathTraversalController {
    @Autowired
    PathTraversalService pathTraversalService;
    @RequestMapping("/level1")
    public String level1(String p){
        return pathTraversalService.level1(p);
    }
}
