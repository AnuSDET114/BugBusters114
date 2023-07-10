package com.numpyninja.pages;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GraphPage
{
	WebDriver driver;
	public static Logger logger = LogManager.getLogger(GraphPage.class);
		
		public GraphPage(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver,this);
		}	

		@FindBy(css = "a[href='graph']")
		WebElement graphlinkelement;
		
		@FindBy(css = "a[href='graph-representations']")
		WebElement representationgraphelement;
		
		@FindBy(css = "a[href='/tryEditor']")
		WebElement tryeditorelement;
		
		@FindBy(css=".codemirror-line")
		WebElement codeEditorElement;
		
		@FindBy(css = "a[href='/graph/practice']")
		WebElement practicequestionselement;
		
		@FindBy(css = "button[type='button']")
		WebElement runElement;
		
		@FindBy(id = "output")
		WebElement outputElement;
		
		public void goToGraphLinkPage()
		{
			graphlinkelement.click();
						
		}
		
		public void goToRepresentationGraphPage()
		{
			representationgraphelement.click();
						
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
			Actions actions=new Actions(driver);
			actions.click(codeEditorElement).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE).build().perform();
			actions.sendKeys(codeEditorElement, inputText).perform();
			//logger.info("passing text on texteditior");
//			element.sendKeys("hello");
			runElement.click();
			
			
		}
		
		public String getOutputMessage() {
			return outputElement.getText();
		}

		public void LaunchGraphPage() {
			driver.get("https://dsportalapp.herokuapp.com/graph/");
		}
		
		
	}
	
		
