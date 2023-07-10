package com.numpyninja.pages;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ArrayPage 
{
WebDriver driver;
public static Logger logger = LogManager.getLogger(ArrayPage.class);
		
		public ArrayPage(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver,this);
		}	

		@FindBy(xpath = "//a[contains(text(),'Arrays in Python')]")
		WebElement arraysinpython;
		
		@FindBy(xpath = "//a[contains(text(),'Arrays Using List')]")
		WebElement arraysusinglist;
		
		@FindBy(xpath = "//a[contains(text(),'Basic Operations in Lists')]")
		WebElement basicoperationsinlists;
		
		@FindBy(xpath = "//a[contains(text(),'Applications of Array')]")
		WebElement applicationsofarray;
		
		@FindBy(css = "a[href='/array/practice']")
		WebElement practicequestionselement;
		
		@FindBy(css = "a[href='/question/1']")
		WebElement searchthearrayelement;
																
		@FindBy(css = "a[href='/question/2']")
		WebElement maxconsecutiveoneselement;
		
		@FindBy(css = "a[href='/question/3']")
		WebElement findnumberswithevennumberofdigitselement;
		
		@FindBy(css = "a[href='/question/4']")
		WebElement squaresofsortedarrayelement;
		
		@FindBy(xpath = "//a[contains(text(),'Try here>>>')]")
		WebElement tryeditorelement;
		
		@FindBy(css=".CodeMirror-line")
		WebElement codeEditorElement;
		
		@FindBy(css = "button[type='button']")
		WebElement runElement;
		
		@FindBy(css = "input[type='Submit']")
		WebElement submitElement;
		
		@FindBy(id = "output")
		WebElement outputElement;
		
		public void goToArraysInPythonPage()
		{	
			arraysinpython.click();
			//logger.info("click on" +arrraysinpython.getText());
		}
		public void goToArraysUsingListPage()
		{
			launchArrayPage();
			arraysusinglist.click();
			//logger.info("click on" +arrraysusinglist.getText());
		}
		
		public void goToBasicOperationsInListsPage()
		{
			launchArrayPage();
			basicoperationsinlists.click();
			//logger.info("click on" +basicoperationsinlists.getText());
		}
		
		public void goToApplicationsOfArrayPage()
		{
			launchArrayPage();
			applicationsofarray.click();
			//logger.info("click on" +applicationsofarray.getText());
		}
		
		public void goToPracticeQuestionsPage()
		{
			practicequestionselement.click();
		
		}
		
		public void goToSearchTheArrayPage()
		{
			searchthearrayelement.click();
		
		}
		
		public void goToMaxConsecutiveOnesPage()
		{
			maxconsecutiveoneselement.click();
		
		}
		
		public void goToFindNumberWithEvenofDigitsPage()
		{
			findnumberswithevennumberofdigitselement.click();
		
		}
		
		public void goToSquaresOfSortedArrayPage()
		{
			squaresofsortedarrayelement.click();
		
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
		
		public void sendTextToEditorAndRun(String inputText,String buttonName) {
			
//			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//			WebElement element = wait.until(
//			ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".codemirror-line")));
			Actions actions = new Actions(driver);
			actions.click(codeEditorElement).keyDown(Keys.CONTROL)
		    .sendKeys("a")
		    .keyUp(Keys.CONTROL)
		    .sendKeys(Keys.DELETE).build().perform();
			actions.sendKeys(codeEditorElement, inputText).perform();
			//logger.info("passing text on texteditior");
//			element.sendKeys("hello");
			if(buttonName.equalsIgnoreCase("run"))
			{
				runElement.click();
			}else {
				submitElement.click();
			}
			
			
			
		}
		
		
		public String getOutputMessage() {
			return outputElement.getText();
		}
		
		public void launchArrayPage() {
			driver.get("https://dsportalapp.herokuapp.com/array/");
		}
		
		public void launchPracticeQuestionsPage() {
			driver.get("https://dsportalapp.herokuapp.com/array/practice");
		}
		
		public void waitUntilElementVisible() {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));    
			wait.until(ExpectedConditions.visibilityOf(outputElement));
		}
		
		
}
