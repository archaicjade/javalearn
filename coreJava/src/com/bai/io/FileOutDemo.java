package com.bai.io;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		// 如果该文件不存在，则直接创建，如果存在，删除后创建
		// 要追加内容，需要增加参数，true
		FileOutputStream out = new FileOutputStream("demo/out.dat");
		out.write('A');// 写入了A的低8位
		out.write('B');// 写入了B的低8位
		int a = 10;// write只能写8位，那么写一个int需要写4次，每次8位
		out.write(a >>> 24);
		out.write(a >>> 16);
		out.write(a >>> 8);
		out.write(a);

		byte[] gbk = "中国".getBytes();
		out.write(gbk);

		out.close();

		IOUtil.printHex("demo/out.dat");

	}

}
