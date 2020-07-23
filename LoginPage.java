package com.actitime.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.generic.SeleniumLib;

public class LoginPage 
{
SeleniumLib slib;	
	
@FindBy(name="username") 
private WebElement unTxtBx;
@FindBy(name="pwd")
private WebElement pwdTxtBx;
@FindBy(id="loginButton")
private WebElement loginBtn;

public LoginPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
	slib= new SeleniumLib(driver);
}
public void login(String username,String password) 
{
	 
	slib.enterdata(unTxtBx, username);
	slib.enterdata(pwdTxtBx, password);
	loginBtn.click();
	
}

}
