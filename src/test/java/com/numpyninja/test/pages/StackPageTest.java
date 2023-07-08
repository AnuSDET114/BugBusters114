package com.numpyninja.test.pages;


import org.testng.annotations.Test;
import org.testng.AssertJUnit;
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
	StackPage stackpage;
	public static Logger logger = LogManager.getLogger(StackPageTest.class);
	
	@BeforeTest
	public void initializeReader()
	{
	
		HomePage homepage=new HomePage(driver);
		homepage.launchHomePage();
		stackpage=homepage.goToStackPage();
//		SignInPage  signinpage =homepage.gotoLoginPage();
//		signinpage.successfullSignIn("sunandab", "sunasdet112");
		
		excelReader = new ExcelReader("stack", readConfig.getExcelPath());
	}
	
	
	@Test(priority=1)
	public void TestValidPythoncodeOfOperationsInStackPage()
	{
		stackpage.goToOperationsInStackPage();
		logger.info("logger is on OperationsInStack page");
		stackpage.goToTryEditorPage();
		logger.info("logger is redirected to tryeditor page");
		stackpage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 0, "pythonCode"));
		String outputmessage=stackpage.getOutputMessage();
		logger.info("after clicking on run button ouput message is:" +outputmessage);
		AssertJUnit.assertEquals(outputmessage,excelReader.getGivenColumnFromExcel(0, "Result"));
	}
	
	@Test(priority=2)
	public void TestInValidPythoncodeOfOperationsInStackPage()
	{
		//stackpage.goToOperationsInStackPage();
		//stackpage.goToTryEditorPage();
		stackpage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 1, "pythonCode"));
		String alertMessage=stackpage.getAlertMessage();
		logger.info("after clicking on run button ouput message is:" +alertMessage);
		AssertJUnit.assertEquals(alertMessage,excelReader.getGivenColumnFromExcel(1, "Result"));
	}
	
	@Test(priority=3)
	public void TestValidPythonCodeOfImplementationPage()
	{
		stackpage.launchstackpage();
		stackpage.goToImplementationPage();
		stackpage.goToTryEditorPage();
		stackpage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 2, "pythonCode"));
		String outputmessage=stackpage.getOutputMessage();
		logger.info("after clicking on run button ouput message is:" +outputmessage);
		AssertJUnit.assertEquals(outputmessage,excelReader.getGivenColumnFromExcel(2, "Result"));
	}
	
	@Test(priority=4)
	public void TestInValidPythoncodeOfImplementationPage()
	{
		//stackpage.goToImplementationPage();
		//stackpage.goToTryEditorPage();
		stackpage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 1, "pythonCode"));
		String alertMessage = stackpage.getAlertMessage();
		logger.info("after clicking on run button ouput message is:" +alertMessage);
		AssertJUnit.assertEquals(alertMessage,excelReader.getGivenColumnFromExcel(1, "Result"));
	}
	
	
	@Test(priority=5)
	public void TestValidPythonCodeOfApplicationsPage()
	{	
		stackpage.launchstackpage();
		stackpage.goToApplicationsPage();
		stackpage.goToTryEditorPage();
		stackpage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel(2, "pythonCode"));
		String outputmessage=stackpage.getOutputMessage();
		logger.info("after clicking on run button ouput message is:" +outputmessage);
		AssertJUnit.assertEquals(outputmessage,excelReader.getGivenColumnFromExcel(2, "Result"));
	}
	
	@Test(priority=6)
	public void TestInValidPythoncodeOfApplicationsPage()
	{
		//stackpage.goToApplicationsPage();
		//stackpage.goToTryEditorPage();
		stackpage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 1, "pythonCode"));
		String alertMessage=stackpage.getAlertMessage();
		logger.info("after clicking on run button ouput message is:" +alertMessage);
		AssertJUnit.assertEquals(alertMessage,excelReader.getGivenColumnFromExcel(1, "Result"));
	}
	@Test(priority=7)
	public void TestpracticeQuestionsPage()
	{	
		stackpage.launchstackpage();
		stackpage.goToOperationsInStackPage();
		stackpage.goToPracticeQuestionsPage();
		String pageTitle=driver.getTitle();
		AssertJUnit.assertEquals("Practice Questions",pageTitle);

	}

}
