package multithread;

public class Aplicacao {

	public static void main(String[] args) {
		
		//Cria o objeto impress�o para as letras
		Impressao letras = new Impressao(true);
		//Inicia a thread
		letras.start();
		
		//Cria o objeto impress�o para os n�meros
		Impressao numeros = new Impressao(false);
		//Inicia a thread
		numeros.start();
	}
}
