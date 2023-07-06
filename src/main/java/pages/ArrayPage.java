package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
		
		@FindBy(xpath = "//a[contains(text(),'Practice Questions')]")
		WebElement practicequestions;
		
		@FindBy(xpath = "//a[contains(text(),'Search the array')]")
		WebElement searchthearray;
		
		@FindBy(xpath = "//a[contains(text(),'Max Consecutive Ones')]")
		WebElement maxconsecutiveones;
		
		@FindBy(xpath = "//a[contains(text(),'Find Numbers with Even Number of Digits')]")
		WebElement findNumberswithevenNumberofDigits;
		
		@FindBy(xpath = "//a[contains(text(),'a Sorted Array')]")
		WebElement squaresOfASortedArray;
		
		@FindBy(xpath = "//a[contains(text(),'Try here>>>')]")
		WebElement tryeditorelement;
		
		@FindBy(css=".CodeMirror-line")
		WebElement codeEditorElement;
		
		@FindBy(css = "button[type='button']")
		WebElement runElement;
		
		@FindBy(css = "input[value='Submit']")
		WebElement submit;
		
		@FindBy(id = "output")
		WebElement outputElement;
		
		public void goToArraysInPythonPage()
		{	
			arraysinpython.click();
			//logger.info("click on" +arrraysinpython.getText());
		}
		public void goToArraysUsingListPage()
		{
			arraysusinglist.click();
			//logger.info("click on" +arrraysusinglist.getText());
		}
		
		public void goToBasicOperationsInListsPage()
		{
			basicoperationsinlists.click();
			//logger.info("click on" +basicoperationsinlists.getText());
		}
		
		public void goToApplicationsOfArrayPage()
		{
			applicationsofarray.click();
			//logger.info("click on" +applicationsofarray.getText());
		}
		
		public void goToPracticeQuestionsPage()
		{
			practicequestions.click();
		}
		
		public void goToSearchTheArrayPage()
		{
			searchthearray.click();
		}
		
		public void goToMaxConsecutiveOnesPage()
		{
			maxconsecutiveones.click();
		}
		
		public void goToFindNumbersWithEvenNumberOfDigitsPage()
		{
			findNumberswithevenNumberofDigits.click();
		}
		
		public void goToSquaresOfASortedArrayPage()
		{
			squaresOfASortedArray.click();
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
//			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//			WebElement element = wait.until(
//			ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".codemirror-line")));
			new Actions(driver).sendKeys(codeEditorElement, inputText).perform();
			//logger.info("passing text on texteditior");
//			element.sendKeys("hello");
			runElement.click();
			
			
		}
		
		public void goToSubmitPage()
		{
			submit.click();
		}
		
		public String getOutputMessage() {
			return outputElement.getText();
		}
		
		
}
