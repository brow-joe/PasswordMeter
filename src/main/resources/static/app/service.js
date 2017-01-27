app.service('PasswordService', function(LabelClassService, PasswordFactory) {
	this.meter = function(password) {
		return PasswordFactory.meter(password).then(
				function(dto) {
					dto.labelScore = LabelClassService.labelScore(dto.score);
					dto.labelComplexity = LabelClassService
							.labelComplexity(dto.complexity);
					dto.complexity = dto.complexity.split('_').join(' ');
					return dto;
				});
	}
	this.loadJson = function() {
		return PasswordFactory.loadJson();
	}
});

app.service('LabelClassService', function() {
	this.labelScore = function(score) {
		if (score < 12) {
			return "label-default";
		} else if (score < 24) {
			return "label-danger";
		} else if (score < 36) {
			return "label-warning";
		} else if (score < 74) {
			return "label-info";
		} else if (score < 86) {
			return "label-success";
		} else {
			return "label-primary";
		}
	}
	this.labelComplexity = function(complexity) {
		if (complexity == "MUITO_FRACA") {
			return "label-danger";
		} else if (complexity == "FRACA") {
			return "label-warning";
		} else if (complexity == "BOA") {
			return "label-info";
		} else if (complexity == "FORTE") {
			return "label-success";
		} else {
			return "label-primary";
		}
	}
});