package base;

import java.time.Duration;

import org.bouncycastle.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ReadConfig;

public class BaseTest {
	
	ReadConfig readConfig = new ReadConfig();
	
	String url = readConfig.getTestUrl();
	String browser = readConfig.getBrowser();
	
	public static WebDriver driver;
	
	@BeforeTest
	public void setup() {
		
		//if(driver == null) {
		      
			//Properties.load(Figs);
		//}
		
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
		
	}
	
	@BeforeMethod
	public void launchURL() {
		driver.get(url);
		//implicit wait of 10secs
	    
	    driver.findElement(By.className("btn")).click();
	}
	

	@AfterTest
	public void teardown() {
		
		driver.close();
		System.out.println("Teardown successful");
		
	}
		
		
}


