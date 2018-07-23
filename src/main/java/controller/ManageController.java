package controller;

import db.DBHelper;
import models.Article;
import models.Category;
import models.Journalist;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;

public class ManageController {

    public ManageController() {
        this.setupEndPoints();

    }


    public void setupEndPoints() {
        get("/manage/articles", (req, res) -> {

            Map<String, Object> model = new HashMap();
            model.put("template", "templates/manage/articles/index.vtl");

            List<Article> articles = DBHelper.getAll(Article.class);
            Article.orderListByDate(articles);
            model.put("articles", articles);
            return new ModelAndView(model, "templates/layout.vtl");

        }, new VelocityTemplateEngine());


        get("/manage/journalist", (req, res) -> {

            Map<String, Object> model = new HashMap();
            model.put("template", "templates/manage/journalists/index.vtl");

            List<Journalist> journalists = DBHelper.getAll(Journalist.class);
            model.put("journalists", journalists);
            return new ModelAndView(model, "templates/layout.vtl");

        }, new VelocityTemplateEngine());


        get("/manage/articles/:id/edit", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("template", "templates/manage/articles/edit.vtl");
            int articleId = Integer.parseInt(request.params(":id"));
            Article article = DBHelper.findById(articleId, Article.class);
            List<Journalist> journalists = DBHelper.getAll(Journalist.class);

            model.put("article", article);
            model.put("categories", Category.values());
            model.put("journalists", journalists);
            return new ModelAndView(model, "templates/layout.vtl");

        }, new VelocityTemplateEngine());


        get("/manage/journalists/:id/edit", (req, res) -> {
            Map<String, Object> model = new HashMap();
            int id = Integer.parseInt(req.params(":id"));
            Journalist journalist = DBHelper.findById(id, Journalist.class);
            model.put("journalist",journalist);
            model.put("template", "templates/manage/journalists/edit.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());


        post("/manage/articles/:id", (req, res) -> {

            //int journalistId = Integer.parseInt(req.queryParams("journalist"));
            //Journalist journalist = DBHelper.findById(journalistId, Journalist.class);
            int articleId = Integer.parseInt(req.params(":id"));
            String title = req.queryParams("title");
            String body = req.queryParams("body");
            String category = req.queryParams("category_id");
            //Doesn't change the journalist
            //maybe as an extension we can change the journalist
            Article article = DBHelper.findById(articleId, Article.class);
            article.setTitle(title);
            article.setBody(body);
            article.setCategory(Category.valueOf(category));

            DBHelper.update(article);

            res.redirect("/manage/articles");

            return null;
        }, new VelocityTemplateEngine());

        post("/manage/articles/:id/delete", (req, res) -> {
            int articleId = Integer.parseInt(req.params(":id"));
            Article article = DBHelper.findById(articleId, Article.class);
            DBHelper.delete(article);

            res.redirect("/manage/articles");

            return null;
        }, new VelocityTemplateEngine());


    }


}