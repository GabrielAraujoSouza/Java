

/**
 * Classe de conversão de temperatura
 */
public class ConversorTemperatura {

	/**
	 * Converte a temperatura para Celsius
	 * @param tf Temperatura em Fahrenheit
	 * @return Temperatura em Celsius
	 */
	public double converterParaCelsius(double tf) {
		double tc = (5 * (tf - 32)) / 9;
		return Math.round(tc);
	}
	
	/**
	 * Converte a temperatura para Fahrenheit
	 * @param tc Temperatura em Celsius
	 * @return Temperatura em Fahrenheit
	 */
	public double converterParaFahrenheit(double tc) {
		double tf = ((9 * tc) / 5) + 32;
		return Math.round(tf);
	}
}
