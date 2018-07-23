package models;


import org.hibernate.annotations.Cascade;

import java.text.SimpleDateFormat;
import javax.persistence.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

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
    private int likes;
    private int dislikes;


    public Article(String title, String body, Category category, Journalist journalist) {
        this.title = title;
        this.body = body;
        this.category = category;
        this.journalist = journalist;
        this.date = new Date();
        this.likes=0;
        this.dislikes=0;
    }

    public Article(){}

    public static void orderListByDate(List<Article> articles) {
        Collections.sort(articles, articleDateComparator);
    }

    public static Comparator<Article> articleDateComparator
            = new Comparator<Article>() {

        public int compare(Article article1, Article article2) {

            Date articleDate1 = article1.getDate();
            Date articleDate2 = article2.getDate();

            //ascending order
            //return articleDate1.compareTo(articleDate2);

            //descending order
            return articleDate2.compareTo(articleDate1);
        }
    };

    public static void orderListByPopularity(List<Article> articles) {
        Collections.sort(articles, articlePopularityComparator);
    }

    public static Comparator<Article> articlePopularityComparator
            = new Comparator<Article>() {

        public int compare(Article article1, Article article2) {

            Integer article1Likes = article1.getLikes();
            Integer article2Likes = article2.getLikes();

            //ascending order
            //return articleDate1.compareTo(articleDate2);

            //descending order
            return article2Likes.compareTo(article1Likes);
        }
    };


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

    @Column(name = "likes")
    public int getLikes() {
        return likes;
    }
    public void setLikes(int likes) {
        this.likes = likes;
    }

    @Column(name = "dislikes")
    public int getDislikes() {
        return dislikes;
    }
    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }

    public void likeArticle(){
        setLikes(getLikes()+1);
    }
    public void dislikeArticle(){
        setDislikes(getDislikes()+1);
    }

    public String giveUserFriendlyDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        return sdf.format(date);
    }

}
