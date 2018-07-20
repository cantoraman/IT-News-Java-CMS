package models;


import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
//import org.hibernate.annotations.UpdateTimeStamp;

//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.util.Date;
//import java.util.Calendar;
//import java.sql.Date;
//import java.sql.Time;
//import java.sql.Timestamp;



@Entity
@Table(name="articles")
public class Article {

    private int id;
    private String title;
    private String body;
    private String imageURL;
    private Journalist journalist;
    private Category category;
    //private SimpleDateFormat dateTime;
    private Date date;


    public Article(String title, String body, Category category, Journalist journalist) {
        this.title = title;
        this.body = body;
        this.category = category;
        this.journalist = journalist;
        this.date = new Date();
//        dateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//dd/MM/yyyy
//        Date now = new Date();
//        String date = dateTime.format(now);


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

//    @CreationTimestamp
//    @Temporal(TemporalType.TIMESTAMP)
//    public Date getDateTime() {
//        return dateTime;
//    }
//    public void setDateTime(Date dateTime) {
//        this.dateTime = dateTime;
//    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="date")
    public Date getCreateDate() {
        return date;
    }
    public void setCreateDate(Date date) {
        this.date = date;
    }


    @ManyToOne
    @JoinColumn(name="journalist_id", nullable = false)
    public Journalist getJournalist() {
        return journalist;
    }
    public void setJournalist(Journalist journalist) {
        this.journalist = journalist;
    }



}
