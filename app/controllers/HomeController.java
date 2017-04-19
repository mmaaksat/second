package controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import models.User;
import play.libs.Json;
import play.mvc.*;



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
        ObjectNode field1 = Json.newObject();
        field1.put("name", "value");
        return ok(Json.toJson(field1));
    }


}
