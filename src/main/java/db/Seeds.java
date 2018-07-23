package db;

import models.Article;
import models.Category;
import models.Journalist;
import models.Article;

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

        DBHelper.save(article1);
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Article article2 = new Article("Java developers close to kill each others", "IT Companies demand Developers", Category.JAVA, journalist1);
        DBHelper.save(article2);
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Article article3 = new Article("Elon Musk makes space-pancakes!", "He makes awesome pancakes and hipsters lose their minds.", Category.TECH, journalist2);
        DBHelper.save(article3);
//
//        Department department1 = new Department("HR");
//        DBHelper.save(department1);
//        Department department2 = new Department("IT");
//        DBHelper.save(department2);
//        Manager manager = new Manager("Peter", "Griffin", 40000,department1, 100000 );
//        DBHelper.save(manager);
//        Engineer engineer1 = new Engineer("Lois", "Griffin", 29000, department1);
//        DBHelper.save(engineer1);
//        Engineer engineer2 = new Engineer("Stewie", "Griffin", 27000, department1);
//        DBHelper.save(engineer2);


    }





    }








