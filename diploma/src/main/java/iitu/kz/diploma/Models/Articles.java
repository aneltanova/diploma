package iitu.kz.diploma.Models;

import javax.persistence.*;

@Entity
@Table(name = "Articles")
public class Articles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)  // updatable = false
    private long id;

    @Column(name = "title", nullable = false, columnDefinition = "TEXT")
    private String title;

    @Column(name = "description", nullable = true, columnDefinition = "TEXT")
    private String description;

    @Column(name = "type", nullable = false, columnDefinition = "TEXT")
    private String type;

    @Column(name = "authors", nullable = true, columnDefinition = "TEXT[]")
    private String[] authors;

    @Column(name = "publisher", nullable = true, columnDefinition = "TEXT[]")
    private String[] publisher;

    public Articles() {
    }

    public Articles(String title, String description, String type, String[] authors, String[] publisher) {
        this.title = title;
        this.description = description;
        this.type = type;
        this.authors = authors;
        this.publisher = publisher;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String[] getAuthors() {
        return authors;
    }

    public void setAuthors(String[] authors) {
        this.authors = authors;
    }

    public String[] getPublisher() {
        return publisher;
    }

    public void setPublisher(String[] publisher) {
        this.publisher = publisher;
    }
}