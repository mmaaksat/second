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
import java.util.Collection;
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
            session("user_id", inAssetsUser.login.toString());
            session("role_id", inAssetsUser.role.toString());
            Asset asset = Asset.find.where().eq("id",inAssetsUser.asset.id).findUnique();
            com.fasterxml.jackson.databind.node.ObjectNode response = Json.newObject();
            response.put("role", inAssetsUser.role.toString());
            response.put("asset_id", asset.id.toString());
            response.put("oil_field_id", "failed");
            response.put("user_id", inAssetsUser.login.toString());
            return ok(Json.toJson(response));
        }else{
            Form<OilUsers> formOil = formFactory.form(OilUsers.class).bindFromRequest();
            OilUsers dataOil = formOil.get();
            OilUsers inOilUsers = OilUsers.find.where().eq("login",dataOil.login)
                    .eq("password",dataOil.password).findUnique();
            System.out.println("AAAAAAAAAAAAAAAAAAAAAAAA");
            if(inOilUsers != null){
                session("user_id", String.valueOf(inOilUsers.login));
                session("role_id", inOilUsers.role.toString());
                OilField oilField = OilField.find.where().eq("id",inOilUsers.oilField.id).findUnique();
                Asset asset = Asset.find.where().eq("id",oilField.asset.id).findUnique();
                com.fasterxml.jackson.databind.node.ObjectNode response = Json.newObject();
                response.put("role", inOilUsers.role.toString());
                response.put("oil_field_id", oilField.id.toString());
                response.put("asset_id", asset.id.toString());
                response.put("user_id", inOilUsers.login.toString());
                return ok(Json.toJson(response));
            }else{
                com.fasterxml.jackson.databind.node.ObjectNode response = Json.newObject();
                response.put("role", "failed");
                response.put("oil_field_id", "failed");
                response.put("asset_id", "failed");
                System.out.println("Failed");
                return ok(Json.toJson(response));
            }

        }


    }

    public Result getRole(){
        System.out.println(session("user_id"));
        if(null != session("user_id") && null != session("role_id").toString()){
            com.fasterxml.jackson.databind.node.ObjectNode response = Json.newObject();
            response.put("role", session("role_id").toString());
            response.put("user_id", session("user_id").toString());
            return ok(Json.toJson(response));
        }else{
            return ok(Json.toJson("Fail"));
        }

    }

    public Result getUser(){
        System.out.println(session("user_id"));
        if(null != session("user_id") && null != session("role_id").toString()){
            if(LoginController.roleAsset()){
                AssetsUser assetsUser = AssetsUser.find.where().eq("login",session("user_id")).findUnique();
                return ok(Json.toJson(assetsUser));
            }else {
                OilUsers oilUsers = OilUsers.find.where().eq("login",session("user_id")).findUnique();
                return ok(Json.toJson(oilUsers));
            }
        }else{
            return ok(Json.toJson("Fail"));
        }

    }

    public Result editUser(){
        System.out.println(session("user_id"));
        if(null != session("user_id") && null != session("role_id").toString()){
            if(LoginController.roleAsset()){
                Form<AssetsUser> formAssetUser = formFactory.form(AssetsUser.class).bindFromRequest();
                AssetsUser assetsUser = AssetsUser.find.where().eq("login",session("user_id")).findUnique();
                assetsUser.login = formAssetUser.get().login;
                assetsUser.password = formAssetUser.get().password;
                assetsUser.update();
                session().remove("user_id");
                session("user_id",assetsUser.login);
                return ok(Json.toJson("ok"));
            }else {
                Form<OilUsers> formAssetUser = formFactory.form(OilUsers.class).bindFromRequest();
                OilUsers oilUsers = OilUsers.find.where().eq("login",session("user_id")).findUnique();
                oilUsers.login = formAssetUser.get().login;
                oilUsers.password = formAssetUser.get().password;
                oilUsers.update();
                session().remove("user_id");
                session("user_id",oilUsers.login);
                return ok(Json.toJson("ok"));
            }
        }else{
            return ok(Json.toJson("Fail"));
        }

    }

    public Result logout(){
        if(null != session("user_id") ){
            session().remove("user_id");
            session().remove("role_id");
            return ok(Json.toJson("OK"));
        }else{
            return ok(Json.toJson("Fail"));
        }

    }

    public static boolean roleAssetAdmin(){
        boolean role = false;
        switch (session("role_id").toString()){
            case "ASSET_ADMIN":
                role = true;
                break;
            case "ASSET_VIEW":
                role = false;
                break;
            case "OIL_ADMIN":
                role = false;
                break;
            case "OIL_VIEW":
                role = false;
                break;
        }
        return role;
    }

    public static boolean roleAsset(){
        boolean role = false;
        switch (session("role_id").toString()){
            case "ASSET_ADMIN":
                role = true;
                break;
            case "ASSET_VIEW":
                role = true;
                break;
            case "OIL_ADMIN":
                role = false;
                break;
            case "OIL_VIEW":
                role = false;
                break;
        }
        return role;
    }

    public static boolean roleOilAdmin(){
        boolean role = false;
        switch (session("role_id").toString()){
            case "ASSET_ADMIN":
                role = false;
                break;
            case "ASSET_VIEW":
                role = false;
                break;
            case "OIL_ADMIN":
                role = true;
                break;
            case "OIL_VIEW":
                role = false;
                break;
        }
        return role;
    }

    public static boolean roleOilView(){
        boolean role = false;
        switch (session("role_id").toString()){
            case "ASSET_ADMIN":
                role = true;
                break;
            case "ASSET_VIEW":
                role = true;
                break;
            case "OIL_ADMIN":
                role = true;
                break;
            case "OIL_VIEW":
                role = true;
                break;
        }
        return role;
    }




}
