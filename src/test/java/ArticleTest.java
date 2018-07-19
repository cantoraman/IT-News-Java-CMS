import models.Article;
import models.Categories;
import models.Journalist;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class ArticleTest {

    public Article article;


    @Before
    public void setup(){
        Journalist journalist = new Journalist();
        article = new Article("Elon Musk makes space-pancakes!", "He makes awesome pancakes and hipsters losing their minds.", "/elon.jpg", journalist);
    }


    @Test
    public void hasTitle(){
        assertEquals("Elon Musk makes space-pancakes!", article.getTitle());

    }


}
