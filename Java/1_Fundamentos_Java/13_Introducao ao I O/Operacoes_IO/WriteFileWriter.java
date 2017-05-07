import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFileWriter {

	public static void main(String[] args) throws IOException {

		BufferedWriter writer = null;

		try {
			//Cria uma FileReader
			writer = new BufferedWriter(new FileWriter("saida.txt"));
			
			//Escreve a string no writer
			writer.write("texto para ser gravado no arquivo");
			
		} finally {
			//Fecha o writer
			if (writer != null) {
				writer.close();
			}
		}
	}
}
