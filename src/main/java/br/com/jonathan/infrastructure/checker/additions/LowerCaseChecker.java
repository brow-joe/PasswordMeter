package br.com.jonathan.infrastructure.checker.additions;

import br.com.jonathan.infrastructure.checker.IChecker;
import br.com.jonathan.infrastructure.dto.MetricsDTO;
import br.com.jonathan.infrastructure.dto.PasswordParametersDTO;
import br.com.jonathan.infrastructure.dto.ScoreMetricDTO;
import br.com.jonathan.infrastructure.enumeration.EAdditionBonus;

public class LowerCaseChecker implements IChecker {

	@Override
	public double score(PasswordParametersDTO dto, MetricsDTO cache) {
		Long countLowerCase = dto.getCountLowerCase();

		double scoreLowerCase = 0;
		if (countLowerCase > 0 && countLowerCase < dto.getCountChars()) {
			scoreLowerCase = dto.getCountChars() - countLowerCase.doubleValue();
		}

		double score = scoreLowerCase * EAdditionBonus.LOWERCASE.getBonus();
		setScoreMetricCache(cache, ScoreMetricDTO.of(countLowerCase, score));
		return score;
	}

	@Override
	public void setScoreMetricCache(MetricsDTO cache, ScoreMetricDTO score) {
		getAdditionsMetric(cache).setLowerCase(score);
	}

}