


var oilApp = angular.module('oilApp', ['ngRoute']);


oilApp.config([
  '$routeProvider', '$locationProvider',
  function($routeProvide, $locationProvider){
    $routeProvide
        .when('/',{
          templateUrl:'assets/templates/login.html',
          controller:'LoginCtrl'
        })
        /*OIL Fields Controller*/
        .when('/assets/:aid/asset_table',{
          templateUrl:'assets/templates/asset.html',
          controller:'AssetTableCtrl'
        })
        .when('/assets/:aid/edit_oil/:oid',{
          templateUrl:'assets/templates/edit_oil.html',
          controller:'EditOilCtrl'
        })
        .when('/assets/:aid/delete_oil/:oid',{
          templateUrl:'assets/templates/delete_oil.html',
          controller:'DeleteOilCtrl'
        })
        .when('/assets/:aid/add_oil',{
          templateUrl:'assets/templates/edit_oil.html',
          controller:'AddOilCtrl'
        })
        /*OIL Fields Controller*/
        /*SCENARIO Controller*/
        .when('/assets/:aid/oil/:oid/oil_table',{
          templateUrl:'assets/templates/oil_table.html',
          controller:'ScenTableCtrl'
        })
        .when('/assets/:aid/oil/:oid/edit_scen/:sid',{
          templateUrl:'assets/templates/add_scenario.html',
          controller:'EditScenCtrl'
        })
        .when('/assets/:aid/oil/:oid/delete_scen/:sid',{
          templateUrl:'assets/templates/delete_scenario.html',
          controller:'DeleteScenCtrl'
        })
        .when('/assets/:aid/oil/:oid/add_scen',{
          templateUrl:'assets/templates/add_scenario.html',
          controller:'AddScenCtrl'
        })
        /*SCENARIO Controller*/
        /*YEAR Controller*/
        .when('/assets/:aid/oil/:oid/scen/:sid/year_table',{
          templateUrl:'assets/templates/scenarios.html',
          controller:'YearTableCtrl'
        })
        .when('/assets/:aid/oil/:oid/scen/:sid/edit_year/:yid',{
          templateUrl:'assets/templates/edit_year.html',
          controller:'EditYearCtrl'
        })
        .when('/assets/:aid/oil/:oid/scen/:sid/year/:yid',{
          templateUrl:'assets/templates/year.html',
          controller:'YearCtrl'
        })
        /*YEAR Controller*/
        .otherwise({
          redirectTo: '/'
        });
  }
]);
