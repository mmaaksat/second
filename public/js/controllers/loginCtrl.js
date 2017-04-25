oilApp.controller('LoginCtrl',
  function($scope, $http, $location,$rootScope,$window,$location) {
  		$scope.i = 0;
    $scope.loginClick = function(){

    		$scope.i++;
    	    $http({
		      method: 'POST',
		      url: '/api/login',
		      headers: {
			   'Content-Type': 'application/json'
			 	},
		      data: { login: $scope.login,
		      		password:$scope.password }
		    }).then(function successCallback(response) {
		        $scope.rs = response.data;
		        if($scope.rs.role != "failed"){
		    	$rootScope.role = $scope.rs.role;
			    	switch($rootScope.role){
			    		case "ASSET_ADMIN":
			    			$location.path( "/asset_table" );
			    			break;
			    		case "ASSET_VIEW":
			    			$location.path( "/asset_table" );
			    			break;
			    		case "OIL_ADMIN":

			    			break;
			    		case "OIL_VIEW":
			    			
			    			break;	
			    	}
			    }else{
			    	$scope.error = "Неправильный имя пользователя и пароль";
			    }	
			});
    }
});