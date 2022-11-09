package ru.mad.cssstarter.filegeneration;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.mad.cssstarter.json.Tag;
import ru.mad.cssstarter.json.TextTag;

import javax.swing.text.TabExpander;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class HtmlGenerator implements FileGenerator{
    private final String fileBasePath;

    public HtmlGenerator(@Value("${download.filebasepath}") String fileBasePath) {
        this.fileBasePath = fileBasePath;
    }
    @Override
    public String generate(List<Tag> fileData) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh_mm_ss_SS");
        String fileName = simpleDateFormat.format(date) + "style.css";
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(fileBasePath + fileName))) {
            for(Tag tag: fileData){
                String[] option = tag.toString().split("\n");
                for(String line: option){
                    bw.write(line);
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return fileName;
    }

    @Override
    public String genetateStringFileData(List<Tag> fileData) {
        StringBuilder stringFileData = new StringBuilder();
        try(BufferedReader br = new BufferedReader(new FileReader("src/main/resources/download-files/index.html"))){
            String line;
            while ((line = br.readLine())!=null){
                stringFileData.append(line + "\n");
                if(line.contains("<body>")){
                    for(Tag tag: fileData){
                        stringFileData.append("<" + tag.getTagName() + " class=\"" + tag.getClName() +  "\">" +
                                "Lorem ipsum dolore</" + tag.getTagName() +">\n");
                    }
                }
                if(line.contains("<link")){
                    stringFileData.append("<link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=");
                    for(Tag tag: fileData){
                        if(tag instanceof TextTag){
                            stringFileData.append(((TextTag)tag).getFontFamily() + "|");
                        }
                    }
                    stringFileData.append("\">\n");
                }
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        return stringFileData.toString();
    }

    @Override
    public void delete(String fileName) {
        return;
    }

    @Override
    public String getFileName() {
        return "index.html";
    }
}
