package br.com.jonathan.infrastructure.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AdditionMetricsDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private ScoreMetricDTO characters;
	private ScoreMetricDTO upperCase;
	private ScoreMetricDTO lowerCase;
	private ScoreMetricDTO numbers;
	private ScoreMetricDTO symbols;
	private ScoreMetricDTO middleNumbersSymbols;
	private ScoreMetricDTO requirements;

	public ScoreMetricDTO getCharacters() {
		return characters;
	}

	public void setCharacters(ScoreMetricDTO characters) {
		this.characters = characters;
	}

	public ScoreMetricDTO getUpperCase() {
		return upperCase;
	}

	public void setUpperCase(ScoreMetricDTO upperCase) {
		this.upperCase = upperCase;
	}

	public ScoreMetricDTO getLowerCase() {
		return lowerCase;
	}

	public void setLowerCase(ScoreMetricDTO lowerCase) {
		this.lowerCase = lowerCase;
	}

	public ScoreMetricDTO getNumbers() {
		return numbers;
	}

	public void setNumbers(ScoreMetricDTO numbers) {
		this.numbers = numbers;
	}

	public ScoreMetricDTO getSymbols() {
		return symbols;
	}

	public void setSymbols(ScoreMetricDTO symbols) {
		this.symbols = symbols;
	}

	public ScoreMetricDTO getMiddleNumbersSymbols() {
		return middleNumbersSymbols;
	}

	public void setMiddleNumbersSymbols(ScoreMetricDTO middleNumbersSymbols) {
		this.middleNumbersSymbols = middleNumbersSymbols;
	}

	public ScoreMetricDTO getRequirements() {
		return requirements;
	}

	public void setRequirements(ScoreMetricDTO requirements) {
		this.requirements = requirements;
	}

}