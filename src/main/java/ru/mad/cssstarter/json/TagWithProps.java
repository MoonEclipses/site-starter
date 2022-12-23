package ru.mad.cssstarter.json;

import ru.mad.cssstarter.db.entities.Propertie;

import java.util.ArrayList;

public class TagWithProps {
    private int id;
    private String name;
    private String desc;
    private ArrayList<Propertie> props;

    public TagWithProps(int id, String name, String desc, ArrayList<Propertie> props) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.props = props;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public ArrayList<Propertie> getProps() {
        return props;
    }

    public void setProps(ArrayList<Propertie> props) {
        this.props = props;
    }
}
