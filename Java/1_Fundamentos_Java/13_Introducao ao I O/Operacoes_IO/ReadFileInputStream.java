import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ReadFileInputStream {

	public static void main(String[] args) throws IOException {

		InputStream is = null;

		try {
			//Cria uma FileInputStream
			is = new FileInputStream("entrada.txt");
			
			//Cria um buffer para armazenar os bytes lidos
			byte[] buffer = new byte[2];
			int bytesLidos;
			
			String s = "";
			
			//Executa o loop enquanto ainda houver bytes para serem lidos e concatena os dados na string
			while((bytesLidos = is.read(buffer)) > -1) {
				s += new String(buffer, 0, bytesLidos);
			}
			
			//Mostra a string
			System.out.println(s);
			
		} finally {
			//Fecha a input stream
			if (is != null) {
				is.close();
			}
		}
	}
}
