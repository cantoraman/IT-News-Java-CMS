package controller;

import db.DBArticle;
import db.DBHelper;
import models.Article;
import models.Category;
import models.Journalist;
import org.hibernate.HibernateException;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.*;

import static spark.Spark.get;
import static spark.Spark.post;

public class ArticleController {

    public ArticleController(){
        this.setupEndPoints();

    }


    public void setupEndPoints(){

        get("/articles", (req, res) -> {

            Map<String, Object> model = new HashMap();
            model.put("template", "templates/article/index.vtl");

            List<Article> articles;
            if (req.queryParams("search") != null) {
                articles = DBArticle.search(req.queryParams("search"));
            }
            else {
                articles = DBHelper.getAll(Article.class);
            }

            Article.orderListByDate(articles);
            model.put("articles", articles);
            return new ModelAndView(model, "templates/layout.vtl");

        }, new VelocityTemplateEngine());


        get("/articles/new", (req, res) -> {


            Map<String, Object> model = new HashMap();
            List<Journalist> journalists = DBHelper.getAll(Journalist.class);
            model.put("journalists", journalists);
            model.put("categories", Category.values());
            model.put("template", "templates/article/create.vtl");
            return new ModelAndView(model, "templates/layout.vtl");

        }, new VelocityTemplateEngine());



        post("/articles", (req, res) -> {

            int journalistId = Integer.parseInt(req.queryParams("journalist_id"));
            Journalist journalist = DBHelper.findById(journalistId, Journalist.class);
            String title = req.queryParams("title");
            String body = req.queryParams("body");
            Category category = Category.valueOf(req.queryParams("category_id"));


            Article newArticle = new Article(title, body, category, journalist);
            DBHelper.save(newArticle);

            res.redirect("/articles");

            return null;
        }, new VelocityTemplateEngine());



        get("/articles/:id", (request, response) -> {

            Map<String, Object> model = new HashMap<>();
            model.put("template", "templates/article/show.vtl");
            int articleId = Integer.parseInt(request.params(":id"));
            Article article = DBHelper.findById(articleId, Article.class);
            model.put("article", article);
            return new ModelAndView(model, "templates/layout.vtl");

        }, new VelocityTemplateEngine());

        get("/articles/manage", (req, res) -> {

            Map<String, Object> model = new HashMap();
            model.put("template", "templates/manage/articles/index.vtl");

            List<Article> articles = DBHelper.getAll(Article.class);
            Article.orderListByDate(articles);
            model.put("articles", articles);
            return new ModelAndView(model, "templates/layout.vtl");

        }, new VelocityTemplateEngine());


//        get("/articles?search=:query", (req, res) -> {
//
//            String query = req.queryParams("query");
//            List<Article> articles = DBArticle.search(query);
//            Article.orderListByDate(articles);
//
//            Map<String, Object> model = new HashMap();
//            model.put("template", "templates/article/search.vtl");
//
//            model.put("articles", articles);
//            return new ModelAndView(model, "templates/layout.vtl");
//        }, new VelocityTemplateEngine());


//        get("/articles/:id/edit", (request, response) -> {
//
//            Map<String, Object> model = new HashMap<>();
//            model.put("template", "templates/article/edit.vtl");
//            int articleId = Integer.parseInt(request.params(":id"));
//            Article article = DBHelper.findById(articleId, Article.class);
//            model.put("article", article);
//            List<Journalist> journalists = DBHelper.getAll(Journalist.class);
//            model.put("journalists", journalists);
//            return new ModelAndView(model, "templates/layout.vtl");
//
//        }, new VelocityTemplateEngine());

//        get("/articles/search/:string", (req, res) ->{
//
//            Map<String, Object> model = new HashMap<>();
//            model.put{"template","template/search.vlt");
//
//
//        }, new VelocityTemplateEngine());





    }



}
