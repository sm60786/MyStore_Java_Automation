package com.store.Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfigurationFile {
	
	Properties prop;
	
	String path = "D:\\Java_Projects\\MyStoreV1\\Configuration\\Config.properties";
	
	public ReadConfigurationFile() {
		
		prop = new Properties();
		
		try {
			FileInputStream fis = new FileInputStream(path);
			prop.load(fis);
		} catch (IOException e) {
				e.printStackTrace();
		}
		
	}
	
	public String getApplicationUrl() {
		
		String value = prop.getProperty("applicationurl");
		
		if (value != null) {
			return value;
		} else {
			throw new RuntimeException("ApplicationURL is not specified in Config.properties file.");
		}
		
	}
	
	public String getBrowser() {
		
		String browser = prop.getProperty("browser");
		
		if (browser != null) {
			return browser;
		} else {
			throw new RuntimeException("Browser is not specified in Config.properties file.");
		}
		
	}
	
	public String getValue(String key) {
		String value = prop.getProperty(key);
		if (value != null) {
			return value;
		} else {
			throw new RuntimeException("Check for given key and make sure particular key has some value");
		}
	}
	
}
