package com.qk365.base.datasource;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.EnvironmentStringPBEConfig;

public class CustomDBCPDatasourceTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EnvironmentStringPBEConfig config = new EnvironmentStringPBEConfig();
		config.setAlgorithm("PBEWithMD5AndDES");
		config.setPassword("playsnailEncrypt");
		StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
		encryptor.setConfig(config);
		String url = encryptor.encrypt("jdbc:mysql://10.103.20.7:3306/dt_snail");
		String root = encryptor.encrypt("root");
		String password = encryptor.encrypt("snailgame");
		
		System.out.println("url：" + url);
		System.out.println("root：" + root);
		System.out.println("pwd：" + password);
		
	}

}
