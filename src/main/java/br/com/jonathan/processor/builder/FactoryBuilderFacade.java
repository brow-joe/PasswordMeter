package br.com.jonathan.processor.builder;

import java.util.stream.Stream;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import br.com.jonathan.infrastructure.checker.IChecker;
import br.com.jonathan.infrastructure.checker.additions.CharsChecker;
import br.com.jonathan.infrastructure.checker.additions.LowerCaseChecker;
import br.com.jonathan.infrastructure.checker.additions.MiddleNumbersSymbolsChecker;
import br.com.jonathan.infrastructure.checker.additions.NumberChecker;
import br.com.jonathan.infrastructure.checker.additions.RequirementsChecker;
import br.com.jonathan.infrastructure.checker.additions.SymbolsChecker;
import br.com.jonathan.infrastructure.checker.additions.UpperCaseChecker;
import br.com.jonathan.infrastructure.checker.deductions.ConsecutiveLowerLettersChecker;
import br.com.jonathan.infrastructure.checker.deductions.ConsecutiveNumbersChecker;
import br.com.jonathan.infrastructure.checker.deductions.ConsecutiveUpperLettersChecker;
import br.com.jonathan.infrastructure.checker.deductions.LettersOnlyChecker;
import br.com.jonathan.infrastructure.checker.deductions.NumbersOnlyChecker;
import br.com.jonathan.infrastructure.checker.deductions.RepeatCharactersChecker;
import br.com.jonathan.infrastructure.checker.deductions.SequentialLettersChecker;
import br.com.jonathan.infrastructure.checker.deductions.SequentialNumbersChecker;
import br.com.jonathan.infrastructure.checker.deductions.SequentialSymbolsChecker;

@Component
public class FactoryBuilderFacade {

	@Async
	public IBuilderProcessorFactory additionBuilder() {
		return this::additionChecker;
	}

	@Async
	public IBuilderProcessorFactory deductionBuilder() {
		return this::deductionChecker;
	}

	@Async
	public Stream<IChecker> additionChecker() {
		return Stream.of(new CharsChecker(), new UpperCaseChecker(), new LowerCaseChecker(), new NumberChecker(),
				new SymbolsChecker(), new MiddleNumbersSymbolsChecker(), new RequirementsChecker());
	}

	@Async
	public Stream<IChecker> deductionChecker() {
		return Stream.of(new LettersOnlyChecker(), new NumbersOnlyChecker(), new RepeatCharactersChecker(),
				new ConsecutiveUpperLettersChecker(), new ConsecutiveLowerLettersChecker(),
				new ConsecutiveNumbersChecker(), new SequentialLettersChecker(), new SequentialNumbersChecker(),
				new SequentialSymbolsChecker());
	}

}