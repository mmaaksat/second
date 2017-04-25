package controllers;

import models.Asset;
import models.OilField;
import models.Scenario;
import play.data.Form;
import play.data.FormFactory;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Manas on 26.04.2017.
 */
public class ScenarioController extends Controller {

    @Inject
    private FormFactory formFactory;

    public Result table(Long aid,Long oid){
        if("" != session("user_id")){
            OilField oilField = OilField.find.where().eq("id", oid).findUnique();
            List<Scenario> list = Scenario.find.where().eq("oilField",oilField).findList();
            return ok(Json.toJson(list));
        }else{
            return ok(Json.toJson("Fail"));
        }
    }

    public Result add(Long aid,Long oid){
        if("" != session("user_id")){
            Form<Scenario> formScen = formFactory.form(Scenario.class).bindFromRequest();
            OilField oilField = OilField.find.where().eq("id",oid).findUnique();
            Scenario newScen = formScen.get();
            newScen.oilField = oilField;
            newScen.save();
            return ok(Json.toJson("Ok"));
        }else{
            return ok(Json.toJson("Fail"));
        }
    }

    public Result edit(Long aid,Long oid,Long sid){
        if("" != session("user_id")){
            Form<Scenario> formScen = formFactory.form(Scenario.class).bindFromRequest();
            OilField oilField = OilField.find.where().eq("id",sid).findUnique();
            Scenario scenario = formScen.get();
            scenario.oilField = oilField;
            scenario.update();
            return ok(Json.toJson("Ok"));
        }else{
            return ok(Json.toJson("Fail"));
        }
    }

}
