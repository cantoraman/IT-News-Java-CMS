package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "journalist")
public class Journalist {

    private int id;
    private String firstName;
    private String lastName;
    private List<Article> articles;

    public Journalist() {
    }

    public Journalist(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.articles = new ArrayList<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @OneToMany(mappedBy = "journalist", fetch = FetchType.LAZY)
    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articlest) {
        this.articles = articlest;
    }
}
