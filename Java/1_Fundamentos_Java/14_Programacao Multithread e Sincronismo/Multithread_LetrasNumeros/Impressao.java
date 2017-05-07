package multithread;

/**
 * Esta classe é a thread responsável por imprimir letras ou números na tela.
 * A impressão de letras e números deve ser feita de forma intercalada, começando por um número
 */
public class Impressao extends Thread {

	/*
	 * Monitor para fazer o sincronismo do código. O monitor tem que ser declarado como static porque
	 * todos os objetos da classe impressão devem compartilhar o mesmo monitor
	 */
	private static Object monitor = new Object();
	
	/*
	 * Este atributo indica de quem é a vez: das LETRAS ou dos NUMEROS
	 */
	private static String vez = "NUMEROS";

	/*
	 * Esta flag indica se o objeto deve imprimir letras (true) ou números (false)
	 */
	private boolean letras;

	/**
	 * Construtor
	 */
	public Impressao(boolean letras) {
		this.letras = letras;
	}

	/**
	 * Método de execução da thread
	 * @see java.lang.Thread#run()
	 */
	public void run() {
		//Dependendo do atributo do objeto, dispara o método imprimir adequado
		if (letras) {
			imprimirLetras();
		} else {
			imprimirNumeros();
		}
	}

	/**
	 * Imprime letras
	 */
	private void imprimirLetras() {
		/*
		 * O bloco synchronized cria uma região crítica, evitando que mais de uma thread acesse o bloco de 
		 * código guardado pelo monitor num mesmo momento.
		 */
		synchronized (monitor) {
			/*
			 * Enquanto a vez for dos números, a thread de impressão de letras deve ficar dormindo. Isto
			 * garante que uma letra será impressa só depois de um número.
			 */
			while (vez.equals("NUMEROS")) {
				try {
					monitor.wait();
				} catch (InterruptedException e1) {
				}
			}
			
			/*
			 * Se o código chegou aqui, é porque a thread acordou. Isto significa que é a vez de imprimir
			 * uma letra, que é a ação feita a seguir
			 */

			for (char c = 'A'; c <= 'Z'; c++) {
				System.out.print(c + " ");

				try {
					//Dorme por 300ms
					Thread.sleep(300);

					/*
					 * Agora a vez passa a ser dos números. É possível que a thread da impressão dos números
					 * esteja dormindo em decorrência de um wait(). O notify() acorda a thread.
					 */
					vez = "NUMEROS";
					monitor.notify();

					/*
					 * Enquanto a vez for dos números, a thread de impressão de letras deve ficar dormindo.
					 */
					while (vez.equals("NUMEROS")) {
						monitor.wait();
					}
				} catch (InterruptedException e) {
				}
			}
		}
	}

	/**
	 * Imprime números
	 */
	private void imprimirNumeros() {
		/*
		 * O bloco synchronized cria uma região crítica, evitando que mais de uma thread acesse o bloco de 
		 * código guardado pelo monitor num mesmo momento.
		 */
		synchronized (monitor) {
			/*
			 * É a vez de imprimir um número, que é a ação feita a seguir
			 */
			for (int i = 1; i <= 26; i++) {
				System.out.print(i + " ");

				try {
					//Dorme por 300ms
					Thread.sleep(300);

					/*
					 * Agora a vez passa a ser das letras. É possível que a thread da impressão das letras
					 * esteja dormindo em decorrência de um wait(). O notify() acorda a thread.
					 */
					vez = "LETRAS";
					monitor.notify();

					/*
					 * Enquanto a vez for das letras, a thread de impressão de números deve ficar dormindo.
					 */
					while (vez.equals("LETRAS")) {
						monitor.wait();
					}
				} catch (InterruptedException e) {
				}
			}
			
			/*
			 * Ao término da impressão do último número, a thread de impressão de letras estará dormindo.
			 * Logo, é definido que a vez passa a ser das letras e a thread é acordada.
			 */
			vez = "LETRAS";
			monitor.notify();
		}
	}
}
