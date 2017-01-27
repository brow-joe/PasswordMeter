package br.com.jonathan.infrastructure.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DeductionMetricsDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private ScoreMetricDTO lettersOnly;
	private ScoreMetricDTO numbersOnly;
	private ScoreMetricDTO repeatCharacters;
	private ScoreMetricDTO consecutiveUpperLetters;
	private ScoreMetricDTO consecutiveLowerLetters;
	private ScoreMetricDTO consecutiveNumbers;
	private ScoreMetricDTO sequentialLetters;
	private ScoreMetricDTO sequentialNumbers;
	private ScoreMetricDTO sequentialSymbols;

	public ScoreMetricDTO getLettersOnly() {
		return lettersOnly;
	}

	public void setLettersOnly(ScoreMetricDTO lettersOnly) {
		this.lettersOnly = lettersOnly;
	}

	public ScoreMetricDTO getNumbersOnly() {
		return numbersOnly;
	}

	public void setNumbersOnly(ScoreMetricDTO numbersOnly) {
		this.numbersOnly = numbersOnly;
	}

	public ScoreMetricDTO getRepeatCharacters() {
		return repeatCharacters;
	}

	public void setRepeatCharacters(ScoreMetricDTO repeatCharacters) {
		this.repeatCharacters = repeatCharacters;
	}

	public ScoreMetricDTO getConsecutiveUpperLetters() {
		return consecutiveUpperLetters;
	}

	public void setConsecutiveUpperLetters(ScoreMetricDTO consecutiveUpperLetters) {
		this.consecutiveUpperLetters = consecutiveUpperLetters;
	}

	public ScoreMetricDTO getConsecutiveLowerLetters() {
		return consecutiveLowerLetters;
	}

	public void setConsecutiveLowerLetters(ScoreMetricDTO consecutiveLowerLetters) {
		this.consecutiveLowerLetters = consecutiveLowerLetters;
	}

	public ScoreMetricDTO getConsecutiveNumbers() {
		return consecutiveNumbers;
	}

	public void setConsecutiveNumbers(ScoreMetricDTO consecutiveNumbers) {
		this.consecutiveNumbers = consecutiveNumbers;
	}

	public ScoreMetricDTO getSequentialLetters() {
		return sequentialLetters;
	}

	public void setSequentialLetters(ScoreMetricDTO sequentialLetters) {
		this.sequentialLetters = sequentialLetters;
	}

	public ScoreMetricDTO getSequentialNumbers() {
		return sequentialNumbers;
	}

	public void setSequentialNumbers(ScoreMetricDTO sequentialNumbers) {
		this.sequentialNumbers = sequentialNumbers;
	}

	public ScoreMetricDTO getSequentialSymbols() {
		return sequentialSymbols;
	}

	public void setSequentialSymbols(ScoreMetricDTO sequentialSymbols) {
		this.sequentialSymbols = sequentialSymbols;
	}

}