package ru.mad.cssstarter.filegeneration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.mad.cssstarter.json.Tag1;
import ru.mad.cssstarter.json.TextTag1;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
public class HtmlGenerator implements FileGenerator{
    private final String fileBasePath;

    public HtmlGenerator(@Value("${download.filebasepath}") String fileBasePath) {
        this.fileBasePath = fileBasePath;
    }
    @Override
    public String generate(List<Tag1> fileData) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh_mm_ss_SS");
        String fileName = simpleDateFormat.format(date) + "style.css";
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(fileBasePath + fileName))) {
            for(Tag1 tag1 : fileData){
                String[] option = tag1.toString().split("\n");
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
    public String genetateStringFileData(List<Tag1> fileData) {
        StringBuilder stringFileData = new StringBuilder();
        try(BufferedReader br = new BufferedReader(new FileReader("src/main/resources/download-files/index.html"))){
            String line;
            while ((line = br.readLine())!=null){
                stringFileData.append(line + "\n");
                if(line.contains("<body>")){
                    for(Tag1 tag1 : fileData){
                        stringFileData.append("<" + tag1.getTagName() + " class=\"" + tag1.getClName() +  "\">" +
                                "Lorem ipsum dolore</" + tag1.getTagName() +">\n");
                    }
                }
                if(line.contains("<link")){
                    stringFileData.append("<link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=");
                    for(Tag1 tag1 : fileData){
                        if(tag1 instanceof TextTag1){
                            stringFileData.append(((TextTag1) tag1).getFontFamily() + "|");
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
