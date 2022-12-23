package ru.mad.cssstarter.filegeneration;

import ru.mad.cssstarter.json.Tag1;

import java.util.List;

public interface FileGenerator {
    String generate(List<Tag1> fileData);
    String genetateStringFileData(List<Tag1> fileData);
    void delete(String fileName);
    String getFileName();
}
