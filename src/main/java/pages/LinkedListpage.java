package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LinkedListpage 
{
WebDriver driver;
	
	public LinkedListpage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}	

	
	@FindBy(css = "a[href='introduction']")
	WebElement introductionelement;
	
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
	}
	
	public void goToTryEditorPage()
	{
		tryeditorelement.click();
	}
	
	public void sendTextToEditorAndRun(String inputText) {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		WebElement element = wait.until(
//		ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".codemirror-line")));
		new Actions(driver).sendKeys(codeEditorElement, inputText).perform();
//		element.sendKeys("hello");
		runElement.click();
		
		
	}
	
	public String getOutputMessage() {
		return outputElement.getText();
	}
	
}
