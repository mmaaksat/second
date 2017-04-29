oilApp.controller('AssetTableCtrl',
  function($scope, $http, $location,$rootScope,$window,$location,$routeParams,checkAuth) {

  	$scope.role = $rootScope.role;
  	$scope.assetId = $routeParams.aid;
  	var rols = ["ASSET_ADMIN","ASSET_VIEW"];
  	checkAuth.check(rols);

  	$http({
		      method: 'GET',
		      url: '/api/assets/'+$routeParams.aid+'/oil_fields/  ',
		      headers: {
			   'Content-Type': 'application/json'
			 	}
		    }).then(function successCallback(response) {
		    	$scope.table = response.data;
		    	$scope.role = $rootScope.user[0];
  				$scope.login = $rootScope.user[1];
		    });

});
oilApp.controller('AddOilCtrl',
  function($scope, $http, $location,$rootScope,$window,$location,$routeParams,checkAuth) {
  	$scope.assetId = $routeParams.aid;
  	var rols = ["ASSET_ADMIN"];
  	checkAuth.check(rols);
  	$scope.a = 1;
  	setTimeout(function(){
  		$scope.role = $rootScope.user[0];
  		$scope.login = $rootScope.user[1];
  		$scope.$apply();
  	},500);
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
  function($scope, $http, $location,$rootScope,$window,$location,$routeParams,checkAuth) {
  	$scope.placeholder = "";
  	var rols = ["ASSET_ADMIN"];
  	checkAuth.check(rols);
	$http({
	      method: 'GET',
	      url: '/api/assets/'+$routeParams.aid+'/oil_fields/'+$routeParams.oid,
	      headers: {
		   'Content-Type': 'application/json'
		 	}
	    }).then(function successCallback(response) {
	    	$scope.role = $rootScope.user[0];
  			$scope.login = $rootScope.user[1];
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
  function($scope, $http, $location,$rootScope,$window,$location,$routeParams,checkAuth) {
  	$scope.placeholder = "";
  	var rols = ["ASSET_ADMIN"];
  	checkAuth.check(rols);
	$http({
	      method: 'GET',
	      url: '/api/assets/'+$routeParams.aid+'/oil_fields/'+$routeParams.oid,
	      headers: {
		   'Content-Type': 'application/json'
		 	}
	    }).then(function successCallback(response) {
	    	$scope.role = $rootScope.user[0];
  			$scope.login = $rootScope.user[1];
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

