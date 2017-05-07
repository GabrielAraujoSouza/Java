

public class Aplicacao {

	public static void main(String[] args) {
		
		Buffer<String> b = new Buffer<String>();
		b.adicionar("texto");
		
		String elem = b.remover();
		System.out.println(elem);
	}
}
