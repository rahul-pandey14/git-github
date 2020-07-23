package orangeHRMLoginPage;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertDemo {
	
	
public static void main(String[] args) throws InterruptedException  {
		
		WebDriver driver;
		
		String browserName="Chrome";
		
		if (browserName.equals("Chrome")) {
			
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();

		}else {
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
			
		}
		
		driver.get("https://www.seleniumeasy.com/test/javascript-alert-box-demo.html");
		
		driver.manage().window().maximize();
			/*WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator))
			*/driver.findElement(By.xpath("//button[@class='btn btn-default']")).click();
		Alert txt = driver.switchTo().alert();
		String t = txt.getText();
		
		System.out.println(t);
		Thread.sleep(4000);
		
		txt.accept();
		
		//driver.quit();
		
		driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg'][contains(text(),'Click me!')]")).click();
		
		Thread.sleep(4000);
		Alert tbt = driver.switchTo().alert();
String th = txt.getText();
		
		System.out.println(th);
		tbt.dismiss();
		
	
		
		
		driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg'][contains(text(),'Click me!')]")).click();

		
		Thread.sleep(4000);
		Alert tvt = driver.switchTo().alert();
String tht = txt.getText();
		
		System.out.println(tht);
		tvt.accept();
		
		
driver.findElement(By.xpath("//button[contains(text(),'Click for Prompt Box')]")).click();

		
		Thread.sleep(4000);
		Alert tvt1 = driver.switchTo().alert();
String tht1 = txt.getText();
System.out.println(tht1);
		
tvt1.sendKeys("Rahul Pandey");
tvt1.accept();

		
		
		
		driver.quit();
		
		
		
		
		
		
		
	
	
	
	

}
}