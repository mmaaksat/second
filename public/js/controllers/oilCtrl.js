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
		    	if($scope.role == "ASSET_ADMIN" || $scope.role == "ASSET_VIEW"){
		    		if($scope.role == "ASSET_VIEW"){ $scope.viewer = true; }
		    		$scope.hide = false;
		    	}else{
		    		if($scope.role == "OIL_VIEW"){ $scope.viewer = true; }
		    		$scope.hide = true;
		    	}

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
		    	if($scope.role == "ASSET_ADMIN" || $scope.role == "ASSET_VIEW"){
		    		if($scope.role == "ASSET_VIEW"){ $scope.viewer = true; }
		    		$scope.hide = false;
		    	}else{
		    		if($scope.role == "OIL_VIEW"){ $scope.viewer = true; }
		    		$scope.hide = true;
		    	}

  		$scope.$apply();
  	},500);
  	$scope.add = function(){
  		$http({
		      method: 'POST',
		      url: 'api/assets/'+$routeParams.aid+'/oil_fields/ ',
		      headers: {
			   'Content-Type': 'application/json'
			 	},
		      data: { oilFieldsName: $scope.rs.oilFieldsName }
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
		    	if($scope.role == "ASSET_ADMIN" || $scope.role == "ASSET_VIEW"){
		    		if($scope.role == "ASSET_VIEW"){ $scope.viewer = true; }
		    		$scope.hide = false;
		    	}else{
		    		if($scope.role == "OIL_VIEW"){ $scope.viewer = true; }
		    		$scope.hide = true;
		    	}

	        $scope.rs = response.data;
	});
	$scope.assetId = $routeParams.aid;
  	$scope.add = function(){
  		$http({
		      method: 'PUT',
		      url: '/api/assets/'+$routeParams.aid+'/oil_fields/'+$routeParams.oid,
		      headers: {
			   'Content-Type': 'application/json'
			 	},
		      data: { oilFieldsName: $scope.rs.oilFieldsName }
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
		    	if($scope.role == "ASSET_ADMIN" || $scope.role == "ASSET_VIEW"){
		    		if($scope.role == "ASSET_VIEW"){ $scope.viewer = true; }
		    		$scope.hide = false;
		    	}else{
		    		if($scope.role == "OIL_VIEW"){ $scope.viewer = true; }
		    		$scope.hide = true;
		    	}

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

