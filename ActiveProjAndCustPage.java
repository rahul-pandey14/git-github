  package com.actitime.pageobjects;



import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.generic.SeleniumLib;

public class ActiveProjAndCustPage extends BasePage {
	SeleniumLib slib;

	@FindBy(css = "input[value='Create New Customer']")
	private WebElement createNewCustBtn;
	@FindBy(className = "successmsg")
	private WebElement successMsg;
	@FindBy(name = "selectedCustomer")
	private WebElement customerDrpDwn;
	@FindBy(css = "input[value*='Show']")
	private WebElement showBtn;
	@FindBy(xpath="//td[starts-with(@id,'customerNameCell')]//a[contains(@href,'customerId')]")
	private List<WebElement> custNameLink;

	public ActiveProjAndCustPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		slib = new SeleniumLib(driver);
	}

	public void clickOnCreateNewCustBtn() {
		createNewCustBtn.click();
	}

	public void verifyCreateCustMsg(String customerName) {
		slib.assertElementDisplayed(successMsg);
		slib.assertByTextContains(successMsg, customerName);
	}

	public void verifyCustomerFromDropDown(String[] expCust) {
	      List<String> allops = slib.getAllOptionsText(customerDrpDwn);
		String[] actCust = new String[expCust.length];
		for (int i = 0; i < allops.size(); i++) {
			for (int j = 0; j < expCust.length; j++) {
				if (allops.get(i).equals(expCust[j])) {
					actCust[j] = allops.get(i);

				}
			}
		}
		slib.assertByObjectArray(actCust, expCust);

	}

	public void showCustomer(String customerName) {

		slib.selectOptionByDropdwn(customerDrpDwn, customerName);
		showBtn.click();
		for (int i = 0; i < custNameLink.size(); i++) {
			if (custNameLink.get(i).getText().equals(customerName)) {
				custNameLink.get(i).click();

			}
		}

	}

	/*******************************************************************************/

	public void verifyDeleteCustomerMsg() {
		String expMsg = "Customer has been successfully deleted.";
		String actMsg = successMsg.getText();
		slib.assertByText(actMsg, expMsg);
	}
}
