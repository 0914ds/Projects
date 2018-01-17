package com.qk365.base.utils;

import java.security.MessageDigest;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.log4j.Logger;

/**
 * 密钥工具类
 */
public class SecretCodeUtils {

	private static final Logger logger = Logger.getLogger(SecretCodeUtils.class);

	/** 加密算法 */
	private static String Algorithm = "DESede";

	/** 默认密钥 */
	private static String key = "-s8G&r7&7i|w5B7o^u;0%j)h";

	/**
	 * MD5加密
	 * 
	 * @param s
	 * @return
	 */
	public final static String MD5(String s) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

		try {
			byte[] btInput = s.getBytes();
			// 获得MD5摘要算法的 MessageDigest 对象
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			// 使用指定的字节更新摘要
			mdInst.update(btInput);
			// 获得密文
			byte[] md = mdInst.digest();
			// 把密文转换成十六进制的字符串形式
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			logger.error("", e);
			return null;
		}
	}

	/**
	 * 对源串进行Des加密(默认密钥)
	 * 
	 * @param sourceCode 源串
	 * @return
	 */
	public static String desEncrypt(String sourceCode) {
		byte[] encoded = encryptMode(key.getBytes(), sourceCode.getBytes());
		return byte2hex(encoded);
	}

	/**
	 * 对源串进行Des加密(指定密钥)
	 * 
	 * @param sourceCode 源串
	 * @param key 密钥
	 * @return
	 */
	public static String desEncrypt(String sourceCode, String key) {
		byte[] encoded = encryptMode(key.getBytes(), sourceCode.getBytes());
		return byte2hex(encoded);
	}

	/**
	 * 对指定密文Des解密(默认密钥)
	 * 
	 * @param encodedCode 密文
	 * @return
	 */
	public static String desDecrypt(String encodedCode) {
		byte[] encoded = decryptMode(key.getBytes(), hex2byte(encodedCode));
		return new String(encoded);
	}



	/**
	 * 对指定密文Des解密(指定密钥)
	 * 
	 * @param encodedCode 密文
	 * @param secKey 密钥
	 * @return
	 */
	public static String desDecrypt(String encodedCode, String secKey) {
		byte[] encoded = decryptMode(secKey.getBytes(), hex2byte(encodedCode));
		return new String(encoded);
	}

	private static String byte2hex(byte[] b) {
		String hs = "";
		String stmp = "";

		for (int n = 0; n < b.length; n++) {
			stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
			if (stmp.length() == 1)
				hs = hs + "0" + stmp;
			else
				hs = hs + stmp;
		}
		return hs.toUpperCase();
	}

	/**
	 * 使用desede算法解密
	 * 
	 * @param keybyte
	 * @param src
	 * @return
	 */
	private static byte[] decryptMode(byte[] keybyte, byte[] src) {
		try {
			SecretKey deskey = new SecretKeySpec(keybyte, Algorithm);
			Cipher c1 = Cipher.getInstance(Algorithm);
			c1.init(Cipher.DECRYPT_MODE, deskey);
			return c1.doFinal(src);
		} catch (java.security.NoSuchAlgorithmException e1) {
			e1.printStackTrace();
		} catch (javax.crypto.NoSuchPaddingException e2) {
			e2.printStackTrace();
		} catch (java.lang.Exception e3) {
			e3.printStackTrace();
		}
		return null;
	}

	/**
	 * 使用desede算法加密
	 * 
	 * @param keybyte
	 * @param src
	 * @return
	 */
	private static byte[] encryptMode(byte[] keybyte, byte[] src) {
		try {
			SecretKey deskey = new SecretKeySpec(keybyte, Algorithm);
			Cipher c1 = Cipher.getInstance(Algorithm);
			c1.init(Cipher.ENCRYPT_MODE, deskey);
			return c1.doFinal(src);
		} catch (java.security.NoSuchAlgorithmException e1) {
			e1.printStackTrace();
		} catch (javax.crypto.NoSuchPaddingException e2) {
			e2.printStackTrace();
		} catch (java.lang.Exception e3) {
			e3.printStackTrace();
		}
		return null;
	}

	private static byte[] hex2byte(String hex) throws IllegalArgumentException {
		if (hex.length() % 2 != 0) {
			throw new IllegalArgumentException();
		}
		char[] arr = hex.toCharArray();
		byte[] b = new byte[hex.length() / 2];
		for (int i = 0, j = 0, l = hex.length(); i < l; i++, j++) {
			String swap = "" + arr[i++] + arr[i];
			int byteint = Integer.parseInt(swap, 16) & 0xFF;
			b[j] = new Integer(byteint).byteValue();
		}
		return b;
	}

	public static void main(String[] args) {
		String aaa = "afsg\"234234&*($#^%";
		String code = SecretCodeUtils.desEncrypt(aaa);
		String bbb = SecretCodeUtils.desDecrypt(code);
		System.out.println(aaa);
		System.out.println(code);
		System.out.println(bbb);
	}

}
