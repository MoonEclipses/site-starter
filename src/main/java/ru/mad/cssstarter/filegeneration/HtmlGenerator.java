package ru.mad.cssstarter.filegeneration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.mad.cssstarter.json.Tag;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
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
    public String generate(List<Tag> fileData) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh_mm_ss_SS");
        String fileName = simpleDateFormat.format(date) + "style.css";
        FileOutputStream fos = null;
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
        return null;
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