
public class Calculadora {

	private int valor1;
	private int valor2;
	private int resultado;
	
	private class Soma {
		public void somar() {
			resultado = valor1 + valor2;
		}
	}

	public void setValor1(int valor1) {
		this.valor1 = valor1;
	}

	public void setValor2(int valor2) {
		this.valor2 = valor2;
	}
	
	public int somar() {
		Soma s = new Soma();
		s.somar();
		return resultado;
	}
}
