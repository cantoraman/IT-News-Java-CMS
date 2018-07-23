package db;

import models.Article;
import models.Journalist;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBJournalist {

    private static Session session;


    public static List<Article> getArticlesForJournalist(Journalist journalist){
        List<Article> articles = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try{
            Criteria cr = session.createCriteria(Article.class);
//            cr.createAlias("articles.journalist_id", "id");
            cr.add(Restrictions.eq( "journalist", journalist));
            articles = cr.list();
        }catch (HibernateException e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return articles;
    }

}
