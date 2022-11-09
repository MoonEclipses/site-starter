package ru.mad.cssstarter.json;

public class TextTag  extends Tag{
    public String fontFamily;
    public int fontSize;
    public boolean bold;
    public boolean italic;
    public String color;


    public TextTag(){
        super();
        fontFamily = null;
        fontSize = 0;
        bold = false;
        italic = false;
        color = "#000000";
    }

    public TextTag(String tagName, String type, String fontFamily, int fontSize, boolean bold, boolean italic, String color, String clName) {
        super(tagName, type,clName);
        this.fontFamily = fontFamily;
        this.fontSize = fontSize;
        this.bold = bold;
        this.italic = italic;
        this.color = color;
    }

    public String getFontFamily() {
        return fontFamily;
    }

    public void setFontFamily(String fontFamily) {
        this.fontFamily = fontFamily;
    }

    public int getFontSize() {
        return fontSize;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    public boolean isBold() {
        return bold;
    }

    public void setBold(boolean bold) {
        this.bold = bold;
    }

    public boolean isItalic() {
        return italic;
    }

    public void setItalic(boolean italic) {
        this.italic = italic;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


    @Override
    public String toString() {
        return "."+clName +" {\n" +
                "font-family:" + fontFamily + ";\n" +
                "font-size:" + fontSize + "px;\n" +
                (bold?"font-weight: bold;\n":"") +
                (italic?"font-style: italic;\n":"") +
                "color:" + color + ";\n" +
                "}\n";
    }
}
