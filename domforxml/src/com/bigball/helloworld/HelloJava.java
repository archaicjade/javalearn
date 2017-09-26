package com.bigball.helloworld;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

/**
 * @author BaiYu
 *
 */
public final class HelloJava {

	public static void main(String[] args)
			throws ParserConfigurationException, SAXException, IOException, TransformerException {
		// TODO Auto-generated method stub

		XmlHelper.ParserXml();

		XmlHelper.createXml();

	}
}
