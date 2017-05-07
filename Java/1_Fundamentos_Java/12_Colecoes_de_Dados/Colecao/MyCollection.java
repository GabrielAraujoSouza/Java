
public class MyCollection {

	/** Array que ir� armazenar os dados. � do tipo Object para permitir o trabalho com dados gen�ricos **/
	private Object[] array;
	
	/** Controla de quanto em quanto o array ser� incrementado **/
	private int incremento;
	
	/** Posi��o onde o �ltimo elemento do array foi inserido **/
	private int posAtual = -1;
	
	/** Quantidade de itens no array **/
	private int tamanho;
	
	
	/**
	 * Cria a cole��o passando um valor de incremento.
	 * @param incremento De quanto em quanto o array ser� incrementado
	 */
	public MyCollection(int incremento) {
		//inicializa o incremento
		this.incremento = incremento;
		
		//inicializa o array
		this.array = new Object[incremento];
	}
	
	/**
	 * Cria a cole��o sem passar um valor de incremento. Neste caso � assumido o incremento 10.
	 */
	public MyCollection() {
		this(10);
	}
	
	/**
	 * Adiciona um item na cole��o.
	 * @param item Item a ser adicionado
	 */
	public void add(Object item) {
		//incrementa a posi��o do item
		posAtual++;
		
		//incrementa o tamanho do array
		tamanho++;
		
		//verifica se o array deve ser aumentado e cria um novo array caso seja necess�rio
		testarTamanhoArray();
		
		//coloca o item na posi��o correta
		array[posAtual] = item;
	}
	
	/**
	 * Obt�m um item de uma posi��o.
	 * @param pos Posi��o a ser procurada
	 * @return Item da posi��o desejada
	 * @throws IllegalArgumentException Se a posi��o for menor que 0 ou maior que o tamanho da cole��o
	 */
	public Object get(int pos) {
		if(pos < 0 || pos >= array.length) {
			/*
			 * Lan�a a exce��o se o argumento for inv�lido.
			 * Por ser uma unchecker exception, n�o � preciso declar�-la na cl�usula throws
			 */
			throw new IllegalArgumentException("A posi��o " + pos + " n�o � v�lida");
		}
		
		//retorna o item da posi��o do array desejada
		return array[pos];
	}
	
	/**
	 * Testa se o array precisa ter seu tamanho aumentado
	 */
	private void testarTamanhoArray() {
		if(posAtual == array.length) {
			//aumenta o tamanho do array
			
			//cria um array tempor�rio com o tamanho do array real somado com o incremento
			Object[] arrayTemp = new Object[array.length + incremento];
			
			//percorre o array real copiando os dados para o array tempor�rio
			for (int i = 0; i < array.length; i++) {
				arrayTemp[i] = array[i];
			}
			
			//aponta a refer�ncia do array real para o array tempor�ro
			array = arrayTemp;
		}
	}
	
	/**
	 * Retorna a quantidade de itens da cole��o
	 * @return Quantidade de itens da cole��o
	 */
	public int size() {
		return tamanho;
	}
}
