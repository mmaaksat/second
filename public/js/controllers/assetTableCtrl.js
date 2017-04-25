oilApp.controller('AssetTableCtrl',
  function($scope, $http, $location,$rootScope,$window,$location) {
  	$http({
		      method: 'GET',
		      url: '/api/asset_table',
		      headers: {
			   'Content-Type': 'application/json'
			 	}
		    }).then(function successCallback(response) {
		    	$scope.table = response.data;
		    	$rootScope.oilTable = response.data;
		    });


});
oilApp.controller('EditOilCtrl',
  function($scope, $http, $location,$rootScope,$window,$location,$routeParams) {
  	$scope.add = function(){
  		$scope.placeholder = $rootScope.oilTable.
  		$http({
		      method: 'POST',
		      url: '/api/add_oil',
		      headers: {
			   'Content-Type': 'application/json'
			 	},
		      data: { oilFieldsName: $scope.oilFieldsName,
		      			id:$routeParams }
		    }).then(function successCallback(response) {
		        $scope.rs = response.data;
		        $location.path("/asset_table");
		});
  	}

});
oilApp.controller('DeleteOilCtrl',
  function($scope, $http, $location,$rootScope,$window,$location,$routeParams) {
  	

});
oilApp.controller('OilFieldsCtrl',
  function($scope, $http, $location,$rootScope,$window,$location,$routeParams) {

});
oilApp.controller('AddOilCtrl',
  function($scope, $http, $location,$rootScope,$window,$location) {
  	$scope.add = function(){
  		$http({
		      method: 'POST',
		      url: '/api/add_oil',
		      headers: {
			   'Content-Type': 'application/json'
			 	},
		      data: { oilFieldsName: $scope.oilFieldsName }
		    }).then(function successCallback(response) {
		        $scope.rs = response.data;
		        $location.path("/asset_table");
		});
  	}
  	

});