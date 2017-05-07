
public class MyCollection {

	/** Array que irá armazenar os dados. É do tipo Object para permitir o trabalho com dados genéricos **/
	private Object[] array;
	
	/** Controla de quanto em quanto o array será incrementado **/
	private int incremento;
	
	/** Posição onde o último elemento do array foi inserido **/
	private int posAtual = -1;
	
	/** Quantidade de itens no array **/
	private int tamanho;
	
	
	/**
	 * Cria a coleção passando um valor de incremento.
	 * @param incremento De quanto em quanto o array será incrementado
	 */
	public MyCollection(int incremento) {
		//inicializa o incremento
		this.incremento = incremento;
		
		//inicializa o array
		this.array = new Object[incremento];
	}
	
	/**
	 * Cria a coleção sem passar um valor de incremento. Neste caso é assumido o incremento 10.
	 */
	public MyCollection() {
		this(10);
	}
	
	/**
	 * Adiciona um item na coleção.
	 * @param item Item a ser adicionado
	 */
	public void add(Object item) {
		//incrementa a posição do item
		posAtual++;
		
		//incrementa o tamanho do array
		tamanho++;
		
		//verifica se o array deve ser aumentado e cria um novo array caso seja necessário
		testarTamanhoArray();
		
		//coloca o item na posição correta
		array[posAtual] = item;
	}
	
	/**
	 * Obtém um item de uma posição.
	 * @param pos Posição a ser procurada
	 * @return Item da posição desejada
	 * @throws IllegalArgumentException Se a posição for menor que 0 ou maior que o tamanho da coleção
	 */
	public Object get(int pos) {
		if(pos < 0 || pos >= array.length) {
			/*
			 * Lança a exceção se o argumento for inválido.
			 * Por ser uma unchecker exception, não é preciso declará-la na cláusula throws
			 */
			throw new IllegalArgumentException("A posição " + pos + " não é válida");
		}
		
		//retorna o item da posição do array desejada
		return array[pos];
	}
	
	/**
	 * Testa se o array precisa ter seu tamanho aumentado
	 */
	private void testarTamanhoArray() {
		if(posAtual == array.length) {
			//aumenta o tamanho do array
			
			//cria um array temporário com o tamanho do array real somado com o incremento
			Object[] arrayTemp = new Object[array.length + incremento];
			
			//percorre o array real copiando os dados para o array temporário
			for (int i = 0; i < array.length; i++) {
				arrayTemp[i] = array[i];
			}
			
			//aponta a referência do array real para o array temporáro
			array = arrayTemp;
		}
	}
	
	/**
	 * Retorna a quantidade de itens da coleção
	 * @return Quantidade de itens da coleção
	 */
	public int size() {
		return tamanho;
	}
}
