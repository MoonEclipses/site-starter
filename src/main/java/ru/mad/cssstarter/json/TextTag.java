package ru.mad.cssstarter.json;

public class TextTag  extends Tag{
    public String fontFamily;
    public int fontSize;
    public boolean bold;
    public boolean italic;
    public String color;
    public String clName;

    public TextTag(String tagName, String fontFamily) {
        super(tagName);
        this.fontFamily = fontFamily;
    }

    public TextTag(String tagName, String fontFamily, int fontSize, boolean bold, boolean italic, String color, String clName) {
        super(tagName);
        this.fontFamily = fontFamily;
        this.fontSize = fontSize;
        this.bold = bold;
        this.italic = italic;
        this.color = color;
        this.clName = clName;
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

    public String getClName() {
        return clName;
    }

    public void setClName(String clName) {
        this.clName = clName;
    }

    @Override
    public String toString() {
        return clName +" {" +
                "font-family:" + fontFamily + ";\n" +
                "font-size:" + fontSize + ";\n" +
                (bold?"font-weight: bold;\n":"") +
                (italic?"font-style: italic;\n":"") +
                "color:" + color + ";\n" +
                "}\n";
    }
}
