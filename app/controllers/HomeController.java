package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import models.Assets;
import models.OilFields;
import play.libs.Json;
import play.mvc.*;

import java.util.List;


/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index() {
        session("a","Like");
        OilFields oilField = new OilFields();
        //oilField.setOilField("Kawagan",(long)2);
        Assets asset = new Assets();
        //User user = new User("manas","kazak", (long) 1,1,1);
        return ok(Json.toJson(Json.toJson(asset.getAssets())));
    }

}
