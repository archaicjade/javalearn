package com.bai.io;

import java.io.UnsupportedEncodingException;

public class EncodingTest {

	public static void main(String[] args) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub

		String s = "易车联通abc";

		byte[] bytes1 = s.getBytes("gbk");

		System.out.println(new String(bytes1, "gbk"));

		for (byte b : bytes1) {
			System.out.print(Integer.valueOf(b & 0xff) + " ");
		}

		System.out.println();

		byte[] bytes2 = s.getBytes("utf-16be");

		System.out.println(new String(bytes2, "utf-16be"));

		for (byte b : bytes2) {
			System.out.print(Integer.valueOf(b & 0xff) + " ");
		}

		System.out.println();

		byte[] byte3 = s.getBytes();

		System.out.println(new String(byte3));

		for (byte b : byte3) {
			System.out.print(Integer.valueOf(b & 0xff) + " ");
		}

		/*
		 * Java Project中指定编码方式后，其他编码方式的文件导入后会产生乱码；
		 */

	}

}
