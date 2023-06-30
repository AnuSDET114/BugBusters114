package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QueuePage
{
	WebDriver driver;
	public static Logger logger = LogManager.getLogger(QueuePage.class);
		
		public QueuePage(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver,this);
		}	

		@FindBy(css = "a[href='implementation-lists']")
		WebElement implementationqueueelement;
		
		@FindBy(css = "a[href='implementation-collections']")
		WebElement implementationscollectionselement;
		
		@FindBy(css = "a[href='Implementation-array']")
		WebElement implementationarrayelement;
		
		@FindBy(css = "a[href='QueueOp']")
		WebElement queueoperationselement;
		
		@FindBy(css = "a[href='/queue/practice']")
		WebElement practicequestionselement;
		
		@FindBy(css = "a[href='/tryEditor']")
		WebElement tryeditorelement;
		
		@FindBy(css=".codemirror-line")
		WebElement codeEditorElement;
		
		@FindBy(css = "button[type='button']")
		WebElement runElement;
		
		@FindBy(id = "output")
		WebElement outputElement;

		
		public void goToImplementationsListPage()
		{
			implementationqueueelement.click();
						
		}
		
		public void goToImplementationCollectionPage()
		{
			implementationscollectionselement.click();
						
		}
		public void goToImplementationArrayPage()
		{
			implementationarrayelement.click();
						
		}
		public void goToQueueOperationsPage()
		{
			queueoperationselement.click();
						
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
	

