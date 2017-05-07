

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;

/*
 * Faz o parse de um XML usando a API SAX
 */
public class Aplicacao {

	public static void main(String[] args) throws Exception {
		
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		
		InputSource source = new InputSource("usuarios.xml");
		
		//Executa o parse de 'usuarios.xml'. Métodos do objeto XMLHandler são invocados pelo parser
		parser.parse(source, new XMLHandler());
	}
}
