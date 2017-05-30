package controllers;

import models.OilField;
import models.OilUsers;
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
 * Created by Max on 26.04.2017.
 */
public class YearController extends Controller {
    @Inject
    private FormFactory formFactory;

    public Result table(Long aid, Long oid,Long sid){
        boolean role = LoginController.roleOilView();
        if(null != session("user_id") && role){
            Scenario scenario = Scenario.find.where().eq("id", sid).findUnique();
            List<YearRecord> list = YearRecord.find.where().eq("scenario",scenario).findList();
            return ok(Json.toJson(list));
        }else{
            return ok(Json.toJson("Fail"));
        }
    }

    public Result add(Long aid,Long oid,Long sid){
        boolean role = LoginController.roleOilAdmin();
        if(null != session("user_id") && role){
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
        boolean role = LoginController.roleOilAdmin();
        if(null != session("user_id") && role){
            Form<YearRecord> formScen = formFactory.form(YearRecord.class).bindFromRequest();
            YearRecord yearRecord = YearRecord.find.where().eq("id",yid).findUnique();
            yearRecord.creditPayments = formScen.get().creditPayments;
            yearRecord.year = formScen.get().year;
            yearRecord.fieldDevelopmentCost = formScen.get().fieldDevelopmentCost;
            yearRecord.oilSold = formScen.get().oilSold;
            yearRecord.oilPrice = formScen.get().oilPrice;
            yearRecord.yearCosts = yearRecord.creditPayments + yearRecord.fieldDevelopmentCost;
            yearRecord.income = yearRecord.oilPrice * yearRecord.oilSold;
            yearRecord.yearMargins = yearRecord.income - yearRecord.yearCosts;
            yearRecord.update();
            Scenario scenario = Scenario.find.where().eq("id",sid).findUnique();
            List<YearRecord> list = YearRecord.find.where().eq("scenario",scenario).findList();
            Long income = 0L;
            Long cost  = 0L;
            for(int i = 0; i<list.size();i++){
                if(list.get(i).income != null) {
                    income += list.get(i).income;
                    cost += list.get(i).yearCosts;
                }
            }
            double taxs = income* scenario.tax * 0.01 ;
            Long costWithTax = (long)taxs;
            Long allCost = costWithTax + cost;
            Long allIncome = income + scenario.moneyFromBank;
            scenario.cost = allCost;
            double allMargin = (allIncome - allCost)*((100 + scenario.inflation)*0.01);
            scenario.scenarioMargin = (long) allMargin;
            scenario.update();
            OilField oilField = OilField.find.where().eq("id",oid).findUnique();
            List<Scenario> scenList = Scenario.find.where().eq("oilField",oilField).findList();
            Long max = -111111111110L;
            String name = "";
            for(int i = 0; i<scenList.size();i++){
                if(scenList.get(i).scenarioMargin != null) {
                    if (max < scenList.get(i).scenarioMargin) {
                        max = scenList.get(i).scenarioMargin;
                        name = scenList.get(i).number;
                    }
                }
            }
            System.out.println(list.get(1).income);
            oilField.bestMargin = max;
            oilField.bestScenario = name;
            oilField.update();
            return ok(Json.toJson("Ok"));
        }else{
            return ok(Json.toJson("Fail"));
        }
    }

    public Result remove(Long aid,Long oid,Long sid,Long yid){
        boolean role = LoginController.roleOilAdmin();
        if(null != session("user_id") && role){
            YearRecord yearRecord = YearRecord.find.where().eq("id",yid).findUnique();
            yearRecord.delete();
            return ok(Json.toJson("Ok"));
        }else{
            return ok(Json.toJson("Fail"));
        }
    }

    public Result get(Long aid,Long oid,Long sid,Long yid){
        boolean role = LoginController.roleOilView();
        if(null != session("user_id") && role){
            YearRecord yearRecord = YearRecord.find.where().eq("id",yid).findUnique();
            return ok(Json.toJson(yearRecord));
        }else{
            return ok(Json.toJson("Fail"));
        }
    }
}
