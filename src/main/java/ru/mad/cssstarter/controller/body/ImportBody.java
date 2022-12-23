package ru.mad.cssstarter.controller.body;

public class ImportBody {
    private String jsonData;

    public ImportBody(String jsonData) {
        this.jsonData = jsonData;
    }

    public String getJsonData() {
        return jsonData;
    }
}
