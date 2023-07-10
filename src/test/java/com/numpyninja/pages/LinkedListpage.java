package com.numpyninja.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class LinkedListpage 
{
WebDriver driver;
public static Logger logger = LogManager.getLogger(LinkedListpage.class);
	
	public LinkedListpage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}	

	
	@FindBy(css = "a[href='introduction']")
	WebElement introductionelement;
	
	@FindBy(css = "a[href='creating-linked-list']")
	WebElement createlinkedlistelement;
	
	@FindBy(css = "a[href='types-of-linked-list']")
	WebElement typesoflinkedlistelement;
	
	@FindBy(css = "a[href='implement-linked-list-in-python\']")
	WebElement implementedlinkedlistelement;
	
	@FindBy(css = "a[href='traversal']")
	WebElement traversallinkedlistelement;
	
	@FindBy(css = "a[href='insertion-in-linked-list']")
	WebElement insertionlinkedlistelement;
	
	@FindBy(css = "a[href='deletion-in-linked-list']")
	WebElement deletionlinkedlistelement;
	
	@FindBy(css = "a[href='/linked-list/practice']")
	WebElement practicequestionselement;
	
	
	
	@FindBy(css = "a[href='/tryEditor']")
	WebElement tryeditorelement;
	
	@FindBy(css=".codemirror-line")
	WebElement codeEditorElement;
	
	@FindBy(css = "button[type='button']")
	WebElement runElement;
	
	@FindBy(id = "output")
	WebElement outputElement;
	
	public void goToIntroductionPage()
	{	
		introductionelement.click();
		//logger.info("click on" +introductionelement.getText());
	}
	public void goToCreateALinkedListPage()
	{
		createlinkedlistelement.click();
		//logger.info("click on" +createlinkedlistelement.getText());
	}
	
	public void goToTypesofLinkedListPage()
	{
		typesoflinkedlistelement.click();
		//logger.info("click on" +typesoflinkedlistelement.getText());
	}
	
	
	
	public void goToImplementedLinkedListPage()
	{
		implementedlinkedlistelement.click();
		//logger.info("click on" +implementedlinkedlistelement.getText());
	}
	

	public void goToTraversalLinkedListPage()
	{
		traversallinkedlistelement.click();
		//logger.info("click on" +traversallinkedlistelement.getText());
	}
	
	public void goToInsertionLinkedListPage()
	{
		insertionlinkedlistelement.click();
		//logger.info("click on" +insertionlinkedlistelement.getText());
	}
	
	
	public void goToDeletionLinkedListPage()
	{
		deletionlinkedlistelement.click();
		//logger.info("click on" +deletionlinkedlistelement.getText());
	}
	
	public String getAlertMessage()
	{
		
		String message=driver.switchTo().alert().getText();
		System.out.println("Alert message is:"+message);
		driver.switchTo().alert().accept();
		return message;
	}
	
	
	public void goToPracticeQuestionsPage()
	{
		practicequestionselement.click();
	
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
		Actions actions = new Actions(driver);
		actions.click(codeEditorElement).keyDown(Keys.CONTROL)
	    .sendKeys("a")
	    .keyUp(Keys.CONTROL)
	    .sendKeys(Keys.DELETE).build().perform();
		actions.sendKeys(codeEditorElement, inputText).perform();
		//logger.info("passing text on texteditior");
//		element.sendKeys("hello");
		runElement.click();
		
		
	}
	
	public String getOutputMessage() {
		return outputElement.getText();
	}
	
	public void launchLinkedlistPage() {
		driver.get("https://dsportalapp.herokuapp.com/linked-list/");
	}
	
	
}
