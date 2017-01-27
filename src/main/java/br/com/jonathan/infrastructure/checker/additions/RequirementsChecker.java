package br.com.jonathan.infrastructure.checker.additions;

import org.springframework.scheduling.annotation.Async;

import br.com.jonathan.infrastructure.checker.IChecker;
import br.com.jonathan.infrastructure.dto.MetricsDTO;
import br.com.jonathan.infrastructure.dto.PasswordParametersDTO;
import br.com.jonathan.infrastructure.dto.ScoreMetricDTO;
import br.com.jonathan.infrastructure.enumeration.EAdditionBonus;

public class RequirementsChecker implements IChecker {

	@Override
	public double score(PasswordParametersDTO dto, MetricsDTO cache) {
		long countRequirements = countRequirements(dto);
		double score = calculateScoreRequirements(dto.getCountChars(), countRequirements);
		setScoreMetricCache(cache, ScoreMetricDTO.of(countRequirements, score));
		return score;
	}

	@Override
	public void setScoreMetricCache(MetricsDTO cache, ScoreMetricDTO score) {
		getAdditionsMetric(cache).setRequirements(score);
	}

	@Async
	private long countRequirements(PasswordParametersDTO dto) {
		long counter = dto.getCountChars() > 7 ? 1 : 0;
		counter += dto.getCountUpperCase() > 0 ? 1 : 0;
		counter += dto.getCountLowerCase() > 0 ? 1 : 0;
		counter += dto.getCountNumbers() > 0 ? 1 : 0;
		counter += dto.getCountSymbols() > 0 ? 1 : 0;
		return counter;
	}

	@Async
	private double calculateScoreRequirements(long countChars, long countRequirements) {
		int min;
		if (countChars > 7) {
			min = 3;
		} else {
			min = 4;
		}

		double score = 0;
		if (countRequirements > min) {
			score = countRequirements * EAdditionBonus.REQUIREMENTS.getBonus();
		}
		return score;
	}

}