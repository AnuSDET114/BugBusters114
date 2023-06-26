package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
	public static Logger logger = LogManager.getLogger(SignInPage.class);

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
		logger.info("user redirected to homepage");
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
		logger.info("click on" +registerelement.getText()+ "in siginpage");
		RegisterPage registerPage=new RegisterPage(driver); 
		registerPage.WaitUntilPageIsFound(driver);
		return registerPage;
	}
	
	}
	

