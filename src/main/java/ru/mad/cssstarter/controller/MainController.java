package ru.mad.cssstarter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.mad.cssstarter.db.PropRepository;
import ru.mad.cssstarter.db.TagRepository;
import ru.mad.cssstarter.db.TagsPropsRepository;
import ru.mad.cssstarter.db.entities.Propertie;
import ru.mad.cssstarter.db.entities.Tag;
import ru.mad.cssstarter.json.TagWithProps;
import ru.mad.cssstarter.services.TagService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

@Controller
public class MainController {
    TagService tagService;

    @Autowired
    public MainController(TagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping("/")
    public String showMain() {
        return "mainpage";
    }

    @GetMapping("/dev")
    public String showDev() {
        return "dev";
    }

    @GetMapping("/team")
    public String showTeam() {
        return "team";
    }

    @GetMapping("/quest")
    public ModelAndView showQuest() {
        ModelAndView modelAndView = new ModelAndView("quest");
        ArrayList<TagWithProps> tags = tagService.getAllTags();
        Collections.reverse(tags);
        modelAndView.addObject("tags", tags);
        return modelAndView;
    }
    @GetMapping("/questhtml")
    public String showQuestHtml() {
        return "questhtlml";
    }
    @GetMapping("/downloadPage")
    public ModelAndView showDPage(@Param("hid") String hid, @Param("fid") String fid) {
        ModelAndView modelAndView = new ModelAndView("down");
        modelAndView.addObject("hid", hid);
        modelAndView.addObject("fid", fid);
        return modelAndView;
    }

    @GetMapping("/func")
    public String showFunc() {
        return "func";
    }
}
