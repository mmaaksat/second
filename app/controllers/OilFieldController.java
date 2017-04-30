package controllers;

import models.Asset;
import models.AssetsUser;
import models.OilField;
import play.data.Form;
import play.data.FormFactory;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Manas on 25.04.2017.
 */
public class OilFieldController extends Controller{

    @Inject
    private FormFactory formFactory;

    public Result table(Long aid){
        boolean role = LoginController.roleAsset();
        if(null != session("user_id") && role){
            Asset asset = Asset.find.where().eq("id", aid).findUnique();
            List<OilField> list = OilField.find.where().eq("asset",asset).findList();
            return ok(Json.toJson(list));
        }else{
            return ok(Json.toJson("Fail"));
        }
    }


    public Result add(Long aid){
        boolean role = LoginController.roleAssetAdmin();
        if(null != session("user_id") && role){
            Form<OilField> formOil = formFactory.form(OilField.class).bindFromRequest();
            Asset asset = Asset.find.where().eq("id", aid).findUnique();
            OilField newOil = formOil.get();
            newOil.asset = asset;
            newOil.save();
            return ok(Json.toJson("Ok"));
        }else{
            return ok(Json.toJson("Fail"));
        }
    }

    public Result edit(Long aid,Long oid){
        boolean role = LoginController.roleAssetAdmin();
        if(null != session("user_id") && role){
            Form<OilField> formOil = formFactory.form(OilField.class).bindFromRequest();
            OilField oilField = OilField.find.where().eq("id",oid).findUnique();
            oilField.oilFieldsName = formOil.get().oilFieldsName;
            oilField.update();
            return ok(Json.toJson("Ok"));
        }else{
            return ok(Json.toJson("Fail"));
        }
    }

    public Result remove(Long aid,Long oid){
        boolean role = LoginController.roleAssetAdmin();
        if(null != session("user_id") && role){
            OilField oilField = OilField.find.where().eq("id",oid).findUnique();
            oilField.delete();
            return ok(Json.toJson("Ok"));
        }else{
            return ok(Json.toJson("Fail"));
        }
    }

    public Result get(Long aid,Long oid){
        boolean role = LoginController.roleAsset();
        if(null != session("user_id") && role){
            OilField oilField = OilField.find.where().eq("id",oid).findUnique();
            return ok(Json.toJson(oilField));
        }else{
            return ok(Json.toJson("Fail"));
        }
    }
}
