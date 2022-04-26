package ru.mad.cssstarter.controller;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/fonts")
public class FontController {
    private final String URL = "https://www.googleapis.com/webfonts/v1/webfonts?key=AIzaSyCpITb3IwHT5c99X-0Cj54hp8iL_D8-fAE";
    @GetMapping("/get")
    public String getFonts(){
        RestTemplate rt = new RestTemplate();
        return rt.getForObject(URL,String.class);
    }
    @GetMapping("/getarr")
    public String getFontsArray(){
        RestTemplate rt = new RestTemplate();
        String json = rt.getForObject(URL,String.class);
        JSONObject obj = new JSONObject(json);
        JSONArray arr = obj.getJSONArray("items");
        JSONArray resArr = new JSONArray();
        for (int i = 0; i < arr.length(); i++) {
            String font = arr.getJSONObject(i).getString("family");
            resArr.put(font);
        }
        JSONObject resObj = new JSONObject();
        resObj.append("fonts",resArr);
        return resObj.toString();
    }
}
