package controller;

import db.DBHelper;
import db.Seeds;
import models.Article;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;
import static spark.SparkBase.staticFileLocation;


public class Controller {

        public static void main(String[] args) {
            VelocityTemplateEngine velocityTemplateEngine = new VelocityTemplateEngine();
            staticFileLocation("/public");
            Seeds.seedData();


            ArticleController articleController = new ArticleController();
            JournalistController journalistController = new JournalistController();
            ManageController manageController = new ManageController();
            CategoryController categoryController = new CategoryController();


            get("/", (req, res) -> {

                Map<String, Object> model = new HashMap();
                model.put("template", "templates/index.vtl");
                List<Article> articles = DBHelper.getAll(Article.class);
                List<Article> trendingArticles = Article.orderListByPopularity(articles,3);
                Article.orderListByDate(articles);
                model.put("articles", articles);
                model.put("trendingArticles", trendingArticles);
                return new ModelAndView(model, "templates/layout.vtl");
            }, velocityTemplateEngine);


        }


    }







