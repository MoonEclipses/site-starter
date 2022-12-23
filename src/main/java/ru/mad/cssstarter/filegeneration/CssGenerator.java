package ru.mad.cssstarter.filegeneration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.mad.cssstarter.json.Tag1;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
public class CssGenerator implements FileGenerator {

    private final String fileBasePath;

    public CssGenerator(@Value("${download.filebasepath}") String fileBasePath) {
        this.fileBasePath = fileBasePath;
    }

    @Override
    public String generate(List<Tag1> fileData){
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
        for(Tag1 tag1 : fileData){
            stringFileData.append(tag1.toString());
        }
        return stringFileData.toString();
    }

    @Override
    public void delete(String fileName){
        File file = new File("src/main/resources/download-files/" + fileName);
        file.delete();
    }

    @Override
    public String getFileName() {
        return "style.css";
    }

    public void writeInFile(BufferedWriter bw) throws IOException {

    }
}
