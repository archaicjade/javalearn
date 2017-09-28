package com.bai.io;

import java.io.File;
import java.io.IOException;

/*
 * 列出File类的一些常用操作，比如过滤，遍历等操作
 */
public class FileUtils {
	/**
	 * 列出指定目录下（包括子目录）的所有文件
	 * 
	 * @param dir
	 * @throws IOException
	 */
	public static void listDirectory(File dir) throws IOException {
		if (!dir.exists()) {
			throw new IllegalArgumentException("目录：" + dir + "不存在");
		}
		if (!dir.isDirectory()) {
			throw new IllegalArgumentException(dir + "不是目录");
		}

		File[] filelist = dir.listFiles();
		if (filelist != null && filelist.length > 0) {
			for (File fi : filelist) {
				if (fi.isDirectory()) {
					listDirectory(fi);
				} else {
					System.out.println(fi);
				}
			}
		}
	}
}
