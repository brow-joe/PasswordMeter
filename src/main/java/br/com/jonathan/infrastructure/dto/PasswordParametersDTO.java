package br.com.jonathan.infrastructure.dto;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class PasswordParametersDTO {

	private String password;
	private final long countChars;
	private long countUpperCase;
	private long countLowerCase;
	private long countNumbers;
	private long countSymbols;
	private List<String> consecutiveUpperCaseLetters;
	private List<String> consecutiveLowerCaseLetters;
	private List<String> consecutiveNumbers;

	public PasswordParametersDTO() {
		this(null, 0, 0, 0, 0);
	}

	public PasswordParametersDTO(String password, long countUpperCase, long countLowerCase, long countNumbers,
			long countSymbols) {
		super();
		this.password = password;
		this.countChars = StringUtils.length(password);
		this.countUpperCase = countUpperCase;
		this.countLowerCase = countLowerCase;
		this.countNumbers = countNumbers;
		this.countSymbols = countSymbols;
		this.consecutiveUpperCaseLetters = new ArrayList<>();
		this.consecutiveLowerCaseLetters = new ArrayList<>();
		this.consecutiveNumbers = new ArrayList<>();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getCountChars() {
		return countChars;
	}

	public long getCountUpperCase() {
		return countUpperCase;
	}

	public void setCountUpperCase(long countUpperCase) {
		this.countUpperCase = countUpperCase;
	}

	public long getCountLowerCase() {
		return countLowerCase;
	}

	public void setCountLowerCase(long countLowerCase) {
		this.countLowerCase = countLowerCase;
	}

	public long getCountNumbers() {
		return countNumbers;
	}

	public void setCountNumber(long countNumbers) {
		this.countNumbers = countNumbers;
	}

	public long getCountSymbols() {
		return countSymbols;
	}

	public void setCountSymbols(long countSymbols) {
		this.countSymbols = countSymbols;
	}

	public List<String> getConsecutiveUpperCaseLetters() {
		return consecutiveUpperCaseLetters;
	}

	public void setConsecutiveUpperCaseLetters(List<String> consecutiveUpperCaseLetters) {
		this.consecutiveUpperCaseLetters = consecutiveUpperCaseLetters;
	}

	public List<String> getConsecutiveLowerCaseLetters() {
		return consecutiveLowerCaseLetters;
	}

	public void setConsecutiveLowerCaseLetters(List<String> consecutiveLowerCaseLetters) {
		this.consecutiveLowerCaseLetters = consecutiveLowerCaseLetters;
	}

	public List<String> getConsecutiveNumbers() {
		return consecutiveNumbers;
	}

	public void setConsecutiveNumbers(List<String> consecutiveNumbers) {
		this.consecutiveNumbers = consecutiveNumbers;
	}

	public void setCountNumbers(long countNumbers) {
		this.countNumbers = countNumbers;
	}

}