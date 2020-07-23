package com.actitime.generic;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
 
public class SeleniumLib {

	WebDriver driver;

	/**************** constructor ************************/
	public SeleniumLib(WebDriver driver) {
		this.driver = driver;
	}

	/******************* enter data into textbox **************/
	public void enterdata(WebElement txtbx, String input) {

		txtbx.clear();
		txtbx.sendKeys(input);
	}
    
	/*********************** verify and click chkbx *******************/
	public void clickChkBx(WebElement chkBx) {

		if (chkBx.isSelected())// true
		{
			Reporter.log("checkbox is already selected", true);

		} else// false
		{
			chkBx.click();
		}
	}

	/************************** mouse hovering ***********************/

	public void mouseOver(WebElement ele) {
		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();
	}

	/************************** select option text in dropdown ******************/
	public void selectOptionByDropdwn(WebElement drpdwn, String optiontext) {

		Select sel = new Select(drpdwn);
		sel.selectByVisibleText(optiontext);

	}

	/******************************get all option text from dropdown *******************/
	public List<String> getAllOptionsText(WebElement drpdwn) {

		Select sel = new Select(drpdwn);

		List<WebElement> allops = sel.getOptions();
		List<String> lt=new ArrayList<String>();
		
		for (int i = 0; i < allops.size(); i++) {
        lt.add(allops.get(i).getText());
		}
		return lt;
	}

	/************************** expilicit wait for visibility *********************/
	public void eWaitForVisible(WebElement ele, int secs) {

		WebDriverWait wait = new WebDriverWait(driver, secs);
		wait.until(ExpectedConditions.visibilityOf(ele));

	}

	/*************************** hardcode wait ****************/
	public void iSleep(int secs) {

		try {
			Thread.sleep(secs * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/*************************** assert equals by text ***************/
	public void assertByText(String actText, String expText) {
		Assert.assertEquals(actText, expText);
		Reporter.log(expText + "  is verified", true);

	}

	/********************** assert equal by object array **************/
	public void assertByObjectArray(Object[] actual, Object[] exp) {
		Assert.assertEquals(actual, exp);
		for (int i = 0; i < exp.length; i++) {

			Reporter.log(exp[i] + "  is verified", true);
		}
	}

	/**************** assert by text contains *******************/
	public void assertByTextContains(WebElement ele, String actText) {

		Assert.assertTrue(ele.getText().contains(actText));

		Reporter.log(ele.getText(), true);

	}

	/*********************** assert true whether element displayed ***************/
	public void assertElementDisplayed(WebElement ele) {
		Assert.assertTrue(ele.isDisplayed());
		Reporter.log("element is displayed", true);
	}
 
}
