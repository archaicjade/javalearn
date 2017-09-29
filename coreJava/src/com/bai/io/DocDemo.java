package com.bai.io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DocDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		String file = "demo/doc.dat";

		DataOutputStream doc = new DataOutputStream(new FileOutputStream(file));

		doc.writeInt(10);
		doc.writeInt(-10);
		doc.writeLong(10l);
		doc.writeDouble(10.5);
		doc.writeUTF("中国");
		doc.writeChars("中国");
		doc.close();
		IOUtil.printHex(file);

		System.out.println();

		DataInputStream dis = new DataInputStream(new FileInputStream("demo/doc.dat"));

		System.out.println(dis.readInt());
		System.out.println(dis.readInt());
		System.out.println(dis.readLong());
		System.out.println(dis.readDouble());
		System.out.println(dis.readUTF());
		System.out.println(dis.readChar());
		
		dis.close();
	}

}
