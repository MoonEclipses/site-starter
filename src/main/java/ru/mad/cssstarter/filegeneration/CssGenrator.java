package ru.mad.cssstarter.filegeneration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.mad.cssstarter.json.Tag;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
public class CssGenrator implements FileGenerator {

    private final String fileBasePath;

    public CssGenrator(@Value("${download.filebasepath}") String fileBasePath) {
        this.fileBasePath = fileBasePath;
    }

    @Override
    public String generate(List<Tag> fileData){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh_mm_ss_SS");
        String fileName = simpleDateFormat.format(date) + "style.css";
        FileOutputStream fos = null;
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(fileBasePath + fileName))) {
            for(Tag tag: fileData){
                bw.write(tag.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return fileName;
    }
    @Override
    public void delete(String fileName){
        File file = new File("src/main/resources/download-files/" + fileName);
        file.delete();
    }
    public void writeInFile(BufferedWriter bw) throws IOException {

    }
}
