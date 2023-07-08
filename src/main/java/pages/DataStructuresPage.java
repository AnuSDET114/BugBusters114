package pages;

import java.awt.RenderingHints.Key;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
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
		
		@FindBy(css = "a[href='/data-structures-introduction/practice']")
		WebElement practicequestionselement;
		
		
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
		public void goToPracticeQuestionsPage()
		{
			practicequestionselement.click();
		
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
			Actions actions = new Actions(driver);
			actions.click(codeEditorElement).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE).build().perform();
			actions.sendKeys(codeEditorElement, inputText).perform();
			//logger.info("passing text on texteditior");
//			element.sendKeys("hello");
			runElement.click();
			
			
		}
		
		public String getOutputMessage() {
			return outputElement.getText();
		}
		
		public void launchDatastructuresPage() {
			driver.get("https://dsportalapp.herokuapp.com/data-structures-introduction/");
		}
		
	}
		
		
		
		
		

