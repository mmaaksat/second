
// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/User/Desktop/deeplom/kazak/diplom_project/conf/routes
// @DATE:Thu May 18 11:06:20 ALMT 2017


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
