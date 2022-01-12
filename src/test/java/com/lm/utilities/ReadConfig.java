package com.lm.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties pro;
public	ReadConfig()
	{
	// load the property file
		File src=new File("./configurationfiles/config.properties");
		try {
			FileInputStream fis=new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
		}
		catch(Exception e)
		{
			System.out.println("Exception is: "+e.getMessage());
		}
	}
//performing action on the config.properties like uname,pwd
public String getApplicationUrl()
{
return pro.getProperty("baseURL");//this variable should be exact from config.properties & here we are returning the values as it is string type.

}
public String getApplicationUname() {
	return pro.getProperty("username");//this variable should be exact from config.properties
}

public String getPassword() {
	return pro.getProperty("pwd");//this variable should be exact from config.properties
}

}
