package com.flipkart.actions;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class GetConfigDataAction {

	static Properties propConfig = new Properties();
	static String projectPath = System.getProperty("user.dir");


	//public static String browserName;


	public static String getProperties (String propertyFilePath, String propertyKey) {
		String propValue="";

		try {
			InputStream input = new FileInputStream(projectPath + propertyFilePath);
			propConfig.load(input);
			propValue = propConfig.getProperty(propertyKey);
			return propValue;

		} catch (Exception exp) {
			exp.getMessage();
			exp.getCause();
			exp.printStackTrace();
			return propValue;
		}

	}
}
