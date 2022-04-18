package ru.mad.cssstarter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/downloadPage")
    public String showDPage(){
        return "download";
    }
    @GetMapping("/quest")
    public String showFunc(){
        return "func";
    }
}
