import db.DBHelper;
import models.Article;
import models.Category;
import models.Journalist;
import org.apache.commons.lang.time.DateUtils;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class ArticleTest {

    public Article article;
    Article article1;
    Article article2;
    Article article3;
    Article article4;


    ArrayList<Article> articles = new ArrayList<>();

    @Before
    public void setup(){
        Journalist journalist = new Journalist();
        article = new Article("Elon Musk makes space-pancakes!", "He makes awesome pancakes and hipsters lose their minds.", Category.TECH, journalist);
        Journalist journalist1 = new Journalist("Matt Blake", "Java Developer, Healthy Life Style Evangelist");
        Journalist journalist2 = new Journalist("Elisa Woodheart", "Front End Wizard, Mother of All Dragons");



        article1 = new Article("Java developers on Demand", "IT Companies demand Developers", Category.JAVA, journalist1);
        article1.setLikes(5);
        article1.setDislikes(2);
        article1.setDate(DateUtils.addDays(article1.getDate(),-10));

        article2 = new Article("Java developers close to kill each others", "IT Companies demand Developers", Category.JAVA, journalist1);
        article2.setLikes(50);
        article2.setDislikes(20);
        article2.setDate(DateUtils.addDays(article2.getDate(),2));

        article3 = new Article("Elon Musk makes space-pancakes!", "He makes awesome pancakes and hipsters lose their minds.", Category.TECH, journalist2);
        article3.setLikes(1);
        article3.setDislikes(90);
        article3.setDate(DateUtils.addDays(article3.getDate(),1));

        article4 = new Article("Man land on Moon!", "and discovers that it is not made of cheese", Category.HISTORY, journalist2);
        article4.setLikes(10);
        article4.setDislikes(10);
        article4.setDate(DateUtils.addDays(article4.getDate(),1));

        articles.add(article1);
        articles.add(article2);
        articles.add(article3);
        articles.add(article4);

    }

    @Test
    public void hasTitle(){
        assertEquals("Elon Musk makes space-pancakes!", article.getTitle());
    }
    @Test
    public void hasBody(){
        assertEquals("He makes awesome pancakes and hipsters lose their minds.", article.getBody());
    }
    @Test
    public void hasCategory(){
        assertEquals(Category.TECH, article.getCategory());
    }
    @Test
    public void hasJournalist(){
        assertEquals(Journalist.class, article.getJournalist().getClass());
    }

    @Test
    public void canSortByLimitedDaysPopularity(){
        List<Article> newList = Article.orderListByPopularity(articles,3);
        System.exit(0);
    }

}
