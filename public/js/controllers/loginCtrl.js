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
		        	if($scope.rs.oil_field_id == "failed"){
		        		$location.path( "/assets/" + $scope.rs.asset_id + "/asset_table" );
		        	} else {
		        		if($scope.rs.asset_id != "failed"){
		        			$location.path( "/assets/" + $scope.rs.asset_id + "/oil/" + $scope.rs.oil_field_id + "/oil_table");
		        		}
		        	}
			    }else{
			    	$scope.error = "Неправильный имя пользователя и пароль";
			    }	
			});
    }
});