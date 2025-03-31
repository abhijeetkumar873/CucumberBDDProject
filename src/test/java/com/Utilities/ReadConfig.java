package com.Utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig
{
	Properties properties;
	String path ="config.properties";
	
	public ReadConfig()
	{
		properties = new Properties();
		FileInputStream file;
		try {
			file = new FileInputStream("C:\\Users\\abhijeakumar2\\OneDrive - Sopra Steria\\Automation\\eclipse-java-2024-09-R-win32-x86_64\\eclipse-workspace\\Cucumber_Freamework\\config.properties");
			properties.load(file);
		} 
		catch (Exception e) {
		
			e.printStackTrace();
		}		
	}
	public String getBrowser()
	{
		String value= properties.getProperty("browser");
		if(value!=null)
		return value;
		else
			throw new RuntimeException("URL not specified in config file");		
	}
	

}
