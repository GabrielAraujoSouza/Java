import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Aplicacao {

	public static void main(String[] args) {
		
		//Descomente esta linha caso você queira apenas uma thread
		//ExecutorService e = Executors.newSingleThreadExecutor();
		
		//Cria um pool de 5 threads
		ExecutorService e = Executors.newFixedThreadPool(5);
		
		//Instancia os objetos que serão executados em threads
		MyThread t1 = new MyThread();
		MyThread t2 = new MyThread();
		MyThread t3 = new MyThread();
		MyThread t4 = new MyThread();
		MyThread t5 = new MyThread();
		
		//Executa as threads
		e.execute(t1);
		e.execute(t2);
		e.execute(t3);
		e.execute(t4);
		e.execute(t5);
		
		//Finaliza o pool de threads
		e.shutdown();
	}
}
