package br.com.jonathan.infrastructure.enumeration;

public enum EAdditionBonus {

	OFCHARS(4D), NUMBERS(4D), SYMBOLS(6D), NUMBERORSYMBOL(2D), UPPERCASE(2D), LOWERCASE(2D), REQUIREMENTS(2D);

	private double bonus;

	EAdditionBonus(double bonus) {
		this.bonus = bonus;
	}

	public double getBonus() {
		return bonus;
	}

}