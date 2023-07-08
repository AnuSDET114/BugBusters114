package com.numpyninja.test.pages;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import utilities.ExcelReader;

public class HomePageTest extends BaseTest
{
	
	public static Logger logger = LogManager.getLogger(HomePageTest.class);
	
	HomePage homePage = null;
	
	ExcelReader	excelReader;
	
	@BeforeTest
	public void initialize() {
		homePage = new HomePage(driver);
		excelReader = new ExcelReader("homepage", readConfig.getExcelPath());
	}
	
	@Test(priority = 1)
	public void clickOnGetStartedOnLaunchPage() {
		homePage.clickOnLaunchURLGetStartedButton();
	}
	
	@Test(priority = 2, dataProvider = "getStartedOptionsData")
	public void clickOnGetStartedButtonsWithOutLogin(String getStartedOption)
	{
//		HomePage homePage=new HomePage(driver);
		homePage.clickOnGetStartedButton(getStartedOption);
		logger.info("user redirected to  page");
		Assert.assertEquals("You are not logged in",homePage.getAlertMessage());
	}
	@Test(priority = 3, dataProvider = "testData")
	public void performDropDownWithOutLogin(String dropDownName)
	{
//		HomePage homePage=new HomePage(driver);
		switch(dropDownName) {
		case "DataStructures":
			homePage.goToDataStructuresPage();
			break;
		case "Arrays":
			homePage.goToArrayPage();
			break;
		case "Linkedlist":
			homePage.goToLinkedListPage();
			break;
		case "Stack":
			homePage.goToStackPage();
			break;
		case "Queue":
			homePage.goToQueuePage();
			break;
		case "Tree":
			homePage.goToTreePage();
			break;
		case "Graph":
			homePage.goToGraphPage();
			break;
		
		
	}
		logger.info("click on dropdown:" +homePage.getAlertMessage());
		Assert.assertEquals("You are not logged in",homePage.getAlertMessage());
	}
	
	@Test(priority = 5)
	public void gotoRegisterPage()
	{
//		HomePage homePage = new HomePage(driver);
		logger.info("user redirected to register page");
		homePage.register();
		
	}
	@Test (priority = 4)
	public void login()
	{
		
//		HomePage homePage = new HomePage(driver);
		logger.info("User redirecting to login page");
		homePage.gotoLoginPage();
		
	}
	
	@DataProvider(name="testData")
	public Object[][] testData(){
	
	int rows = excelReader.getRowCount()-1;
	Object[][]dropDownList = new Object[rows][1];

	for(int i=0;i<rows;i++)
	{
		dropDownList[i][0] = excelReader.getGivenColumnFromExcel(i, "options");
	
	}
	
	return dropDownList;
	}
	
	
	@DataProvider(name="getStartedOptionsData")
	public Object[][] getStartedOptions(){
	int rows = excelReader.getRowCount();
	Object[][]dropDownList = new Object[rows][1];

	for(int i=0;i<rows;i++)
	{
		dropDownList[i][0] = excelReader.getGivenColumnFromExcel(i, "getStartedOptions");
	
	}
	
	return dropDownList;
	}
	
}