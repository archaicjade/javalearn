package com.yiche.domtest;

import java.io.IOException;

import org.dom4j.DocumentException;

public class Dom4JTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			DOM4JHelper.parseXml();

			DOM4JHelper.createXml();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
