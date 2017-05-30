oilApp.controller('LoginCtrl',
  function($scope, $http, $location,$rootScope,$window,$location) {
  		$scope.i = 0;
    $scope.loginClick = function(){
    		$scope.i++;
    	    $http({
		      method: 'POST',
		      url: 'api/login',
		      headers: {
			   'Content-Type': 'application/json'
			 	},
		      data: { login: $scope.login,
		      		  password:$scope.password }
		    }).then(function successCallback(response) {
		        $scope.rs = response.data;
		        if($scope.rs.role != "failed"){
		        	$rootScope.role = $scope.rs.role;
		        	$rootScope.login = $scope.rs.user_id;
		        	if($scope.rs.oil_field_id == "failed"){
		        		$location.path( "/assets/" + $scope.rs.asset_id + "/asset_table" );
		        	} else {
		        		if($scope.rs.asset_id != "failed"){
		        			$location.path( "/assets/" + $scope.rs.asset_id + "/oil/" + $scope.rs.oil_field_id + "/oil_table");
		        		}
		        	}
			    }else{
			    	$scope.error = "Wrong username and/or password!";
			    }	
			});
    }
});

oilApp.controller('LogoutCtrl',
  function($scope, $http, $location) {
  		$http({
		      method: 'GET',
		      url: '/api/logout',
		      headers: {
			   'Content-Type': 'application/json'
			 	}
		    }).then(function successCallback(response) {
		    	$location.path("/");
		    });
});

oilApp.controller('SettingsCtrl',
  function($scope, $http, $location,checkAuth,$rootScope) {
  		
  	var rols = ["ASSET_ADMIN","ASSET_VIEW","OIL_ADMIN","OIL_VIEW"];
  	checkAuth.check(rols);
  	
  	var intervalID = setInterval(function(){
  		if($rootScope.user != undefined){
  			$http({
				method: 'GET',
				url: '/api/user_info',
				headers: {
					'Content-Type': 'application/json'
				}
			}).then(function successCallback(response) {
				$scope.role = $rootScope.user[0];
		  		$scope.login = $rootScope.user[1];
				$scope.rs = response.data;
				$http({
							method: 'GET',
							url: '/api/assetname/'+$routeParams.aid,
							headers: {
								'Content-Type': 'application/json'
							}
						}).then(function successCallback(response) {
							$scope.assetname = response.data.assetName;
							$scope.$apply();
				});
			});
			clearInterval(intervalID);
		}
	},10);

  	

	$scope.add = function(){
		$http({
		      method: 'PUT',
		      url: '/api/change_user_data',
		      headers: {
			   'Content-Type': 'application/json'
			 	},
		      data: { login: $scope.rs.login,
		      		password:$scope.rs.password }
		    }).then(function successCallback(response) {
		    	history.back();
		});
	}



});

