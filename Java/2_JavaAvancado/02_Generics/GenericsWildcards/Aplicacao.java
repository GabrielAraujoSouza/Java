import java.util.ArrayList;
import java.util.List;


public class Aplicacao {

	public static void main(String[] args) {
		List<Bebida> bebidas = new ArrayList<Bebida>();
		bebidas.add(new Cafe());
		bebidas.add(new Cha());
		preparar1(bebidas);
		preparar2(bebidas);
		preparar3(bebidas);
		
		List<Cafe> cafes = new ArrayList<Cafe>();
		cafes.add(new Cafe());
		cafes.add(new Cafe());
		preparar1(cafes);
		preparar2(cafes);
		preparar3(cafes);
	}
	
	private static void preparar1(List<? extends Bebida> bebidas) {
		
		/*
		 * Ao usar o wildcard com extends, voc� n�o pode adicionar elementos na cole��o.
		 * A linha abaixo n�o funciona
		 */
		//bebidas.add(new Cha());
		
		for (Bebida b : bebidas) {
			b.preparar();
		}
	}
	
	private static void preparar2(List<? super Cafe> bebidas) {
		/*
		 * O uso do wildcard com super permite que voc� adicione elementos � lista, mas voc� deve referenciar 
		 * o elemento como se fosse um Object
		 */
		for (Object o : bebidas) {
			Cafe c = (Cafe) o;
			c.preparar();
		}
	}
	
	private static void preparar3(List<?> bebidas) {
		/*
		 * O uso do wildcard sozinho faz com que a lista aceite qualquer tipo, sem qualquer restri��o
		 */
		for (Object o : bebidas) {
			Cafe c = (Cafe) o;
			c.preparar();
		}
	}
}
