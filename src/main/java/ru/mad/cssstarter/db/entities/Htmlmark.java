package ru.mad.cssstarter.db.entities;

import javax.persistence.*;

@Entity
@Table(name="htmlmark")
public class Htmlmark {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "htmlmark_generator")
    @SequenceGenerator(name = "htmlmark_generator", sequenceName = "htmlmark_id_seq", allocationSize = 1)
    private int id;
    private String content;

    public Htmlmark() {
    }

    public Htmlmark(int id, String content) {
        this.id = id;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String name) {
        this.content = name;
    }
}
