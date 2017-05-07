
public class Aplicacao {

	public static void main(String[] args) {
		Calculadora c = new Calculadora();
		c.setValor1(10);
		c.setValor2(100);
		
		int result = c.somar();
		System.out.println(result);
	}
}
