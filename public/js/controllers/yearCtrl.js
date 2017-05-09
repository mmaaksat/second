oilApp.controller('YearTableCtrl', function($scope, $http, $location, $rootScope, $window, $location, $routeParams, checkAuth, $q, $route) {
	$scope.assetId = $routeParams.aid;
	$scope.oilId = $routeParams.oid;
	$scope.scenId = $routeParams.sid;
	$scope.reload = function() {
		location.reload();
	}



	var rols = ["ASSET_ADMIN", "ASSET_VIEW", "OIL_ADMIN", "OIL_VIEW"];
	checkAuth.check(rols);
  	var intervalID = setInterval(function(){
  		if($rootScope.user[0] != undefined){
  			$http({
				method: 'GET',
				url: '/api/assets/' + $routeParams.aid + '/oil_fields/' + $routeParams.oid + '/scenarios/' + $routeParams.sid,
				headers: {
					'Content-Type': 'application/json'
				}
			}).then(function successCallback(response) {
				$scope.role = $rootScope.user[0];
				$scope.login = $rootScope.user[1];
				if ($scope.role == "ASSET_ADMIN" || $scope.role == "ASSET_VIEW") {
					if ($scope.role == "ASSET_VIEW") {
						$scope.viewer = true;
					}
					if ($scope.role == "ASSET_ADMIN") {
						$scope.admin = true;
					}
					$scope.hide = false;
				} else {
					if ($scope.role == "OIL_VIEW") {
						$scope.viewer = true;
					}
					$scope.hide = true;
				}
				$scope.scenarios = response.data;
				$http({
					method: 'GET',
					url: '/api/assets/' + $routeParams.aid + '/oil_fields/' + $routeParams.oid + '/scenarios/' + $routeParams.sid + '/year',
					headers: {
						'Content-Type': 'application/json'
					}
				}).then(function successCallback(response) {
					$scope.year = response.data;
					$scope.year[0].income = $scope.year[0].income + $scope.scenarios.moneyFromBank;
					var year = $scope.year;
					deferred.resolve(year);
				});
			});
			var deferred = $q.defer();
			$http({
				method: 'GET',
				url: '/api/assetname/' + $routeParams.aid,
				headers: {
					'Content-Type': 'application/json'
				}
			}).then(function successCallback(response) {
				$scope.assetname = response.data.assetName;
				var obj = deferred.promise;
				obj.then(function(value) {
					var year = value;
					window.year = year;
				});
			});
  			clearInterval(intervalID);
  			$scope.$apply();
  		}
  	},10);
	

});












oilApp.controller('YearCtrl', function($scope, $http, $location, $rootScope, $window, $location, $routeParams, checkAuth) {
	$scope.assetId = $routeParams.aid;
	$scope.oilId = $routeParams.oid;
	$scope.scenId = $routeParams.sid;
	$scope.yearId = $routeParams.yid;
	var rols = ["ASSET_ADMIN", "ASSET_VIEW", "OIL_ADMIN", "OIL_VIEW"];
	checkAuth.check(rols);


	var intervalID = setInterval(function(){
		if($rootScope.user != undefined){
			$http({
				method: 'GET',
				url: '/api/assets/' + $routeParams.aid + '/oil_fields/' + $routeParams.oid + '/scenarios/' + $routeParams.sid + '/year/' + $routeParams.yid,
				headers: {
					'Content-Type': 'application/json'
				}
			}).then(function successCallback(response) {
				$scope.role = $rootScope.user[0];
				$scope.login = $rootScope.user[1];
				if ($scope.role == "ASSET_ADMIN" || $scope.role == "ASSET_VIEW") {
					if ($scope.role == "ASSET_VIEW") {
						$scope.viewer = true;
					}
					$scope.hide = false;
				} else {
					if ($scope.role == "OIL_VIEW") {
						$scope.viewer = true;
					}
					$scope.hide = true;
				}
				$http({
					method: 'GET',
					url: '/api/assetname/' + $routeParams.aid,
					headers: {
						'Content-Type': 'application/json'
					}
				}).then(function successCallback(response) {
					$scope.assetname = response.data.assetName;
				});
				$scope.year = response.data;
			});
			clearInterval(intervalID);
		}
	},10);
	
});
oilApp.controller('EditYearCtrl', function($scope, $http, $location, $rootScope, $window, $location, $routeParams, checkAuth) {
	$scope.assetId = $routeParams.aid;
	$scope.oilId = $routeParams.oid;
	$scope.scenId = $routeParams.sid;
	$scope.yearId = $routeParams.yid;
	var rols = ["OIL_ADMIN"];
	checkAuth.check(rols);


	var intervalID = setInterval(function(){
		if($rootScope.user != undefined){
			$http({
				method: 'GET',
				url: '/api/assets/' + $routeParams.aid + '/oil_fields/' + $routeParams.oid + '/scenarios/' + $routeParams.sid + '/year/' + $routeParams.yid,
				headers: {
					'Content-Type': 'application/json'
				}
			}).then(function successCallback(response) {
				$scope.role = $rootScope.user[0];
				$scope.login = $rootScope.user[1];
				if ($scope.role == "ASSET_ADMIN" || $scope.role == "ASSET_VIEW") {
					if ($scope.role == "ASSET_VIEW") {
						$scope.viewer = true;
					}
					$scope.hide = false;
				} else {
					if ($scope.role == "OIL_VIEW") {
						$scope.viewer = true;
					}
					$scope.hide = true;
				}
				$scope.year = response.data;
				$http({
					method: 'GET',
					url: '/api/assetname/' + $routeParams.aid,
					headers: {
						'Content-Type': 'application/json'
					}
				}).then(function successCallback(response) {
					$scope.assetname = response.data.assetName;
				});
			});

			clearInterval(intervalID);
		}
	},10);
	
		$scope.add = function() {
		$http({
			method: 'PUT',
			url: '/api/assets/' + $routeParams.aid + '/oil_fields/' + $routeParams.oid + '/scenarios/' + $routeParams.sid + '/year/' + $routeParams.yid,
			headers: {
				'Content-Type': 'application/json'
			},
			data: {
				year: $scope.year.year,
				creditPayments: $scope.year.creditPayments,
				fieldDevelopmentCost: $scope.year.fieldDevelopmentCost,
				oilSold: $scope.year.oilSold,
				oilPrice: $scope.year.oilPrice
			}
		}).then(function successCallback(response) {
			$location.path('/assets/' + $routeParams.aid + '/oil/' + $routeParams.oid + '/scen/' + $routeParams.sid + '/year_table');
		});
	}
});