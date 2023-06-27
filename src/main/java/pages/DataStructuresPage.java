package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DataStructuresPage
{
	WebDriver driver;
	public static Logger logger = LogManager.getLogger(DataStructuresPage.class);
		
		public DataStructuresPage(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver,this);
		}	

		@FindBy(css = "a[href='time-complexity']")
		WebElement timecomplexityelement;
		
		@FindBy(css = "a[href='/tryEditor']")
		WebElement tryeditorelement;
		
		@FindBy(css=".codemirror-line")
		WebElement codeEditorElement;
		
		@FindBy(css = "button[type='button']")
		WebElement runElement;
		
		@FindBy(id = "output")
		WebElement outputElement;
		
		public void goToTimeComplexityPage()
		{
			timecomplexityelement.click();
						
		}
		
		public String getAlertMessage()
		{
			
			String message=driver.switchTo().alert().getText();
			System.out.println("Alert message is:"+message);
			driver.switchTo().alert().accept();
			return message;
		}
		
		
		
		public void goToTryEditorPage()
		{
			tryeditorelement.click();
			
		}
		
		public void sendTextToEditorAndRun(String inputText) {
//			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//			WebElement element = wait.until(
//			ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".codemirror-line")));
			new Actions(driver).sendKeys(codeEditorElement, inputText).perform();
			//logger.info("passing text on texteditior");
//			element.sendKeys("hello");
			runElement.click();
			
			
		}
		
		public String getOutputMessage() {
			return outputElement.getText();
		}
		
	}
		
		
		
		
		

