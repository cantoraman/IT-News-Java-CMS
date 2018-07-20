package models;


import org.hibernate.annotations.Cascade;

import java.text.SimpleDateFormat;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="articles")
public class Article {

    private int id;
    private String title;
    private String body;
    private String imageURL;
    private Journalist journalist;
    private Date date;
    private Category category;


    public Article(String title, String body, Category category, Journalist journalist) {
        this.title = title;
        this.body = body;
        this.category = category;
        this.journalist = journalist;
        this.date = new Date();

    }

    public Article(){}


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Column(name="title")
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name="body")
    public String getBody() {
        return body;
    }
    public void setBody(String body) {
        this.body = body;
    }

    @Column(name="category")
    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }

    @Column(name="image")
    public String getImageURL() {
        return imageURL;
    }
    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    @ManyToOne
    @JoinColumn(name="journalist_id", nullable = false)
    public Journalist getJournalist() {
        return journalist;
    }
    public void setJournalist(Journalist journalist) {
        this.journalist = journalist;
    }

    @Column(name = "date")
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    public String DateForUser() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        return sdf.format(date);
    }
}
