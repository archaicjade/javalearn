package com.bai.jdom;

import java.io.IOException;

import org.jdom2.JDOMException;

public class DOMTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			JDOMHelper.parseXML();
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
