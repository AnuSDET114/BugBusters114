package pages;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class RegisterPage 
{
WebDriver driver;
public static Logger logger = LogManager.getLogger(RegisterPage.class);
	
	public RegisterPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}	
	
	@FindBy(name="username")
	WebElement usernameElement;
	
	@FindBy(name="password1")
	WebElement paswordElement;
	
	@FindBy(name="password2")
	WebElement cofirmationpaswordElement;
	
	@FindBy(css="input[type='submit']")
	WebElement registerlinkElement;
	
	@FindBy(css="a[href='/login']")
	WebElement loginlinkElement;
	
	@FindBy(css=".alert.alert-primary")
	WebElement errormessage1;
	
	
	
	public void performRegistrationPage(String userName,String password,String confirmationpassword)
	{
		usernameElement.sendKeys(userName);
//		if(password != null)
			paswordElement.sendKeys(password);
		
//		if(confirmationpassword != null)
			cofirmationpaswordElement.sendKeys(confirmationpassword);
		
		registerlinkElement.click();
		
	}
	public void clickOnRegister()
	{
		registerlinkElement.click();
		logger.info("click on" +registerlinkElement.getText());
	}
	public String getuserNameValidationMessage()
	{
		return usernameElement.getAttribute("validationMessage");
	}
	
	public String getPasswordValidationMessage()
	{
		return paswordElement.getAttribute("validationMessage");
	}
	
	public String getValidationMessage(String elementName)
	{
		switch(elementName)
		{
			case "userName": return usernameElement.getAttribute("validationMessage");
			case "password": return paswordElement.getAttribute("validationMessage");
			case "confirmationPassword" : return cofirmationpaswordElement.getAttribute("validationMessage");
		}
		return null;
	}
	
	
	
	public void WaitUntilPageIsFound(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(usernameElement));
	}
	
	public String getAlertMessage()
	{
		
		return errormessage1.getText();
	}
	
}