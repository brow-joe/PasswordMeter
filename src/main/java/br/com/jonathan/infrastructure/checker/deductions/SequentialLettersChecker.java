package br.com.jonathan.infrastructure.checker.deductions;

import org.springframework.scheduling.annotation.Async;

import br.com.jonathan.infrastructure.checker.IChecker;
import br.com.jonathan.infrastructure.dto.MetricsDTO;
import br.com.jonathan.infrastructure.dto.PasswordParametersDTO;
import br.com.jonathan.infrastructure.dto.ScoreMetricDTO;
import br.com.jonathan.infrastructure.enumeration.EDeductionBonus;

public class SequentialLettersChecker implements IChecker {
	private static final String ALPHAS = "abcdefghijklmnopqrstuvwxyz";

	@Override
	public double score(PasswordParametersDTO dto, MetricsDTO cache) {
		long countSequentialLetters = getQuantitySequenialLetters(dto.getPassword());
		double score = countSequentialLetters * EDeductionBonus.LETTERS.getBonus();
		setScoreMetricCache(cache, ScoreMetricDTO.of(countSequentialLetters, score));
		return score;
	}

	@Override
	public void setScoreMetricCache(MetricsDTO cache, ScoreMetricDTO score) {
		getDeductionMetric(cache).setSequentialLetters(score);
	}

	@Async
	private long getQuantitySequenialLetters(String password) {
		return getQuantity(ALPHAS, password);
	}

}
