package com.yiche.domtest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
 * @author BaiYu
 *
 */
public class DOM4JHelper {

	@SuppressWarnings("unchecked")
	public static void parseXml() throws DocumentException {
		SAXReader reader = new SAXReader();

		Document doc = reader.read(new File("src/res/getcase.xml"));

		Element el = doc.getRootElement();

		for (Iterator<Element> iit = el.elementIterator(); iit.hasNext();) {
			Element one = iit.next();

			List<Attribute> attrs = one.attributes();

			for (Attribute attribute : attrs) {
				System.out.println(attribute.getName() + ":" + attribute.getValue());
			}

			for (Iterator<Element> iterator = one.elementIterator(); iterator.hasNext();) {

				Element item = iterator.next();
				System.out.println(item.getName() + ":" + item.getStringValue());

			}
		}
	}

	public static void createXml() throws IOException {
		Document document = DocumentHelper.createDocument();

		OutputFormat format = OutputFormat.createPrettyPrint();

		Element rss = document.addElement("rss");

		rss.addAttribute("version", "2.0");

		rss.addElement("channel").addElement("title").setText("<![CDATA[国内最新新闻]]>");

		File fi = new File("src/res/rssnews.xml");

		XMLWriter xw = new XMLWriter(new FileOutputStream(fi), format);
		xw.setEscapeText(false);
		xw.write(document);

		xw.close();
	}
}
