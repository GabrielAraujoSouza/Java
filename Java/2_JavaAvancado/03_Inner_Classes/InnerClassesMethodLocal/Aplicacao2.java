
public class Aplicacao2 {

	public static void main(String[] args) {
		
		final String texto = "mensagem";
		
		class Texto {
			public void imprimir() {
				//Como a classe acessa uma vari�vel local, a vari�vel deve ser 'final'
				System.out.println(texto);
			}
		}
		
		Texto t = new Texto();
		t.imprimir();
	}
}
