package curso.java.viagem.utils;


/**
 * Utilitário com métodos utilizados em validação
 */
public class Validator {

	/**
	 * Valida uma data
	 * @param date Data a ser validada
	 * @return true se a data é válida, false caso contrário
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
	 * @return true se o valor foi preenchido, false caso contrário
	 */
	public static boolean validateRequired(String value) {
		if (value == null || value.trim().isEmpty()) {
			return false;
		}
		return true;
	}
	
	/**
	 * Valida se um objeto está presente (não é nulo)
	 * @param obj Objeto a ser verificado
	 * @return true se o objeto não é nulo, false caso contrário
	 */
	public static boolean validateRequired(Object obj) {
		if (obj == null) {
			return false;
		}
		return true;
	}
	
	/**
	 * Valida se o dado não ultrapassa o tamanho máximo
	 * @param value Dado a ser verificado
	 * @param max Valor máximo que o dado pode assumir
	 * @return true se o dado não ultrapassa o valor máximo, false caso contrário
	 */
	public static boolean validateMaxLength(String value, int max) {
		// Se o dado não for preenchido, a validação passa
		if (!validateRequired(value)) {
			return true;
		}
		
		if (value.trim().length() > max) {
			return false;
		}
		
		return true;
	}
}
