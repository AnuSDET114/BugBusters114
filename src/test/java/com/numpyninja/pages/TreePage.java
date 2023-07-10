package com.numpyninja.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TreePage 
{

	WebDriver driver;
	public static Logger logger = LogManager.getLogger(TreePage.class);
		
		public TreePage(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver,this);
		}	

		@FindBy(css = "a[href='overview-of-trees']")
		WebElement overviewoftreeslement;
		
		@FindBy(css = "a[href='terminologies']")
		WebElement terminologieselement;
		
		@FindBy(css = "a[href='types-of-trees']")
		WebElement typesoftreeselement;
		
		@FindBy(css = "a[href='tree-traversals']")
		WebElement treetraversalselement;
		
		@FindBy(css = "a[href='traversals-illustration']")
		WebElement traversalillustrationelement;
		
		@FindBy(css = "a[href='binary-trees']")
		WebElement binarytreeselement;
		
		@FindBy(css = "a[href='types-of-binary-trees']")
		WebElement typesofbinarytreeselement;
		
		@FindBy(css = "a[href='implementation-in-python']")
		WebElement implementationinphythonelement;
		
		@FindBy(css = "a[href='binary-tree-traversals']")
		WebElement binarytreetraversalelement;
		
		@FindBy(css = "a[href='implementation-of-binary-trees']")
		WebElement implementationofbinarytreeselement;
		
		@FindBy(css = "a[href='applications-of-binary-trees']")
		WebElement applicationsofofbinarytreeselement;
		
		@FindBy(css = "a[href='binary-search-trees']")
		WebElement binarysearchtreeselement;
		
		@FindBy(css = "a[href='implementation-of-bst']")
		WebElement implementationofbstelement;
		
		@FindBy(css = "a[href='/tree/practice']")
		WebElement practicequestionselement;
		
		@FindBy(css = "a[href='/tryEditor']")
		WebElement tryeditorelement;
		
		@FindBy(css=".codemirror-line")
		WebElement codeEditorElement;
		
		@FindBy(css = "button[type='button']")
		WebElement runElement;
		
		@FindBy(id = "output")
		WebElement outputElement;
		
		public void goToOverViewOftreesPage()
		{
			overviewoftreeslement.click();
			
		}
		public void goToTerminologiesPage()
		{
			terminologieselement.click();
			
		}
		public void goToTypesOfTreesPage()
		{
			typesoftreeselement.click();
			
		}
		public void goToTraversalIllustrationPage()
		{
			traversalillustrationelement.click();
			
		}
		
		public void goToBinaryTreesPage()
		{
			binarytreeselement.click();
			
		}
		public void goTOTypesOfBinaryTreesPage()
		{
			typesofbinarytreeselement.click();
			
		}
		public void goToImplementationinPythonPage()
		{
			implementationinphythonelement.click();
			
		}
		public void goToTreeTraversalsPage()
		{
			treetraversalselement.click();
			
		}
		
	
		public void goToBinaryTreeTraversalPage()
		{
			binarytreetraversalelement.click();
			
		}
		public void goToImplementationOfBinaryTreesPage()
		{
			implementationofbinarytreeselement.click();
			
		}
		
		public void goToApplicationOfBinaryTreespage()
		{
			implementationofbinarytreeselement.click();
			
		}
		
		
		public void goToBinarySearchTreesPage()
		{
			binarysearchtreeselement.click();
			
		}
		
		public void goToImplementationOfBSTPage()
		{
			implementationofbstelement.click();
		
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
		
		public String getOutputMessage() 
		{
			return outputElement.getText();
		}
		
		public void LaunchTreePage() {
			driver.get("https://dsportalapp.herokuapp.com/tree/");
		}
		
		
		
		
		
		
}
