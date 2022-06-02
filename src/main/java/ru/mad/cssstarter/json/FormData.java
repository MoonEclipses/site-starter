package ru.mad.cssstarter.json;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FormData {
    public static List<Tag> GetList(String json) {
        List<Tag> list = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            list =  Arrays.asList(mapper.readValue(json,TextTag[].class));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static List<Tag> testGetList() {
        ArrayList<Tag> list = new ArrayList<>();
        Tag tag = new TextTag("h1","sans");
        list.add(tag);
        return list;
    }
}
