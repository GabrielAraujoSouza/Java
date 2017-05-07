
public class Aplicacao1 {

	public static void main(String[] args) {
		
		class Texto {
			private String t;
			
			public Texto(String t) {
				this.t = t;
			}
			
			public void imprimir() {
				System.out.println(t);
			}
		}
		
		Texto t = new Texto("mensagem");
		t.imprimir();
	}
}
