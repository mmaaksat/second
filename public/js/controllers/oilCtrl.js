oilApp.controller('AssetTableCtrl',
  function($scope, $http, $location,$rootScope,$window,$location,$routeParams) {

  	$scope.role = $rootScope.role;
  	$scope.assetId = $routeParams.aid;
  	
  	$http({
		      method: 'GET',
		      url: '/api/assets/'+$routeParams.aid+'/oil_fields/  ',
		      headers: {
			   'Content-Type': 'application/json'
			 	}
		    }).then(function successCallback(response) {
		    	$scope.table = response.data;
		    });

});
oilApp.controller('AddOilCtrl',
  function($scope, $http, $location,$rootScope,$window,$location,$routeParams) {
  	$scope.assetId = $routeParams.aid;
  	$scope.add = function(){
  		$http({
		      method: 'POST',
		      url: 'api/assets/'+$routeParams.aid+'/oil_fields/ ',
		      headers: {
			   'Content-Type': 'application/json'
			 	},
		      data: { oilFieldsName: $scope.oilFieldsName }
		    }).then(function successCallback(response) {
		        $location.path("/assets/" + $routeParams.aid + "/asset_table");
		});
  	}
});

oilApp.controller('EditOilCtrl',
  function($scope, $http, $location,$rootScope,$window,$location,$routeParams) {
  	$scope.placeholder = "";
	$http({
	      method: 'GET',
	      url: '/api/assets/'+$routeParams.aid+'/oil_fields/'+$routeParams.oid,
	      headers: {
		   'Content-Type': 'application/json'
		 	}
	    }).then(function successCallback(response) {
	        $scope.placeholder = response.data.oilFieldsName;
	});
	$scope.assetId = $routeParams.aid;
  	$scope.add = function(){
  		$http({
		      method: 'PUT',
		      url: '/api/assets/'+$routeParams.aid+'/oil_fields/'+$routeParams.oid,
		      headers: {
			   'Content-Type': 'application/json'
			 	},
		      data: { oilFieldsName: $scope.oilFieldsName }
		    }).then(function successCallback(response) {
		        $location.path("/assets/" + $routeParams.aid + "/asset_table");
		});
  	}

});

oilApp.controller('DeleteOilCtrl',
  function($scope, $http, $location,$rootScope,$window,$location,$routeParams) {
  	$scope.placeholder = "";
	$http({
	      method: 'GET',
	      url: '/api/assets/'+$routeParams.aid+'/oil_fields/'+$routeParams.oid,
	      headers: {
		   'Content-Type': 'application/json'
		 	}
	    }).then(function successCallback(response) {
	        $scope.oilFieldsName = response.data.oilFieldsName;
	});
	$scope.assetId = $routeParams.aid;

	$scope.delete = function(){
		$http({
	      method: 'DELETE',
	      url: '/api/assets/'+$routeParams.aid+'/oil_fields/'+$routeParams.oid,
	      headers: {
		   'Content-Type': 'application/json'
		 	}
	    }).then(function successCallback(response) {
	    	$location.path("/assets/" + $routeParams.aid + "/asset_table");
		});
	}

});

