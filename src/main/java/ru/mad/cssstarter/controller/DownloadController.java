package ru.mad.cssstarter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;


import ru.mad.cssstarter.filegeneration.CssGenerator;
import ru.mad.cssstarter.filegeneration.FileGenerator;
import ru.mad.cssstarter.filegeneration.HtmlGenerator;
import ru.mad.cssstarter.json.FormData;
import ru.mad.cssstarter.json.Tag;

@Controller
public class DownloadController {
    private final String fileBasePath;
    private final String zipFileName = "generated-files";
    private CssGenerator cssFileGenerator;
    private HtmlGenerator htmlFileGenerator;

    @Autowired
    public DownloadController(@Value("${download.filebasepath}") String fileBasePath, CssGenerator cssFileGenerator, HtmlGenerator htmlFileGenerator) {
        this.fileBasePath = fileBasePath;
        this.cssFileGenerator = cssFileGenerator;
        this.htmlFileGenerator = htmlFileGenerator;
    }

    @GetMapping("/download")
    public void zipDownload(HttpServletResponse response, @CookieValue("name") String name) throws IOException {
        String json = FormData.getJsonFromName(name);
        List<Tag> fileData = FormData.getList(json);
        String stringCssFileData = cssFileGenerator.genetateStringFileData(fileData);
        List<String> files = new ArrayList<>();
        files.add(stringCssFileData);
        ZipOutputStream zipOut = new ZipOutputStream(response.getOutputStream());
        for (String file : files) {
            ZipEntry zipEntry = new ZipEntry(cssFileGenerator.getFileName());
            zipEntry.setSize(file.getBytes(StandardCharsets.UTF_8).length);
            zipOut.putNextEntry(zipEntry);
            StreamUtils.copy(new ByteArrayInputStream(file.getBytes()), zipOut);
            zipOut.closeEntry();
        }
        zipOut.finish();
        zipOut.close();
        response.setStatus(HttpServletResponse.SC_OK);
        response.addHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + zipFileName + "\"");
    }
}
