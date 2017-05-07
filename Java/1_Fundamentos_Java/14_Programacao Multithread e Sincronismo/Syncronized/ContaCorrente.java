
public class ContaCorrente {
	
	//O monitor gerencia o acesso concorrente �s regi�es cr�ticas
	private Object monitor = new Object();

	private double saldo = 1000;
	
	public void depositar(double valor) {
		synchronized (monitor) {
			this.saldo += valor;
		}
	}
	
	public void sacar(double valor) {
		synchronized (monitor) {
			this.saldo -= valor;
		}
	}
	
	public double getSaldo() {
		synchronized (monitor) {
			return saldo;
		}
	}
}
