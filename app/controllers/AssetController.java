package controllers;

import models.Asset;
import models.AssetsUser;
import models.OilField;
import models.OilUsers;
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
public class AssetController extends Controller {

    @Inject
    private FormFactory formFactory;

    public Result index(){
        if("" != session("user_id")){
            String user_id = session("user_id");
            AssetsUser user = AssetsUser.find.where().in("id",user_id).findUnique();
            Asset asset = Asset.find.where().eq("assetsUsers", user).findUnique();
            List<OilField> field = OilField.find.where().eq("asset", asset).findList();
            return ok(Json.toJson(field));
        }else{
            com.fasterxml.jackson.databind.node.ObjectNode response = Json.newObject();
            response.put("response","failed");
            return ok(Json.toJson(response));
        }
    }

    public Result addOil(){
        if("" != session("user_id") ){
            String user_id = session("user_id");
            Form<OilField> form = formFactory.form(OilField.class).bindFromRequest();
            AssetsUser user = AssetsUser.find.where().in("id",user_id).findUnique();
            Asset asset = Asset.find.where().eq("assetsUsers", user).findUnique();
            OilField oilField = form.get();
            oilField.asset = asset;
            oilField.save();
            com.fasterxml.jackson.databind.node.ObjectNode response = Json.newObject();
            response.put("response","success");
            return ok(Json.toJson(response));
        }else{
            com.fasterxml.jackson.databind.node.ObjectNode response = Json.newObject();
            response.put("response","failed");
            return ok(Json.toJson(response));
        }
    }



    public Result editOil(Long id){
        if("" != session("user_id") ){
            String user_id = session("user_id");
            Form<OilField> form = formFactory.form(OilField.class).bindFromRequest();
            AssetsUser user = AssetsUser.find.where().in("id",user_id).findUnique();
            Asset asset = Asset.find.where().eq("assetsUsers", user).findUnique();
            OilField field = OilField.find.where().eq("asset", asset).eq("id",id).findUnique();
            field.oilFieldsName =  form.get().oilFieldsName;
            field.update();
            com.fasterxml.jackson.databind.node.ObjectNode response = Json.newObject();
            response.put("response","success");
            return ok(Json.toJson(response));
        }else{
            com.fasterxml.jackson.databind.node.ObjectNode response = Json.newObject();
            response.put("response","failed");
            return ok(Json.toJson(response));
        }
    }
}
