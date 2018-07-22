package controller;

import db.DBArticle;
import db.DBHelper;
import models.Article;
import models.Category;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;

public class CategoryController {

public CategoryController(){
    this.setupEndPoints();
}


    public void setupEndPoints() {

        get("/categories", (req, res) -> {

            Map<String, Object> model = new HashMap();
            model.put("template", "templates/categories/index.vtl");
            model.put("categories", Category.values());
            return new ModelAndView(model, "templates/layout.vtl");

        }, new VelocityTemplateEngine());


        get("/categories/:category", (request, response) -> {

            Map<String, Object> model = new HashMap<>();
            model.put("template", "templates/categories/show.vtl");
            String categoryString = request.params(":category");
            Category categoryEnum = Category.valueOf(categoryString);
            ArrayList<Article> articles = DBArticle.getAllByCategory(categoryEnum);
            model.put("category", categoryEnum);
            model.put("articles", articles);
            return new ModelAndView(model, "templates/layout.vtl");

        }, new VelocityTemplateEngine());




    }
















    }
