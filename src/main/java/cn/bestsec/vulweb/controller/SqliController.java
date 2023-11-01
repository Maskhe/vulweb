package cn.bestsec.vulweb.controller;
import cn.bestsec.vulweb.service.SqliService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.sql.*;
import java.util.List;

@RestController
@RequestMapping("/sqli")
public class SqliController {

    @Autowired
    private SqliService sqliService;

    public SqliController() throws SQLException {
    }

    @RequestMapping("/level1")
    public String level1(@RequestParam  String p){
        return sqliService.level1(p);
    }

    @RequestMapping("/level2")
    public List<?> level2(@RequestParam String p){
        return sqliService.level2(p);
    }

    @RequestMapping("/level3")
    public String level3(@RequestParam String p){
        return sqliService.level3(p);
    }

    @RequestMapping("/level4")
    public List<?> level4(@RequestParam String p){
        return sqliService.level4(p);
    }

    @RequestMapping("/level5")
    public String level5(@RequestParam String p){
        return sqliService.level5(p);
    }

    @RequestMapping("/level6")
    public String level6(@RequestParam String p){
        return sqliService.level6(p);
    }

    @RequestMapping("level7")
    public String level7(@RequestParam String p){
        return sqliService.level7(p);
    }

    @RequestMapping("/level8")
    public String level8(@RequestParam String p){
        return sqliService.level8(p);
    }

    @RequestMapping("/level9")
    public String level9(@RequestParam String p){
        return sqliService.level9(p);
    }

    @RequestMapping("/level10")
    public String level10(@RequestParam String p){
        return sqliService.level10(p);
    }

    @RequestMapping("/level11")
    public String level11(@RequestParam String p){
        return sqliService.level11(p);
    }

    @RequestMapping("/level12")
    public String level12(@RequestParam String p){
        return sqliService.level12(p);
    }

    @RequestMapping("/level13")
    public String level13(String p){
        return sqliService.level13(p);
    }

    @RequestMapping("/level14")
    public String level14(String p){
        return sqliService.level14(p);
    }

    @RequestMapping("/level15")
    public String level15(int p){
        return sqliService.level15(p);
    }

    @RequestMapping("/level16")
    public String level16(String p){
        return sqliService.level16(p);
    }

    @RequestMapping("/level17")
    public String level17(String p){
        return sqliService.level17(p);
    }

    @RequestMapping("/level18")
    public String level18(String p) {
        return sqliService.level18(p);
    }
}
