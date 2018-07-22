package db;

import models.Article;
import models.Category;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

public class DBArticle {

    public static ArrayList<Article> getAllByCategory(Category categoryEnum) {

        ArrayList<Article> allArticles = new ArrayList<>(DBHelper.getAll(Article.class));
        ArrayList<Article> articlesByCategory = new ArrayList<>();
        for(Article article : allArticles){
            if (article.getCategory()==categoryEnum)
                articlesByCategory.add(article);
        }

        return articlesByCategory;
    }
}
