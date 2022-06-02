package ru.mad.cssstarter.json;

public class Tag {
    private String tagName;
    public String getTagName(){
        return this.tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public Tag(String tagName) {
        this.tagName = tagName;
    }

    @Override
    public String toString() {
        return tagName +"{ }";
    }
}
