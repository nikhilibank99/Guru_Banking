package com.lm.testcases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.lm.pageobjects.LoginPage;


public class TC_LoginTest_001 extends TestBase{
	
	public LoginPage lp;
	@Test
	public void loginTest() throws IOException {
		driver.get(baseURL);
		lp=new LoginPage(driver);
		lp.setUserName(username);
		log.info("####user name successfully entered #####");
		lp.setPassword(pwd);
		log.info("####password successfully entered #####");
		lp.clickLoginButton();
		log.info("####Button clicked successfully #####");
		System.out.println(driver.getTitle());
		
		if(driver.getTitle().equals("GTPL Bank Manager HomePage"))
		{
			takesScreenshot("loginTest");//logintest is method name coming from tname i,e testmethod name
			log.info("####Screenshot taken for Passed test case successfully");
			Assert.assertTrue(true);//just to verify above validation(i.e title match) is correct or not. it is optional.
			System.out.println("actual is matching expected test");//for displaying in console
			
		}
		else
		{
			takesScreenshot("loginTest");
			log.info("####Screenshot taken for failed test case successfully");
			Assert.assertTrue(false);//just to verify above validation(i.e title match) is correct or not. it is optional.
			System.out.println("actual is not matching expected test");//for displaying in console
			
		}
	}

}
