angular.module('movie', []);
angular.module('movie').controller('control', function($scope, $http) {
	$scope.list = [];
	$scope.cadastrar = function() {
		$http({
			method : 'POST',
			url : 'Control',
			params : {
				acao : 'cadastrar',
				title: $scope.title,
				genre: $scope.genre,
				protagonist: $scope.protagonist,
				director: $scope.director,
				what: $scope.what,
				extra: $scope.extra,
				released: $scope.released,
				rating: $scope.rating
			}
		}).then(function(response) {
			$scope.list = response.data;
		}, function(response) {
		});
	};
	$scope.listar = function() {
		$http({
			method : 'POST',
			url : 'Control'
		}).then(function(response) {
			$scope.list = response.data;
		}, function(response) {
		});
	}
});