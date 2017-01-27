package br.com.jonathan.infrastructure.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ScoreMetricDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private long counter;
	private double score;

	public ScoreMetricDTO() {
		this(0L, 0D);
	}

	public ScoreMetricDTO(long counter, double score) {
		super();
		this.counter = counter;
		this.score = score;
	}

	public long getCounter() {
		return counter;
	}

	public void setCounter(long counter) {
		this.counter = counter;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public static ScoreMetricDTO of(long counter, double score) {
		return new ScoreMetricDTO(counter, score);
	}
}