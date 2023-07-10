package com.numpyninja.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StackPage 
{
WebDriver driver;
public static Logger logger = LogManager.getLogger(StackPage.class);
	
	public StackPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}	
	
	@FindBy(xpath = "//a[contains(text(),'Operations in Stack')]")
	WebElement operationsinstack;
	
	@FindBy(xpath = "//a[contains(text(),'Implementation')]")
	WebElement implementationstackelement;
	
	@FindBy(xpath = "//a[contains(text(),'Applications')]")
	WebElement applicationsstackelement;
	
	@FindBy(css = "a[href='/stack/practice']")
	WebElement practicequestionselement;
	
	
	@FindBy(xpath = "//a[contains(text(),'Try here>>>')]")
	WebElement tryeditorelement;
	
	@FindBy(css=".codemirror-line")
	WebElement codeEditorElement;
	
	@FindBy(xpath = "//button[contains(text(),'Run')]")
	WebElement runElement;
	
	@FindBy(id = "output")
	WebElement outputElement;
	
	public void goToOperationsInStackPage()
	{	
		operationsinstack.click();
		//logger.info("click on" +operationsinstack.getText());
	}
	public void goToImplementationPage()
	{
		implementationstackelement.click();
		//logger.info("click on" +implementationstackelement.getText());
	}
	
	public void goToApplicationsPage()
	{
		applicationsstackelement.click();
		//logger.info("click on" +applictionsstackelement.getText());
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
		//logger.info("click on Run" +tryeditorelement.getText());
	}
	
	public void sendTextToEditorAndRun(String inputText) {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		WebElement element = wait.until(
//		ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".codemirror-line")));
		Actions actions=new Actions(driver);
		actions.click(codeEditorElement).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE).build().perform();
		actions.sendKeys(codeEditorElement, inputText).perform();
		//logger.info("passing text on texteditior");
//		element.sendKeys("hello");
		runElement.click();
		
		
	}
	
	public String getOutputMessage() {
		return outputElement.getText();
	}
	public void launchstackpage() {
		driver.get("https://dsportalapp.herokuapp.com/stack/");
	}
	
	
}



