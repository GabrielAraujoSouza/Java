

public class Aplicacao {

	public static void main(String[] args) {
		//instancia a outer class
		ClasseDeFora f = new ClasseDeFora();
		
		//instancia a inner class (n�o � necess�rio que exista uma inst�ncia da outer class)
		ClasseDeFora.ClasseDeDentro d = new ClasseDeFora.ClasseDeDentro();
		d.m();
	}
}
