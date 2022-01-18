package com.lm.testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.lm.pageobjects.LoginPage;
import com.lm.pageobjects.NewCustomer;

public class Tc_NewCustomer_002 extends TestBase {

	public NewCustomer nc;
	public LoginPage lp;
	
	@Test
	public void newCustomerTest() throws IOException, InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		TC_LoginTest_001 tc=new TC_LoginTest_001();
		tc.loginTest();
		nc=new NewCustomer(driver);
		Thread.sleep(4000);
		nc.clickNewCustomerlink();
		log.info("####New Customer link clicked successfully #####");
		//take from property file. pare karibi
		nc.setCustNametxtbox("Nikhil");
		log.info("####New Customer Name Entered successfully #####");
		Thread.sleep(4000);
		nc.clickGenderMale();
		Thread.sleep(4000);
		String dd=randomDate();
		String mm=randomMonth();
		String yyyy=randomYear();
		System.out.println(dd+"-"+ mm+"-"+yyyy);
		nc.setDob(dd, mm, yyyy);
		log.info("####DOB Entered successfully #####");
	//	nc.setDob("12", "02", "1989");//for separate user maintain separate date from excel sheet or property file. we can use random string
		Thread.sleep(6000);
		
	}
	
}
