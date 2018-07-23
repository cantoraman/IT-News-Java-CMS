package db;

import models.Article;
import models.Category;
import models.Journalist;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class DBArticle {
    private static Transaction transaction;
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
            cr.add(Restrictions.ilike("title", query + "%"));
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

//    public static List<Article> getAllByJournalist(Journalist journalist) {
//        session = HibernateUtil.getSessionFactory().openSession();
//        List<Article> results = null;
//        try {
//            Criteria cr = session.createCriteria(Article.class);
//            cr.createAlias("journalist", "journalist");
//            cr.add(Restrictions.eq("journalist.id", journalist.getId()));
//            results = cr.list();
//        }
//        catch (HibernateException e) {
//            e.printStackTrace();
//        }
//        finally {
//            session.close();
//        }
//        return results;
//    }


//    public  ArrayList<Article> search(String values){
//        ArrayList<Article> articles = null;
//        articles = new ArrayList<>(DBHelper.getAll(Article.class));
//
//        for (Article article : articles) {
//            if (article.getBody().contains(values) || article.getBody().contentEquals(values)){
//                articles.add(article);
//            }
//        }
//        return articles;
//    }
}
