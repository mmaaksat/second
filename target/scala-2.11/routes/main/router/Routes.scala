
// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/User/Desktop/deeplom/kazak/diplom_project/conf/routes
// @DATE:Thu May 18 11:06:20 ALMT 2017

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:5
  Assets_4: controllers.Assets,
  // @LINE:7
  LoginController_5: controllers.LoginController,
  // @LINE:12
  OilFieldController_3: controllers.OilFieldController,
  // @LINE:21
  ScenarioController_1: controllers.ScenarioController,
  // @LINE:27
  MembersController_2: controllers.MembersController,
  // @LINE:33
  YearController_0: controllers.YearController,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:5
    Assets_4: controllers.Assets,
    // @LINE:7
    LoginController_5: controllers.LoginController,
    // @LINE:12
    OilFieldController_3: controllers.OilFieldController,
    // @LINE:21
    ScenarioController_1: controllers.ScenarioController,
    // @LINE:27
    MembersController_2: controllers.MembersController,
    // @LINE:33
    YearController_0: controllers.YearController
  ) = this(errorHandler, Assets_4, LoginController_5, OilFieldController_3, ScenarioController_1, MembersController_2, YearController_0, "/")

  import ReverseRouteContext.empty

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, Assets_4, LoginController_5, OilFieldController_3, ScenarioController_1, MembersController_2, YearController_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.Assets.versioned(path:String = "/public", file:String = "index.html")"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/login""", """controllers.LoginController.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/logout""", """controllers.LoginController.logout"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/role""", """controllers.LoginController.getRole"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/user_info""", """controllers.LoginController.getUser"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/change_user_data""", """controllers.LoginController.editUser"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/assetname/""" + "$" + """aid<[^/]+>""", """controllers.OilFieldController.getAssetName(aid:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/assets/""" + "$" + """aid<[^/]+>/oil_fields/""", """controllers.OilFieldController.table(aid:Long)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/assets/""" + "$" + """aid<[^/]+>/oil_fields/""", """controllers.OilFieldController.add(aid:Long)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/assets/""" + "$" + """aid<[^/]+>/oil_fields/""" + "$" + """oid<[^/]+>""", """controllers.OilFieldController.edit(aid:Long, oid:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/assets/""" + "$" + """aid<[^/]+>/oil_fields/""" + "$" + """oid<[^/]+>""", """controllers.OilFieldController.get(aid:Long, oid:Long)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/assets/""" + "$" + """aid<[^/]+>/oil_fields/""" + "$" + """oid<[^/]+>""", """controllers.OilFieldController.remove(aid:Long, oid:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/assets/""" + "$" + """aid<[^/]+>/oil_fields/""" + "$" + """oid<[^/]+>/scenarios""", """controllers.ScenarioController.table(aid:Long, oid:Long)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/assets/""" + "$" + """aid<[^/]+>/oil_fields/""" + "$" + """oid<[^/]+>/scenarios""", """controllers.ScenarioController.add(aid:Long, oid:Long)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/assets/""" + "$" + """aid<[^/]+>/oil_fields/""" + "$" + """oid<[^/]+>/scenarios/""" + "$" + """sid<[^/]+>""", """controllers.ScenarioController.edit(aid:Long, oid:Long, sid:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/assets/""" + "$" + """aid<[^/]+>/oil_fields/""" + "$" + """oid<[^/]+>/scenarios/""" + "$" + """sid<[^/]+>""", """controllers.ScenarioController.get(aid:Long, oid:Long, sid:Long)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/assets/""" + "$" + """aid<[^/]+>/oil_fields/""" + "$" + """oid<[^/]+>/scenarios/""" + "$" + """sid<[^/]+>""", """controllers.ScenarioController.remove(aid:Long, oid:Long, sid:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/assets/""" + "$" + """aid<[^/]+>/oil_fields/""" + "$" + """oid<[^/]+>/members""", """controllers.MembersController.table(aid:Long, oid:Long)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/assets/""" + "$" + """aid<[^/]+>/oil_fields/""" + "$" + """oid<[^/]+>/members""", """controllers.MembersController.add(aid:Long, oid:Long)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/assets/""" + "$" + """aid<[^/]+>/oil_fields/""" + "$" + """oid<[^/]+>/members/""" + "$" + """mid<[^/]+>""", """controllers.MembersController.edit(aid:Long, oid:Long, mid:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/assets/""" + "$" + """aid<[^/]+>/oil_fields/""" + "$" + """oid<[^/]+>/members/""" + "$" + """mid<[^/]+>""", """controllers.MembersController.get(aid:Long, oid:Long, mid:Long)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/assets/""" + "$" + """aid<[^/]+>/oil_fields/""" + "$" + """oid<[^/]+>/members/""" + "$" + """mid<[^/]+>""", """controllers.MembersController.remove(aid:Long, oid:Long, mid:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/assets/""" + "$" + """aid<[^/]+>/oil_fields/""" + "$" + """oid<[^/]+>/scenarios/""" + "$" + """sid<[^/]+>/year""", """controllers.YearController.table(aid:Long, oid:Long, sid:Long)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/assets/""" + "$" + """aid<[^/]+>/oil_fields/""" + "$" + """oid<[^/]+>/scenarios/""" + "$" + """sid<[^/]+>/year""", """controllers.YearController.add(aid:Long, oid:Long, sid:Long)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/assets/""" + "$" + """aid<[^/]+>/oil_fields/""" + "$" + """oid<[^/]+>/scenarios/""" + "$" + """sid<[^/]+>/year/""" + "$" + """yid<[^/]+>""", """controllers.YearController.edit(aid:Long, oid:Long, sid:Long, yid:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/assets/""" + "$" + """aid<[^/]+>/oil_fields/""" + "$" + """oid<[^/]+>/scenarios/""" + "$" + """sid<[^/]+>/year/""" + "$" + """yid<[^/]+>""", """controllers.YearController.get(aid:Long, oid:Long, sid:Long, yid:Long)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/assets/""" + "$" + """aid<[^/]+>/oil_fields/""" + "$" + """oid<[^/]+>/scenarios/""" + "$" + """sid<[^/]+>/year/""" + "$" + """yid<[^/]+>""", """controllers.YearController.remove(aid:Long, oid:Long, sid:Long, yid:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.at(path:String = "/public", file:String)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:5
  private[this] lazy val controllers_Assets_versioned0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_Assets_versioned0_invoker = createInvoker(
    Assets_4.versioned(fakeValue[String], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[String]),
      "GET",
      """""",
      this.prefix + """"""
    )
  )

  // @LINE:7
  private[this] lazy val controllers_LoginController_index1_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/login")))
  )
  private[this] lazy val controllers_LoginController_index1_invoker = createInvoker(
    LoginController_5.index,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.LoginController",
      "index",
      Nil,
      "POST",
      """ An example controller showing a sample home page""",
      this.prefix + """api/login"""
    )
  )

  // @LINE:8
  private[this] lazy val controllers_LoginController_logout2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/logout")))
  )
  private[this] lazy val controllers_LoginController_logout2_invoker = createInvoker(
    LoginController_5.logout,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.LoginController",
      "logout",
      Nil,
      "GET",
      """""",
      this.prefix + """api/logout"""
    )
  )

  // @LINE:9
  private[this] lazy val controllers_LoginController_getRole3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/role")))
  )
  private[this] lazy val controllers_LoginController_getRole3_invoker = createInvoker(
    LoginController_5.getRole,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.LoginController",
      "getRole",
      Nil,
      "GET",
      """""",
      this.prefix + """api/role"""
    )
  )

  // @LINE:10
  private[this] lazy val controllers_LoginController_getUser4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/user_info")))
  )
  private[this] lazy val controllers_LoginController_getUser4_invoker = createInvoker(
    LoginController_5.getUser,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.LoginController",
      "getUser",
      Nil,
      "GET",
      """""",
      this.prefix + """api/user_info"""
    )
  )

  // @LINE:11
  private[this] lazy val controllers_LoginController_editUser5_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/change_user_data")))
  )
  private[this] lazy val controllers_LoginController_editUser5_invoker = createInvoker(
    LoginController_5.editUser,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.LoginController",
      "editUser",
      Nil,
      "PUT",
      """""",
      this.prefix + """api/change_user_data"""
    )
  )

  // @LINE:12
  private[this] lazy val controllers_OilFieldController_getAssetName6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/assetname/"), DynamicPart("aid", """[^/]+""",true)))
  )
  private[this] lazy val controllers_OilFieldController_getAssetName6_invoker = createInvoker(
    OilFieldController_3.getAssetName(fakeValue[Long]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.OilFieldController",
      "getAssetName",
      Seq(classOf[Long]),
      "GET",
      """""",
      this.prefix + """api/assetname/""" + "$" + """aid<[^/]+>"""
    )
  )

  // @LINE:15
  private[this] lazy val controllers_OilFieldController_table7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/assets/"), DynamicPart("aid", """[^/]+""",true), StaticPart("/oil_fields/")))
  )
  private[this] lazy val controllers_OilFieldController_table7_invoker = createInvoker(
    OilFieldController_3.table(fakeValue[Long]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.OilFieldController",
      "table",
      Seq(classOf[Long]),
      "GET",
      """""",
      this.prefix + """api/assets/""" + "$" + """aid<[^/]+>/oil_fields/"""
    )
  )

  // @LINE:16
  private[this] lazy val controllers_OilFieldController_add8_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/assets/"), DynamicPart("aid", """[^/]+""",true), StaticPart("/oil_fields/")))
  )
  private[this] lazy val controllers_OilFieldController_add8_invoker = createInvoker(
    OilFieldController_3.add(fakeValue[Long]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.OilFieldController",
      "add",
      Seq(classOf[Long]),
      "POST",
      """""",
      this.prefix + """api/assets/""" + "$" + """aid<[^/]+>/oil_fields/"""
    )
  )

  // @LINE:17
  private[this] lazy val controllers_OilFieldController_edit9_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/assets/"), DynamicPart("aid", """[^/]+""",true), StaticPart("/oil_fields/"), DynamicPart("oid", """[^/]+""",true)))
  )
  private[this] lazy val controllers_OilFieldController_edit9_invoker = createInvoker(
    OilFieldController_3.edit(fakeValue[Long], fakeValue[Long]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.OilFieldController",
      "edit",
      Seq(classOf[Long], classOf[Long]),
      "PUT",
      """""",
      this.prefix + """api/assets/""" + "$" + """aid<[^/]+>/oil_fields/""" + "$" + """oid<[^/]+>"""
    )
  )

  // @LINE:18
  private[this] lazy val controllers_OilFieldController_get10_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/assets/"), DynamicPart("aid", """[^/]+""",true), StaticPart("/oil_fields/"), DynamicPart("oid", """[^/]+""",true)))
  )
  private[this] lazy val controllers_OilFieldController_get10_invoker = createInvoker(
    OilFieldController_3.get(fakeValue[Long], fakeValue[Long]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.OilFieldController",
      "get",
      Seq(classOf[Long], classOf[Long]),
      "GET",
      """""",
      this.prefix + """api/assets/""" + "$" + """aid<[^/]+>/oil_fields/""" + "$" + """oid<[^/]+>"""
    )
  )

  // @LINE:19
  private[this] lazy val controllers_OilFieldController_remove11_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/assets/"), DynamicPart("aid", """[^/]+""",true), StaticPart("/oil_fields/"), DynamicPart("oid", """[^/]+""",true)))
  )
  private[this] lazy val controllers_OilFieldController_remove11_invoker = createInvoker(
    OilFieldController_3.remove(fakeValue[Long], fakeValue[Long]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.OilFieldController",
      "remove",
      Seq(classOf[Long], classOf[Long]),
      "DELETE",
      """""",
      this.prefix + """api/assets/""" + "$" + """aid<[^/]+>/oil_fields/""" + "$" + """oid<[^/]+>"""
    )
  )

  // @LINE:21
  private[this] lazy val controllers_ScenarioController_table12_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/assets/"), DynamicPart("aid", """[^/]+""",true), StaticPart("/oil_fields/"), DynamicPart("oid", """[^/]+""",true), StaticPart("/scenarios")))
  )
  private[this] lazy val controllers_ScenarioController_table12_invoker = createInvoker(
    ScenarioController_1.table(fakeValue[Long], fakeValue[Long]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ScenarioController",
      "table",
      Seq(classOf[Long], classOf[Long]),
      "GET",
      """""",
      this.prefix + """api/assets/""" + "$" + """aid<[^/]+>/oil_fields/""" + "$" + """oid<[^/]+>/scenarios"""
    )
  )

  // @LINE:22
  private[this] lazy val controllers_ScenarioController_add13_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/assets/"), DynamicPart("aid", """[^/]+""",true), StaticPart("/oil_fields/"), DynamicPart("oid", """[^/]+""",true), StaticPart("/scenarios")))
  )
  private[this] lazy val controllers_ScenarioController_add13_invoker = createInvoker(
    ScenarioController_1.add(fakeValue[Long], fakeValue[Long]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ScenarioController",
      "add",
      Seq(classOf[Long], classOf[Long]),
      "POST",
      """""",
      this.prefix + """api/assets/""" + "$" + """aid<[^/]+>/oil_fields/""" + "$" + """oid<[^/]+>/scenarios"""
    )
  )

  // @LINE:23
  private[this] lazy val controllers_ScenarioController_edit14_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/assets/"), DynamicPart("aid", """[^/]+""",true), StaticPart("/oil_fields/"), DynamicPart("oid", """[^/]+""",true), StaticPart("/scenarios/"), DynamicPart("sid", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ScenarioController_edit14_invoker = createInvoker(
    ScenarioController_1.edit(fakeValue[Long], fakeValue[Long], fakeValue[Long]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ScenarioController",
      "edit",
      Seq(classOf[Long], classOf[Long], classOf[Long]),
      "PUT",
      """""",
      this.prefix + """api/assets/""" + "$" + """aid<[^/]+>/oil_fields/""" + "$" + """oid<[^/]+>/scenarios/""" + "$" + """sid<[^/]+>"""
    )
  )

  // @LINE:24
  private[this] lazy val controllers_ScenarioController_get15_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/assets/"), DynamicPart("aid", """[^/]+""",true), StaticPart("/oil_fields/"), DynamicPart("oid", """[^/]+""",true), StaticPart("/scenarios/"), DynamicPart("sid", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ScenarioController_get15_invoker = createInvoker(
    ScenarioController_1.get(fakeValue[Long], fakeValue[Long], fakeValue[Long]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ScenarioController",
      "get",
      Seq(classOf[Long], classOf[Long], classOf[Long]),
      "GET",
      """""",
      this.prefix + """api/assets/""" + "$" + """aid<[^/]+>/oil_fields/""" + "$" + """oid<[^/]+>/scenarios/""" + "$" + """sid<[^/]+>"""
    )
  )

  // @LINE:25
  private[this] lazy val controllers_ScenarioController_remove16_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/assets/"), DynamicPart("aid", """[^/]+""",true), StaticPart("/oil_fields/"), DynamicPart("oid", """[^/]+""",true), StaticPart("/scenarios/"), DynamicPart("sid", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ScenarioController_remove16_invoker = createInvoker(
    ScenarioController_1.remove(fakeValue[Long], fakeValue[Long], fakeValue[Long]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ScenarioController",
      "remove",
      Seq(classOf[Long], classOf[Long], classOf[Long]),
      "DELETE",
      """""",
      this.prefix + """api/assets/""" + "$" + """aid<[^/]+>/oil_fields/""" + "$" + """oid<[^/]+>/scenarios/""" + "$" + """sid<[^/]+>"""
    )
  )

  // @LINE:27
  private[this] lazy val controllers_MembersController_table17_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/assets/"), DynamicPart("aid", """[^/]+""",true), StaticPart("/oil_fields/"), DynamicPart("oid", """[^/]+""",true), StaticPart("/members")))
  )
  private[this] lazy val controllers_MembersController_table17_invoker = createInvoker(
    MembersController_2.table(fakeValue[Long], fakeValue[Long]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MembersController",
      "table",
      Seq(classOf[Long], classOf[Long]),
      "GET",
      """""",
      this.prefix + """api/assets/""" + "$" + """aid<[^/]+>/oil_fields/""" + "$" + """oid<[^/]+>/members"""
    )
  )

  // @LINE:28
  private[this] lazy val controllers_MembersController_add18_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/assets/"), DynamicPart("aid", """[^/]+""",true), StaticPart("/oil_fields/"), DynamicPart("oid", """[^/]+""",true), StaticPart("/members")))
  )
  private[this] lazy val controllers_MembersController_add18_invoker = createInvoker(
    MembersController_2.add(fakeValue[Long], fakeValue[Long]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MembersController",
      "add",
      Seq(classOf[Long], classOf[Long]),
      "POST",
      """""",
      this.prefix + """api/assets/""" + "$" + """aid<[^/]+>/oil_fields/""" + "$" + """oid<[^/]+>/members"""
    )
  )

  // @LINE:29
  private[this] lazy val controllers_MembersController_edit19_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/assets/"), DynamicPart("aid", """[^/]+""",true), StaticPart("/oil_fields/"), DynamicPart("oid", """[^/]+""",true), StaticPart("/members/"), DynamicPart("mid", """[^/]+""",true)))
  )
  private[this] lazy val controllers_MembersController_edit19_invoker = createInvoker(
    MembersController_2.edit(fakeValue[Long], fakeValue[Long], fakeValue[Long]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MembersController",
      "edit",
      Seq(classOf[Long], classOf[Long], classOf[Long]),
      "PUT",
      """""",
      this.prefix + """api/assets/""" + "$" + """aid<[^/]+>/oil_fields/""" + "$" + """oid<[^/]+>/members/""" + "$" + """mid<[^/]+>"""
    )
  )

  // @LINE:30
  private[this] lazy val controllers_MembersController_get20_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/assets/"), DynamicPart("aid", """[^/]+""",true), StaticPart("/oil_fields/"), DynamicPart("oid", """[^/]+""",true), StaticPart("/members/"), DynamicPart("mid", """[^/]+""",true)))
  )
  private[this] lazy val controllers_MembersController_get20_invoker = createInvoker(
    MembersController_2.get(fakeValue[Long], fakeValue[Long], fakeValue[Long]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MembersController",
      "get",
      Seq(classOf[Long], classOf[Long], classOf[Long]),
      "GET",
      """""",
      this.prefix + """api/assets/""" + "$" + """aid<[^/]+>/oil_fields/""" + "$" + """oid<[^/]+>/members/""" + "$" + """mid<[^/]+>"""
    )
  )

  // @LINE:31
  private[this] lazy val controllers_MembersController_remove21_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/assets/"), DynamicPart("aid", """[^/]+""",true), StaticPart("/oil_fields/"), DynamicPart("oid", """[^/]+""",true), StaticPart("/members/"), DynamicPart("mid", """[^/]+""",true)))
  )
  private[this] lazy val controllers_MembersController_remove21_invoker = createInvoker(
    MembersController_2.remove(fakeValue[Long], fakeValue[Long], fakeValue[Long]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MembersController",
      "remove",
      Seq(classOf[Long], classOf[Long], classOf[Long]),
      "DELETE",
      """""",
      this.prefix + """api/assets/""" + "$" + """aid<[^/]+>/oil_fields/""" + "$" + """oid<[^/]+>/members/""" + "$" + """mid<[^/]+>"""
    )
  )

  // @LINE:33
  private[this] lazy val controllers_YearController_table22_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/assets/"), DynamicPart("aid", """[^/]+""",true), StaticPart("/oil_fields/"), DynamicPart("oid", """[^/]+""",true), StaticPart("/scenarios/"), DynamicPart("sid", """[^/]+""",true), StaticPart("/year")))
  )
  private[this] lazy val controllers_YearController_table22_invoker = createInvoker(
    YearController_0.table(fakeValue[Long], fakeValue[Long], fakeValue[Long]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.YearController",
      "table",
      Seq(classOf[Long], classOf[Long], classOf[Long]),
      "GET",
      """""",
      this.prefix + """api/assets/""" + "$" + """aid<[^/]+>/oil_fields/""" + "$" + """oid<[^/]+>/scenarios/""" + "$" + """sid<[^/]+>/year"""
    )
  )

  // @LINE:34
  private[this] lazy val controllers_YearController_add23_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/assets/"), DynamicPart("aid", """[^/]+""",true), StaticPart("/oil_fields/"), DynamicPart("oid", """[^/]+""",true), StaticPart("/scenarios/"), DynamicPart("sid", """[^/]+""",true), StaticPart("/year")))
  )
  private[this] lazy val controllers_YearController_add23_invoker = createInvoker(
    YearController_0.add(fakeValue[Long], fakeValue[Long], fakeValue[Long]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.YearController",
      "add",
      Seq(classOf[Long], classOf[Long], classOf[Long]),
      "POST",
      """""",
      this.prefix + """api/assets/""" + "$" + """aid<[^/]+>/oil_fields/""" + "$" + """oid<[^/]+>/scenarios/""" + "$" + """sid<[^/]+>/year"""
    )
  )

  // @LINE:35
  private[this] lazy val controllers_YearController_edit24_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/assets/"), DynamicPart("aid", """[^/]+""",true), StaticPart("/oil_fields/"), DynamicPart("oid", """[^/]+""",true), StaticPart("/scenarios/"), DynamicPart("sid", """[^/]+""",true), StaticPart("/year/"), DynamicPart("yid", """[^/]+""",true)))
  )
  private[this] lazy val controllers_YearController_edit24_invoker = createInvoker(
    YearController_0.edit(fakeValue[Long], fakeValue[Long], fakeValue[Long], fakeValue[Long]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.YearController",
      "edit",
      Seq(classOf[Long], classOf[Long], classOf[Long], classOf[Long]),
      "PUT",
      """""",
      this.prefix + """api/assets/""" + "$" + """aid<[^/]+>/oil_fields/""" + "$" + """oid<[^/]+>/scenarios/""" + "$" + """sid<[^/]+>/year/""" + "$" + """yid<[^/]+>"""
    )
  )

  // @LINE:36
  private[this] lazy val controllers_YearController_get25_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/assets/"), DynamicPart("aid", """[^/]+""",true), StaticPart("/oil_fields/"), DynamicPart("oid", """[^/]+""",true), StaticPart("/scenarios/"), DynamicPart("sid", """[^/]+""",true), StaticPart("/year/"), DynamicPart("yid", """[^/]+""",true)))
  )
  private[this] lazy val controllers_YearController_get25_invoker = createInvoker(
    YearController_0.get(fakeValue[Long], fakeValue[Long], fakeValue[Long], fakeValue[Long]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.YearController",
      "get",
      Seq(classOf[Long], classOf[Long], classOf[Long], classOf[Long]),
      "GET",
      """""",
      this.prefix + """api/assets/""" + "$" + """aid<[^/]+>/oil_fields/""" + "$" + """oid<[^/]+>/scenarios/""" + "$" + """sid<[^/]+>/year/""" + "$" + """yid<[^/]+>"""
    )
  )

  // @LINE:37
  private[this] lazy val controllers_YearController_remove26_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/assets/"), DynamicPart("aid", """[^/]+""",true), StaticPart("/oil_fields/"), DynamicPart("oid", """[^/]+""",true), StaticPart("/scenarios/"), DynamicPart("sid", """[^/]+""",true), StaticPart("/year/"), DynamicPart("yid", """[^/]+""",true)))
  )
  private[this] lazy val controllers_YearController_remove26_invoker = createInvoker(
    YearController_0.remove(fakeValue[Long], fakeValue[Long], fakeValue[Long], fakeValue[Long]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.YearController",
      "remove",
      Seq(classOf[Long], classOf[Long], classOf[Long], classOf[Long]),
      "DELETE",
      """""",
      this.prefix + """api/assets/""" + "$" + """aid<[^/]+>/oil_fields/""" + "$" + """oid<[^/]+>/scenarios/""" + "$" + """sid<[^/]+>/year/""" + "$" + """yid<[^/]+>"""
    )
  )

  // @LINE:42
  private[this] lazy val controllers_Assets_at27_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_at27_invoker = createInvoker(
    Assets_4.at(fakeValue[String], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "at",
      Seq(classOf[String], classOf[String]),
      "GET",
      """""",
      this.prefix + """assets/""" + "$" + """file<.+>"""
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:5
    case controllers_Assets_versioned0_route(params) =>
      call(Param[String]("path", Right("/public")), Param[String]("file", Right("index.html"))) { (path, file) =>
        controllers_Assets_versioned0_invoker.call(Assets_4.versioned(path, file))
      }
  
    // @LINE:7
    case controllers_LoginController_index1_route(params) =>
      call { 
        controllers_LoginController_index1_invoker.call(LoginController_5.index)
      }
  
    // @LINE:8
    case controllers_LoginController_logout2_route(params) =>
      call { 
        controllers_LoginController_logout2_invoker.call(LoginController_5.logout)
      }
  
    // @LINE:9
    case controllers_LoginController_getRole3_route(params) =>
      call { 
        controllers_LoginController_getRole3_invoker.call(LoginController_5.getRole)
      }
  
    // @LINE:10
    case controllers_LoginController_getUser4_route(params) =>
      call { 
        controllers_LoginController_getUser4_invoker.call(LoginController_5.getUser)
      }
  
    // @LINE:11
    case controllers_LoginController_editUser5_route(params) =>
      call { 
        controllers_LoginController_editUser5_invoker.call(LoginController_5.editUser)
      }
  
    // @LINE:12
    case controllers_OilFieldController_getAssetName6_route(params) =>
      call(params.fromPath[Long]("aid", None)) { (aid) =>
        controllers_OilFieldController_getAssetName6_invoker.call(OilFieldController_3.getAssetName(aid))
      }
  
    // @LINE:15
    case controllers_OilFieldController_table7_route(params) =>
      call(params.fromPath[Long]("aid", None)) { (aid) =>
        controllers_OilFieldController_table7_invoker.call(OilFieldController_3.table(aid))
      }
  
    // @LINE:16
    case controllers_OilFieldController_add8_route(params) =>
      call(params.fromPath[Long]("aid", None)) { (aid) =>
        controllers_OilFieldController_add8_invoker.call(OilFieldController_3.add(aid))
      }
  
    // @LINE:17
    case controllers_OilFieldController_edit9_route(params) =>
      call(params.fromPath[Long]("aid", None), params.fromPath[Long]("oid", None)) { (aid, oid) =>
        controllers_OilFieldController_edit9_invoker.call(OilFieldController_3.edit(aid, oid))
      }
  
    // @LINE:18
    case controllers_OilFieldController_get10_route(params) =>
      call(params.fromPath[Long]("aid", None), params.fromPath[Long]("oid", None)) { (aid, oid) =>
        controllers_OilFieldController_get10_invoker.call(OilFieldController_3.get(aid, oid))
      }
  
    // @LINE:19
    case controllers_OilFieldController_remove11_route(params) =>
      call(params.fromPath[Long]("aid", None), params.fromPath[Long]("oid", None)) { (aid, oid) =>
        controllers_OilFieldController_remove11_invoker.call(OilFieldController_3.remove(aid, oid))
      }
  
    // @LINE:21
    case controllers_ScenarioController_table12_route(params) =>
      call(params.fromPath[Long]("aid", None), params.fromPath[Long]("oid", None)) { (aid, oid) =>
        controllers_ScenarioController_table12_invoker.call(ScenarioController_1.table(aid, oid))
      }
  
    // @LINE:22
    case controllers_ScenarioController_add13_route(params) =>
      call(params.fromPath[Long]("aid", None), params.fromPath[Long]("oid", None)) { (aid, oid) =>
        controllers_ScenarioController_add13_invoker.call(ScenarioController_1.add(aid, oid))
      }
  
    // @LINE:23
    case controllers_ScenarioController_edit14_route(params) =>
      call(params.fromPath[Long]("aid", None), params.fromPath[Long]("oid", None), params.fromPath[Long]("sid", None)) { (aid, oid, sid) =>
        controllers_ScenarioController_edit14_invoker.call(ScenarioController_1.edit(aid, oid, sid))
      }
  
    // @LINE:24
    case controllers_ScenarioController_get15_route(params) =>
      call(params.fromPath[Long]("aid", None), params.fromPath[Long]("oid", None), params.fromPath[Long]("sid", None)) { (aid, oid, sid) =>
        controllers_ScenarioController_get15_invoker.call(ScenarioController_1.get(aid, oid, sid))
      }
  
    // @LINE:25
    case controllers_ScenarioController_remove16_route(params) =>
      call(params.fromPath[Long]("aid", None), params.fromPath[Long]("oid", None), params.fromPath[Long]("sid", None)) { (aid, oid, sid) =>
        controllers_ScenarioController_remove16_invoker.call(ScenarioController_1.remove(aid, oid, sid))
      }
  
    // @LINE:27
    case controllers_MembersController_table17_route(params) =>
      call(params.fromPath[Long]("aid", None), params.fromPath[Long]("oid", None)) { (aid, oid) =>
        controllers_MembersController_table17_invoker.call(MembersController_2.table(aid, oid))
      }
  
    // @LINE:28
    case controllers_MembersController_add18_route(params) =>
      call(params.fromPath[Long]("aid", None), params.fromPath[Long]("oid", None)) { (aid, oid) =>
        controllers_MembersController_add18_invoker.call(MembersController_2.add(aid, oid))
      }
  
    // @LINE:29
    case controllers_MembersController_edit19_route(params) =>
      call(params.fromPath[Long]("aid", None), params.fromPath[Long]("oid", None), params.fromPath[Long]("mid", None)) { (aid, oid, mid) =>
        controllers_MembersController_edit19_invoker.call(MembersController_2.edit(aid, oid, mid))
      }
  
    // @LINE:30
    case controllers_MembersController_get20_route(params) =>
      call(params.fromPath[Long]("aid", None), params.fromPath[Long]("oid", None), params.fromPath[Long]("mid", None)) { (aid, oid, mid) =>
        controllers_MembersController_get20_invoker.call(MembersController_2.get(aid, oid, mid))
      }
  
    // @LINE:31
    case controllers_MembersController_remove21_route(params) =>
      call(params.fromPath[Long]("aid", None), params.fromPath[Long]("oid", None), params.fromPath[Long]("mid", None)) { (aid, oid, mid) =>
        controllers_MembersController_remove21_invoker.call(MembersController_2.remove(aid, oid, mid))
      }
  
    // @LINE:33
    case controllers_YearController_table22_route(params) =>
      call(params.fromPath[Long]("aid", None), params.fromPath[Long]("oid", None), params.fromPath[Long]("sid", None)) { (aid, oid, sid) =>
        controllers_YearController_table22_invoker.call(YearController_0.table(aid, oid, sid))
      }
  
    // @LINE:34
    case controllers_YearController_add23_route(params) =>
      call(params.fromPath[Long]("aid", None), params.fromPath[Long]("oid", None), params.fromPath[Long]("sid", None)) { (aid, oid, sid) =>
        controllers_YearController_add23_invoker.call(YearController_0.add(aid, oid, sid))
      }
  
    // @LINE:35
    case controllers_YearController_edit24_route(params) =>
      call(params.fromPath[Long]("aid", None), params.fromPath[Long]("oid", None), params.fromPath[Long]("sid", None), params.fromPath[Long]("yid", None)) { (aid, oid, sid, yid) =>
        controllers_YearController_edit24_invoker.call(YearController_0.edit(aid, oid, sid, yid))
      }
  
    // @LINE:36
    case controllers_YearController_get25_route(params) =>
      call(params.fromPath[Long]("aid", None), params.fromPath[Long]("oid", None), params.fromPath[Long]("sid", None), params.fromPath[Long]("yid", None)) { (aid, oid, sid, yid) =>
        controllers_YearController_get25_invoker.call(YearController_0.get(aid, oid, sid, yid))
      }
  
    // @LINE:37
    case controllers_YearController_remove26_route(params) =>
      call(params.fromPath[Long]("aid", None), params.fromPath[Long]("oid", None), params.fromPath[Long]("sid", None), params.fromPath[Long]("yid", None)) { (aid, oid, sid, yid) =>
        controllers_YearController_remove26_invoker.call(YearController_0.remove(aid, oid, sid, yid))
      }
  
    // @LINE:42
    case controllers_Assets_at27_route(params) =>
      call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_at27_invoker.call(Assets_4.at(path, file))
      }
  }
}
