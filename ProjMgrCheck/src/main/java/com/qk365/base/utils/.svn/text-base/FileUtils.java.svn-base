package com.qk365.base.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/**
 * 文件上传下载工具类
 */
public abstract class FileUtils {

	static Logger logger = Logger.getLogger(FileUtils.class);

	public static final int BUFFER_SIZE = 4096;

	/**
	 * 文件上传
	 * 
	 * @param in
	 * @param filePath
	 */
	public static void uploadFile(InputStream in, String filePath) {
		OutputStream out = null;
		try {
			out = new FileOutputStream(filePath);
			copy(in, out);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 从输入流拷贝文件到输出流
	 * 
	 * @param in
	 * @param out
	 * @return
	 * @throws IOException
	 */
	public static int copy(InputStream in, OutputStream out) throws IOException {
		try {
			int byteCount = 0;
			byte[] buffer = new byte[BUFFER_SIZE];
			int bytesRead = -1;
			while ((bytesRead = in.read(buffer)) != -1) {
				out.write(buffer, 0, bytesRead);
				byteCount += bytesRead;
			}
			out.flush();
			return byteCount;
		} finally {
			try {
				in.close();
			} catch (IOException ex) {
			}
			try {
				out.close();
			} catch (IOException ex) {
			}
		}
	}

	/**
	 * 文件下载
	 * 
	 * @param response
	 * @param filePath
	 */
	public static void downloadFile(HttpServletResponse response, String filePath) {
		File file = new File(filePath);
		if (!file.exists()) {
			logger.error("File " + filePath + " does not exist");
			return;
		}
		String fileName = file.getName();
		logger.info("fileName:" + fileName);
		long fileLength = file.length();
		response.setContentType("application/octet-stream");
		try {
			response.setHeader("Content-disposition", "attachment; filename=" + URLEncoder.encode(fileName, "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} // 设定输出文件头
		response.setHeader("Content-Length", String.valueOf(fileLength));

		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			bis = new BufferedInputStream(new FileInputStream(filePath));
			bos = new BufferedOutputStream(response.getOutputStream());
			copy(bis, bos);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 功能:压缩多个文件成一个zip文件
	 * 
	 * @param srcfile：源文件列表
	 * @param zipfile：压缩后的文件
	 */
	public static void zipFiles(File[] srcfile, File zipfile) {
		byte[] buf = new byte[1024];
		try {
			// ZipOutputStream类：完成文件或文件夹的压缩
			ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipfile));
			for (int i = 0; i < srcfile.length; i++) {
				FileInputStream in = new FileInputStream(srcfile[i]);
				out.putNextEntry(new ZipEntry(srcfile[i].getName()));
				int len;
				while ((len = in.read(buf)) > 0) {
					out.write(buf, 0, len);
				}
				out.closeEntry();
				in.close();
			}
			out.close();
		} catch (Exception e) {
			logger.error("压缩文件异常", e);
		}
	}
}
