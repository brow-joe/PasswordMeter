var host_app = "http://localhost:8080";
var app = angular.module('home_app', []);

app.controller("homeController", function($scope, $http, PasswordService) {
	$scope.form = {};
	$scope.passwordAction = function() {
		var password = $scope.form.password;
		if (password != "" && password != null) {
			PasswordService.meter(password).then(function(dto) {
				$scope.passwordMetter = dto;
			});
		} else {
			defaultPassword($scope);
		}
	}
	PasswordService.loadJson().then(function(json) {
		$scope.passwordDefault = json;
		defaultPassword($scope);
	});
});

function defaultPassword($scope) {
	$scope.passwordMetter = $scope.passwordDefault;
}