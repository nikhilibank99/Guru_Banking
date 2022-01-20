package com.lm.testcases;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.lm.utilities.ReadConfig;

public class TestBase {

	ReadConfig config=new ReadConfig();
	public String baseURL=config.getApplicationUrl();
	public String username=config.getApplicationUname();
	public String pwd=config.getPassword();
	public static WebDriver driver;
	public static Logger log;
	//for different browsers we are using @Parameters
@Parameters("Browser")
@BeforeMethod
public void setup(String br)
{
	if(br.equals("Chrome")) {
		

System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

driver=new ChromeDriver();
	}
	else if(br.equals("FireFox"))
	{
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		driver=new FirefoxDriver();
	}
//Logger class used for collecting logs
log=Logger.getLogger("Banking");
PropertyConfigurator.configure("Log4j.properties");

}

@AfterMethod
public void teardown()
{
driver.quit();

}
//tname is test case name
public static void takesScreenshot(String tname) throws IOException  {
	DateFormat df=new SimpleDateFormat("dd_MMM_yyyy hh_mm_ss");
	Date d=new Date();
	String time=df.format(d);
	TakesScreenshot ts=(TakesScreenshot) driver;
	File src=ts.getScreenshotAs(OutputType.FILE);
	FileHandler.copy(src, new File("./screenshots/" + tname+".png"));	
}
public static String randomDate() {
	String gs1=RandomStringUtils.randomNumeric(2);
	return gs1;
}
public static String randomMonth() {
	String gs2=RandomStringUtils.randomNumeric(2);
	return gs2;}
public static String randomYear() {
	String gs3=RandomStringUtils.randomNumeric(4);
	return gs3;}
public static String randomEmail()
{
	String email=RandomStringUtils.randomAlphabetic(8);
	return email;
}

}


