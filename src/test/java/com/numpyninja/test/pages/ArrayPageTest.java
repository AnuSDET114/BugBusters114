package com.numpyninja.test.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.ArrayPage;
import pages.HomePage;
import pages.LinkedListpage;
import pages.SignInPage;
import utilities.ExcelReader;

public class ArrayPageTest extends BaseTest
{
	ExcelReader excelReader;
	HomePage homepage;
	public static Logger logger = LogManager.getLogger(ArrayPageTest.class);
	
	@BeforeTest
	public void initializeReader()
	{
		launchURL();
		homepage=new HomePage(driver);
		SignInPage  signinpage =homepage.gotoLoginPage();
		signinpage.successfullSignIn("sunandab", "sunasdet112");
		
		excelReader = new ExcelReader("array", readConfig.getExcelPath());
	}
	
	
	@Test
	public void TestValidPythoncodeOfArraysInPythonPage()
	{
		HomePage homePage=new HomePage(driver);
		ArrayPage arraypage = homePage.goToArrayPage();
		arraypage.goToArraysInPythonPage();
		logger.info("logger is on introduction page");
		arraypage.goToTryEditorPage();
		logger.info("loggeris redirected to tryeditor page");
		arraypage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 0, "pythonCode"));
		String outputmessage=arraypage.getOutputMessage();
		logger.info("after clicking on run button ouput message is:" +outputmessage);
		Assert.assertEquals(outputmessage,excelReader.getGivenColumnFromExcel(0, "Result"));
	}
	
	@Test
	public void TestInValidPythoncodeOfArraysInPythonPage()
	{
		HomePage homePage=new HomePage(driver);
		ArrayPage arraypage = homePage.goToArrayPage();
		arraypage.goToArraysInPythonPage();
		arraypage.goToTryEditorPage();
		arraypage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 1, "pythonCode"));
		String alertMessage=arraypage.getAlertMessage();
		logger.info("after clicking on run button ouput message is:" +alertMessage);
		Assert.assertEquals(alertMessage,excelReader.getGivenColumnFromExcel(1, "Result"));
	}
	
	@Test
	public void TestValidPythonCodeOfArraysUsingListPage()
	{
		HomePage homePage=new HomePage(driver);
		ArrayPage arraypage = homePage.goToArrayPage();
		arraypage.goToArraysUsingListPage();
		arraypage.goToTryEditorPage();
		arraypage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 2, "pythonCode"));
		String outputmessage=arraypage.getOutputMessage();
		logger.info("after clicking on run button ouput message is:" +outputmessage);
		Assert.assertEquals(outputmessage,excelReader.getGivenColumnFromExcel(2, "Result"));
	}
	
	@Test
	public void TestInValidPythoncodeOfArraysUsingListPage()
	{
		HomePage homePage=new HomePage(driver);
		ArrayPage arraypage = homePage.goToArrayPage();
		arraypage.goToArraysUsingListPage();
		arraypage.goToTryEditorPage();
		arraypage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 1, "pythonCode"));
		String alertMessage=arraypage.getAlertMessage();
		logger.info("after clicking on run button ouput message is:" +alertMessage);
		Assert.assertEquals(alertMessage,excelReader.getGivenColumnFromExcel(1, "Result"));
	}
	
	@Test
	public void TestValidPythonCodeOfBasicOperationsInListsPage()
	{
		HomePage homePage=new HomePage(driver);
		ArrayPage arraypage = homePage.goToArrayPage();
		arraypage.goToBasicOperationsInListsPage();
		arraypage.goToTryEditorPage();
		arraypage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel(2, "pythonCode"));
		String outputmessage=arraypage.getOutputMessage();
		logger.info("after clicking on run button ouput message is:" +outputmessage);
		Assert.assertEquals(outputmessage,excelReader.getGivenColumnFromExcel(2, "Result"));
	}
	
	@Test
	public void TestInValidPythoncodeOfBasicOperatinsInListsPage()
	{
		HomePage homePage=new HomePage(driver);
		ArrayPage arraypage = homePage.goToArrayPage();
		arraypage.goToBasicOperationsInListsPage();
		arraypage.goToTryEditorPage();
		arraypage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel(1, "pythonCode"));
		String alertMessage=arraypage.getAlertMessage();
		logger.info("after clicking on run button ouput message is:" +alertMessage);
		Assert.assertEquals(alertMessage,excelReader.getGivenColumnFromExcel(1, "Result"));
	}
	
	@Test
	public void TestvalidPhythoncodeOfApplicationsOfArrayPage()
	{
		HomePage homePage=new HomePage(driver);
		ArrayPage arraypage = homePage.goToArrayPage();
		arraypage.goToApplicationsOfArrayPage();
		arraypage.goToTryEditorPage();
		
		arraypage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 0, "pythonCode"));
		String outputmessage=arraypage.getOutputMessage();
		logger.info("after clicking on run button ouput message is:" +outputmessage);
		Assert.assertEquals(outputmessage,excelReader.getGivenColumnFromExcel(0, "Result"));
	}
	
	@Test
	public void TestInValidPythoncodeOfApplicationsOfArrayPage()
	{
		HomePage homePage=new HomePage(driver);
		ArrayPage arraypage = homePage.goToArrayPage();
		arraypage.goToApplicationsOfArrayPage();
		arraypage.goToTryEditorPage();
		arraypage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 1, "pythonCode"));
		String alertMessage=arraypage.getAlertMessage();
		logger.info("after clicking on run button ouput message is:" +alertMessage);
		Assert.assertEquals(alertMessage,excelReader.getGivenColumnFromExcel(1, "Result"));
	}

	
	
	


	
	
	


}
