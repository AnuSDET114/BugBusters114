package com.numpyninja.pages;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class HomePage {
	WebDriver driver;
	
	public static Logger logger = LogManager.getLogger(HomePage.class);

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='data-structures-introduction']")
	WebElement dataStructuresGetStartedElement;
	
	@FindBy(xpath = "//a[@href='array']")
	WebElement arrayGetStartedElement;
	
	@FindBy(xpath = "//a[@href='linked-list']")
	WebElement linkedListGetStartedElement;
	
	@FindBy(xpath = "//a[@href='stack']")
	WebElement stackGetStartedElement;
	
	@FindBy(xpath = "//a[@href='queue']")
	WebElement queueGetStartedElement;
	
	@FindBy(xpath = "//a[@href='tree']")
	WebElement treeGetStartedElement;
	
	@FindBy(xpath = "//a[@href='graph']")
	WebElement graphGetStartedElement;

	@FindBy(css = ".nav-link.dropdown-toggle")
	WebElement dropDown;

	@FindBy(xpath = "//a[@href='/array']")
	WebElement array;

	@FindBy(xpath = "//a[@href='/linked-list']")
	WebElement linkedlistelement;
	
	@FindBy(xpath = "//a[@href='/stack']")
	WebElement stackelement;

	@FindBy(xpath = "//a[@href='/register']")
	WebElement registerElement;

	@FindBy(xpath = "//a[@href='/login']")
	WebElement signInElement;

	@FindBy(css = ".alert.alert-primary")
	WebElement errorMessage;

	@FindBy(css = "a[href='/register']")
	WebElement registerelement;

	@FindBy(css = "a[href='/graph']")
	WebElement graphelement;
	
	@FindBy(css = "a[href='/tree']")
	WebElement treeelement;

	@FindBy(css = "a[href='/queue']")
	WebElement queuelement;
	
	@FindBy(className = "btn")
	WebElement getStartedBtn;
	
	
	public void clickOnLaunchURLGetStartedButton() {
		getStartedBtn.click();
	}

	public DataStructuresPage goToDataStructuresPage()
	{
		dataStructuresGetStartedElement.click();
		DataStructuresPage datastructurespage = new DataStructuresPage(driver);
		return datastructurespage;
	}
	
	public void clickOnGetStartedButton(String optionName) {
		
		switch(optionName) {
		case "DataStructures":
			dataStructuresGetStartedElement.click();
			break;
		case "Arrays":
			arrayGetStartedElement.click();
			break;
		case "Linkedlist":
			linkedListGetStartedElement.click();
			break;
		case "Stack":
			stackGetStartedElement.click();
			break;
		case "Queue":
			queueGetStartedElement.click();
			break;
		case "Tree":
			treeGetStartedElement.click();
			break;
		case "Graph":
			graphGetStartedElement.click();
			break;
		
		
	}
		
	}
	
	public ArrayPage goToArrayPage() {
		dropDown();
		array.click();
		ArrayPage arraypage = new ArrayPage(driver);
		return arraypage;
	}

	public LinkedListpage goToLinkedListPage() {
		dropDown();
		linkedlistelement.click();
		LinkedListpage linkedListpage = new LinkedListpage(driver);
		return linkedListpage;
	}
	
	public StackPage goToStackPage() {
		dropDown();
		stackelement.click();
		StackPage stackpage = new StackPage(driver);
		return stackpage;
	}
	

	public TreePage goToTreePage() {
		dropDown();
		treeelement.click();
		TreePage treepage = new TreePage(driver);
		return treepage;
	}
	

	public GraphPage goToGraphPage()
	{
		dropDown();
		graphelement.click();
		GraphPage graphpage = new GraphPage(driver);
		return graphpage;
	}

	public QueuePage goToQueuePage()
	{
		dropDown();
		queuelement.click();
		QueuePage queuepage = new QueuePage(driver);
		return queuepage;
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
		case "Stack":
			stackelement.click();
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
		logger.info("Click on "+signInElement.getText()+" link on Home page");
		signInElement.click();
		logger.info("Title of the login page is "+driver.getTitle());
		SignInPage signin = new SignInPage(driver);
		return signin;

	}

	public String getAlertMessage() {
		return errorMessage.getText();

	}

	public void dropDownArray() {
		logger.info("Click on "+dropDown.getText());
		array.click();
	}

	public RegisterPage goToRegisterPage() {
		logger.info("Click on "+registerelement.getText()+" link on register page");
		registerelement.click();
		RegisterPage registerPage = new RegisterPage(driver);
		registerPage.WaitUntilPageIsFound(driver);
		return registerPage;
	}
	
	public void launchHomePage() {
		driver.get("https://dsportalapp.herokuapp.com/home");
	}

}
