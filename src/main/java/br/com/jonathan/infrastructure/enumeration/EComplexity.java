package br.com.jonathan.infrastructure.enumeration;

public enum EComplexity {
	MUITO_FRACA, FRACA, BOA, FORTE, MUITO_FORTE;

	public static EComplexity valueOf(double score) {
		EComplexity complexidade;
		if (score < 20) {
			complexidade = EComplexity.MUITO_FRACA;
		} else if (score < 40) {
			complexidade = EComplexity.FRACA;
		} else if (score < 60) {
			complexidade = EComplexity.BOA;
		} else if (score < 80) {
			complexidade = EComplexity.FORTE;
		} else {
			complexidade = EComplexity.MUITO_FORTE;
		}
		return complexidade;
	}
}