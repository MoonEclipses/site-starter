package ru.mad.cssstarter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import ru.mad.cssstarter.filegeneration.FileGenerator;
import ru.mad.cssstarter.json.FormData;

@Controller
public class DownloadController {
    private final String fileBasePath;
    private final String zipFileName = "generated-files";
    private FileGenerator fileGenrator;

    @Autowired
    public DownloadController(@Value("${download.filebasepath}") String fileBasePath, FileGenerator fileGenrator) {
        this.fileBasePath = fileBasePath;
        this.fileGenrator = fileGenrator;
    }

    @GetMapping("/download")
    public void zipDownload(HttpServletResponse response) throws IOException {
        List<String> fileData = FormData.testGetList();
        String fn = fileGenrator.generate(fileData);
        List<String> names = new ArrayList<>();
        names.add(fn);
        ZipOutputStream zipOut = new ZipOutputStream(response.getOutputStream());
        for (String fileName : names) {
            FileSystemResource resource = new FileSystemResource(fileBasePath + fileName);
            ZipEntry zipEntry = new ZipEntry(resource.getFilename());
            zipEntry.setSize(resource.contentLength());
            zipOut.putNextEntry(zipEntry);
            StreamUtils.copy(resource.getInputStream(), zipOut);
            zipOut.closeEntry();
        }
        zipOut.finish();
        zipOut.close();
        fileGenrator.delete(fn);
        response.setStatus(HttpServletResponse.SC_OK);
        response.addHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + zipFileName + "\"");
    }
}
