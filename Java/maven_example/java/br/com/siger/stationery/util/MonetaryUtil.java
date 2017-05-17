package br.com.siger.stationery.util;

import javax.money.CurrencyUnit;
import javax.money.Monetary;

public interface MonetaryUtil {

	public static final CurrencyUnit CURRENCY_BRL = Monetary.getCurrency("BRL");
}
