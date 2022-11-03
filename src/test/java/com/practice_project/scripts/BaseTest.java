package com.practice_project.scripts;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class BaseTest 
{
	public WebDriver driver;
	
	@BeforeClass
	public void preCondition()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
	}
	
	@AfterClass
	public void postCondition() throws InterruptedException
	{
		Thread.sleep(3000);
		//driver.close();
		
		driver.quit();
	}
	
	public void captureScreenShot(String tname) throws IOException 
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "//screenshots//" + tname + ".png");
		FileUtils.copyFile(source, target);
		
		System.out.println("Screenshot taken");
	}
}
