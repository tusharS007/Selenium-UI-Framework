package com.utility;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.constant.Env;

public class PropertiesUtil {

	public static String readProperties(Env env,String propertyName)  {
		
		File propFile = new File(System.getProperty("user.dir") + "\\config\\"+env+".properties");
		FileReader fileReader = null;
		Properties prop = new Properties();
		try {
			fileReader = new FileReader(propFile);
			prop.load(fileReader);
		} catch (IOException e) {
			e.printStackTrace();
		}
		 
		String value = prop.getProperty(propertyName.toUpperCase());
		return value;
	}
	
}
