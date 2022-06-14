package ru.mad.cssstarter.json;

public class Tag {
    private String tagName;
    private String type;

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

    public Tag(){
        tagName = null;
        type = null;
    }

    public Tag(String tagName, String type) {
        this.tagName = tagName;
        this.type = type;
    }

    @Override
    public String toString() {
        return tagName +"{ }";
    }
}
