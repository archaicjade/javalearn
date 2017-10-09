package com.bai.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class IsdAndOswDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InputStreamReader isr = new InputStreamReader(new FileInputStream("src/res/io.txt"), "utf-8");
		// 默认编码是项目的编码，操作时要使用文件本身的编码方式
		FileOutputStream out = new FileOutputStream("src/res/ioback.txt");
		OutputStreamWriter osw = new OutputStreamWriter(out, "utf-8");

		// int c;
		// while ((c = isr.read()) != -1) {
		// System.out.print((char) c);
		// }
		char[] buffer = new char[8 * 1024];
		int c;

		/*
		 * 批量读取，放入buffer这个字符数组， 从第0个位置开始放置，最多放buffer.length个
		 */
		while ((c = isr.read(buffer, 0, buffer.length)) != -1) {
			String s = new String(buffer, 0, c);
			System.out.print(s);

			osw.write(buffer, 0, c);
			osw.flush();
		}

		isr.close();
		osw.close();
	}

}
