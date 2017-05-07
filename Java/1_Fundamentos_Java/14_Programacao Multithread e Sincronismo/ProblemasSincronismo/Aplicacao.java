
public class Aplicacao {

	public static void main(String[] args) throws Exception {
		
		Contador c = new Contador();
		
		MyThread[] threads = new MyThread[1000];
		
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new MyThread(c);
			threads[i].start();
		}

		for (int i = 0; i < threads.length; i++) {
			threads[i].join();
		}
		
		System.out.println(c.getContador());
	}
}
