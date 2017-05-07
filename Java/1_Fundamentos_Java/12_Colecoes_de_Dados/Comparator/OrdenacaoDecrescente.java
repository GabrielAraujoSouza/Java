import java.util.Set;
import java.util.TreeSet;

public class OrdenacaoDecrescente {
	
	public static void main(String[] args) {
		
		/*
		 * O TreeSet � criado com um objeto Comparator sendo passado no construtor.
		 * Este Comparator ser� o respons�vel por fazer a compara��o dos elementos e os ordenar.
		 */
		Set<Integer> numeros = new TreeSet<Integer>(new NumberComparator());
		
		//adiciona n�meros na cole��o
		for (int i = 1; i <= 1000; i++) {
			numeros.add(i);
		}
		
		//imprime os n�meros
		System.out.println(numeros);
	}
}
