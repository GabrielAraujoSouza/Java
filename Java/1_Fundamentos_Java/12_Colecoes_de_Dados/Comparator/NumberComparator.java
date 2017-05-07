import java.util.Comparator;


/*
 * O seu Comparator deve implementar a interface java.util.Comparator. É possível usar o generics, 
 * informando qual o tipo dos elementos que serão comparados.
 */
public class NumberComparator implements Comparator<Integer> {

	/*
	 * O método compare() deve obrigatoriamente ser implementado. Ele recebe o elemento a ser comparado.
	 * Como retorno, se o1 deve vir depois de o2 na coleção, o método deve retornar um número > 0.
	 * Se o1 deve vir antes de o2 na coleção, o método deve retornar um número < 0.
	 * Se não fizer diferença em qual ordem os elementos devem aparecer, o método deve retornar 0.
	 */
	public int compare(Integer o1, Integer o2) {
		/*
		 * O compareTo() da classe Integer já faz a ordenação correta em forma crescente.
		 * Para que ela seja decrescente, basta inverter o sinal do retorno (multiplicando por -1).
		 */
		return o1.compareTo(o2) * -1;
	}
}