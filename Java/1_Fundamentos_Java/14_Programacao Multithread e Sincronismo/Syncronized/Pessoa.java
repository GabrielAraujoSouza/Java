
public class Pessoa extends Thread {

	private ContaCorrente conta;
	
	public Pessoa(ContaCorrente conta) {
		this.conta = conta;
	}
	
	public void run() {
		try {
			for (int i = 0; i < 10; i++) {
				conta.depositar(100);
				Thread.sleep(100);
				conta.sacar(100);
				Thread.sleep(100);
			}
		} catch (InterruptedException e) {
		}
	}
	
	public static void main(String[] args) throws Exception {
		ContaCorrente conta = new ContaCorrente();
		
		Pessoa p1 = new Pessoa(conta);
		Pessoa p2 = new Pessoa(conta);
		
		p1.start();
		p2.start();
		
		p1.join();
		p2.join();
		
		System.out.println("Saldo da conta: " + conta.getSaldo());
	}
}
