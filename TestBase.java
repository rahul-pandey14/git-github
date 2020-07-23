package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	public static WebDriver driver;
	public void getBrowser() {
		
		//System.setProperty("webdriver.chrome.driver","./Driver/chromedriver.exe");
		String browser="chrome";
		if (browser.equals("chrome")) 
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		} else 
		{
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();

		}
	
		
	}
	}


