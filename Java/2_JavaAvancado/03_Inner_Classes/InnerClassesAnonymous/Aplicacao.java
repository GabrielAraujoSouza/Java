
public class Aplicacao {

	public static void main(String[] args) {
		
		Bebida b1 = new Bebida();
		b1.preparar();
		
		Bebida b2 = new Bebida() {
			//o método preparar() é sobrescrito
			public void preparar() {
				System.out.println("Adicionar chá");
			}
		};
		b2.preparar();
	}
}
