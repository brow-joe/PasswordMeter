package br.com.jonathan.infrastructure.checker.additions;

import br.com.jonathan.infrastructure.checker.IChecker;
import br.com.jonathan.infrastructure.dto.MetricsDTO;
import br.com.jonathan.infrastructure.dto.PasswordParametersDTO;
import br.com.jonathan.infrastructure.dto.ScoreMetricDTO;
import br.com.jonathan.infrastructure.enumeration.EAdditionBonus;

public class NumberChecker implements IChecker {

	@Override
	public double score(PasswordParametersDTO dto, MetricsDTO cache) {
		double score;
		if (dto.getCountUpperCase() > 0 || dto.getCountLowerCase() > 0 || dto.getCountSymbols() > 0) {
			score = dto.getCountNumbers() * EAdditionBonus.NUMBERS.getBonus();
		} else {
			score = 0;
		}
		setScoreMetricCache(cache, ScoreMetricDTO.of(dto.getCountNumbers(), score));
		return score;
	}

	@Override
	public void setScoreMetricCache(MetricsDTO cache, ScoreMetricDTO score) {
		getAdditionsMetric(cache).setNumbers(score);
	}

}