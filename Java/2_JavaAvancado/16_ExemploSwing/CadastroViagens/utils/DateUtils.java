package curso.java.viagem.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Classe com utilit�rios para datas
 */
public class DateUtils {

	/**
	 * Padr�o a ser utilizado na convers�o
	 */
	private static String PATTERN = "dd/MM/yyyy";
	
	/**
	 * Objeto utilizado para converter datas 
	 */
	private static SimpleDateFormat SDF = new SimpleDateFormat(PATTERN);
	
	/**
	 * Constroi um objeto Date com base em uma String
	 * @param date String que representa uma data
	 * @return Objeto Date correspondente, ou null se o objeto n�o puder ser criado
	 */
	public static Date buildDateObject(String date) {
		// Se a string for nula ou n�o tiver o tamanho correto, retorna null
		if (date == null || date.trim().length() != PATTERN.length()) {
			return null;
		}
		
		try {
			// Tenta fazer o parse da string
			return SDF.parse(date.trim());
		} catch (ParseException e) {
			// Se n�o puder fazer o parse, retorna null
			return null;
		}
	}
	
	/**
	 * Retorna uma data convertida para String
	 * @param date Data a ser convertida para String
	 * @return Data convertida para String
	 */
	public static String getDateAsString(Date date) {
		return SDF.format(date);
	}
}
