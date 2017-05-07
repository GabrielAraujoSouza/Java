
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
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

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		
		if (qName.equals("nome")) {
			sb = new StringBuilder();
		}
	}
}
