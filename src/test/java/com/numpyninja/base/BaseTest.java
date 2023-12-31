package com.numpyninja.base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.numpyninja.pages.HomePage;
import com.numpyninja.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public ReadConfig readConfig = new ReadConfig();
	
	String url = readConfig.getTestUrl();
	String browser = readConfig.getBrowser();
	
	public static WebDriver driver;
	public static Logger logger = LogManager.getLogger(HomePage.class);
	
	@BeforeSuite
	public void setup() {
		
		if(browser.equalsIgnoreCase("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();

			
		}
		else if(browser.equalsIgnoreCase("firefox")) {
		
			WebDriverManager.firefoxdriver().setup();
		    driver = new FirefoxDriver();

		    
		}
		
		else if(browser.equalsIgnoreCase("msedge")) {
			
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

			
		}	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(url);
	}
	
	public void launchURL() {
		driver.get(url);
	    
	    driver.findElement(By.className("btn")).click();
	}
	

	@AfterSuite
	public void teardown() {
		
		driver.close();
		System.out.println("Teardown successful");
		
	}
		
	public void captureScreenShot(WebDriver driver,String testName) throws IOException
	{
		//step1: convert webdriver object to TakesScreenShot interface
		TakesScreenshot screenshot = ((TakesScreenshot)driver);
		
		//step2: call getScreenshotAs method to create image file
		
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		File dest = new File(System.getProperty("user.dir")+ "//Screenshots//" + testName + ".png");
		
		//step3: copy image file to destination
		FileUtils.copyFile(src, dest);
		
	}
		
		
	}
		



