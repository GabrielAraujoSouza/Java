
public class Aplicacao {

	public static void main(String[] args) {
		
		Contador c = new Contador();
		c.start();
		
		for (int i = 0; i < 5; i++) {
			System.out.println("Main: " + i);
		}
	}
}
