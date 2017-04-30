package controllers;

import models.Asset;
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
public class ScenarioController extends Controller {

    @Inject
    private FormFactory formFactory;

    public Result table(Long aid,Long oid){
        boolean role = LoginController.roleOilView();
        if(null != session("user_id") && role){
            OilField oilField = OilField.find.where().eq("id", oid).findUnique();
            List<Scenario> list = Scenario.find.where().eq("oilField",oilField).findList();
            return ok(Json.toJson(list));
        }else{
            return ok(Json.toJson("Fail"));
        }
    }

    public Result add(Long aid,Long oid){
        boolean role = LoginController.roleOilAdmin();
        if(null != session("user_id") && role){
            Form<Scenario> formScen = formFactory.form(Scenario.class).bindFromRequest();
            OilField oilField = OilField.find.where().eq("id",oid).findUnique();
            Scenario newScen = formScen.get();
            newScen.oilField = oilField;
            newScen.save();
            for(Long i = formScen.get().startYear;i <= formScen.get().endYear;i++){
                YearRecord yearRecord = new YearRecord();
                yearRecord.year = i;
                yearRecord.scenario = newScen;
                yearRecord.save();
            }
            return ok(Json.toJson("Ok"));
        }else{
            return ok(Json.toJson("Fail"));
        }
    }

    public Result edit(Long aid,Long oid,Long sid){
        boolean role = LoginController.roleOilAdmin();
        if(null != session("user_id") && role){
            Form<Scenario> formScen = formFactory.form(Scenario.class).bindFromRequest();
            Scenario scenario = Scenario.find.where().eq("id",sid).findUnique();
            scenario.number = formScen.get().number;
            scenario.tax = formScen.get().tax;
            List<YearRecord> list = YearRecord.find.where().eq("scenario",scenario).findList();
            System.out.println(list);
            for(int i = 0; i <= scenario.endYear - scenario.startYear; i++){
                YearRecord yearRecordForDelete = list.get(i);
                yearRecordForDelete.delete();
            }
            scenario.endYear = formScen.get().endYear;
            scenario.startYear = formScen.get().startYear;
            scenario.inflation = formScen.get().inflation;
            scenario.moneyFromBank = formScen.get().moneyFromBank;
            for(Long i = formScen.get().startYear;i <= formScen.get().endYear;i++){
                YearRecord yearRecord = new YearRecord();
                yearRecord.year = i;
                yearRecord.scenario = scenario;
                yearRecord.save();
            }
            scenario.update();
            return ok(Json.toJson("Ok"));
        }else{
            return ok(Json.toJson("Fail"));
        }
    }

    public Result remove(Long aid,Long oid,Long sid){
        boolean role = LoginController.roleOilAdmin();
        if(null != session("user_id") && role){
            Scenario scenario = Scenario.find.where().eq("id",sid).findUnique();
            List<YearRecord> list = YearRecord.find.where().eq("scenario",scenario).findList();
            for(int i = 0; i <= scenario.endYear - scenario.startYear; i++){
                YearRecord yearRecordForDelete = list.get(i);
                yearRecordForDelete.delete();
            }
            scenario.delete();
            return ok(Json.toJson("Ok"));
        }else{
            return ok(Json.toJson("Fail"));
        }
    }

    public Result get(Long aid,Long oid,Long sid){
        boolean role = LoginController.roleOilView();
        if(null != session("user_id") && role){
            Scenario scenario = Scenario.find.where().eq("id",sid).findUnique();
            return ok(Json.toJson(scenario));
        }else{
            return ok(Json.toJson("Fail"));
        }
    }
}
