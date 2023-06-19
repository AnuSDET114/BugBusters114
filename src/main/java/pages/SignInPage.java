package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage 
{
	WebDriver driver;
	
	public SignInPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}	

	@FindBy(name="username")
	WebElement usernameElement;
	
	@FindBy(name="password")
	WebElement passwordElement;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement loginElement;
	
	public void login(String userName, String password) {
		
		usernameElement.sendKeys(userName);
		passwordElement.sendKeys(password);
		loginElement.click();
	}
	
	public HomePage successfullSignIn(String userName, String password) {
		login(userName, password);
		HomePage HomePage = new HomePage(driver);
		return HomePage;
	}
	@FindBy(css=".alert.alert-primary")
	WebElement errorMessage;
	
	@FindBy(css="a[href='/register']")
	WebElement registerelement;
	
	public String getAlertMessage()
	{
		
		return errorMessage.getText();
	}
	
	public  RegisterPage goToRegisterPage()
	{
		
		registerelement.click();
		RegisterPage registerPage=new RegisterPage(driver); 
		registerPage.WaitUntilPageIsFound(driver);
		return registerPage;
	}
	
	}
	

