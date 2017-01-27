package br.com.jonathan.infrastructure.checker.additions;

import br.com.jonathan.infrastructure.checker.IChecker;
import br.com.jonathan.infrastructure.dto.MetricsDTO;
import br.com.jonathan.infrastructure.dto.PasswordParametersDTO;
import br.com.jonathan.infrastructure.dto.ScoreMetricDTO;
import br.com.jonathan.infrastructure.enumeration.EAdditionBonus;

public class UpperCaseChecker implements IChecker {

	@Override
	public double score(PasswordParametersDTO dto, MetricsDTO cache) {
		Long countUpperCase = dto.getCountUpperCase();
		Long countChars = dto.getCountChars();

		double scoreUpperCase = 0;
		if (countUpperCase > 0 && countUpperCase < countChars) {
			scoreUpperCase = countChars.doubleValue() - countUpperCase.doubleValue();
		}
		double score = scoreUpperCase * EAdditionBonus.UPPERCASE.getBonus();
		setScoreMetricCache(cache, ScoreMetricDTO.of(countUpperCase, score));
		return score;
	}

	@Override
	public void setScoreMetricCache(MetricsDTO cache, ScoreMetricDTO score) {
		getAdditionsMetric(cache).setUpperCase(score);

	}

}