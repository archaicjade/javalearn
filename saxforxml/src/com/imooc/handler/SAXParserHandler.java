package com.imooc.handler;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.yiche.entity.InvokeConfig;

public class SAXParserHandler extends DefaultHandler {

	private InvokeConfig ic = new InvokeConfig();
	private ArrayList<InvokeConfig> list = null;
	private Set<String> methodList = new HashSet<String>();
	private Class<?> c = InvokeConfig.class;
	private String currentValue = null;
	private Method method = null;
	private String methodName = null;

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		super.startElement(uri, localName, qName, attributes);

		if (qName.equals("KeyItem")) {
			ic = new InvokeConfig();
		}
		try {

			for (int i = 0; i < attributes.getLength(); i++) {
				methodName = "set" + attributes.getQName(i);

				if (methodList.contains(methodName)) {
					method = c.getMethod(methodName, String.class);

					if (method != null) {
						method.invoke(ic, attributes.getValue(i));
					}
				}
			}

		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		super.characters(ch, start, length);

		currentValue = (new String(ch, start, length)).trim();
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// TODO Auto-generated method stub
		super.endElement(uri, localName, qName);

		try {
			methodName = "set" + qName;
			if (methodList.contains(methodName)) {
				method = c.getMethod(methodName, String.class);

				if (method != null) {
					method.invoke(ic, currentValue);
				}
			}
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (qName.equals("KeyItem")) {
			getList().add(ic);
		}
	}

	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.startDocument();

		Method[] methods = c.getDeclaredMethods();

		for (Method method : methods) {
			methodList.add(method.getName());
		}
		setList(new ArrayList<InvokeConfig>());

	}

	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.endDocument();
		System.out.println(getList().size());
	}

	public ArrayList<InvokeConfig> getList() {
		return list;
	}

	public void setList(ArrayList<InvokeConfig> list) {
		this.list = list;
	}
}
