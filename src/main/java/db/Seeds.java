package db;

import models.Article;
import models.Category;
import models.Journalist;
import org.apache.commons.lang.time.DateUtils;

import java.util.concurrent.TimeUnit;


public class Seeds {

    public static void seedData() {
        DBHelper.deleteAll(Article.class);
        DBHelper.deleteAll(Journalist.class);

        Journalist journalist1 = new Journalist("Matt Blake", "Java Developer, Healthy Life Style Evangelist");
        Journalist journalist2 = new Journalist("Elisa Woodheart", "Front End Wizard, Mother of All Dragons");
        DBHelper.save(journalist1);
        DBHelper.save(journalist2);


        Article article1 = new Article("Java developers on Demand", "IT Companies demand Developers", Category.JAVA, journalist1);
        article1.setLikes(5);
        article1.setDislikes(2);
        article1.setDate(DateUtils.addDays(article1.getDate(),-5));
        DBHelper.save(article1);

        Article article2 = new Article("Java developers close to kill each others", "IT Companies demand Developers", Category.JAVA, journalist1);
        article2.setLikes(50);
        article2.setDislikes(20);
        article2.setDate(DateUtils.addDays(article2.getDate(),-2));
        DBHelper.save(article2);


        Article article3 = new Article("Elon Musk makes space-pancakes!", "He makes awesome pancakes and hipsters lose their minds.", Category.TECH, journalist2);
        article3.setLikes(1);
        article3.setDislikes(90);
        article3.setDate(DateUtils.addDays(article3.getDate(),-1));

        DBHelper.save(article3);

        Article article4 = new Article("Tourist lands on the Moon!", "And claims compensation for lack of oxygen", Category.HISTORY, journalist2);
        article4.setLikes(25);
        article4.setDislikes(3);

        DBHelper.save(article4);


    }





    }








