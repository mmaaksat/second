


var oilApp = angular.module('oilApp', ['ngRoute']);


oilApp.config([
  '$routeProvider', '$locationProvider',
  function($routeProvide, $locationProvider){
    $routeProvide
        .when('/',{
          templateUrl:'assets/templates/login.html',
          controller:'LoginCtrl'
        })
        .when('/asset_table',{
          templateUrl:'assets/templates/asset.html',
          controller:'AssetTableCtrl'
        })
        .when('/add_oil',{
          templateUrl:'assets/templates/edit_oil.html',
          controller:'AddOilCtrl'
        })
        .when('/edit_oil/:oil_id',{
          templateUrl:'assets/templates/edit_oil.html',
          controller:'EditOilCtrl'
        })
        .when('/delete_oil/:oil_id',{
          templateUrl:'assets/templates/delete_oil.html',
          controller:'DeleteOilCtrl'
        })
        .when('/oil_fields/:oil_id',{
          templateUrl:'assets/templates/oil_fields.html',
          controller:'OilTableCtrl'
        })
        .otherwise({
          redirectTo: '/'
        });
  }
]);
