package com.bigball.helloworld;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public final class XmlHelper {

	public static DocumentBuilder getDocumentBuilder() throws ParserConfigurationException {

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();

		return db;
	}

	public static void createXml() throws ParserConfigurationException, TransformerException {
		DocumentBuilder db = getDocumentBuilder();
		Document doc = db.newDocument();

		doc.setXmlStandalone(true);

		Element bookstore = doc.createElement("bookStore");
		Element book = doc.createElement("Book");
		book.setAttribute("id", "1");
		Element name = doc.createElement("Name");
		// name.appendChild(doc.createTextNode("白鹿原"));
		name.setTextContent("白鹿原");
		book.appendChild(name);
		bookstore.appendChild(book);
		doc.appendChild(bookstore);
		TransformerFactory ttf = TransformerFactory.newInstance();
		Transformer tf = ttf.newTransformer();
		tf.setOutputProperty(OutputKeys.INDENT, "yes");
		tf.transform(new DOMSource(doc), new StreamResult(new File("books1.xml")));

	}

	public static void ParserXml() throws ParserConfigurationException, SAXException, IOException {

		Document doc = getDocumentBuilder().parse("books.xml");
		NodeList booklist = doc.getElementsByTagName("Book");

		for (int i = 0; i < booklist.getLength(); i++) {

			Node book = booklist.item(i);

			NamedNodeMap attrs = book.getAttributes();
			for (int j = 0; j < attrs.getLength(); j++) {
				Node attr = attrs.item(j);
				System.out.println(attr.getNodeName() + ":" + attr.getNodeValue());
			}

			NodeList childNodes = book.getChildNodes();

			for (int j = 0; j < childNodes.getLength(); j++) {
				Node n = childNodes.item(j);
				if (n.getNodeType() == Node.ELEMENT_NODE) {

					System.out.println(n.getNodeName() + ":" + n.getFirstChild().getNodeValue());
					System.out.println(n.getNodeName() + ":" + n.getTextContent());
				}
			}

		}
	}
}
