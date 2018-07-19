import models.Article;
import models.Category;
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
        article = new Article("Elon Musk makes space-pancakes!", "He makes awesome pancakes and hipsters lose their minds.", "/elon.jpg", journalist);
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
    public void hasImage(){
        assertEquals("/elon.jpg", article.getImageURL());
    }
    @Test
    public void hasJournalist(){
        assertEquals(Journalist.class, article.getJournalist().getClass());
    }


}
