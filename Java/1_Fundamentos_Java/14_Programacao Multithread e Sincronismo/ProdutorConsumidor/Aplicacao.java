package multithread;

public class Aplicacao {

	public static void main(String[] args) {
		
		//instancia um buffer
		Buffer buffer = new Buffer();
		
		//instancia o produtor, que deve produzir no buffer
		Produtor p = new Produtor(100, buffer);
		
		//inicia a thread do produtor
		p.start();
		
		//instancia o consumidor, que deve consumir do buffer
		Consumidor c = new Consumidor(100, buffer);
		
		//inicia a thread do consumidor
		c.start();
	}
}
