package com.lm.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

public	WebDriver localdriver;

//Declaring web elements of login page
@FindBy(name="uid")
WebElement txtUsername;
@FindBy(name="password")
WebElement txtPassword;
@FindBy(name="btnLogin")
WebElement loginbutton;

//Initialization of web elements within the constructor
public LoginPage(WebDriver remotedriver){
	localdriver=remotedriver;
	PageFactory.initElements(remotedriver,this);
	
}
//Utilization by creating custom methods
public void setUserName(String uname) {
	txtUsername.sendKeys(uname);
}

public void setPassword(String pwd) {
	txtPassword.sendKeys(pwd);
}
public void clickLoginButton() {
	loginbutton.click();
}

	
}
