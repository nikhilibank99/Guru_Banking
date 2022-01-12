package com.lm.testcases;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.lm.utilities.ReadConfig;

public class TestBase {

	ReadConfig config=new ReadConfig();
	public String baseURL=config.getApplicationUrl();
	public String username=config.getApplicationUname();
	public String pwd=config.getPassword();
	public static WebDriver driver;
	public static Logger log;
	
@Parameters("Browser")
@BeforeClass
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

@AfterClass
public void teardown()
{
driver.quit();

}

public static void takesScreenshot(String tname) throws IOException {
	DateFormat df=new SimpleDateFormat("dd_MMM_yyyy hh_mm_ss");
	Date d=new Date();
	String time=df.format(d);
	TakesScreenshot ts=(TakesScreenshot) driver;
	File src=ts.getScreenshotAs(OutputType.FILE);
	FileHandler.copy(src, new File("./screenshots/" + tname+".png"));
	
}
}


