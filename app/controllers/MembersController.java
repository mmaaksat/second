package controllers;

import models.OilField;
import models.OilUsers;
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
public class MembersController extends Controller {
    @Inject
    private FormFactory formFactory;

    public Result table(Long aid, Long oid){
        boolean role = LoginController.roleAssetAdmin();
        if("" != session("user_id") && role){
            OilField oilField = OilField.find.where().eq("id", oid).findUnique();
            List<OilUsers> list = OilUsers.find.where().eq("oilField",oilField).findList();
            return ok(Json.toJson(list));
        }else{
            return ok(Json.toJson("Fail"));
        }
    }

    public Result add(Long aid,Long oid){
        boolean role = LoginController.roleAssetAdmin();
        if("" != session("user_id") && role){
            Form<OilUsers> formUser = formFactory.form(OilUsers.class).bindFromRequest();
            OilField oilField = OilField.find.where().eq("id",oid).findUnique();
            OilUsers newUser = formUser.get();
            newUser.oilField = oilField;
            newUser.save();
            return ok(Json.toJson("Ok"));
        }else{
            return ok(Json.toJson("Fail"));
        }
    }

    public Result edit(Long aid,Long oid,Long mid){
        boolean role = LoginController.roleAssetAdmin();
        if("" != session("user_id") && role){
            Form<OilUsers> formScen = formFactory.form(OilUsers.class).bindFromRequest();
            OilUsers oilUsers = OilUsers.find.where().eq("id",mid).findUnique();
            oilUsers.login = formScen.get().login;
            oilUsers.password = formScen.get().password;
            oilUsers.role = formScen.get().role;
            oilUsers.update();
            return ok(Json.toJson("Ok"));
        }else{
            return ok(Json.toJson("Fail"));
        }
    }

    public Result remove(Long aid,Long oid,Long mid){
        boolean role = LoginController.roleAssetAdmin();
        if("" != session("user_id") && role){
            OilUsers oilUsers = OilUsers.find.where().eq("id",mid).findUnique();
            oilUsers.delete();
            return ok(Json.toJson("Ok"));
        }else{
            return ok(Json.toJson("Fail"));
        }
    }

    public Result get(Long aid,Long oid,Long  mid){
        boolean role = LoginController.roleAssetAdmin();
        if("" != session("user_id") && role){
            OilUsers oilUsers = OilUsers.find.where().eq("id",mid).findUnique();
            return ok(Json.toJson(oilUsers));
        }else{
            return ok(Json.toJson("Fail"));
        }
    }
}
