package com.bai.io;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

public class RafDemo {

	public static void main(String[] args) throws IOException {

		File demo = new File("demo");

		if (!demo.exists()) {
			demo.mkdir();
		}

		File file = new File(demo, "raf.dat");
		if (!file.exists()) {
			file.createNewFile();
		}

		RandomAccessFile raf = new RandomAccessFile(file, "rw");
		System.out.println(raf.getFilePointer());

		raf.write('A');// 只写了一个字节

		System.out.println(raf.getFilePointer());

		raf.write('B');

		System.out.println(raf.getFilePointer());

		int i = 0x7fffffff;
		// 用write方法每次只能写一个字节，如果要把i写进去就得写4次
		raf.write(i >>> 24);// 高8位
		raf.write(i >>> 16);
		raf.write(i >>> 8);
		raf.write(i);
		System.out.println(raf.getFilePointer());

		raf.writeInt(i);

		String s = "中";
		byte[] b = s.getBytes("gbk");

		raf.write(b);

		System.out.println(raf.length());

		// 读文件，必须把指针移到头部
		raf.seek(0);

		byte[] buf = new byte[(int) raf.length()];

		raf.read(buf);

		System.out.println(Arrays.toString(buf));

		String s1 = new String(buf, "gbk");

		System.out.println(s1);

		for (byte c : buf) {
			System.out.print(Integer.toHexString(c & 0xff) + " ");
		}

		raf.close();

	}

}
