package orangeHRMLoginPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHrm {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver;
		
		String browserName="Chrome";
		
		if (browserName=="Chrome") {
			
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();

		}else {
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
			
		}
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).submit();
		driver.manage().window().maximize();
		Thread.sleep(6000);
		
	}
	
	
	
	
	
	
	
	

}
