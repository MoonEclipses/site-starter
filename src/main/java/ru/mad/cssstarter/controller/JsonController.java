package ru.mad.cssstarter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.mad.cssstarter.json.FormData;
import ru.mad.cssstarter.json.Tag;

import java.util.List;

@Controller
public class JsonController {
    @RequestMapping("/getJSON")
    public void getJSON(@RequestParam("json") String json){
        List<Tag> tagList = FormData.GetList(json);

    }
}
