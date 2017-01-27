package br.com.jonathan.processor.transformer;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import br.com.jonathan.infrastructure.dto.PasswordParametersDTO;
import br.com.jonathan.util.RegexMatcherIterator;

@Component
public class PasswordParametersTransformer {

	@Async
	public PasswordParametersDTO covered(String password) {
		return coveredConsecutiver(password, coveredCounter(password));
	}

	@Async
	private PasswordParametersDTO coveredConsecutiver(String password, PasswordParametersDTO dto) {
		dto.setConsecutiveUpperCaseLetters(regex(password, Pattern.compile("[A-Z\\s]+")));
		dto.setConsecutiveLowerCaseLetters(regex(password, Pattern.compile("[a-z\\s]+")));
		dto.setConsecutiveNumbers(regex(password, Pattern.compile("[0-9\\s]+")));
		return dto;
	}

	@Async
	private PasswordParametersDTO coveredCounter(String password) {
		long countUpperCase = StreamSupport
				.stream(new RegexMatcherIterator(Pattern.compile("[A-Z]").matcher(password)), false).count();
		long countLowerCase = StreamSupport
				.stream(new RegexMatcherIterator(Pattern.compile("[a-z]").matcher(password)), false).count();
		long countNumbers = StreamSupport
				.stream(new RegexMatcherIterator(Pattern.compile("[0-9]").matcher(password)), false).count();
		long countSymbols = StreamSupport
				.stream(new RegexMatcherIterator(Pattern.compile("[^a-z^A-Z^\\d^\\s]").matcher(password)), false)
				.count();
		return new PasswordParametersDTO(password, countUpperCase, countLowerCase, countNumbers, countSymbols);
	}

	@Async
	private static List<String> regex(String password, Pattern pattern) {
		return StreamSupport.stream(new RegexMatcherIterator(pattern.matcher(password)), false)
				.collect(Collectors.toList());
	}

}