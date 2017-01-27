package br.com.jonathan.infrastructure.checker.deductions;

import br.com.jonathan.infrastructure.checker.IChecker;
import br.com.jonathan.infrastructure.dto.MetricsDTO;
import br.com.jonathan.infrastructure.dto.PasswordParametersDTO;
import br.com.jonathan.infrastructure.dto.ScoreMetricDTO;
import br.com.jonathan.infrastructure.enumeration.EDeductionBonus;

public class ConsecutiveLowerLettersChecker implements IChecker {

	@Override
	public double score(PasswordParametersDTO dto, MetricsDTO cache) {
		long countConsecutiveLowerLetters = sumLengthOfList(dto.getConsecutiveLowerCaseLetters());
		double score = countConsecutiveLowerLetters * EDeductionBonus.LOWERLETTER.getBonus();
		setScoreMetricCache(cache, ScoreMetricDTO.of(countConsecutiveLowerLetters, score));
		return score;
	}

	@Override
	public void setScoreMetricCache(MetricsDTO cache, ScoreMetricDTO score) {
		getDeductionMetric(cache).setConsecutiveLowerLetters(score);
	}

}