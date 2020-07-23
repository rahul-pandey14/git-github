package com.actitime.scripts;

import org.testng.annotations.Test;

import com.actitime.generic.BaseLib;
import com.actitime.generic.ExcelUtilities;
import com.actitime.pageobjects.ActiveProjAndCustPage;
import com.actitime.pageobjects.CreateNewCustPage;
import com.actitime.pageobjects.EditCustInfo;
import com.actitime.pageobjects.EnterTimeTrackPage;
import com.actitime.pageobjects.LoginPage;
import com.actitime.pageobjects.OpenTaskPage;

public class TestHarness extends BaseLib {

	@Test
	public void createAndDeleteMultipleCustomers() {
		
		String file = "./testdata/testData.xlsx";
		String username = ExcelUtilities.readData(file, "Tasks-Customers", 2, 1);
		String password = ExcelUtilities.readData(file, "Tasks-Customers", 2, 2);
		LoginPage lp = new LoginPage(driver);
		lp.login(username, password);

		EnterTimeTrackPage ettp = new EnterTimeTrackPage(driver);
		ettp.clickOnTasks();
		OpenTaskPage otp = new OpenTaskPage(driver);
		otp.clickOnProjAndCustLink();
		ActiveProjAndCustPage apcp = new ActiveProjAndCustPage(driver);

		String[] expCust = new String[4];
		int cell = 3;
		for (int i = 0; i < expCust.length; i++) { 
			String customerName = ExcelUtilities.readData(file, "Tasks-Customers", 2, cell);
			expCust[i] = customerName;
			cell++;

			apcp.clickOnCreateNewCustBtn();
			CreateNewCustPage cncp = new CreateNewCustPage(driver);
			cncp.createCustomer(customerName);
			apcp.verifyCreateCustMsg(customerName);

		}
		apcp.verifyCustomerFromDropDown(expCust);
		for (int j = 0; j < expCust.length; j++) {
			String customerName = (String) expCust[j];
			apcp.showCustomer(customerName);
			EditCustInfo ecip = new EditCustInfo(driver);
			ecip.deleteCustomer();
			apcp.verifyDeleteCustomerMsg();

		}
		apcp.clickOnLogout();

	}
}
 