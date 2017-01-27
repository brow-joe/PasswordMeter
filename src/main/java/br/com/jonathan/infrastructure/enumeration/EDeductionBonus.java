package br.com.jonathan.infrastructure.enumeration;

public enum EDeductionBonus {

	UPPERLETTERS(2D), LOWERLETTER(2D), NUMBERS(2D), LETTERS(3D), SEQUENCENUMBERS(3D), SEQUENCESYMBOLS(3D);

	private double bonus;

	EDeductionBonus(double bonus) {
		this.bonus = bonus;
	}

	public double getBonus() {
		return bonus;
	}

}