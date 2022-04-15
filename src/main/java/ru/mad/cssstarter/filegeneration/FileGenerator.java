package ru.mad.cssstarter.filegeneration;

import java.util.List;

public interface FileGenerator {
    String generate(List<String> fileData);
    void delete(String fileName);
}
