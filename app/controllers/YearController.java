package controllers;

import models.OilField;
import models.Scenario;
import models.YearRecord;
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
public class YearController extends Controller {
    @Inject
    private FormFactory formFactory;

    public Result table(Long aid, Long oid,Long sid){
        if("" != session("user_id")){
            Scenario scenario = Scenario.find.where().eq("id", sid).findUnique();
            List<YearRecord> list = YearRecord.find.where().eq("scenario",scenario).findList();
            return ok(Json.toJson(list));
        }else{
            return ok(Json.toJson("Fail"));
        }
    }

    public Result add(Long aid,Long oid,Long sid){
        if("" != session("user_id")){
            Form<YearRecord> formYear = formFactory.form(YearRecord.class).bindFromRequest();
            Scenario scenario = Scenario.find.where().eq("id",sid).findUnique();
            YearRecord yearRecord = formYear.get();
            yearRecord.scenario = scenario;
            yearRecord.save();
            return ok(Json.toJson("Ok"));
        }else{
            return ok(Json.toJson("Fail"));
        }
    }

    public Result edit(Long aid,Long oid,Long sid,Long yid){
        if("" != session("user_id")){
            Form<YearRecord> formScen = formFactory.form(YearRecord.class).bindFromRequest();
            YearRecord yearRecord = YearRecord.find.where().eq("id",sid).findUnique();
            yearRecord.creditPayments = formScen.get().creditPayments;
            yearRecord.fieldDevelopmentCost = formScen.get().fieldDevelopmentCost;
            yearRecord.oilSold = formScen.get().oilSold;
            yearRecord.oilPrice = formScen.get().oilPrice;
            yearRecord.update();
            return ok(Json.toJson("Ok"));
        }else{
            return ok(Json.toJson("Fail"));
        }
    }

    public Result remove(Long aid,Long oid,Long sid,Long yid){
        if("" != session("user_id")){
            YearRecord yearRecord = YearRecord.find.where().eq("id",yid).findUnique();
            yearRecord.delete();
            return ok(Json.toJson("Ok"));
        }else{
            return ok(Json.toJson("Fail"));
        }
    }

    public Result get(Long aid,Long oid,Long sid,Long yid){
        if("" != session("user_id")){
            YearRecord yearRecord = YearRecord.find.where().eq("id",yid).findUnique();
            return ok(Json.toJson(yearRecord));
        }else{
            return ok(Json.toJson("Fail"));
        }
    }
}
