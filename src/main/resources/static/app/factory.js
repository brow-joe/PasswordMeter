app.factory('PasswordFactory', function($http) {
	var factory = {};
	factory.meter = function(password) {
		return $http.post(host_app + '/password/meter', password).then(
				function successCallback(response) {
					var dto = {}
					if (response.status == 200) {
						dto = response.data;
					}
					return dto;
				}, function errorCallback(response) {
					alert("Erro ao invocar back-end {" + host_app + "}");
				});
	}
	factory.loadJson = function() {
		return $http.get('app/passwordMeter.json').then(function(res) {
			return res.data;
		});
	}
	return factory;
});