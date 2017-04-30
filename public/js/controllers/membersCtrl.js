oilApp.controller('MemTableCtrl',
  function($scope, $http, $location,$rootScope,$window,$location,$routeParams,checkAuth) {
  	$scope.assetId = $routeParams.aid;
  	$scope.oilId = $routeParams.oid;

  	var rols = ["ASSET_ADMIN","ASSET_VIEW"];
  	var user = checkAuth.check(rols);
  	

  	$http({
		      method: 'GET',
		      url: '/api/assets/'+$routeParams.aid+'/oil_fields/'+$routeParams.oid + '/members',
		      headers: {
			   'Content-Type': 'application/json'
			 	}
		    }).then(function successCallback(response) {
		    	$scope.table = response.data;
		    });
});

oilApp.controller('AddMemCtrl',
  function($scope, $http, $location,$rootScope,$window,$location,$routeParams,checkAuth) {
  	$scope.assetId = $routeParams.aid;
  	$scope.oilId = $routeParams.oid;
  	$scope.memId = $routeParams.mid;

  	var rols = ["ASSET_ADMIN"];
  	checkAuth.check(rols);

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
		      url: '/api/assets/'+$routeParams.aid+'/oil_fields/'+$routeParams.oid + '/members',
		      headers: {
			   'Content-Type': 'application/json'
			 	},
			 data:{
			 	login:$scope.rs.login,
			 	password:$scope.rs.password,
			 	role:$scope.role
			 }
		    }).then(function successCallback(response) {
		    	$scope.table = response.data;
		    	$location.path('/assets/' + $routeParams.aid + '/oil/'+$routeParams.oid + '/mem_table');
		});
  	}
  	
});


oilApp.controller('EditMemCtrl',
  function($scope, $http, $location,$rootScope,$window,$location,$routeParams,checkAuth) {
  	$scope.assetId = $routeParams.aid;
  	$scope.oilId = $routeParams.oid;
  	$scope.memId = $routeParams.mid;

  	var rols = ["ASSET_ADMIN"];
  	checkAuth.check(rols);

  	$http({
		      method: 'GET',
		      url: '/api/assets/'+$routeParams.aid+'/oil_fields/'+$routeParams.oid + '/members/'+$routeParams.mid,
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

  	$scope.add = function(){
  		$http({
		      method: 'PUT',
		      url: '/api/assets/'+$routeParams.aid+'/oil_fields/'+$routeParams.oid + '/members/'+$routeParams.mid,
		      headers: {
			   'Content-Type': 'application/json'
			 	},
			 data:{
			 	login:$scope.rs.login,
			 	password:$scope.rs.password,
			 	role:$scope.role
			 }
		    }).then(function successCallback(response) {
		    	$location.path('/assets/' + $routeParams.aid + '/oil/'+$routeParams.oid + '/mem_table');
		});
  	}
  	
});

oilApp.controller('DeleteMemCtrl',
  function($scope, $http, $location,$rootScope,$window,$location,$routeParams,checkAuth) {
  	$scope.assetId = $routeParams.aid;
  	$scope.oilId = $routeParams.oid;
  	$scope.scenId = $routeParams.mid;

  	var rols = ["ASSET_ADMIN"];
  	checkAuth.check(rols);

  	$http({
		      method: 'GET',
		      url: '/api/assets/'+$routeParams.aid+'/oil_fields/'+$routeParams.oid + '/members/'+$routeParams.mid,
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

  	$scope.delete = function(){
  		$http({
		      method: 'DELETE',
		      url: '/api/assets/'+$routeParams.aid+'/oil_fields/'+$routeParams.oid + '/members/'+$routeParams.mid,
		      headers: {
			   'Content-Type': 'application/json'
			 	}
		    }).then(function successCallback(response) {
		    	$location.path('/assets/' + $routeParams.aid + '/oil/'+$routeParams.oid + '/mem_table');
		});
  	}
  	
});