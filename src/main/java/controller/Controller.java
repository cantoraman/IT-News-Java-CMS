package controller;

<<<<<<< HEAD
import spark.template.velocity.VelocityTemplateEngine;

public class Controller {

=======
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


        get("/", (req, res) -> {

            Map<String, Object> model = new HashMap();
            model.put("template", "templates/index.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());


    }

>>>>>>> 999a3ed63001d5d36b85298cf2d66e978d3e1c23
}






