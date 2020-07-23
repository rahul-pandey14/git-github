package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.GoogleHomePage;

public class SearchTest extends TestBase {

	GoogleHomePage g;
@BeforeTest
public void setup() 
{
getBrowser();
g= new GoogleHomePage();

}
  @Test
  public void search() {
	 driver.get("https://www.google.co.in/");
	 g.enterSearchData();
	
	 try {
		WebDriverWait w = new WebDriverWait(driver, 3);
		w.until(ExpectedConditions.titleContains("India"));
	} catch (Exception e)
	 {
		Assert.fail("title incorrect");
		
	}
  }
}
