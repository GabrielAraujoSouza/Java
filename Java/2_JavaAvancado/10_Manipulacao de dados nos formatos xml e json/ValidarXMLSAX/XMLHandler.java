package javaavancado.xml;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;


public class XMLHandler extends DefaultHandler {

	private StringBuilder sb = new StringBuilder();

	public void characters(char[] ch, int start, int length)
			throws SAXException {
		
		sb.append(ch, start, length);
	}

	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		
		if (qName.equals("nome")) {
			System.out.println(sb.toString());
		}
	}

	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		
		if (qName.equals("nome")) {
			sb = new StringBuilder();
		}
	}
	
	public void error(SAXParseException e) throws SAXException {
		throw e;
	}

	public void fatalError(SAXParseException e) throws SAXException {
		throw e;
	}

	public void warning(SAXParseException e) throws SAXException {
		throw e;
	}
}
