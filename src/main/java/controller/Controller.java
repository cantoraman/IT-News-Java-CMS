package controller;

import db.DBHelper;
import db.Seeds;
import models.Article;
import models.Category;
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
            CategoryController categoryController = new CategoryController();


            get("/", (req, res) -> {
                Map<String, Object> model = createModel();
                model.put("template", "templates/index.vtl");
                return new ModelAndView(model, "templates/layout.vtl");
            }, velocityTemplateEngine);


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







