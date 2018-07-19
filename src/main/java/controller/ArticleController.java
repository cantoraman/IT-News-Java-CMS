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

public class ArticleController {

    public ArticleController(){
        this.setupEndPoints();

    }


    public void setupEndPoints(){

        get("/articles", (req, res) -> {

            Map<String, Object> model = new HashMap();
            model.put("template", "templates/article/index.vtl");

            List<Article> articles = DBHelper.getAll(Article.class);
            model.put("articles", articles);
            return new ModelAndView(model, "templates/layout.vtl");

        }, new VelocityTemplateEngine());


        get("/articles/new", (req, res) -> {


            Map<String, Object> model = new HashMap();
            List<Journalist> journalists = DBHelper.getAll(Journalist.class);
            model.put("journalists", journalists);
            model.put("template", "templates/article/create.vtl");
            return new ModelAndView(model, "templates/layout.vtl");

        }, new VelocityTemplateEngine());



        post("/articles", (req, res) -> {

            int journalistId = Integer.parseInt(req.queryParams("journalist"));
            Journalist journalist = DBHelper.findById(journalistId, Journalist.class);
            String title = req.queryParams("title");
            String body = req.queryParams("body");
            Category category = Category.valueOf(req.queryParams("category"));


            Article newManager = new Article(title, body, category, journalist);
            DBHelper.save(newManager);

            res.redirect("/articles");

            return null;
        }, new VelocityTemplateEngine());






    }



}
