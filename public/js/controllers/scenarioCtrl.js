oilApp.controller('ScenTableCtrl',
  function($scope, $http, $location,$rootScope,$window,$location,$routeParams) {
  	$scope.assetId = $routeParams.aid;
  	$scope.oilId = $routeParams.oid;
  	$http({
		      method: 'GET',
		      url: '/api/assets/'+$routeParams.aid+'/oil_fields/'+$routeParams.oid + '/scenarios',
		      headers: {
			   'Content-Type': 'application/json'
			 	}
		    }).then(function successCallback(response) {
		    	$scope.table = response.data;
		    });
});

oilApp.controller('AddScenCtrl',
  function($scope, $http, $location,$rootScope,$window,$location,$routeParams) {
  	$scope.assetId = $routeParams.aid;
  	$scope.oilId = $routeParams.oid;

  	$scope.add = function(){
  		$http({
		      method: 'POST',
		      url: '/api/assets/'+$routeParams.aid+'/oil_fields/'+$routeParams.oid + '/scenarios',
		      headers: {
			   'Content-Type': 'application/json'
			 	},
			 data:{
			 	number:$scope.number,
			 	startYear:$scope.startYear,
			 	endYear:$scope.endYear,
			 	tax:$scope.tax,
			 	moneyFromBank:$scope.moneyFromBank,
			 	inflation:$scope.inflation
			 }
		    }).then(function successCallback(response) {
		    	$scope.table = response.data;
		    	$location.path('/assets/' + $routeParams.aid + '/oil/'+$routeParams.oid + '/oil_table');
		});
  	}
  	
});


oilApp.controller('EditScenCtrl',
  function($scope, $http, $location,$rootScope,$window,$location,$routeParams) {
  	$scope.assetId = $routeParams.aid;
  	$scope.oilId = $routeParams.oid;
  	$scope.scenId = $routeParams.sid;

  	$http({
		      method: 'GET',
		      url: '/api/assets/'+$routeParams.aid+'/oil_fields/'+$routeParams.oid + '/scenarios/'+$routeParams.sid,
		      headers: {
			   'Content-Type': 'application/json'
			 	}
		    }).then(function successCallback(response) {
		    	$scope.rs = response.data;
	});

  	$scope.add = function(){
  		$http({
		      method: 'PUT',
		      url: '/api/assets/'+$routeParams.aid+'/oil_fields/'+$routeParams.oid + '/scenarios/'+$routeParams.sid,
		      headers: {
			   'Content-Type': 'application/json'
			 	},
				 data:{
				 	number:$scope.number,
				 	startYear:$scope.startYear,
				 	endYear:$scope.endYear,
				 	tax:$scope.tax,
				 	moneyFromBank:$scope.moneyFromBank,
				 	inflation:$scope.inflation
				 }
		    }).then(function successCallback(response) {
		    	$location.path('/assets/' + $routeParams.aid + '/oil/'+$routeParams.oid + '/oil_table');
		});
  	}
  	
});

oilApp.controller('DeleteScenCtrl',
  function($scope, $http, $location,$rootScope,$window,$location,$routeParams) {
  	$scope.assetId = $routeParams.aid;
  	$scope.oilId = $routeParams.oid;
  	$scope.scenId = $routeParams.sid;

  	$http({
		      method: 'GET',
		      url: '/api/assets/'+$routeParams.aid+'/oil_fields/'+$routeParams.oid + '/scenarios/'+$routeParams.sid,
		      headers: {
			   'Content-Type': 'application/json'
			 	}
		    }).then(function successCallback(response) {
		    	$scope.rs = response.data;
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