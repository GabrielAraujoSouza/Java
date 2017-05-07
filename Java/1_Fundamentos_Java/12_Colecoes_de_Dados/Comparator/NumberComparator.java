import java.util.Comparator;


/*
 * O seu Comparator deve implementar a interface java.util.Comparator. � poss�vel usar o generics, 
 * informando qual o tipo dos elementos que ser�o comparados.
 */
public class NumberComparator implements Comparator<Integer> {

	/*
	 * O m�todo compare() deve obrigatoriamente ser implementado. Ele recebe o elemento a ser comparado.
	 * Como retorno, se o1 deve vir depois de o2 na cole��o, o m�todo deve retornar um n�mero > 0.
	 * Se o1 deve vir antes de o2 na cole��o, o m�todo deve retornar um n�mero < 0.
	 * Se n�o fizer diferen�a em qual ordem os elementos devem aparecer, o m�todo deve retornar 0.
	 */
	public int compare(Integer o1, Integer o2) {
		/*
		 * O compareTo() da classe Integer j� faz a ordena��o correta em forma crescente.
		 * Para que ela seja decrescente, basta inverter o sinal do retorno (multiplicando por -1).
		 */
		return o1.compareTo(o2) * -1;
	}
}