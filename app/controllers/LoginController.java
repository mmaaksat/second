package controllers;

import com.avaje.ebean.Model;
import com.fasterxml.jackson.databind.JsonNode;
import jdk.nashorn.internal.ir.ObjectNode;
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
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class LoginController extends Controller {

    @Inject
    private FormFactory formFactory;
    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index() {
        Form<AssetsUser> formAsset = formFactory.form(AssetsUser.class).bindFromRequest();
        AssetsUser dataAsset = formAsset.get();
        AssetsUser inAssetsUser = AssetsUser.find.where().eq("login",dataAsset.login).
                eq("password",dataAsset.password).findUnique();
        if(inAssetsUser != null){
            session("user_id", String.valueOf(inAssetsUser.id));
            session("role_id", String.valueOf(inAssetsUser.role));
            Asset asset = Asset.find.where().eq("assetsUser",inAssetsUser).findUnique();
            com.fasterxml.jackson.databind.node.ObjectNode response = Json.newObject();
            response.put("role", String.valueOf(inAssetsUser.role));
            response.put("asset_id", String.valueOf(asset.id));
            response.put("oil_field_id", "failed");
            return ok(Json.toJson(response));
        }else{
            Form<OilUsers> formOil = formFactory.form(OilUsers.class).bindFromRequest();
            OilUsers dataOil = formOil.get();
            OilUsers inOilUsers = OilUsers.find.where().eq("login",dataOil.login)
                    .eq("password",dataOil.password).findUnique();
            if(inOilUsers != null){
                session("user_id", String.valueOf(inOilUsers.id));
                session("role_id", String.valueOf(inOilUsers.role));
                OilField oilField = OilField.find.where().eq("oilUsers",inOilUsers).findUnique();
                Asset asset = Asset.find.where().eq("oilField",oilField).findUnique();
                com.fasterxml.jackson.databind.node.ObjectNode response = Json.newObject();
                response.put("role", String.valueOf(inOilUsers.role));
                response.put("oil_field_id", String.valueOf(oilField.id));
                response.put("asset_id", String.valueOf(asset.id));
                return ok(Json.toJson(response));
            }else{
                com.fasterxml.jackson.databind.node.ObjectNode response = Json.newObject();
                response.put("role", "failed");
                response.put("oil_field_id", "failed");
                response.put("asset_id", "failed");
                return ok(Json.toJson(response));
            }

        }

        //Asset myAsset = Asset.find.byId(1L);
        //OilField oilField = OilField.find.byId((long)1);

        //OilField oil = OilField.find
        //        .select("oilFieldsName")
        //        .where().idEq(1L)
        //        .findUnique();
        //Asset ast = Asset.find.select("name").where().idEq(1L).findUnique();
        //oilField.setOilField("Kawagan",(long)2);
        //OilField.find.where().eq("asset", myAsset).findList())
        //User user = new User("manas","kazak", (long) 1,1,1);
        //Asset ast1 = Asset.find.where().in("id",2L).findUnique();
        //List<OilField> field = OilField.find.where().eq("asset", myAsset).findList();
        //System.out.println(field.get(1).oilFieldsName);
        //return ok(Json.toJson(inAssetsUser));
    }

}
