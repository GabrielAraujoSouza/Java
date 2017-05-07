import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;


public class TCPClient {

	public static void main(String[] args) throws Exception {
		
		//Conecta no servidor localizado no 'localhost' e na porta 3000
		Socket socket = new Socket("localhost", 3000);
		
		//Obt�m as streams de entrada e sa�da
		InputStream is = socket.getInputStream();
		OutputStream os = socket.getOutputStream();
		
		//Cria os objetos para manipula��o dos dados
		DataInputStream dis = new DataInputStream(is);
		DataOutputStream dos = new DataOutputStream(os);
		
		//Envia o valor '5' para o servidor
		dos.writeInt(5);
		
		//L� do servidor o valor incrementado
		int valorIncrementado = dis.readInt();
		
		System.out.println(valorIncrementado);
		
		//Fecha a conex�o
		socket.close();
	}
}
