
/**
 * Classe com utilitários para strings
 */
public class StringUtils {

	/**
	 * Inverte os caracteres da string passada como parämetro
	 * @param s String a ser invertida
	 * @return String invertida
	 */
	public static String inverter(String s) {
		if(s == null) {
			return null;
		}
		
		char[] array1 = s.toCharArray();
		String result = "";
		
		for(int i = array1.length - 1; i >= 0; i--) {
			result += array1[i];
		}
		
		return result;
	}
}
