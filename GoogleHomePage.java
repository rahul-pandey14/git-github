package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import test.TestBase;

public class GoogleHomePage extends TestBase{
	@FindBy(name="q")
	static WebElement srchTxtBx;
	@FindBy(name="btnK")
	static WebElement srchBtn;
	
	public void enterSearchData() {
		
		PageFactory.initElements(driver, this);
		
		srchTxtBx.sendKeys("INDIA");
		srchBtn.submit();
	}
	

	
	/* driver.findElement(By.name("q")).sendKeys("INDIA");
	 driver.findElement(By.name("btnK")).submit();
	 */
}
