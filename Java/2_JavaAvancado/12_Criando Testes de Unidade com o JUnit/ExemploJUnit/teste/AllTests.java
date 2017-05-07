package teste;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

//Esta é a classe que agrupa as duas classes de teste

@RunWith(Suite.class)
@SuiteClasses({ ConversorTemperaturaTest.class, StringUtilsTest.class })
public class AllTests {
}
