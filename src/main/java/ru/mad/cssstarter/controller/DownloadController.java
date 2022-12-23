package ru.mad.cssstarter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;


import ru.mad.cssstarter.filegeneration.CssGenerator;
import ru.mad.cssstarter.filegeneration.FileGenerator;
import ru.mad.cssstarter.filegeneration.HtmlGenerator;
import ru.mad.cssstarter.json.FormData;
import ru.mad.cssstarter.json.Tag1;

@Controller
public class DownloadController {
    private final String fileBasePath;
    private final String zipFileName = "css-starter";
    private CssGenerator cssFileGenerator;
    private HtmlGenerator htmlFileGenerator;
    private int hid;
    private int fid;

    @Autowired
    public DownloadController(@Value("${download.filebasepath}") String fileBasePath, CssGenerator cssFileGenerator, HtmlGenerator htmlFileGenerator) {
        this.fileBasePath = fileBasePath;
        this.cssFileGenerator = cssFileGenerator;
        this.htmlFileGenerator = htmlFileGenerator;
    }

    @GetMapping("/download")
    public void zipDownload(HttpServletResponse response, @CookieValue("name") String name, @Param("hid") String hid, @Param("fid") String fid) throws IOException {
        response.addHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + zipFileName + ".zip\"");
        response.setStatus(HttpServletResponse.SC_OK);
        this.hid = Integer.parseInt(hid);
        this.fid = Integer.parseInt(fid);
        String json = FormData.getJsonFromName(name);
        List<Tag1> fileData = FormData.getList(json);
        ZipOutputStream zipOut = new ZipOutputStream(response.getOutputStream());
        createZipEntry(zipOut,cssFileGenerator,fileData);
        createZipEntry(zipOut,htmlFileGenerator,fileData);
        zipOut.finish();
        zipOut.close();
    }
    private void createZipEntry(ZipOutputStream zipOut, FileGenerator fileGenerator, List<Tag1> fileData) throws IOException{
        String stringFileData;
        if(fileGenerator instanceof HtmlGenerator) stringFileData = ((HtmlGenerator) fileGenerator).genetateStringFileData1(fileData,hid,fid);
        else stringFileData = fileGenerator.genetateStringFileData(fileData);
        ZipEntry zipEntry = new ZipEntry(fileGenerator.getFileName());
        zipEntry.setSize(stringFileData.getBytes(StandardCharsets.UTF_8).length);
        zipOut.putNextEntry(zipEntry);
        StreamUtils.copy(new ByteArrayInputStream(stringFileData.getBytes()), zipOut);
        zipOut.closeEntry();
    }
}

