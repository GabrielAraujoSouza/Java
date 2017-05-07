package multithread;

/**
 * Esta classe � a thread respons�vel por imprimir letras ou n�meros na tela.
 * A impress�o de letras e n�meros deve ser feita de forma intercalada, come�ando por um n�mero
 */
public class Impressao extends Thread {

	/*
	 * Monitor para fazer o sincronismo do c�digo. O monitor tem que ser declarado como static porque
	 * todos os objetos da classe impress�o devem compartilhar o mesmo monitor
	 */
	private static Object monitor = new Object();
	
	/*
	 * Este atributo indica de quem � a vez: das LETRAS ou dos NUMEROS
	 */
	private static String vez = "NUMEROS";

	/*
	 * Esta flag indica se o objeto deve imprimir letras (true) ou n�meros (false)
	 */
	private boolean letras;

	/**
	 * Construtor
	 */
	public Impressao(boolean letras) {
		this.letras = letras;
	}

	/**
	 * M�todo de execu��o da thread
	 * @see java.lang.Thread#run()
	 */
	public void run() {
		//Dependendo do atributo do objeto, dispara o m�todo imprimir adequado
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
		 * O bloco synchronized cria uma regi�o cr�tica, evitando que mais de uma thread acesse o bloco de 
		 * c�digo guardado pelo monitor num mesmo momento.
		 */
		synchronized (monitor) {
			/*
			 * Enquanto a vez for dos n�meros, a thread de impress�o de letras deve ficar dormindo. Isto
			 * garante que uma letra ser� impressa s� depois de um n�mero.
			 */
			while (vez.equals("NUMEROS")) {
				try {
					monitor.wait();
				} catch (InterruptedException e1) {
				}
			}
			
			/*
			 * Se o c�digo chegou aqui, � porque a thread acordou. Isto significa que � a vez de imprimir
			 * uma letra, que � a a��o feita a seguir
			 */

			for (char c = 'A'; c <= 'Z'; c++) {
				System.out.print(c + " ");

				try {
					//Dorme por 300ms
					Thread.sleep(300);

					/*
					 * Agora a vez passa a ser dos n�meros. � poss�vel que a thread da impress�o dos n�meros
					 * esteja dormindo em decorr�ncia de um wait(). O notify() acorda a thread.
					 */
					vez = "NUMEROS";
					monitor.notify();

					/*
					 * Enquanto a vez for dos n�meros, a thread de impress�o de letras deve ficar dormindo.
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
	 * Imprime n�meros
	 */
	private void imprimirNumeros() {
		/*
		 * O bloco synchronized cria uma regi�o cr�tica, evitando que mais de uma thread acesse o bloco de 
		 * c�digo guardado pelo monitor num mesmo momento.
		 */
		synchronized (monitor) {
			/*
			 * � a vez de imprimir um n�mero, que � a a��o feita a seguir
			 */
			for (int i = 1; i <= 26; i++) {
				System.out.print(i + " ");

				try {
					//Dorme por 300ms
					Thread.sleep(300);

					/*
					 * Agora a vez passa a ser das letras. � poss�vel que a thread da impress�o das letras
					 * esteja dormindo em decorr�ncia de um wait(). O notify() acorda a thread.
					 */
					vez = "LETRAS";
					monitor.notify();

					/*
					 * Enquanto a vez for das letras, a thread de impress�o de n�meros deve ficar dormindo.
					 */
					while (vez.equals("LETRAS")) {
						monitor.wait();
					}
				} catch (InterruptedException e) {
				}
			}
			
			/*
			 * Ao t�rmino da impress�o do �ltimo n�mero, a thread de impress�o de letras estar� dormindo.
			 * Logo, � definido que a vez passa a ser das letras e a thread � acordada.
			 */
			vez = "LETRAS";
			monitor.notify();
		}
	}
}
