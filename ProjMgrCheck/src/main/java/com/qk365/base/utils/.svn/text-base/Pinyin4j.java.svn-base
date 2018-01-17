package com.qk365.base.utils;

import java.util.HashSet;
import java.util.Set;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

public class Pinyin4j {

	/**
	 * 中文转拼音只取首字母,不分多音字
	 * 
	 * @param src
	 * @return
	 */
	public static String Chinese2PinYinFirstStr(String src) {
		Set<String> stringSet = Chinese2PinYinSet(src);
		if (stringSet == null || stringSet.size() == 0) {
			return "";
		}
		StringBuilder str = new StringBuilder();
		int i = 0;
		for (String s : stringSet) {
			if (i == stringSet.size() - 1) {
				str.append(s);
			} else {
				str.append(s + ",");
			}
			i++;
		}
		String retVal = str.toString();
		if (retVal.length() <= 1) {
			return retVal.toUpperCase();
		}
		return retVal.substring(0, 1).toUpperCase();
	}

	/**
	 * 中文转拼音(包含多音字各种组合)(如果多音字,逗号分隔)
	 * 
	 * @param src
	 * @return
	 */
	public static String Chinese2PinYinStr(String src) {
		Set<String> stringSet = Chinese2PinYinSet(src);
		if (stringSet == null || stringSet.size() == 0) {
			return "";
		}
		StringBuilder str = new StringBuilder();
		int i = 0;
		for (String s : stringSet) {
			if (i == stringSet.size() - 1) {
				str.append(s);
			} else {
				str.append(s + ",");
			}
			i++;
		}
		return str.toString().toLowerCase();
	}

	/**
	 * 中文转拼音,集合(包含多音字各种组合)
	 * 
	 * @param src
	 * @return Set<String>
	 */
	public static Set<String> Chinese2PinYinSet(String src) {
		if (src != null && !src.trim().equalsIgnoreCase("")) {
			char[] srcChar;
			srcChar = src.toCharArray();
			// 汉语拼音格式输出类
			HanyuPinyinOutputFormat hanYuPinOutputFormat = new HanyuPinyinOutputFormat();

			// 输出设置，大小写，音标方式等
			/**
			 * LOWERCASE min2 <br>
			 * UPPERCASE MIN2
			 */
			hanYuPinOutputFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);// 小写

			/**
			 * WITH_TONE_NUMBER da3 <br>
			 * WITHOUT_TONE da <br>
			 * WITH_TONE_MARK dǎ
			 */
			hanYuPinOutputFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);// 第几声

			/**
			 * Define the output format of character 'ü' <br>
			 * WITH_U_AND_COLON u:<br>
			 * WITH_V v<br>
			 * WITH_U_UNICODE ü<br>
			 */
			hanYuPinOutputFormat.setVCharType(HanyuPinyinVCharType.WITH_V);// 音标方式

			String[][] temp = new String[src.length()][];

			for (int i = 0; i < srcChar.length; i++) {
				char c = srcChar[i];
				// 是中文或者a-z或者A-Z转换拼音(我的需求，是保留中文或者a-z或者A-Z)
				if (String.valueOf(c).matches("[\\u4E00-\\u9FA5]+")) {
					try {
						temp[i] = PinyinHelper.toHanyuPinyinStringArray(srcChar[i], hanYuPinOutputFormat);
					} catch (BadHanyuPinyinOutputFormatCombination e) {
						e.printStackTrace();
					}
				} else if (((int) c >= 65 && (int) c <= 90) || ((int) c >= 97 && (int) c <= 122)) {
					temp[i] = new String[] { String.valueOf(srcChar[i]) };
				} else {
					temp[i] = new String[] { "" };
				}
			}
			String[] pingyinArray = Exchange(temp);
			Set<String> pinyinSet = new HashSet<String>();
			for (int i = 0; i < pingyinArray.length; i++) {
				pinyinSet.add(pingyinArray[i]);
			}
			return pinyinSet;
		}
		return null;
	}

	/**
	 * 递归
	 * 
	 * @param strJaggedArray
	 * @return
	 */
	private static String[] Exchange(String[][] strJaggedArray) {
		String[][] temp = DoExchange(strJaggedArray);
		return temp[0];
	}

	/**
	 * 递归
	 * 
	 * @param strJaggedArray
	 * @return
	 */
	private static String[][] DoExchange(String[][] strJaggedArray) {
		int len = strJaggedArray.length;
		if (len >= 2) {
			int len1 = strJaggedArray[0].length;
			int len2 = strJaggedArray[1].length;
			int newlen = len1 * len2;
			String[] temp = new String[newlen];
			int Index = 0;
			for (int i = 0; i < len1; i++) {
				for (int j = 0; j < len2; j++) {
					temp[Index] = strJaggedArray[0][i] + strJaggedArray[1][j];
					Index++;
				}
			}
			String[][] newArray = new String[len - 1][];
			for (int i = 2; i < len; i++) {
				newArray[i - 1] = strJaggedArray[i];
			}
			newArray[0] = temp;
			return DoExchange(newArray);
		} else {
			return strJaggedArray;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "";
		System.out.println(Chinese2PinYinStr(str));
	}

}
