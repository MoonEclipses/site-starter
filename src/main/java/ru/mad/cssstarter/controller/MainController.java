package ru.mad.cssstarter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String showMain(){
        return "mainpage";
    }
    @GetMapping("/dev")
    public String showDev(){
        return "dev";
    }
    @GetMapping("/team")
    public String showTeam(){
        return "team";
    }
    @GetMapping("/quest")
    public String showQuest(){
        return "quest";
    }
    @GetMapping("/downloadPage")
    public String showDPage(){
        return "down";
    }
    @GetMapping("/func")
    public String showFunc(){
        return "func";
    }
}
