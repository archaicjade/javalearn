package com.bai.jdom;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.CDATA;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class JDOMHelper {

	public static void createXml() throws FileNotFoundException, IOException {

		Element rss = new Element("rss");

		rss.setAttribute("version", "2.0");
		Document doc = new Document(rss);

		rss.addContent(new Element("channel").addContent(new Element("title").addContent(new CDATA("国内最新新闻"))));

		Format f = Format.getPrettyFormat();

		XMLOutputter outputer = new XMLOutputter(f);

		outputer.output(doc, new FileOutputStream(new File("src/res/rssnew.xml")));

	}

	public static void parseXML() throws JDOMException, IOException {
		SAXBuilder builder = new SAXBuilder();
		InputStream in;

		in = new FileInputStream(new File("src/res/books.xml"));

		Document doc = builder.build(in);

		Element root = doc.getRootElement();

		List<Element> booklist = root.getChildren();

		for (Element element : booklist) {

			System.out.println(booklist.indexOf(element));

			List<Attribute> attrlist = element.getAttributes();

			for (Attribute attribute : attrlist) {
				System.out.println(attribute.getName() + ":" + attribute.getValue());
			}

			List<Element> bookChilds = element.getChildren();

			for (Element element2 : bookChilds) {
				System.out.println(element2.getName() + ":" + element2.getText());
			}
		}
	}
}
