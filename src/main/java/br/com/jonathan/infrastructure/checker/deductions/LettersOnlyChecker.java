package br.com.jonathan.infrastructure.checker.deductions;

import br.com.jonathan.infrastructure.checker.IChecker;
import br.com.jonathan.infrastructure.dto.MetricsDTO;
import br.com.jonathan.infrastructure.dto.PasswordParametersDTO;
import br.com.jonathan.infrastructure.dto.ScoreMetricDTO;

public class LettersOnlyChecker implements IChecker {

	@Override
	public double score(PasswordParametersDTO dto, MetricsDTO cache) {
		Double countLettersOnly = 0D;
		if (dto.getCountNumbers() == 0 && dto.getCountSymbols() == 0) {
			countLettersOnly = (double) dto.getPassword().length();
		}
		setScoreMetricCache(cache, ScoreMetricDTO.of(countLettersOnly.longValue(), countLettersOnly));
		return countLettersOnly;
	}

	@Override
	public void setScoreMetricCache(MetricsDTO cache, ScoreMetricDTO score) {
		getDeductionMetric(cache).setLettersOnly(score);
	}

}