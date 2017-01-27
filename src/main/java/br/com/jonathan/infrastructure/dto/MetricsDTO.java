package br.com.jonathan.infrastructure.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MetricsDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private AdditionMetricsDTO additions;
	private DeductionMetricsDTO deductions;

	public MetricsDTO() {
		this(new AdditionMetricsDTO(), new DeductionMetricsDTO());
	}

	public MetricsDTO(AdditionMetricsDTO additions, DeductionMetricsDTO deductions) {
		super();
		this.additions = additions;
		this.deductions = deductions;
	}

	public AdditionMetricsDTO getAdditions() {
		return additions;
	}

	public void setAdditions(AdditionMetricsDTO additions) {
		this.additions = additions;
	}

	public DeductionMetricsDTO getDeductions() {
		return deductions;
	}

	public void setDeductions(DeductionMetricsDTO deductions) {
		this.deductions = deductions;
	}

}