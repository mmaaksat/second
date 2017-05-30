
// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/User/Desktop/deeplom/kazak/diplom_project/conf/routes
// @DATE:Thu May 18 11:06:20 ALMT 2017

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseAssets Assets = new controllers.ReverseAssets(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseOilFieldController OilFieldController = new controllers.ReverseOilFieldController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseScenarioController ScenarioController = new controllers.ReverseScenarioController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseYearController YearController = new controllers.ReverseYearController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseMembersController MembersController = new controllers.ReverseMembersController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseLoginController LoginController = new controllers.ReverseLoginController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseAssets Assets = new controllers.javascript.ReverseAssets(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseOilFieldController OilFieldController = new controllers.javascript.ReverseOilFieldController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseScenarioController ScenarioController = new controllers.javascript.ReverseScenarioController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseYearController YearController = new controllers.javascript.ReverseYearController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseMembersController MembersController = new controllers.javascript.ReverseMembersController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseLoginController LoginController = new controllers.javascript.ReverseLoginController(RoutesPrefix.byNamePrefix());
  }

}
