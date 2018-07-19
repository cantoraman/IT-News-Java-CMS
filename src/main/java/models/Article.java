package models;

import java.util.Date;

public class Article {

    private int id;
private String title;
private String body;
private String imageURL;
private Journalist journalist;

    public Article(String title, String body, String imageURL, Journalist journalist) {
        this.title = title;
        this.body = body;
        this.imageURL = imageURL;
        this.journalist = journalist;
    }

  public Article(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Journalist getJournalist() {
        return journalist;
    }

    public void setJournalist(Journalist journalist) {
        this.journalist = journalist;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }


    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }



}
