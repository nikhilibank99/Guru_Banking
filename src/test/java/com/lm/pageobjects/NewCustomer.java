package com.lm.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewCustomer {

	public WebDriver ldriver;
	//Declaration
	@FindBy(xpath="//a[.='New Customer']")
	WebElement NewCustomerlink;
	@FindBy(name="name")
	WebElement CustNametxtbox;
	@FindBy(xpath="//input[@name='rad1'][1]")
	WebElement GenderRadiobtn;
	@FindBy(id="dob")
	WebElement Dob;
	@FindBy(xpath="//textarea[@name='addr']")
	WebElement Addresstxtbox;
	@FindBy(xpath="//input[@name='city']")
	WebElement Citytxtbox;
	@FindBy(xpath="//input[@name='state']")
	WebElement Statetxtbox;
	@FindBy(xpath="//input[@name='pinno']")
	WebElement Pintxtbox;
	@FindBy(xpath="//input[@name='telephoneno']")
	WebElement TelNumbertxtbox;
	@FindBy(xpath="//input[@name='emailid']")
	WebElement Emailtxtbox;
	@FindBy(xpath="//input[@name='sub']")
	WebElement Submitbtn;
	
	public NewCustomer(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	public void clickNewCustomerlink() {
		NewCustomerlink.click();
		
	}
	
	public void setCustNametxtbox(String cu_name) {
		CustNametxtbox.sendKeys(cu_name);
	}
	public void clickGenderMale() {
		GenderRadiobtn.click();
	}
	public void setDob(String dd,String mm,String yyyy) {
		Dob.sendKeys(dd);
		Dob.sendKeys(mm);
		Dob.sendKeys(yyyy);
	}
	public void setAddresstxtbox(String address_name) {
		Addresstxtbox.sendKeys(address_name);
	}
	public void setCitytxtbox(String city_name) {
		Citytxtbox.sendKeys(city_name);
	}
	public void setStatetxtbox(String state_name) {
		Statetxtbox.sendKeys(state_name);
	}
	public void setPintxtbox(String pin_code){
		Pintxtbox.sendKeys(pin_code);
	}
	public void setTelNumbertxtbox(String tel_no) {
		TelNumbertxtbox.sendKeys(tel_no);
	}
	public void setEmailtxtbox(String email) {
		Emailtxtbox.sendKeys(email);
	}
	public void clickSubmitbtn() {
		Submitbtn.click();
	}
	
	
	
}
