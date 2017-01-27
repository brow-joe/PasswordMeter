package br.com.jonathan.infrastructure.checker.deductions;

import br.com.jonathan.infrastructure.checker.IChecker;
import br.com.jonathan.infrastructure.dto.MetricsDTO;
import br.com.jonathan.infrastructure.dto.PasswordParametersDTO;
import br.com.jonathan.infrastructure.dto.ScoreMetricDTO;
import br.com.jonathan.infrastructure.enumeration.EDeductionBonus;

public class ConsecutiveUpperLettersChecker implements IChecker {

	@Override
	public double score(PasswordParametersDTO dto, MetricsDTO cache) {
		long countConsecutiveUpperLetters = sumLengthOfList(dto.getConsecutiveUpperCaseLetters());
		double score = countConsecutiveUpperLetters * EDeductionBonus.UPPERLETTERS.getBonus();
		setScoreMetricCache(cache, ScoreMetricDTO.of(countConsecutiveUpperLetters, score));
		return score;
	}

	@Override
	public void setScoreMetricCache(MetricsDTO cache, ScoreMetricDTO score) {
		getDeductionMetric(cache).setConsecutiveUpperLetters(score);
	}

}