
import java.io.FileWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

/*
 * Gera um arquivo XML usando a API DOM
 */
public class Aplicacao {

	public static void main(String[] args) throws Exception {
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		
		//Cria um novo documento XML
		Document doc = db.newDocument();
		
		//Cria a tag 'usuarios'
		Element rootElem = doc.createElement("usuarios");
		doc.appendChild(rootElem);
		
		//Cria a tag 'usuario'
		Element usuarioElem = doc.createElement("usuario");
		usuarioElem.setAttribute("id", "1");
		rootElem.appendChild(usuarioElem);
		
		//Cria a tag 'nome'
		Element nomeElem = doc.createElement("nome");
		Text nome = doc.createTextNode("José da Silva");
		nomeElem.appendChild(nome);
		usuarioElem.appendChild(nomeElem);
		
		//Cria a tag 'idade'
		Element idadeElem = doc.createElement("idade");
		Text idade = doc.createTextNode("20");
		idadeElem.appendChild(idade);
		usuarioElem.appendChild(idadeElem);
		
		//Cria um transformer, que gerará o arquivo XML
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer trans = tf.newTransformer();
		trans.setOutputProperty(OutputKeys.INDENT, "yes");
		
		//A propriedade abaixo muda a codificação do XML, fazendo com que os acentos
		//possam ser gerados adequadamente
		trans.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1");
		
		//Define a origem e destino da transformação
		FileWriter fw = new FileWriter("usuarios.xml");
		StreamResult sr = new StreamResult(fw);
		DOMSource source = new DOMSource(doc);
		
		//Gera o XML de saída
		trans.transform(source, sr);
		fw.close();
	}
}
