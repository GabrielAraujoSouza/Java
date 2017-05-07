import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteOutputStream {

	public static void main(String[] args) throws IOException {

		OutputStream os = null;

		try {
			//Cria uma FileOutputStream
			os = new FileOutputStream("saida.txt");
			
			//Texto que ser� gravado no arquivo de sa�da
			String s = "texto para ser gravado no arquivo";
			
			//Obt�m os bytes da string
			byte[] bytes = s.getBytes();
			
			//Escreve os bytes na stream de sa�da
			os.write(bytes);
			
		} finally {
			//Fecha a output stream
			if (os != null) {
				os.close();
			}
		}
	}
}
