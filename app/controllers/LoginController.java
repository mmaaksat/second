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
        AssetsUser inAssetsUser = AssetsUser.find.where().eq("login",formAsset.get().login).
                eq("password",formAsset.get().password).findUnique();
        if(inAssetsUser != null){
            session("user_id", inAssetsUser.id.toString());
            session("role_id", inAssetsUser.role.toString());
            Asset asset = Asset.find.where().eq("id",inAssetsUser.asset.id).findUnique();
            com.fasterxml.jackson.databind.node.ObjectNode response = Json.newObject();
            response.put("role", inAssetsUser.role.toString());
            response.put("asset_id", asset.id.toString());
            response.put("oil_field_id", "failed");
            return ok(Json.toJson(response));
        }else{
            Form<OilUsers> formOil = formFactory.form(OilUsers.class).bindFromRequest();
            OilUsers dataOil = formOil.get();
            OilUsers inOilUsers = OilUsers.find.where().eq("login",dataOil.login)
                    .eq("password",dataOil.password).findUnique();
            if(inOilUsers != null){
                session("user_id", String.valueOf(inOilUsers.id));
                session("role_id", inOilUsers.role.toString());
                OilField oilField = OilField.find.where().eq("id",inOilUsers.oilField.id).findUnique();
                Asset asset = Asset.find.where().eq("id",oilField.asset.id).findUnique();
                com.fasterxml.jackson.databind.node.ObjectNode response = Json.newObject();
                response.put("role", inOilUsers.role.toString());
                response.put("oil_field_id", oilField.id.toString());
                response.put("asset_id", asset.id.toString());
                return ok(Json.toJson(response));
            }else{
                com.fasterxml.jackson.databind.node.ObjectNode response = Json.newObject();
                response.put("role", "failed");
                response.put("oil_field_id", "failed");
                response.put("asset_id", "failed");
                return ok(Json.toJson(response));
            }

        }


    }

}
