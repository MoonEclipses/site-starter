package ru.mad.cssstarter.db.entities;

import javax.persistence.*;

@Entity
@Table(name="properties")
public class Propertie {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "properties_generator")
    @SequenceGenerator(name = "properties_generator", sequenceName = "properties_id_seq", allocationSize = 1)
    private int id;
    private String name;
    private String type;
    @Column(name = "default_value")
    private String defVal;

    public Propertie() {
    }

    public Propertie(int id, String name, String type, String defVal) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.defVal = defVal;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDefVal() {
        return defVal;
    }

    public void setDefVal(String defVal) {
        this.defVal = defVal;
    }
}
