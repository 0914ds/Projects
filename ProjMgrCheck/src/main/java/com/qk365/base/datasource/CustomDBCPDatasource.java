package com.qk365.base.datasource;

import org.apache.commons.dbcp.BasicDataSource;
import org.jasypt.encryption.pbe.PBEStringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomDBCPDatasource extends BasicDataSource {
	
	@Autowired
	private PBEStringEncryptor encryptor;

	@Override
	public void setPassword(String password) {
		String decodedPassword = encryptor.decrypt(password);
		super.setPassword(decodedPassword);
	}

	@Override
	public void setUsername(String username) {
		String decodedUsername = encryptor.decrypt(username);
		super.setUsername(decodedUsername);
	}

	@Override
	public synchronized void setUrl(String url) {
		String decodedUrl = encryptor.decrypt(url);
		super.setUrl(decodedUrl);
	}
}
