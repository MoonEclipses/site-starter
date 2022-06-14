package ru.mad.cssstarter.json;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FormData {
    public static List<Tag> getList(String json) {
        List<Tag> list = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode wrap = mapper.readValue(json,JsonNode.class);
            ArrayNode array =  (ArrayNode) wrap.get("items");
            for(JsonNode node: array){
                String type = node.get("type").asText();
                String nodejs = node.toString();
                Class tagClass = Class.forName("ru.mad.cssstarter.json." +type);
                Tag tag = (Tag) mapper.readValue(nodejs,tagClass);
                list.add(tag);
            }
        } catch (JsonProcessingException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }
    public static String getJsonFromName(String name){
        String json = null;
        try(BufferedReader br = new BufferedReader(new FileReader("src/main/resources/usersdata/ud.json"))){
            String fData = "";
            String line;
            while((line = br.readLine()) != null){
                fData+=line;
            }
            int ind = fData.indexOf(name) + name.length() + 2;
            json = fData.substring(ind);
            json = json.substring(0,json.indexOf(']')+2);
        }catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }

}
