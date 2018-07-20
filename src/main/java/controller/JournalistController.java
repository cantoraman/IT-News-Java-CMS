package controller;

import db.DBHelper;
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

        get("/journalist", (req, res) -> {

            Map<String, Object> model = new HashMap();
            model.put("template", "templates/journalist/index.vtl");

            List<Journalist> journalists = DBHelper.getAll(Journalist.class);
            model.put("journalists", journalists);
            return new ModelAndView(model, "templates/layout.vtl");

        }, new VelocityTemplateEngine());


        get("/journalist/new", (req, res) -> {


            Map<String, Object> model = new HashMap();
            model.put("template", "templates/article/create.vtl");
            return new ModelAndView(model, "templates/layout.vtl");

        }, new VelocityTemplateEngine());



        post("/journalist", (req, res) -> {

            String name = req.queryParams("name");
            String description = req.queryParams("description");


            Journalist newJournalist = new Journalist(name, description);
            DBHelper.save(newJournalist);

            res.redirect("/journalist");

            return null;
        }, new VelocityTemplateEngine());


        get("/journalist/:id/edit", (req, res) -> {
            Map<String, Object> model = new HashMap();
            int id = Integer.parseInt(req.params(":id"));
            Journalist journalist = DBHelper.findById(id, Journalist.class);
            model.put("journalist",journalist);
            model.put("template", "templates/journalist/edit.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());


        post("/journalist/:id", (req,res) ->{

            int journalistId = Integer.parseInt(req.params(":id"));
            String name = req.queryParams("name");
            String description = req.queryParams("description");

            Journalist journalist = DBHelper.findById(journalistId, Journalist.class);
            journalist.setName(name);
            journalist.setDescription(description);
            DBHelper.save(journalist);
            res.redirect("/journalist");
            return null;

        }, new VelocityTemplateEngine());

        get ("/journalist/:id", (req, res)->{
            Map<String, Object> model = new HashMap<>();
            int id = Integer.parseInt(req.params(":id"));
            Journalist journalist = DBHelper.findById(id, Journalist.class);
            model.put("journalist", journalist);
            model.put("template", "templates/journalist/show.vtl");
            return new ModelAndView(model, "templates/layout.vtl");

        }, new VelocityTemplateEngine());

        post ("/journalist/:id/delete", (req, res) -> {

            int journalistId = Integer.parseInt(req.params(":id"));
            Journalist journalist = DBHelper.findById(journalistId, Journalist.class);
            DBHelper.delete(journalist);

            res.redirect("/journalist");
            return null;
        }, new VelocityTemplateEngine());




    }
}
