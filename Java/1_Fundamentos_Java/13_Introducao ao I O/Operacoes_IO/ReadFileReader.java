import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileReader {

	public static void main(String[] args) throws IOException {

		BufferedReader reader = null;

		try {
			//Cria uma FileReader
			reader = new BufferedReader(new FileReader("entrada.txt"));
			
			String linha;
			String s = "";
			
			//Enquanto houver linhas no arquivo, lê as linhas e concatena na string
			while((linha = reader.readLine()) != null) {
				s += linha;
				s += "\n";
			}
			
			//Mostra s string
			System.out.println(s);
			
		} finally {
			//Fecha o reader
			if (reader != null) {
				reader.close();
			}
		}
	}
}
