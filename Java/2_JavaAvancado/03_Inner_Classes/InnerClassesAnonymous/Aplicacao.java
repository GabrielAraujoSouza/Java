
public class Aplicacao {

	public static void main(String[] args) {
		
		Bebida b1 = new Bebida();
		b1.preparar();
		
		Bebida b2 = new Bebida() {
			//o m�todo preparar() � sobrescrito
			public void preparar() {
				System.out.println("Adicionar ch�");
			}
		};
		b2.preparar();
	}
}
