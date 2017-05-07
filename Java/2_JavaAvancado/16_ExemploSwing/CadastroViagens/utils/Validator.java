package curso.java.viagem.utils;


/**
 * Utilit�rio com m�todos utilizados em valida��o
 */
public class Validator {

	/**
	 * Valida uma data
	 * @param date Data a ser validada
	 * @return true se a data � v�lida, false caso contr�rio
	 */
	public static boolean validateDate(String date) {
		// Tenta gerar o objeto Date
		if (DateUtils.buildDateObject(date) == null) {
			return false;
		}
		return true;
	}
	
	/**
	 * Valida se um dado foi realmente preenchido
	 * @param value Valor a ser verificado
	 * @return true se o valor foi preenchido, false caso contr�rio
	 */
	public static boolean validateRequired(String value) {
		if (value == null || value.trim().isEmpty()) {
			return false;
		}
		return true;
	}
	
	/**
	 * Valida se um objeto est� presente (n�o � nulo)
	 * @param obj Objeto a ser verificado
	 * @return true se o objeto n�o � nulo, false caso contr�rio
	 */
	public static boolean validateRequired(Object obj) {
		if (obj == null) {
			return false;
		}
		return true;
	}
	
	/**
	 * Valida se o dado n�o ultrapassa o tamanho m�ximo
	 * @param value Dado a ser verificado
	 * @param max Valor m�ximo que o dado pode assumir
	 * @return true se o dado n�o ultrapassa o valor m�ximo, false caso contr�rio
	 */
	public static boolean validateMaxLength(String value, int max) {
		// Se o dado n�o for preenchido, a valida��o passa
		if (!validateRequired(value)) {
			return true;
		}
		
		if (value.trim().length() > max) {
			return false;
		}
		
		return true;
	}
}
