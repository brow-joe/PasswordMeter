package br.com.jonathan.infrastructure.checker.additions;

import java.util.regex.Pattern;

import org.springframework.scheduling.annotation.Async;

import br.com.jonathan.infrastructure.checker.IChecker;
import br.com.jonathan.infrastructure.dto.MetricsDTO;
import br.com.jonathan.infrastructure.dto.PasswordParametersDTO;
import br.com.jonathan.infrastructure.dto.ScoreMetricDTO;
import br.com.jonathan.infrastructure.enumeration.EAdditionBonus;

public class MiddleNumbersSymbolsChecker implements IChecker {
	private Pattern regex = Pattern.compile("[^a-z^A-Z^\\s]|[\\d]");

	@Override
	public double score(PasswordParametersDTO dto, MetricsDTO cache) {
		double score = 0;
		long countNumberOrSymbol = 0;
		if (dto.getCountUpperCase() > 0 || dto.getCountLowerCase() > 0 || dto.getCountSymbols() > 0
				|| dto.getCountNumbers() > 2) {
			String password = dto.getPassword();
			char first = password.charAt(0);
			char last = password.charAt(password.length() - 1);
			countNumberOrSymbol = countNumerOrSymbol(dto, first, last);
			score = countNumberOrSymbol * EAdditionBonus.NUMBERORSYMBOL.getBonus();
		}
		setScoreMetricCache(cache, ScoreMetricDTO.of(countNumberOrSymbol, score));
		return score;
	}

	@Override
	public void setScoreMetricCache(MetricsDTO cache, ScoreMetricDTO score) {
		getAdditionsMetric(cache).setMiddleNumbersSymbols(score);
	}

	@Async
	private long countNumerOrSymbol(PasswordParametersDTO dto, Character first, Character last) {
		long counter = dto.getCountNumbers() + dto.getCountSymbols();
		if (regex.matcher(first.toString()).find()) {
			counter--;
		}
		if (regex.matcher(last.toString()).find()) {
			counter--;
		}
		if (counter < 0) {
			return 0;
		}
		return counter;
	}

}