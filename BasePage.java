  package com.actitime.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage 
{
@FindBy(xpath="//div[text()='Tasks']")
private WebElement tasks;
@FindBy(id="logoutLink")
private WebElement logout;

public BasePage(WebDriver driver)
{

	PageFactory.initElements(driver, this);
	
}
	
public void clickOnTasks()
{
	tasks.click();
}
public void clickOnLogout() {
	logout.click();
}
}
