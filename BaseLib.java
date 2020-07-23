package com.actitime.generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseLib {

	public static WebDriver driver;
	
	@BeforeMethod
	@Parameters({"browser","baseurl"})
	public static void setUp(String browserName,String url) {
		

if(browserName.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver", "./exefiles/chromedriver.exe");
		driver = new ChromeDriver();
		Reporter.log("chrome launched",true);
		}
else if(browserName.equalsIgnoreCase("firefox")) {
	System.setProperty("webdriver.gecko.driver", "./exefiles/geckodriver.exe");
	driver= new FirefoxDriver(); 
	Reporter.log("firefox launched",true);



}
driver.manage().deleteAllCookies();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
driver.navigate().to(url);
Reporter.log(url+" url is navigated",true);
	
}
	@AfterMethod
	public void teardown(ITestResult result) {
      String scriptName = result.getMethod().getMethodName();
      
      if(result.isSuccess()) {
    Reporter.log(scriptName+"script passed :)",true);
      }else {
    	  ScreenShotLib slib= new ScreenShotLib();
    	  slib.takeScreenShot(scriptName);
    	  Reporter.log("screenshot has been taken",true);
      }
      
      driver.close();
	}
 } 
