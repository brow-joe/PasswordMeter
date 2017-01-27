package br.com.jonathan.infrastructure.checker.deductions;

import org.springframework.scheduling.annotation.Async;

import br.com.jonathan.infrastructure.checker.IChecker;
import br.com.jonathan.infrastructure.dto.MetricsDTO;
import br.com.jonathan.infrastructure.dto.PasswordParametersDTO;
import br.com.jonathan.infrastructure.dto.ScoreMetricDTO;
import br.com.jonathan.infrastructure.enumeration.EDeductionBonus;

public class SequentialNumbersChecker implements IChecker {
	private static final String NUMERICS = "01234567890";

	@Override
	public double score(PasswordParametersDTO dto, MetricsDTO cache) {
		long countSequentialNumbers = getQuantitySequenialNumbers(dto.getPassword());
		double score = countSequentialNumbers * EDeductionBonus.SEQUENCENUMBERS.getBonus();
		setScoreMetricCache(cache, ScoreMetricDTO.of(countSequentialNumbers, score));
		return score;
	}

	@Override
	public void setScoreMetricCache(MetricsDTO cache, ScoreMetricDTO score) {
		getDeductionMetric(cache).setSequentialNumbers(score);
	}

	@Async
	private long getQuantitySequenialNumbers(String password) {
		return getQuantity(NUMERICS, password);
	}

}