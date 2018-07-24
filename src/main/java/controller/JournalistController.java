package controller;

import db.DBHelper;
import db.DBJournalist;
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

public class JournalistController {

    public JournalistController(){
        this.setupEndPoints();
    }


    public void setupEndPoints(){

        get("/journalists", (req, res) -> {

            Map<String, Object> model = createModel();
            model.put("template", "templates/journalist/index.vtl");

            List<Journalist> journalists = DBHelper.getAll(Journalist.class);
            model.put("journalists", journalists);
            return new ModelAndView(model, "templates/layout.vtl");

        }, new VelocityTemplateEngine());


        get("/journalists/new", (req, res) -> {

            Map<String, Object> model = createModel();
            model.put("template", "templates/journalist/create.vtl");
            return new ModelAndView(model, "templates/layout.vtl");

        }, new VelocityTemplateEngine());



        post("/journalists", (req, res) -> {

            String name = req.queryParams("name");
            String description = req.queryParams("description");


            Journalist newJournalist = new Journalist(name, description);
            DBHelper.save(newJournalist);

            res.redirect("/journalists/manage");

            return null;
        }, new VelocityTemplateEngine());

        get("/journalists/manage", (req, res) -> {

            Map<String, Object> model = createModel();
            model.put("template", "templates/manage/journalists/index.vtl");

            List<Journalist> journalists = DBHelper.getAll(Journalist.class);
            model.put("journalists", journalists);
            return new ModelAndView(model, "templates/layout.vtl");

        }, new VelocityTemplateEngine());


        get ("/journalists/:id", (req, res)->{
            Map<String, Object> model = createModel();
            int id = Integer.parseInt(req.params(":id"));
            Journalist journalist = DBHelper.findById(id, Journalist.class);
            List<Article> articles = DBJournalist.getArticlesForJournalist(journalist);
            model.put("journalist", journalist);

            model.put("articles", articles);
            model.put("template", "templates/journalist/show.vtl");
            return new ModelAndView(model, "templates/layout.vtl");

        }, new VelocityTemplateEngine());


        get("/journalists/:id/edit", (req, res) -> {
            Map<String, Object> model = createModel();
            int id = Integer.parseInt(req.params(":id"));
            Journalist journalist = DBHelper.findById(id, Journalist.class);
            model.put("journalist",journalist);
            model.put("template", "templates/journalist/edit.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());



        post("/journalists/:id", (req,res) ->{

            int journalistId = Integer.parseInt(req.params(":id"));
            String name = req.queryParams("name");
            String description = req.queryParams("description");

            Journalist journalist = DBHelper.findById(journalistId, Journalist.class);
            journalist.setName(name);
            journalist.setDescription(description);
            DBHelper.update(journalist);
            res.redirect("/journalists/manage");
            return null;

        }, new VelocityTemplateEngine());


        post ("/journalists/:id/delete", (req, res) -> {

            int journalistId = Integer.parseInt(req.params(":id"));
            Journalist journalist = DBHelper.findById(journalistId, Journalist.class);
            DBHelper.delete(journalist);

            res.redirect("/journalists/manage");
            return null;
        }, new VelocityTemplateEngine());
    }


    public static Map<String, Object> createModel() {
        Map<String, Object> model = new HashMap();
        List<Article> articles = DBHelper.getAll(Article.class);
        Article.orderListByDate(articles);
        List<Article> trendingArticles = Article.orderListByPopularity(articles,3);
        model.put("trendingArticles", trendingArticles);
        model.put("categories", Category.values());
        model.put("articles", articles);
        return model;
    }
}
