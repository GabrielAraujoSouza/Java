

import java.io.File;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/*
 * Lê e valida um arquivo XML usando a API DOM
 */
public class Aplicacao {

	public static void main(String[] args) throws Exception {
		
		//Faz a validação de 'usuarios.xml'
		SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = factory.newSchema();
		Validator validator = schema.newValidator();
		validator.validate(new StreamSource(new File("usuarios.xml")));
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		
		//Faz o parse do arquivo 'usuarios.xml'
		Document doc = db.parse("usuarios.xml");
		
		//Leitura da tag 'usuario'
		Element elem = doc.getDocumentElement();
		NodeList usuarioNodeList = elem.getElementsByTagName("usuario");
		
		for (int i = 0; i < usuarioNodeList.getLength(); i++) {
			//Leitura da tag 'usuario'
			Element tagUsuario = (Element) usuarioNodeList.item(i);
			String id = tagUsuario.getAttribute("id");
			
			//Leitura da tag 'nome'
			NodeList nomeNodeList = tagUsuario.getElementsByTagName("nome");
			Element tagNome = (Element) nomeNodeList.item(0);
			String nome = tagNome.getTextContent();
			
			//Leitura da tag 'idade'
			NodeList idadeNodeList = tagUsuario.getElementsByTagName("idade");
			Element tagIdade = (Element) idadeNodeList.item(0);
			String idade = tagIdade.getTextContent();
			
			//Leitura da tag 'email'
			NodeList emailNodeList = tagUsuario.getElementsByTagName("email");
			Element tagEmail = (Element) emailNodeList.item(0);
			String email = tagEmail.getTextContent();
			
			System.out.println(id + ", " + nome + ", " + idade + ", " + email);
		}
	}
}
