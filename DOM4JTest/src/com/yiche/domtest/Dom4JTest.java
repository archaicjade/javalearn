package com.yiche.domtest;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Dom4JTest {
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws DocumentException {
		// TODO Auto-generated method stub

		SAXReader reader = new SAXReader();

		Document doc = reader.read(new File("src/res/getcase.xml"));

		Element el = doc.getRootElement();
		Iterator<?> iit = el.elementIterator();

		while (iit.hasNext()) {
			Element one = (Element) iit.next();
			List<Attribute> oneAttr = one.attributes();

			for (Attribute attribute : oneAttr) {
				System.out.println("节点名称" + attribute.getName() + ":" + attribute.getValue());
			}

			Iterator<?> keyitem = one.elementIterator();
			while (keyitem.hasNext()) {
				Element item = (Element) keyitem.next();

				System.out.println(item.getName() + ":" + item.getStringValue());
			}

		}

	}

}
