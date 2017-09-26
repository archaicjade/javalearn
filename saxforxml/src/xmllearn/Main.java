package xmllearn;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

import com.imooc.handler.SAXParserHandler;
import com.yiche.entity.InvokeConfig;

public class Main {

	public static ArrayList<InvokeConfig> parseXML() throws ParserConfigurationException, SAXException, IOException {
		SAXParserFactory spf = SAXParserFactory.newInstance();

		SAXParser sp = spf.newSAXParser();

		SAXParserHandler handler = new SAXParserHandler();
		sp.parse("src/res/getcase.xml", handler);

		return handler.getList();

	}

	public static void createXML() throws ParserConfigurationException, SAXException, IOException,
			TransformerConfigurationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException {

		ArrayList<InvokeConfig> list = parseXML();

		SAXTransformerFactory tff = (SAXTransformerFactory) SAXTransformerFactory.newInstance();

		TransformerHandler handler = tff.newTransformerHandler();

		Transformer tr = handler.getTransformer();

		tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		tr.setOutputProperty(OutputKeys.INDENT, "yes");

		File fi = new File("src/res/newbooks.xml");
		if (!fi.exists()) {

			fi.createNewFile();
		}

		Result result = new StreamResult(new FileOutputStream(fi));
		handler.setResult(result);

		handler.startDocument();

		AttributesImpl attr = new AttributesImpl();

		handler.startElement("", "", "bookstore", attr);

		for (InvokeConfig invokeConfig : list) {
			attr.clear();
			attr.addAttribute("", "", "id", "", invokeConfig.getID());
			handler.startElement("", "", "book", attr);
			attr.clear();
			Class<?> c = invokeConfig.getClass();

			Field[] fields = c.getDeclaredFields();

			for (Field field : fields) {

				String key = field.getName();
				if (key.equals("ID"))
					continue;
				Method m = c.getDeclaredMethod("get" + key);
				String v = String.valueOf(m.invoke(invokeConfig));

				handler.startElement("", "", key, attr);
				handler.characters(v.toCharArray(), 0, v.length());
				handler.endElement("", "", key);
			}

			handler.endElement("", "", "book");
		}

		handler.endElement("", "", "bookstore");

		handler.endDocument();

	}

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException,
			TransformerConfigurationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException {
		// TODO Auto-generated method stub

		createXML();

	}

}
