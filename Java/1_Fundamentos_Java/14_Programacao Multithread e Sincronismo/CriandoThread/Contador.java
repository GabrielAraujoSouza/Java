
public class Contador extends Thread {

	public void run() {
		
		for (int i = 10; i < 15; i++) {
			System.out.println("Thread: " + i);
		}
	}
}
