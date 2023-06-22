package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='data-structures-introduction']")
	WebElement getStartedElement;

	@FindBy(css = ".nav-link.dropdown-toggle")
	WebElement dropDown;

	@FindBy(xpath = "//a[@href='/array']")
	WebElement array;

	@FindBy(xpath = "//a[@href='/linked-list']")
	WebElement linkedlistelement;

	@FindBy(xpath = "//a[@href='/register']")
	WebElement registerElement;

	@FindBy(xpath = "//a[@href='/login']")
	WebElement signInElement;

	@FindBy(css = ".alert.alert-primary")
	WebElement errorMessage;

	@FindBy(css = "a[href='/register']")
	WebElement registerelement;

	public void goToDataStructuresPage() {
		getStartedElement.click();
	}
	
	public LinkedListpage goToLinkedListPage() {
		SignInPage signInPage = gotoLoginPage();
		signInPage.successfullSignIn("sunandab", "sunasdet112");
		dropDown();
		linkedlistelement.click();
		LinkedListpage linkedListpage = new LinkedListpage(driver);
		return linkedListpage;
	}

	public void gotoPage(String pagename) {
		dropDown();
		switch (pagename) {
		case "linkedlist":
			linkedlistelement.click();

			break;
		case "Array":
			array.click();
			break;
		}
	}

	public void dropDown() {
		dropDown.click();
	}

	public void register() {
		registerElement.click();
	}

	public SignInPage gotoLoginPage() {
		signInElement.click();
		SignInPage signin = new SignInPage(driver);
		return signin;

	}

	public String getAlertMessage() {
		return errorMessage.getText();

	}

	public void dropDownArray() {
		array.click();
	}

	public RegisterPage goToRegisterPage() {

		registerelement.click();
		RegisterPage registerPage = new RegisterPage(driver);
		registerPage.WaitUntilPageIsFound(driver);
		return registerPage;
	}

}
