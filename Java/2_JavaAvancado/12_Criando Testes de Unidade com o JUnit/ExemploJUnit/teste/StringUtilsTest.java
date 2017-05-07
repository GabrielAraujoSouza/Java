package teste;

import junit.framework.Assert;

import org.junit.Test;

import conversor.StringUtils;

/**
 * Testcases da classe StringUtils
 */
public class StringUtilsTest {

	@Test
	public void testInverter() {

		String s = null;

		s = StringUtils.inverter(null);
		Assert.assertTrue(s == null);

		s = StringUtils.inverter("aaaa");
		Assert.assertEquals("aaaa", s);

		s = StringUtils.inverter("abcde");
		Assert.assertEquals("edcba", s);
	}
}
