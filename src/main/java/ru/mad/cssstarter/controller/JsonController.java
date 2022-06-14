package ru.mad.cssstarter.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.io.*;


@Controller
public class JsonController {
    @RequestMapping("/getJSON")
    public void getJSON(@RequestParam("name") String name, HttpServletRequest request){

        String json = null;
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(request.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            json = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String newFData = null;
        try(BufferedReader br = new BufferedReader(new FileReader("src/main/resources/usersdata/ud.json"))){
            String fData = "";
            String line;
            while((line = br.readLine()) != null){
                fData+=line;
            }
            ObjectMapper mapper = new ObjectMapper();
            ObjectNode obj = mapper.readValue(fData,ObjectNode.class);
            JsonNode newField = mapper.readValue(json,JsonNode.class);
            obj.put(name,newField);
            newFData = obj.toString();
        }catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/main/resources/usersdata/ud.json"))){
            bw.write(newFData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
