package com.bai.io;

import java.io.File;
import java.io.IOException;

public class FileDemo {

	public static void APILearn() throws IOException {
		File fi = new File("src/res/rssnews.xml");
		System.out.println(fi.exists());
		System.out.println(fi.isDirectory());
		System.out.println(fi.isFile());

		File fi2 = new File("src/res");

		if (fi2.exists()) {
			fi2.mkdir();
			/*
			 * 如果是多级目录，使用mkdirs创建
			 */
			// fi2.mkdirs();
		}

		System.out.println(fi2.exists());
		System.out.println(fi2.isDirectory());
		System.out.println(fi2.isFile());

		File fi3 = new File("src/res/1.txt");

		if (!fi3.exists()) {
			fi3.createNewFile();
		}

		System.out.println(fi3.getAbsolutePath());
		System.out.println(fi3.getName());
		System.out.println(fi3.getParent());
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileUtils.listDirectory(new File("src"));
	}

}
