
public class Aplicacao {

	public static void main(String[] args) throws Exception {
		
		Client client = new Client("localhost", 4646);
		String msgRet = client.sendMessage("Olá, bom dia, como vai?");
		System.out.println("Retornou: " + msgRet);
	}
}
