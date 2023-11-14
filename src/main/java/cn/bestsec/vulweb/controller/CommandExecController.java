package cn.bestsec.vulweb.controller;


import cn.bestsec.vulweb.service.CommandExecService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hjxin
 * @since 2023/11/13
 */
@RestController
@RequestMapping("/cmd")
public class CommandExecController {
    CommandExecService commandExecService;

    public CommandExecController(CommandExecService commandExecService){
        this.commandExecService = commandExecService;
    }
    @RequestMapping("/level1")
    public String level1(String p){
        return commandExecService.level1(p);
    }

    @RequestMapping("/level2")
    public String level2(String p){
        return commandExecService.level2(p);
    }

    @RequestMapping("/level3")
    public String level3(String p){
        return commandExecService.level3(p);
    }
}
