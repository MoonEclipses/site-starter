package ru.mad.cssstarter.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.mad.cssstarter.controller.body.ImportBody;

public class QuestController {
    @PostMapping("/quest")
    public String showQuestWithParams(@RequestBody ImportBody importBody){
        String json = importBody.getJsonData();
        return "quest";
    }

}
