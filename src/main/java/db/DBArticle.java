package db;

import models.Article;
import models.Category;
import models.Journalist;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

public class DBArticle {
    private static Session session;

    public static ArrayList<Article> getAllByCategory(Category categoryEnum) {

        ArrayList<Article> allArticles = new ArrayList<>(DBHelper.getAll(Article.class));
        ArrayList<Article> articlesByCategory = new ArrayList<>();
        for(Article article : allArticles){
            if (article.getCategory()==categoryEnum)
                articlesByCategory.add(article);
        }

        return articlesByCategory;
    }

    public static List<Article> search(String query) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Article> results = null;
        try {
            Criteria cr = session.createCriteria(Article.class);
            Criterion cr1 = Restrictions.ilike("title", query + "%", MatchMode.ANYWHERE);
            Criterion cr2 = Restrictions.ilike("body", query + "%", MatchMode.ANYWHERE);
            cr.add(Restrictions.or(cr1, cr2));
            results = cr.list();
        }
        catch (HibernateException e) {
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return results;
    }
}
