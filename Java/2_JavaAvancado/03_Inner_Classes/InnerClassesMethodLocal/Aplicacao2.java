
public class Aplicacao2 {

	public static void main(String[] args) {
		
		final String texto = "mensagem";
		
		class Texto {
			public void imprimir() {
				//Como a classe acessa uma variável local, a variável deve ser 'final'
				System.out.println(texto);
			}
		}
		
		Texto t = new Texto();
		t.imprimir();
	}
}
