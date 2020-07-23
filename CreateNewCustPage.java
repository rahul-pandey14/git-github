package com.actitime.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.generic.SeleniumLib;

public class CreateNewCustPage {
	SeleniumLib slib;
	@FindBy(name = "name")
	private WebElement custNameTxtBx;
	@FindBy(name = "createCustomerSubmit")
	private WebElement createCustBtn;

	public CreateNewCustPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		slib = new SeleniumLib(driver);

	}

	public void createCustomer(String customerName) {
		slib.enterdata(custNameTxtBx, customerName);
		createCustBtn.click();
	}
}
