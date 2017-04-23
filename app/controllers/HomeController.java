package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import jdk.nashorn.internal.ir.ObjectNode;
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
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    @Inject
    private FormFactory formFactory;
    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index() {
        AssetsUser as = new AssetsUser();
        Form<AssetsUser> form = formFactory.form(AssetsUser.class).bindFromRequest();
        as = form.get();
        AssetsUser inAssetsUser = AssetsUser.find.where().eq("login",as.login).
                eq("password",as.password).findUnique();
        if(inAssetsUser != null){
            return ok(Json.toJson(inAssetsUser));
        }else{
            return ok(Json.toJson(as));
        }
        //session("a", "Like");
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
