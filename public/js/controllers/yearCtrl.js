oilApp.controller('YearTableCtrl',
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
		    	$scope.scenarios = response.data;
	});
  	$http({
		      method: 'GET',
		      url: '/api/assets/'+$routeParams.aid+'/oil_fields/'+$routeParams.oid + '/scenarios/'+$routeParams.sid+'/year',
		      headers: {
			   'Content-Type': 'application/json'
			 	}
		    }).then(function successCallback(response) {
		    	$scope.year = response.data;
	});
});

oilApp.controller('YearCtrl',
  function($scope, $http, $location,$rootScope,$window,$location,$routeParams) {
  	$scope.assetId = $routeParams.aid;
  	$scope.oilId = $routeParams.oid;
  	$scope.scenId = $routeParams.sid;
	$scope.yearId = $routeParams.yid;


  	$http({
		      method: 'GET',
		      url: '/api/assets/'+$routeParams.aid+'/oil_fields/'+$routeParams.oid + '/scenarios/'+$routeParams.sid+'/year/'+$routeParams.yid,
		      headers: {
			   'Content-Type': 'application/json'
			 	}
		    }).then(function successCallback(response) {
		    	$scope.year = response.data;
	});
});

oilApp.controller('EditYearCtrl',
  function($scope, $http, $location,$rootScope,$window,$location,$routeParams) {
  	$scope.assetId = $routeParams.aid;
  	$scope.oilId = $routeParams.oid;
  	$scope.scenId = $routeParams.sid;
	$scope.yearId = $routeParams.yid;


  	$http({
		      method: 'GET',
		      url: '/api/assets/'+$routeParams.aid+'/oil_fields/'+$routeParams.oid + '/scenarios/'+$routeParams.sid+'/year/'+$routeParams.yid,
		      headers: {
			   'Content-Type': 'application/json'
			 	}
		    }).then(function successCallback(response) {
		    	$scope.year = response.data;
	});


	$scope.add = function(){
		$http({
		      method: 'PUT',
		      url: '/api/assets/'+$routeParams.aid+'/oil_fields/'+$routeParams.oid + '/scenarios/'+$routeParams.sid+'/year/'+$routeParams.yid,
		      headers: {
			   'Content-Type': 'application/json'
			 	},
			  data: {
			  	year:$scope.year.year,
			  	creditPayments:$scope.creditPayments,
			  	fieldDevelopmentCost:$scope.fieldDevelopmentCost,
			  	oilSold:$scope.oilSold,
			  	oilPrice:$scope.oilPrice
			  }
		    }).then(function successCallback(response) {
		    	$location.path('/assets/' + $routeParams.aid + '/oil/'+$routeParams.oid + '/scen/'+$routeParams.sid +'/year_table');
		});

	}
});