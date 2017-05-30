
// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/User/Desktop/deeplom/kazak/diplom_project/conf/routes
// @DATE:Thu May 18 11:06:20 ALMT 2017

import play.api.routing.JavaScriptReverseRoute
import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:5
package controllers.javascript {
  import ReverseRouteContext.empty

  // @LINE:5
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:42
    def at: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.at",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
    // @LINE:5
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
  }

  // @LINE:12
  class ReverseOilFieldController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:17
    def edit: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.OilFieldController.edit",
      """
        function(aid0,oid1) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "api/assets/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("aid", aid0) + "/oil_fields/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("oid", oid1)})
        }
      """
    )
  
    // @LINE:19
    def remove: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.OilFieldController.remove",
      """
        function(aid0,oid1) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "api/assets/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("aid", aid0) + "/oil_fields/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("oid", oid1)})
        }
      """
    )
  
    // @LINE:16
    def add: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.OilFieldController.add",
      """
        function(aid0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "api/assets/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("aid", aid0) + "/oil_fields/"})
        }
      """
    )
  
    // @LINE:18
    def get: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.OilFieldController.get",
      """
        function(aid0,oid1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/assets/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("aid", aid0) + "/oil_fields/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("oid", oid1)})
        }
      """
    )
  
    // @LINE:12
    def getAssetName: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.OilFieldController.getAssetName",
      """
        function(aid0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/assetname/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("aid", aid0)})
        }
      """
    )
  
    // @LINE:15
    def table: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.OilFieldController.table",
      """
        function(aid0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/assets/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("aid", aid0) + "/oil_fields/"})
        }
      """
    )
  
  }

  // @LINE:21
  class ReverseScenarioController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:21
    def table: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ScenarioController.table",
      """
        function(aid0,oid1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/assets/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("aid", aid0) + "/oil_fields/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("oid", oid1) + "/scenarios"})
        }
      """
    )
  
    // @LINE:22
    def add: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ScenarioController.add",
      """
        function(aid0,oid1) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "api/assets/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("aid", aid0) + "/oil_fields/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("oid", oid1) + "/scenarios"})
        }
      """
    )
  
    // @LINE:24
    def get: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ScenarioController.get",
      """
        function(aid0,oid1,sid2) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/assets/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("aid", aid0) + "/oil_fields/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("oid", oid1) + "/scenarios/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("sid", sid2)})
        }
      """
    )
  
    // @LINE:23
    def edit: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ScenarioController.edit",
      """
        function(aid0,oid1,sid2) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "api/assets/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("aid", aid0) + "/oil_fields/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("oid", oid1) + "/scenarios/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("sid", sid2)})
        }
      """
    )
  
    // @LINE:25
    def remove: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ScenarioController.remove",
      """
        function(aid0,oid1,sid2) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "api/assets/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("aid", aid0) + "/oil_fields/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("oid", oid1) + "/scenarios/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("sid", sid2)})
        }
      """
    )
  
  }

  // @LINE:33
  class ReverseYearController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:35
    def edit: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.YearController.edit",
      """
        function(aid0,oid1,sid2,yid3) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "api/assets/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("aid", aid0) + "/oil_fields/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("oid", oid1) + "/scenarios/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("sid", sid2) + "/year/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("yid", yid3)})
        }
      """
    )
  
    // @LINE:34
    def add: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.YearController.add",
      """
        function(aid0,oid1,sid2) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "api/assets/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("aid", aid0) + "/oil_fields/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("oid", oid1) + "/scenarios/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("sid", sid2) + "/year"})
        }
      """
    )
  
    // @LINE:33
    def table: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.YearController.table",
      """
        function(aid0,oid1,sid2) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/assets/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("aid", aid0) + "/oil_fields/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("oid", oid1) + "/scenarios/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("sid", sid2) + "/year"})
        }
      """
    )
  
    // @LINE:37
    def remove: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.YearController.remove",
      """
        function(aid0,oid1,sid2,yid3) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "api/assets/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("aid", aid0) + "/oil_fields/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("oid", oid1) + "/scenarios/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("sid", sid2) + "/year/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("yid", yid3)})
        }
      """
    )
  
    // @LINE:36
    def get: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.YearController.get",
      """
        function(aid0,oid1,sid2,yid3) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/assets/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("aid", aid0) + "/oil_fields/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("oid", oid1) + "/scenarios/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("sid", sid2) + "/year/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("yid", yid3)})
        }
      """
    )
  
  }

  // @LINE:27
  class ReverseMembersController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:27
    def table: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MembersController.table",
      """
        function(aid0,oid1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/assets/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("aid", aid0) + "/oil_fields/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("oid", oid1) + "/members"})
        }
      """
    )
  
    // @LINE:28
    def add: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MembersController.add",
      """
        function(aid0,oid1) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "api/assets/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("aid", aid0) + "/oil_fields/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("oid", oid1) + "/members"})
        }
      """
    )
  
    // @LINE:30
    def get: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MembersController.get",
      """
        function(aid0,oid1,mid2) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/assets/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("aid", aid0) + "/oil_fields/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("oid", oid1) + "/members/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("mid", mid2)})
        }
      """
    )
  
    // @LINE:29
    def edit: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MembersController.edit",
      """
        function(aid0,oid1,mid2) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "api/assets/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("aid", aid0) + "/oil_fields/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("oid", oid1) + "/members/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("mid", mid2)})
        }
      """
    )
  
    // @LINE:31
    def remove: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MembersController.remove",
      """
        function(aid0,oid1,mid2) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "api/assets/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("aid", aid0) + "/oil_fields/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("oid", oid1) + "/members/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("mid", mid2)})
        }
      """
    )
  
  }

  // @LINE:7
  class ReverseLoginController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:9
    def getRole: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.LoginController.getRole",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/role"})
        }
      """
    )
  
    // @LINE:8
    def logout: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.LoginController.logout",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/logout"})
        }
      """
    )
  
    // @LINE:10
    def getUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.LoginController.getUser",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/user_info"})
        }
      """
    )
  
    // @LINE:11
    def editUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.LoginController.editUser",
      """
        function() {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "api/change_user_data"})
        }
      """
    )
  
    // @LINE:7
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.LoginController.index",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "api/login"})
        }
      """
    )
  
  }


}
