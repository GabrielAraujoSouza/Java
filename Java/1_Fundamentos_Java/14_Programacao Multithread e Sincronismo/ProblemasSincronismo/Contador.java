
public class Contador {

	private int c = 0;
	
	public synchronized void incrementar() {
		c++;
	}
	
	public int getContador() {
		return c;
	}
}
