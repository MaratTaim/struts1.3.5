package com.epam.testapp.model;

import com.epam.testapp.util.Const;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "NEWS")
public class News implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "TITLE", nullable = false, length = 100)
    private String title;

    @Column(name = "N_DATE", nullable = false, length = 10)
    private String date = Const.KURR_DATE;

    @Column(name = "BRIEF", nullable = false, length = 512)
    private String brief;

    @Column(name = "CONTENT", nullable = false, length = 1024)
    private String content;

    @Column(name = "DEL")
    private boolean delete;

    public News() {
    }

    public News(Long id, String title, String date, String brief, String content) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.brief = brief;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isDelete() {
        return delete;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", date=" + date +
                ", brief='" + brief + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}