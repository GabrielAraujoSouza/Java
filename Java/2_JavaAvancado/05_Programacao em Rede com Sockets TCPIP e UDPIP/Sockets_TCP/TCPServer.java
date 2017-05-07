import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class TCPServer {

	public static void main(String[] args) throws Exception {
		
		//Cria um socket TCP que fica aguardando conex�es na porta 3000 
		ServerSocket serverSocket = new ServerSocket(3000);
		Socket clientSocket = serverSocket.accept();
		
		//Obt�m as streams de entrada e sa�da
		InputStream is = clientSocket.getInputStream();
		OutputStream os = clientSocket.getOutputStream();
		
		//Cria objetos para manipula��o dos dados que trafegam pelo socket
		DataInputStream dis = new DataInputStream(is);
		DataOutputStream dos = new DataOutputStream(os);
		
		//L� um inteiro vindo do cliente
		int valor = dis.readInt();
		System.out.println(valor);
		
		//Incrementa o valor e devolve o valor incementado para o cliente
		valor++;
		dos.writeInt(valor);
		
		//Fecha o socket
		clientSocket.close();
		serverSocket.close();
	}
}
