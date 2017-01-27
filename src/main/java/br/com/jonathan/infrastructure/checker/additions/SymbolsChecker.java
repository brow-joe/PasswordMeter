package br.com.jonathan.infrastructure.checker.additions;

import br.com.jonathan.infrastructure.checker.IChecker;
import br.com.jonathan.infrastructure.dto.MetricsDTO;
import br.com.jonathan.infrastructure.dto.PasswordParametersDTO;
import br.com.jonathan.infrastructure.dto.ScoreMetricDTO;
import br.com.jonathan.infrastructure.enumeration.EAdditionBonus;

public class SymbolsChecker implements IChecker {

	@Override
	public double score(PasswordParametersDTO dto, MetricsDTO cache) {
		double score = dto.getCountSymbols() * EAdditionBonus.SYMBOLS.getBonus();
		setScoreMetricCache(cache, ScoreMetricDTO.of(dto.getCountSymbols(), score));
		return score;
	}

	@Override
	public void setScoreMetricCache(MetricsDTO cache, ScoreMetricDTO score) {
		getAdditionsMetric(cache).setSymbols(score);
	}

}