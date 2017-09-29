package com.bai.io;

import java.io.File;
import java.io.IOException;

public class IOUtilTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			IOUtil.printHex("src/res/io.txt");
			System.out.println("----------");
			IOUtil.printHexByByteArray("src/res/io.txt");
			System.out.println("----------");
			IOUtil.printHexByByteArray("src/res/io.txt", true);
			System.out.println("----------");

			IOUtil.copyFile(new File("src/res/io.txt"), new File("src/res/ioback.txt"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
