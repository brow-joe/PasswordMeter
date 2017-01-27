package br.com.jonathan.processor.builder;

import java.util.function.Function;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

import org.springframework.scheduling.annotation.Async;

import br.com.jonathan.infrastructure.dto.PasswordMeterDTO;
import br.com.jonathan.infrastructure.checker.IChecker;
import br.com.jonathan.infrastructure.dto.MetricsDTO;
import br.com.jonathan.infrastructure.dto.PasswordParametersDTO;

@FunctionalInterface
public interface IBuilderProcessorFactory {

	@Async
	default DoubleStream builder(PasswordParametersDTO parameters, PasswordMeterDTO cache) {
		Function<IChecker, Double> executer = executer(parameters, cache.getMetrics());
		return builder().mapToDouble(executer::apply);
	}

	@Async
	default Function<IChecker, Double> executer(PasswordParametersDTO dto, MetricsDTO cache) {
		return checker -> checker.score(dto, cache);
	}

	@Async
	public Stream<IChecker> builder();

}