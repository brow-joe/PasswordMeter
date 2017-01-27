package br.com.jonathan.infrastructure.checker.deductions;

import org.springframework.scheduling.annotation.Async;

import br.com.jonathan.infrastructure.checker.IChecker;
import br.com.jonathan.infrastructure.dto.MetricsDTO;
import br.com.jonathan.infrastructure.dto.PasswordParametersDTO;
import br.com.jonathan.infrastructure.dto.ScoreMetricDTO;

public class NumbersOnlyChecker implements IChecker {

	@Override
	public double score(PasswordParametersDTO dto, MetricsDTO cache) {
		String password = dto.getPassword();
		double countNumbersOnly = 0;
		if (dto.getCountUpperCase() == 0 && dto.getCountLowerCase() == 0 && dto.getCountSymbols() == 0) {
			countNumbersOnly = password.length();
		}

		Double score = countNumbersOnly(countNumbersOnly, password);
		setScoreMetricCache(cache, ScoreMetricDTO.of(score.longValue(), score));
		return score;
	}

	@Override
	public void setScoreMetricCache(MetricsDTO cache, ScoreMetricDTO score) {
		getDeductionMetric(cache).setNumbersOnly(score);
	}

	@Async
	private double countNumbersOnly(double quantity, String password) {
		String replace = password.replaceAll("\\s", "");
		double counter = quantity;
		int diff = password.length() - replace.length();
		if (counter > 0 && diff > 0) {
			counter += diff;
		}
		return counter;
	}

}
