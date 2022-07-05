package ru.mad.cssstarter.filegeneration;

import ru.mad.cssstarter.json.Tag;

import java.util.List;

public interface FileGenerator {
    String generate(List<Tag> fileData);
    String genetateStringFileData(List<Tag> fileData);
    void delete(String fileName);
    String getFileName();
}
