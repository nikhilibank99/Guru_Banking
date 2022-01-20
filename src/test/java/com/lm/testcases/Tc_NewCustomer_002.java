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
		//logging into the app
		TC_LoginTest_001 tc=new TC_LoginTest_001();
		tc.loginTest();
		//inorder to access New customer page - here creating object.
		nc=new NewCustomer(driver);
		Thread.sleep(4000);
		// click on new customer link
		nc.clickNewCustomerlink();
		log.info("####New Customer link clicked successfully #####");
		//take from property file. pare karibi
		//entering name as Nikhil
		nc.setCustNametxtbox("Nikhil");
		log.info("####New Customer Name Entered successfully #####");
		Thread.sleep(4000);
		//click on Male radio
		nc.clickGenderMale();
		Thread.sleep(4000);
		//calling dd,mm,yyyy from base class line 73-82
		String dd=randomDate();
		String mm=randomMonth();
		String yyyy=randomYear();
		System.out.println(dd+"-"+ mm+"-"+yyyy);
		//entering above dob here
		nc.setDob(dd, mm, yyyy);
		log.info("####DOB Entered successfully #####");
	//	nc.setDob("12", "02", "1989");//for separate user maintain separate date from excel sheet or property file. we can use random string
		Thread.sleep(6000);
		//entering address
		nc.setAddresstxtbox("21/4,19th d cross, 7th main,btm 2nd stage");
		//entering city
		nc.setCitytxtbox("bengaluru");
		//entering state
		nc.setStatetxtbox("Karnataka");
		//entering pincode
		nc.setPintxtbox("560076");
		//entering telephone number
		nc.setTelNumbertxtbox("9527700858");
		//email id returned from TestBase line 83-86 and entering it here
		String email=randomEmail();
		nc.setEmailtxtbox(email);
		//clicking on submit button
		nc.clickSubmitbtn();
		
	}
	
}
