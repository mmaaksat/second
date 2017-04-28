oilApp.controller('MemTableCtrl',
  function($scope, $http, $location,$rootScope,$window,$location,$routeParams) {
  	$scope.assetId = $routeParams.aid;
  	$scope.oilId = $routeParams.oid;

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
  function($scope, $http, $location,$rootScope,$window,$location,$routeParams) {
  	$scope.assetId = $routeParams.aid;
  	$scope.oilId = $routeParams.oid;
  	$scope.memId = $routeParams.mid;


  	$scope.add = function(){
  		$http({
		      method: 'POST',
		      url: '/api/assets/'+$routeParams.aid+'/oil_fields/'+$routeParams.oid + '/members',
		      headers: {
			   'Content-Type': 'application/json'
			 	},
			 data:{
			 	login:$scope.login,
			 	password:$scope.password,
			 	role:$scope.role
			 }
		    }).then(function successCallback(response) {
		    	$scope.table = response.data;
		    	$location.path('/assets/' + $routeParams.aid + '/oil/'+$routeParams.oid + '/mem_table');
		});
  	}
  	
});


oilApp.controller('EditMemCtrl',
  function($scope, $http, $location,$rootScope,$window,$location,$routeParams) {
  	$scope.assetId = $routeParams.aid;
  	$scope.oilId = $routeParams.oid;
  	$scope.memId = $routeParams.mid;

  	$http({
		      method: 'GET',
		      url: '/api/assets/'+$routeParams.aid+'/oil_fields/'+$routeParams.oid + '/members/'+$routeParams.mid,
		      headers: {
			   'Content-Type': 'application/json'
			 	}
		    }).then(function successCallback(response) {
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
			 	login:$scope.login,
			 	password:$scope.password,
			 	role:$scope.role
			 }
		    }).then(function successCallback(response) {
		    	$location.path('/assets/' + $routeParams.aid + '/oil/'+$routeParams.oid + '/mem_table');
		});
  	}
  	
});

oilApp.controller('DeleteMemCtrl',
  function($scope, $http, $location,$rootScope,$window,$location,$routeParams) {
  	$scope.assetId = $routeParams.aid;
  	$scope.oilId = $routeParams.oid;
  	$scope.scenId = $routeParams.mid;

  	$http({
		      method: 'GET',
		      url: '/api/assets/'+$routeParams.aid+'/oil_fields/'+$routeParams.oid + '/members/'+$routeParams.mid,
		      headers: {
			   'Content-Type': 'application/json'
			 	}
		    }).then(function successCallback(response) {
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