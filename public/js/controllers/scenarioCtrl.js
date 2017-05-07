oilApp.controller('ScenTableCtrl',
  function($scope, $http, $location,$rootScope,$window,$location,$routeParams,checkAuth) {
  	$scope.assetId = $routeParams.aid;
  	$scope.oilId = $routeParams.oid;

  	var rols = ["ASSET_ADMIN","ASSET_VIEW","OIL_ADMIN","OIL_VIEW"];
  	checkAuth.check(rols);

  	$http({
		      method: 'GET',
		      url: '/api/assets/'+$routeParams.aid+'/oil_fields/'+$routeParams.oid + '/scenarios',
		      headers: {
			   'Content-Type': 'application/json'
			 	}
		    }).then(function successCallback(response) {
		    	$scope.role = $rootScope.user[0];
		    	if($scope.role == "ASSET_ADMIN" || $scope.role == "ASSET_VIEW"){
		    		if($scope.role == "ASSET_VIEW"){ $scope.viewer = true; }
		    		if($scope.role == "ASSET_ADMIN"){ $scope.admin = true; }
		    		$scope.hide = false;
		    	}else{
		    		if($scope.role == "OIL_VIEW"){ $scope.viewer = true; }
		    		$scope.hide = true;
		    	}
  				$scope.login = $rootScope.user[1];
		    	$scope.table = response.data;
		    	$http({
					method: 'GET',
					url: '/api/assetname/'+$routeParams.aid,
					headers: {
						'Content-Type': 'application/json'
					}
				}).then(function successCallback(response) {
					$scope.assetname = response.data.assetName;
				});
		    });
});

oilApp.controller('AddScenCtrl',
  function($scope, $http, $location,$rootScope,$window,$location,$routeParams,checkAuth) {
  	$scope.assetId = $routeParams.aid;
  	$scope.oilId = $routeParams.oid;

  	var rols = ["OIL_ADMIN"];
  	checkAuth.check(rols);
  	
  	$http({
			method: 'GET',
			url: '/api/assetname/'+$routeParams.aid,
			headers: {
				'Content-Type': 'application/json'
			}
		}).then(function successCallback(response) {
			$scope.assetname = response.data.assetName;
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


  	$scope.add = function(){
  		$http({
		      method: 'POST',
		      url: '/api/assets/'+$routeParams.aid+'/oil_fields/'+$routeParams.oid + '/scenarios',
		      headers: {
			   'Content-Type': 'application/json'
			 	},
			 data:{
			 	number:$scope.rs.number,
				 	startYear:$scope.rs.startYear,
				 	endYear:$scope.rs.endYear,
				 	tax:$scope.rs.tax,
				 	moneyFromBank:$scope.rs.moneyFromBank,
				 	inflation:$scope.rs.inflation
			 }
		    }).then(function successCallback(response) {
		    	
		    	$scope.table = response.data;
		    	$location.path('/assets/' + $routeParams.aid + '/oil/'+$routeParams.oid + '/oil_table');
		});
  	}
  	
});


oilApp.controller('EditScenCtrl',
  function($scope, $http, $location,$rootScope,$window,$location,$routeParams,checkAuth) {
  	$scope.assetId = $routeParams.aid;
  	$scope.oilId = $routeParams.oid;
  	$scope.scenId = $routeParams.sid;

  	var rols = ["OIL_ADMIN"];
  	checkAuth.check(rols);

  	$http({
		      method: 'GET',
		      url: '/api/assets/'+$routeParams.aid+'/oil_fields/'+$routeParams.oid + '/scenarios/'+$routeParams.sid,
		      headers: {
			   'Content-Type': 'application/json'
			 	}
		    }).then(function successCallback(response) {
		    	$scope.role = $rootScope.user[0];
  				$scope.login = $rootScope.user[1];
		    	$scope.rs = response.data;
		    	if($scope.role == "ASSET_ADMIN" || $scope.role == "ASSET_VIEW"){
		    		if($scope.role == "ASSET_VIEW"){ $scope.viewer = true; }
		    		$scope.hide = false;
		    	}else{
		    		if($scope.role == "OIL_VIEW"){ $scope.viewer = true; }
		    		$scope.hide = true;
		    	}
		    	$http({
					method: 'GET',
					url: '/api/assetname/'+$routeParams.aid,
					headers: {
						'Content-Type': 'application/json'
					}
				}).then(function successCallback(response) {
					$scope.assetname = response.data.assetName;
				});
	});

  	$scope.add = function(){
  		
  		$http({
		      method: 'PUT',
		      url: '/api/assets/'+$routeParams.aid+'/oil_fields/'+$routeParams.oid + '/scenarios/'+$routeParams.sid,
		      headers: {
			   'Content-Type': 'application/json'
			 	},
				 data:{
				 	number:$scope.rs.number,
				 	startYear:$scope.rs.startYear,
				 	endYear:$scope.rs.endYear,
				 	tax:$scope.rs.tax,
				 	moneyFromBank:$scope.rs.moneyFromBank,
				 	inflation:$scope.rs.inflation
				 }
		    }).then(function successCallback(response) {
		    	$location.path('/assets/' + $routeParams.aid + '/oil/'+$routeParams.oid + '/oil_table');
		});
  	}
  	
});

oilApp.controller('DeleteScenCtrl',
  function($scope, $http, $location,$rootScope,$window,$location,$routeParams,checkAuth) {
  	$scope.assetId = $routeParams.aid;
  	$scope.oilId = $routeParams.oid;
  	$scope.scenId = $routeParams.sid;

  	var rols = ["OIL_ADMIN"];
  	checkAuth.check(rols);

  	$http({
		      method: 'GET',
		      url: '/api/assets/'+$routeParams.aid+'/oil_fields/'+$routeParams.oid + '/scenarios/'+$routeParams.sid,
		      headers: {
			   'Content-Type': 'application/json'
			 	}
		    }).then(function successCallback(response) {
		    	$scope.role = $rootScope.user[0];
  				$scope.login = $rootScope.user[1];
		    	$scope.rs = response.data;
		    	if($scope.role == "ASSET_ADMIN" || $scope.role == "ASSET_VIEW"){
		    		if($scope.role == "ASSET_VIEW"){ $scope.viewer = true; }
		    		$scope.hide = false;
		    	}else{
		    		if($scope.role == "OIL_VIEW"){ $scope.viewer = true; }
		    		$scope.hide = true;
		    	}
		    	$http({
					method: 'GET',
					url: '/api/assetname/'+$routeParams.aid,
					headers: {
						'Content-Type': 'application/json'
					}
				}).then(function successCallback(response) {
					$scope.assetname = response.data.assetName;
				});
	});

  	$scope.delete = function(){
  		$http({
		      method: 'DELETE',
		      url: '/api/assets/'+$routeParams.aid+'/oil_fields/'+$routeParams.oid + '/scenarios/'+$routeParams.sid,
		      headers: {
			   'Content-Type': 'application/json'
			 	}
		    }).then(function successCallback(response) {
		    	$location.path('/assets/' + $routeParams.aid + '/oil/'+$routeParams.oid + '/oil_table');
		});
  	}
  	
});