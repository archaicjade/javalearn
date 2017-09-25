package xmllearn;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import com.imooc.handler.SAXParserHandler;

public class Main {

	/**
	 * @param args
	 * @throws SAXException
	 * @throws ParserConfigurationException
	 * @throws IOException
	 */
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		// TODO Auto-generated method stub

		// SAXΩ‚ŒˆXml

		SAXParserFactory spf = SAXParserFactory.newInstance();

		SAXParser sp = spf.newSAXParser();

		SAXParserHandler handler = new SAXParserHandler();
		sp.parse("getcase.xml", handler);
		
		

	}

}
