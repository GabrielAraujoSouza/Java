

public class Aplicacao {

	public static void main(String[] args) {
		//instancia a outer class
		ClasseDeFora f = new ClasseDeFora();
		
		//instancia a inner class (não é necessário que exista uma instância da outer class)
		ClasseDeFora.ClasseDeDentro d = new ClasseDeFora.ClasseDeDentro();
		d.m();
	}
}
