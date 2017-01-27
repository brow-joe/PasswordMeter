package br.com.jonathan.infrastructure.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import br.com.jonathan.infrastructure.enumeration.EComplexity;

@XmlRootElement
public class PasswordMeterDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private EComplexity complexity;
	private double score;
	private MetricsDTO metrics;

	public PasswordMeterDTO() {
		this(0);
	}

	public PasswordMeterDTO(double score) {
		this(EComplexity.valueOf(score), score, new MetricsDTO());
	}

	public PasswordMeterDTO(double score, MetricsDTO metrics) {
		this(EComplexity.valueOf(score), score, metrics);
	}

	public PasswordMeterDTO(EComplexity complexity, double score, MetricsDTO metrics) {
		super();
		this.complexity = complexity;
		this.score = score;
		this.metrics = metrics;
	}

	public EComplexity getComplexity() {
		return complexity;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
		this.complexity = EComplexity.valueOf(score);
	}

	public MetricsDTO getMetrics() {
		return metrics;
	}

	public void setMetrics(MetricsDTO metrics) {
		this.metrics = metrics;
	}

	public void setComplexity(EComplexity complexity) {
		this.complexity = complexity;
	}

}