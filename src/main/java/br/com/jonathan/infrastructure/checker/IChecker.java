package br.com.jonathan.infrastructure.checker;

import java.util.List;
import java.util.stream.IntStream;

import org.springframework.scheduling.annotation.Async;

import br.com.jonathan.infrastructure.dto.AdditionMetricsDTO;
import br.com.jonathan.infrastructure.dto.DeductionMetricsDTO;
import br.com.jonathan.infrastructure.dto.MetricsDTO;
import br.com.jonathan.infrastructure.dto.PasswordParametersDTO;
import br.com.jonathan.infrastructure.dto.ScoreMetricDTO;

public interface IChecker {

	@Async
	public double score(PasswordParametersDTO parameters, MetricsDTO cache);

	@Async
	public void setScoreMetricCache(MetricsDTO cache, ScoreMetricDTO score);

	@Async
	default AdditionMetricsDTO getAdditionsMetric(MetricsDTO metrics) {
		return metrics.getAdditions();
	}

	@Async
	default DeductionMetricsDTO getDeductionMetric(MetricsDTO metrics) {
		return metrics.getDeductions();
	}

	@Async
	default long getQuantity(String sequence, String password) {
		return IntStream.range(0, sequence.length() - 3)
				.map(i -> quantity(sequence, password, i))
				.sum();
	}
	
	@Async
	default int quantity(String sequence, String password, int index) {
		String order = sequence.substring(index, index + 3);
		String reverse = new StringBuilder(order).reverse().toString();
		if (password.toLowerCase().indexOf(order) != -1 || password.toLowerCase().indexOf(reverse) != -1) {
			return 1;
		}
		return 0;
	}
	
	@Async
	default long sumLengthOfList(List<String> list) {
		return list.stream()
				.mapToInt(String::length)
				.filter(l -> l > 1)
				.map(e -> e - 1)
				.sum();
	}

}