package br.com.jonathan.infrastructure.checker.deductions;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.IntStream;

import org.apache.commons.lang3.tuple.Pair;
import org.springframework.scheduling.annotation.Async;

import com.google.common.util.concurrent.AtomicDouble;

import br.com.jonathan.infrastructure.checker.IChecker;
import br.com.jonathan.infrastructure.dto.MetricsDTO;
import br.com.jonathan.infrastructure.dto.PasswordParametersDTO;
import br.com.jonathan.infrastructure.dto.ScoreMetricDTO;

public class RepeatCharactersChecker implements IChecker {
	
	@Override
	public double score(PasswordParametersDTO dto, MetricsDTO cache) {
		Pair<Long, Long> pair = countRepeatCharacters(dto.getPassword());

		double score = 0;
		long countRepeatChar = pair.getLeft();
		long countRepeatAcc = pair.getRight();
		if (countRepeatChar > 0) {
			score = countRepeatAcc;
		}
		setScoreMetricCache(cache, ScoreMetricDTO.of(countRepeatChar, score));
		return score;
	}

	@Override
	public void setScoreMetricCache(MetricsDTO cache, ScoreMetricDTO score) {
		getDeductionMetric(cache).setRepeatCharacters(score);
	}
	
	@Async
	private Pair<Long, Long> countRepeatCharacters(String password) {
		String replace = password.replaceAll("\\s+", "");
		AtomicInteger quantityRepeatChar = new AtomicInteger(0);
		AtomicDouble quantityRepeatInc = new AtomicDouble(0);

		Function<Integer, Pair<Boolean, Double>> executer = i -> countIndexRepeatCharacters(
				i, replace
		);
		
		Consumer<Double> consumer = result -> sumRepeatConsumer(
				result, replace, quantityRepeatChar, quantityRepeatInc
		);

		IntStream.range(0, replace.length())
			.mapToObj(executer::apply)
			.filter(Pair::getLeft)
			.map(Pair::getRight)
			.forEach(consumer);

		return Pair.of(
				quantityRepeatChar.longValue(), 
				quantityRepeatInc.longValue()
		);
	}
	
	@Async
	private void sumRepeatConsumer(double coeficient, String password, AtomicInteger quantityRepeatChar,
			AtomicDouble quantityRepeatInc) {
		double accumulator = quantityRepeatInc.addAndGet(coeficient);
		int quantityUniqueChars = password.length() - quantityRepeatChar.incrementAndGet();

		double score;
		if (quantityUniqueChars > 0) {
			score = Math.ceil(accumulator / quantityUniqueChars);
		} else {
			score = Math.ceil(accumulator);
		}
			
		quantityRepeatInc.set(score);
	}
	
	@Async
	private Pair<Boolean, Double> countIndexRepeatCharacters(final int index, String password) {
		boolean exists = false;
		double result = 0;
		for (int subIndex = 0; subIndex < password.length(); subIndex++) {
			if (password.charAt(index) == password.charAt(subIndex) && index != subIndex
					&& password.charAt(subIndex) != ' ') {
				exists = true;
				result += calculateDiffAbs(password, index, subIndex);
			}
		}
		return Pair.of(exists, result);
	}
	
	@Async
	private double calculateDiffAbs(String password, int index, int subIndex) {
		return Math.abs((double) password.length() / (subIndex - index));
	}

}