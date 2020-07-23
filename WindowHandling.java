package orangeHRMLoginPage;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandling {
	
	
	public static void main(String[] args) {
		
		WebDriver driver;
		
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		
		driver.get("http://www.seleniumframework.com/Practiceform/");
		
		driver.findElement(By.id("button1")).click();
		
		Set<String> win = driver.getWindowHandles();	
		
		for (String a : win) {
			  
			System.out.println(a);
			
		}
		driver.close();	
	}
	

}
