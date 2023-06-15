package base;

import java.time.Duration;

import org.bouncycastle.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

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
		      
			//Properties.load(fis);
		//}
		
		if(browser.equalsIgnoreCase("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get("url");
			
		}
		else if(browser.equalsIgnoreCase("firefox")) {
		
			WebDriverManager.firefoxdriver().setup();
		    driver = new ChromeDriver();
		    driver.get("url");
		    
		}
		
		else if(browser.equalsIgnoreCase("msedge")) {
			
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.get("url");
			
		}	
		
		//implicit wait of 10secs
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@AfterTest
	public void teardown() {
		
		driver.close();
		System.out.println("Teardown successful");
		
	}
		//implicit wait of 10secs
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Test comment
		
		
	}


