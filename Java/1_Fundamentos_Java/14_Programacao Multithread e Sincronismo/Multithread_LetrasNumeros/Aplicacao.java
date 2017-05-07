package multithread;

public class Aplicacao {

	public static void main(String[] args) {
		
		//Cria o objeto impressão para as letras
		Impressao letras = new Impressao(true);
		//Inicia a thread
		letras.start();
		
		//Cria o objeto impressão para os números
		Impressao numeros = new Impressao(false);
		//Inicia a thread
		numeros.start();
	}
}
