package cn.bestsec.vulweb.controller;


import cn.bestsec.vulweb.service.PathTraversalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/file")
public class PathTraversalController {
    private final PathTraversalService pathTraversalService;

    public PathTraversalController(PathTraversalService pathTraversalService) {
        this.pathTraversalService = pathTraversalService;
    }

    @RequestMapping("/level1")
    public String level1(String p){
        return pathTraversalService.level1(p);
    }

    @RequestMapping("/level2")
    public String level2(String p){
        return pathTraversalService.level2(p);
    }

    @RequestMapping("/level3")
    public String level3(String p){
        return pathTraversalService.level3(p);
    }

    @RequestMapping("/level4")
    public String level4(String p){
        return pathTraversalService.level4(p);
    }

    @RequestMapping("/level5")
    public String level5(String p){
        return pathTraversalService.level5(p);
    }

    @RequestMapping("/level6")
    public String level6(String p){
        return pathTraversalService.level6(p);
    }

    @RequestMapping("/level7")
    public String level7(String p, String d) {
        return pathTraversalService.level7(p, d);
    }
}
