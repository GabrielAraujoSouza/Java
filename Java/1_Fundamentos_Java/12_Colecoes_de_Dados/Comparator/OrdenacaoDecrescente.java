import java.util.Set;
import java.util.TreeSet;

public class OrdenacaoDecrescente {
	
	public static void main(String[] args) {
		
		/*
		 * O TreeSet é criado com um objeto Comparator sendo passado no construtor.
		 * Este Comparator será o responsável por fazer a comparação dos elementos e os ordenar.
		 */
		Set<Integer> numeros = new TreeSet<Integer>(new NumberComparator());
		
		//adiciona números na coleção
		for (int i = 1; i <= 1000; i++) {
			numeros.add(i);
		}
		
		//imprime os números
		System.out.println(numeros);
	}
}
