package controller;

import db.Seeds;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;


    public class Controller {

        public static void main(String[] args) {
            Seeds.seedData();


            ArticleController articleController = new ArticleController();
            JournalistController journalistController = new JournalistController();
            ManageController manageController = new ManageController();


            get("/", (req, res) -> {

                Map<String, Object> model = new HashMap();
                model.put("template", "templates/index.vtl");
                return new ModelAndView(model, "templates/layout.vtl");
            }, new VelocityTemplateEngine());


        }


    }







