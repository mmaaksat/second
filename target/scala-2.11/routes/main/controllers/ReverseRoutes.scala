
// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/User/Desktop/deeplom/kazak/diplom_project/conf/routes
// @DATE:Thu May 18 11:06:20 ALMT 2017

import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:5
package controllers {

  // @LINE:5
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:42
    def at(file:String): Call = {
      implicit val _rrc = new ReverseRouteContext(Map(("path", "/public")))
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
    }
  
    // @LINE:5
    def versioned(): Call = {
      implicit val _rrc = new ReverseRouteContext(Map(("path", "/public"), ("file", "index.html")))
      Call("GET", _prefix)
    }
  
  }

  // @LINE:12
  class ReverseOilFieldController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:17
    def edit(aid:Long, oid:Long): Call = {
      import ReverseRouteContext.empty
      Call("PUT", _prefix + { _defaultPrefix } + "api/assets/" + implicitly[PathBindable[Long]].unbind("aid", aid) + "/oil_fields/" + implicitly[PathBindable[Long]].unbind("oid", oid))
    }
  
    // @LINE:19
    def remove(aid:Long, oid:Long): Call = {
      import ReverseRouteContext.empty
      Call("DELETE", _prefix + { _defaultPrefix } + "api/assets/" + implicitly[PathBindable[Long]].unbind("aid", aid) + "/oil_fields/" + implicitly[PathBindable[Long]].unbind("oid", oid))
    }
  
    // @LINE:16
    def add(aid:Long): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "api/assets/" + implicitly[PathBindable[Long]].unbind("aid", aid) + "/oil_fields/")
    }
  
    // @LINE:18
    def get(aid:Long, oid:Long): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "api/assets/" + implicitly[PathBindable[Long]].unbind("aid", aid) + "/oil_fields/" + implicitly[PathBindable[Long]].unbind("oid", oid))
    }
  
    // @LINE:12
    def getAssetName(aid:Long): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "api/assetname/" + implicitly[PathBindable[Long]].unbind("aid", aid))
    }
  
    // @LINE:15
    def table(aid:Long): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "api/assets/" + implicitly[PathBindable[Long]].unbind("aid", aid) + "/oil_fields/")
    }
  
  }

  // @LINE:21
  class ReverseScenarioController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:21
    def table(aid:Long, oid:Long): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "api/assets/" + implicitly[PathBindable[Long]].unbind("aid", aid) + "/oil_fields/" + implicitly[PathBindable[Long]].unbind("oid", oid) + "/scenarios")
    }
  
    // @LINE:22
    def add(aid:Long, oid:Long): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "api/assets/" + implicitly[PathBindable[Long]].unbind("aid", aid) + "/oil_fields/" + implicitly[PathBindable[Long]].unbind("oid", oid) + "/scenarios")
    }
  
    // @LINE:24
    def get(aid:Long, oid:Long, sid:Long): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "api/assets/" + implicitly[PathBindable[Long]].unbind("aid", aid) + "/oil_fields/" + implicitly[PathBindable[Long]].unbind("oid", oid) + "/scenarios/" + implicitly[PathBindable[Long]].unbind("sid", sid))
    }
  
    // @LINE:23
    def edit(aid:Long, oid:Long, sid:Long): Call = {
      import ReverseRouteContext.empty
      Call("PUT", _prefix + { _defaultPrefix } + "api/assets/" + implicitly[PathBindable[Long]].unbind("aid", aid) + "/oil_fields/" + implicitly[PathBindable[Long]].unbind("oid", oid) + "/scenarios/" + implicitly[PathBindable[Long]].unbind("sid", sid))
    }
  
    // @LINE:25
    def remove(aid:Long, oid:Long, sid:Long): Call = {
      import ReverseRouteContext.empty
      Call("DELETE", _prefix + { _defaultPrefix } + "api/assets/" + implicitly[PathBindable[Long]].unbind("aid", aid) + "/oil_fields/" + implicitly[PathBindable[Long]].unbind("oid", oid) + "/scenarios/" + implicitly[PathBindable[Long]].unbind("sid", sid))
    }
  
  }

  // @LINE:33
  class ReverseYearController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:35
    def edit(aid:Long, oid:Long, sid:Long, yid:Long): Call = {
      import ReverseRouteContext.empty
      Call("PUT", _prefix + { _defaultPrefix } + "api/assets/" + implicitly[PathBindable[Long]].unbind("aid", aid) + "/oil_fields/" + implicitly[PathBindable[Long]].unbind("oid", oid) + "/scenarios/" + implicitly[PathBindable[Long]].unbind("sid", sid) + "/year/" + implicitly[PathBindable[Long]].unbind("yid", yid))
    }
  
    // @LINE:34
    def add(aid:Long, oid:Long, sid:Long): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "api/assets/" + implicitly[PathBindable[Long]].unbind("aid", aid) + "/oil_fields/" + implicitly[PathBindable[Long]].unbind("oid", oid) + "/scenarios/" + implicitly[PathBindable[Long]].unbind("sid", sid) + "/year")
    }
  
    // @LINE:33
    def table(aid:Long, oid:Long, sid:Long): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "api/assets/" + implicitly[PathBindable[Long]].unbind("aid", aid) + "/oil_fields/" + implicitly[PathBindable[Long]].unbind("oid", oid) + "/scenarios/" + implicitly[PathBindable[Long]].unbind("sid", sid) + "/year")
    }
  
    // @LINE:37
    def remove(aid:Long, oid:Long, sid:Long, yid:Long): Call = {
      import ReverseRouteContext.empty
      Call("DELETE", _prefix + { _defaultPrefix } + "api/assets/" + implicitly[PathBindable[Long]].unbind("aid", aid) + "/oil_fields/" + implicitly[PathBindable[Long]].unbind("oid", oid) + "/scenarios/" + implicitly[PathBindable[Long]].unbind("sid", sid) + "/year/" + implicitly[PathBindable[Long]].unbind("yid", yid))
    }
  
    // @LINE:36
    def get(aid:Long, oid:Long, sid:Long, yid:Long): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "api/assets/" + implicitly[PathBindable[Long]].unbind("aid", aid) + "/oil_fields/" + implicitly[PathBindable[Long]].unbind("oid", oid) + "/scenarios/" + implicitly[PathBindable[Long]].unbind("sid", sid) + "/year/" + implicitly[PathBindable[Long]].unbind("yid", yid))
    }
  
  }

  // @LINE:27
  class ReverseMembersController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:27
    def table(aid:Long, oid:Long): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "api/assets/" + implicitly[PathBindable[Long]].unbind("aid", aid) + "/oil_fields/" + implicitly[PathBindable[Long]].unbind("oid", oid) + "/members")
    }
  
    // @LINE:28
    def add(aid:Long, oid:Long): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "api/assets/" + implicitly[PathBindable[Long]].unbind("aid", aid) + "/oil_fields/" + implicitly[PathBindable[Long]].unbind("oid", oid) + "/members")
    }
  
    // @LINE:30
    def get(aid:Long, oid:Long, mid:Long): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "api/assets/" + implicitly[PathBindable[Long]].unbind("aid", aid) + "/oil_fields/" + implicitly[PathBindable[Long]].unbind("oid", oid) + "/members/" + implicitly[PathBindable[Long]].unbind("mid", mid))
    }
  
    // @LINE:29
    def edit(aid:Long, oid:Long, mid:Long): Call = {
      import ReverseRouteContext.empty
      Call("PUT", _prefix + { _defaultPrefix } + "api/assets/" + implicitly[PathBindable[Long]].unbind("aid", aid) + "/oil_fields/" + implicitly[PathBindable[Long]].unbind("oid", oid) + "/members/" + implicitly[PathBindable[Long]].unbind("mid", mid))
    }
  
    // @LINE:31
    def remove(aid:Long, oid:Long, mid:Long): Call = {
      import ReverseRouteContext.empty
      Call("DELETE", _prefix + { _defaultPrefix } + "api/assets/" + implicitly[PathBindable[Long]].unbind("aid", aid) + "/oil_fields/" + implicitly[PathBindable[Long]].unbind("oid", oid) + "/members/" + implicitly[PathBindable[Long]].unbind("mid", mid))
    }
  
  }

  // @LINE:7
  class ReverseLoginController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:9
    def getRole(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "api/role")
    }
  
    // @LINE:8
    def logout(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "api/logout")
    }
  
    // @LINE:10
    def getUser(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "api/user_info")
    }
  
    // @LINE:11
    def editUser(): Call = {
      import ReverseRouteContext.empty
      Call("PUT", _prefix + { _defaultPrefix } + "api/change_user_data")
    }
  
    // @LINE:7
    def index(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "api/login")
    }
  
  }


}
