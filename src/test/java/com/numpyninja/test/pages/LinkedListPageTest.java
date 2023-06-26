package com.numpyninja.test.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.LinkedListpage;
import pages.SignInPage;
import utilities.ExcelReader;

public class LinkedListPageTest extends BaseTest
{
	
	ExcelReader excelReader;
	HomePage homepage;
	public static Logger logger = LogManager.getLogger(LinkedListPageTest.class);
	
	@BeforeTest
	public void initializeReader()
	{
		launchURL();
		homepage=new HomePage(driver);
		SignInPage  signinpage =homepage.gotoLoginPage();
		signinpage.successfullSignIn("sunandab", "sunasdet112");
		
		excelReader = new ExcelReader("linkedList", readConfig.getExcelPath());
	}
	
@Test
public void TestValidPythoncodeOfIntroductionPage()
{
	HomePage homePage=new HomePage(driver);
	LinkedListpage linkedListpage = homePage.goToLinkedListPage();
	linkedListpage.goToIntroductionPage();
	logger.info("logger is on introduction page");
	linkedListpage.goToTryEditorPage();
	logger.info("loggeris redirected to tryeditor page");
	linkedListpage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 0, "pythonCode"));
	String outputmessage=linkedListpage.getOutputMessage();
	logger.info("after clicking on run button ouput message is:" +outputmessage);
	Assert.assertEquals(outputmessage,excelReader.getGivenColumnFromExcel(0, "Result"));
}

@Test
public void TestInValidPythoncodeOfIntroductionPage()
{
	HomePage homePage=new HomePage(driver);
	LinkedListpage linkedListpage = homePage.goToLinkedListPage();
	linkedListpage.goToIntroductionPage();
	linkedListpage.goToTryEditorPage();
	linkedListpage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 1, "pythonCode"));
	String alertMessage=linkedListpage.getAlertMessage();
	logger.info("after clicking on run button ouput message is:" +alertMessage);
	Assert.assertEquals(alertMessage,excelReader.getGivenColumnFromExcel(1, "Result"));
}


@Test
public void TestValidPythonCodeOfCreateALinkedListsPage()
{
	HomePage homePage=new HomePage(driver);
	LinkedListpage linkedListpage = homePage.goToLinkedListPage();
	linkedListpage.goToCreateALinkedListPage();
	linkedListpage.goToTryEditorPage();
	linkedListpage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 2, "pythonCode"));
	String outputmessage=linkedListpage.getOutputMessage();
	logger.info("after clicking on run button ouput message is:" +outputmessage);
	Assert.assertEquals(outputmessage,excelReader.getGivenColumnFromExcel(2, "Result"));
}

@Test
public void TestInValidPythoncodeOfCreateALinkedListPage()
{
	HomePage homePage=new HomePage(driver);
	LinkedListpage linkedListpage = homePage.goToLinkedListPage();
	linkedListpage.goToCreateALinkedListPage();
	linkedListpage.goToTryEditorPage();
	linkedListpage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 1, "pythonCode"));
	String alertMessage = linkedListpage.getAlertMessage();
	logger.info("after clicking on run button ouput message is:" +alertMessage);
	Assert.assertEquals(alertMessage,excelReader.getGivenColumnFromExcel(1, "Result"));
}






@Test
public void TestValidPythonCodeOfTypesofLinkedListsPage()
{
	HomePage homePage=new HomePage(driver);
	LinkedListpage linkedListpage = homePage.goToLinkedListPage();
	linkedListpage.goToTypesofLinkedListPage();
	linkedListpage.goToTryEditorPage();
	linkedListpage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel(2, "pythonCode"));
	String outputmessage=linkedListpage.getOutputMessage();
	logger.info("after clicking on run button ouput message is:" +outputmessage);
	Assert.assertEquals(outputmessage,excelReader.getGivenColumnFromExcel(2, "Result"));
}

@Test
public void TestInValidPythoncodeOfTypesofLinkedListPage()
{
	HomePage homePage=new HomePage(driver);
	LinkedListpage linkedListpage = homePage.goToLinkedListPage();
	linkedListpage.goToTypesofLinkedListPage();
	linkedListpage.goToTryEditorPage();
	linkedListpage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 1, "pythonCode"));
	String alertMessage=linkedListpage.getAlertMessage();
	logger.info("after clicking on run button ouput message is:" +alertMessage);
	Assert.assertEquals(alertMessage,excelReader.getGivenColumnFromExcel(1, "Result"));
}




@Test
public void TestvalidPhythoncodeOfImplementedLinkedListsPage()
{
	HomePage homePage=new HomePage(driver);
	LinkedListpage linkedListpage = homePage.goToLinkedListPage();
	linkedListpage.goToImplementedLinkedListPage();
	linkedListpage.goToTryEditorPage();
	
	linkedListpage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 0, "pythonCode"));
	String outputmessage=linkedListpage.getOutputMessage();
	logger.info("after clicking on run button ouput message is:" +outputmessage);
	Assert.assertEquals(outputmessage,excelReader.getGivenColumnFromExcel(0, "Result"));
}

@Test
public void TestInValidPythoncodeOfImplementedLinkedListPage()
{
	HomePage homePage=new HomePage(driver);
	LinkedListpage linkedListpage = homePage.goToLinkedListPage();
	linkedListpage.goToImplementedLinkedListPage();
	linkedListpage.goToTryEditorPage();
	linkedListpage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 1, "pythonCode"));
	String alertMessage=linkedListpage.getAlertMessage();
	logger.info("after clicking on run button ouput message is:" +alertMessage);
	Assert.assertEquals(alertMessage,excelReader.getGivenColumnFromExcel(1, "Result"));
}


@Test
public void TestValidPhythoncodeOfTraversalLinkedListsPage()
{
	HomePage homePage=new HomePage(driver);
	LinkedListpage linkedListpage = homePage.goToLinkedListPage();
	linkedListpage.goToTraversalLinkedListPage();
	linkedListpage.goToTryEditorPage();
	linkedListpage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 2, "pythonCode"));
	String outputmessage=linkedListpage.getOutputMessage();
	logger.info("after clicking on run button ouput message is:" +outputmessage);
	Assert.assertEquals(outputmessage,excelReader.getGivenColumnFromExcel(2, "Result"));
}

@Test
public void TestInValidPythoncodeOfTraversalLinkedListPage()
{
	HomePage homePage=new HomePage(driver);
	LinkedListpage linkedListpage = homePage.goToLinkedListPage();
	linkedListpage.goToTraversalLinkedListPage();
	linkedListpage.goToTryEditorPage();
	linkedListpage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 3, "pythonCode"));
	String alertMessage=linkedListpage.getAlertMessage();
	logger.info("after clicking on run button ouput message is:" +alertMessage);
	Assert.assertEquals(alertMessage,excelReader.getGivenColumnFromExcel(3, "Result"));
}


@Test
public void TestValidPythoncodeOfInsertionLinkedListsPage()
{
	HomePage homePage=new HomePage(driver);
	LinkedListpage linkedListpage = homePage.goToLinkedListPage();
	linkedListpage.goToInsertionLinkedListPage();
	linkedListpage.goToTryEditorPage();
	linkedListpage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel(0, "pythonCode"));
	String outputmessage=linkedListpage.getOutputMessage();
	logger.info("after clicking on run button ouput message is:" +outputmessage);
	Assert.assertEquals(outputmessage,excelReader.getGivenColumnFromExcel(0, "Result"));
}

@Test
public void TestInValidPythoncodeOfInsertionLinkedListPage()
{
	HomePage homePage=new HomePage(driver);
	LinkedListpage linkedListpage = homePage.goToLinkedListPage();
	linkedListpage.goToInsertionLinkedListPage();
	linkedListpage.goToTryEditorPage();
	linkedListpage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 3, "pythonCode"));
	String alertMessage=linkedListpage.getAlertMessage();
	logger.info("after clicking on run button ouput message is:" +alertMessage);
	Assert.assertEquals(alertMessage,excelReader.getGivenColumnFromExcel(3, "Result"));
}


@Test
public void TestValidPhythoncodeOfDeletionLinkedListsPage()
{
	HomePage homePage=new HomePage(driver);
	LinkedListpage linkedListpage = homePage.goToLinkedListPage();
	linkedListpage.goToDeletionLinkedListPage();
	linkedListpage.goToTryEditorPage();
	linkedListpage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel(2, "pythonCode"));
	String outputmessage=linkedListpage.getOutputMessage();
	logger.info("after clicking on run button ouput message is:" +outputmessage);
	Assert.assertEquals(outputmessage,excelReader.getGivenColumnFromExcel(2, "Result"));
}

@Test
public void TestInValidPythoncodeOfDeletionLinkedListPage()
{
	HomePage homePage=new HomePage(driver);
	LinkedListpage linkedListpage = homePage.goToLinkedListPage();
	linkedListpage.goToDeletionLinkedListPage();
	linkedListpage.goToTryEditorPage();
	linkedListpage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel(3, "pythonCode"));
	String alertMessage=linkedListpage.getAlertMessage();
	logger.info("after clicking on run button ouput message is:" +alertMessage);
	Assert.assertEquals(alertMessage,excelReader.getGivenColumnFromExcel(3, "Result"));
}
}


