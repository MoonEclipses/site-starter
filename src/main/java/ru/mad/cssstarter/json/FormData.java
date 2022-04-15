package ru.mad.cssstarter.json;


import java.util.ArrayList;
import java.util.List;
public class FormData {
     public static List<String> testGetList(){
        ArrayList<String> list = new ArrayList<>();
        list.add("h1 {");
        list.add("font-family: sans;");
        list.add("}");
        return list;
    }
}
