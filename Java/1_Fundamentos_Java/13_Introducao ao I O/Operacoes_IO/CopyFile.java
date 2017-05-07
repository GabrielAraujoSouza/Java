import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyFile {

	public static void main(String[] args) throws IOException {

		InputStream is = null;
		OutputStream os = null;

		try {
			//Cria as streams de entrada e saída
			is = new FileInputStream("entrada.txt");
			os = new FileOutputStream("saida.txt");
			
			//Cria um buffer, usado no armazenamento temporário dos dados de uma stream para outra
			byte[] buffer = new byte[1024];
			int bytesLidos;
			
			//Enquanto houver bytes na stream de entrada, grava os bytes lidos na stream de saída
			while((bytesLidos = is.read(buffer)) > -1) {
				os.write(buffer, 0, bytesLidos);
			}
			
		} finally {
			//Fecha a input stream e a output stream
			if (is != null) {
				is.close();
			}
			if (os != null) {
				os.close();
			}
		}
	}
}
