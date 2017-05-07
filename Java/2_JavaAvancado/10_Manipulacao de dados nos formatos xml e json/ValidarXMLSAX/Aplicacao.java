package javaavancado.xml;

import javax.xml.XMLConstants;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;

/*
 * Valida um documento XML usando a API SAX
 */
public class Aplicacao {

	public static void main(String[] args) throws Exception {
		
		SAXParserFactory factory = SAXParserFactory.newInstance();
		
		//Habilita a validação via XML Schema
		factory.setValidating(true);
		factory.setNamespaceAware(true);
		
		SAXParser parser = factory.newSAXParser();
		parser.setProperty("http://java.sun.com/xml/jaxp/properties/schemaLanguage", XMLConstants.W3C_XML_SCHEMA_NS_URI);
		
		InputSource source = new InputSource("usuarios.xml");
		
		//Executa o parse de 'usuarios.xml'. Métodos do objeto XMLHandler são invocados pelo parser
		parser.parse(source, new XMLHandler());
	}
}
