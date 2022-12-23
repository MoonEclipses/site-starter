package ru.mad.cssstarter.json;

public class Tag1 {
    private String tagName;
    private String type;
    public String clName;

    public Tag1(){
        tagName = null;
        type = null;
        clName = null;
    }

    public Tag1(String tagName, String type, String clName) {
        this.tagName = tagName;
        this.type = type;
        this.clName = clName;
    }

    public String getTagName(){
        return this.tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getClName() {
        return clName;
    }

    public void setClName(String clName) {
        this.clName = clName;
    }

    @Override
    public String toString() {
        return tagName +"{ }";
    }
}
