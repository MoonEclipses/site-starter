package ru.mad.cssstarter.db.entities;

import javax.persistence.*;

@Entity
@Table(name = "tags_props")
public class TagsProps {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tags_props_generator")
    @SequenceGenerator(name = "tags_props_generator", sequenceName = "tags_props_id_seq", allocationSize = 1)
    private int id;
    private int tagId;
    private int propId;

    public TagsProps() {
    }

    public TagsProps(int id, int tagId, int propId) {
        this.id = id;
        this.tagId = tagId;
        this.propId = propId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTagId() {
        return tagId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }

    public int getPropId() {
        return propId;
    }

    public void setPropId(int propId) {
        this.propId = propId;
    }
}
