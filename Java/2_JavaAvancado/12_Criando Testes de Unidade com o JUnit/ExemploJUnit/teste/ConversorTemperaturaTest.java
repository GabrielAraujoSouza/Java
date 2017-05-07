package teste;

import org.junit.Test;

import junit.framework.Assert;
import conversor.ConversorTemperatura;

/**
 * Testcases da classe ConversorTemperatura
 */
public class ConversorTemperaturaTest {

	@Test
	public void testConverterParaCelsius() {
		ConversorTemperatura conversor = new ConversorTemperatura();
		double tf;
		
		tf = conversor.converterParaCelsius(32);
		Assert.assertEquals(0.0, tf);
		
		tf = conversor.converterParaCelsius(100);
		Assert.assertEquals(38.0, tf);
	}
	
	@Test
	public void testConverterParaFahrenheit() {
		ConversorTemperatura conversor = new ConversorTemperatura();
		double tf;
		
		tf = conversor.converterParaFahrenheit(0);
		Assert.assertEquals(32.0, tf);
		
		tf = conversor.converterParaFahrenheit(38);
		Assert.assertEquals(100.0, tf);
	}
}
