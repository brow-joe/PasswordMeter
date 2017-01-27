package br.com.jonathan.infrastructure.checker.deductions;

import br.com.jonathan.infrastructure.checker.IChecker;
import br.com.jonathan.infrastructure.dto.MetricsDTO;
import br.com.jonathan.infrastructure.dto.PasswordParametersDTO;
import br.com.jonathan.infrastructure.dto.ScoreMetricDTO;
import br.com.jonathan.infrastructure.enumeration.EDeductionBonus;

public class ConsecutiveNumbersChecker implements IChecker {

	@Override
	public double score(PasswordParametersDTO dto, MetricsDTO cache) {
		long countConsecutiveNumbers = sumLengthOfList(dto.getConsecutiveNumbers());
		double score = countConsecutiveNumbers * EDeductionBonus.NUMBERS.getBonus();
		setScoreMetricCache(cache, ScoreMetricDTO.of(countConsecutiveNumbers, score));
		return score;
	}

	@Override
	public void setScoreMetricCache(MetricsDTO cache, ScoreMetricDTO score) {
		getDeductionMetric(cache).setConsecutiveNumbers(score);
	}

}