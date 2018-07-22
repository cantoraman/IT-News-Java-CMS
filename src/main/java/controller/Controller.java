package controller;

import db.Seeds;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
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
                return new ModelAndView(model, "templates/layout.vtl");
            }, velocityTemplateEngine);


        }


    }







