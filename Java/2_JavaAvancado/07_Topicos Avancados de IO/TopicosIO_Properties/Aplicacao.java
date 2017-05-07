import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;


public class Aplicacao {

	public static void main(String[] args) throws Exception {
		
		//Este código lê as propriedades do arquivo config.txt
		{
			Properties p = new Properties();
			InputStream is = new FileInputStream("config.txt");
			p.load(is);
			
			System.out.println(p.getProperty("nomeAplicacao"));
			System.out.println(p.getProperty("versao"));
			
			is.close();
		}
		
		//Este código salva as propriedades no arquivo config2.txt
		{
			Properties p = new Properties();
			p.setProperty("nomeAplicacao", "Um nome qualquer");
			p.setProperty("versao", "1.0");
			
			OutputStream os = new FileOutputStream("config2.txt");
			p.store(os, "Arquivo config2.txt");
			os.close();
		}
	}
}
