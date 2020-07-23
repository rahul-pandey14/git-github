package com.actitime.generic;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShotLib {
WebDriver driver;

/*public ScreenShotLib(WebDriver driver) {
	this.driver=driver;*/
	

public void takeScreenShot(String scriptName) {
	TakesScreenshot ts=(TakesScreenshot) driver;
	File srcfile=ts.getScreenshotAs(OutputType.FILE);
	File destfile=new File("./Screenshots/"+scriptName+".png");
	try
	{
		FileUtils.copyFile(srcfile, destfile);
	
	
		
	}catch(IOException e) {
		e.printStackTrace();
	}
}
}
