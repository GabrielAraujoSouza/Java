

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/*
 * L� um arquivo XML usando a API DOM
 */
public class Aplicacao {

	public static void main(String[] args) throws Exception {
		
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
