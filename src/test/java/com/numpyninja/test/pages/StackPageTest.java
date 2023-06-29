package com.numpyninja.test.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.SignInPage;
import pages.StackPage;
import utilities.ExcelReader;

public class StackPageTest extends BaseTest 
{
	
	ExcelReader excelReader;
	HomePage homepage;
	public static Logger logger = LogManager.getLogger(StackPageTest.class);
	
	@BeforeTest
	public void initializeReader()
	{
		launchURL();
		homepage=new HomePage(driver);
		SignInPage  signinpage =homepage.gotoLoginPage();
		signinpage.successfullSignIn("sunandab", "sunasdet112");
		
		excelReader = new ExcelReader("stack", readConfig.getExcelPath());
	}
	
	
	@Test
	public void TestValidPythoncodeOfOperationsInStackPage()
	{
		HomePage homePage=new HomePage(driver);
		StackPage stackpage = homePage.goToStackPage();
		stackpage.goToOperationsInStackPage();
		logger.info("logger is on OperationsInStack page");
		stackpage.goToTryEditorPage();
		logger.info("logger is redirected to tryeditor page");
		stackpage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 0, "pythonCode"));
		String outputmessage=stackpage.getOutputMessage();
		logger.info("after clicking on run button ouput message is:" +outputmessage);
		Assert.assertEquals(outputmessage,excelReader.getGivenColumnFromExcel(0, "Result"));
	}
	
	@Test
	public void TestInValidPythoncodeOfOperationsInStackPage()
	{
		HomePage homePage=new HomePage(driver);
		StackPage stackpage = homePage.goToStackPage();
		stackpage.goToOperationsInStackPage();
		stackpage.goToTryEditorPage();
		stackpage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 1, "pythonCode"));
		String alertMessage=stackpage.getAlertMessage();
		logger.info("after clicking on run button ouput message is:" +alertMessage);
		Assert.assertEquals(alertMessage,excelReader.getGivenColumnFromExcel(1, "Result"));
	}
	
	@Test
	public void TestValidPythonCodeOfImplementationPage()
	{
		HomePage homePage=new HomePage(driver);
		StackPage stackpage = homePage.goToStackPage();
		stackpage.goToImplementationPage();
		stackpage.goToTryEditorPage();
		stackpage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 2, "pythonCode"));
		String outputmessage=stackpage.getOutputMessage();
		logger.info("after clicking on run button ouput message is:" +outputmessage);
		Assert.assertEquals(outputmessage,excelReader.getGivenColumnFromExcel(2, "Result"));
	}
	
	@Test
	public void TestInValidPythoncodeOfImplementationPage()
	{
		HomePage homePage=new HomePage(driver);
		StackPage stackpage = homePage.goToStackPage();
        stackpage.goToImplementationPage();
		stackpage.goToTryEditorPage();
		stackpage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 1, "pythonCode"));
		String alertMessage = stackpage.getAlertMessage();
		logger.info("after clicking on run button ouput message is:" +alertMessage);
		Assert.assertEquals(alertMessage,excelReader.getGivenColumnFromExcel(1, "Result"));
	}
	
	
	@Test
	public void TestValidPythonCodeOfApplicationsPage()
	{
		HomePage homePage=new HomePage(driver);
		StackPage stackpage = homePage.goToStackPage();
		stackpage.goToApplicationsPage();
		stackpage.goToTryEditorPage();
		stackpage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel(2, "pythonCode"));
		String outputmessage=stackpage.getOutputMessage();
		logger.info("after clicking on run button ouput message is:" +outputmessage);
		Assert.assertEquals(outputmessage,excelReader.getGivenColumnFromExcel(2, "Result"));
	}
	
	@Test
	public void TestInValidPythoncodeOfApplicationsPage()
	{
		HomePage homePage=new HomePage(driver);
		StackPage stackpage = homePage.goToStackPage();
		stackpage.goToApplicationsPage();
		stackpage.goToTryEditorPage();
		stackpage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 1, "pythonCode"));
		String alertMessage=stackpage.getAlertMessage();
		logger.info("after clicking on run button ouput message is:" +alertMessage);
		Assert.assertEquals(alertMessage,excelReader.getGivenColumnFromExcel(1, "Result"));
	}

}
