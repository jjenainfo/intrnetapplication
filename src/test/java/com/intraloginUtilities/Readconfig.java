package com.intraloginUtilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class Readconfig {
	
	Properties prop = new Properties();

	public Readconfig() {
		
		File src = new File("./configuration/config.properties");
		
		try {
			FileInputStream fi=new FileInputStream(src);
			prop.load(fi);
		} catch (Exception e) {
		System.out.println("Error is"+e.getMessage());
			
		}
		
	}
	public String getURL() {
		
		String url= prop.getProperty("url");
		return url;
		
	}
public String getUserName() {
		
		String userName= prop.getProperty("userName");
		return userName;
		
	}
public String getPassword() {
	
	String password= prop.getProperty("password");
	return password;
	
}
	
	


}
