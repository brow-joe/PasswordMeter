package br.com.jonathan.processor;

import java.util.stream.DoubleStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import br.com.jonathan.infrastructure.dto.PasswordMeterDTO;
import br.com.jonathan.infrastructure.dto.PasswordParametersDTO;
import br.com.jonathan.processor.builder.FactoryBuilderFacade;
import br.com.jonathan.processor.transformer.PasswordParametersTransformer;

@Component
public class PasswordProcessor {

	@Autowired
	private PasswordParametersTransformer transformer;
	@Autowired
	private FactoryBuilderFacade factory;

	@Async
	public PasswordMeterDTO process(String password) throws ProcessorException {
		PasswordMeterDTO dto = new PasswordMeterDTO(0);
		PasswordParametersDTO parameters = transformer.covered(password);
		double score = calculateScore(parameters, dto);
		dto.setScore(score);
		return dto;
	}

	@Async
	public double calculateScore(PasswordParametersDTO dto, PasswordMeterDTO cache) {
		DoubleStream addition = factory.additionBuilder().builder(dto, cache);
		DoubleStream deduction = factory.deductionBuilder().builder(dto, cache);
		double score = calculateBuilder(addition, deduction);
		return coveredScore(score);
	}

	@Async
	private double calculateBuilder(DoubleStream addition, DoubleStream deduction) {
		return addition.sum() - deduction.sum();
	}

	@Async
	private double coveredScore(double score) {
		if (score > 100) {
			return 100;
		} else if (score < 0) {
			return 0;
		}
		return score;
	}

}