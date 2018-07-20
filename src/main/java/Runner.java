import db.DBHelper;
import models.Article;
import models.Category;
import models.Journalist;

import java.util.HashMap;

public class Runner {

    public static void main(String[] args) {

        Journalist journalist1 = new Journalist("Matt", "Blake");
        Journalist journalist2 = new Journalist("Elisa", "Woodheart");
        DBHelper.save(journalist1);
        DBHelper.save(journalist2);


        Article article1 = new Article("Java developers on Demand", "IT Companies demand Developers", Category.JAVA, journalist1);
        Article article2 = new Article("Java developers close to kill each others", "IT Companies demand Developers", Category.JAVA, journalist1);
        Article article3 = new Article("Elon Musk makes space-pancakes!", "He makes awesome pancakes and hipsters lose their minds.", Category.TECH, journalist2);
    DBHelper.save(article1);
    DBHelper.save(article2);
    DBHelper.save(article3);

    }
}
