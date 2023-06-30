package com.numpyninja.test.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.QueuePage;
import pages.SignInPage;
import utilities.ExcelReader;

public class QueuePageTest extends BaseTest
{
	ExcelReader excelReader;
	HomePage homepage;
	public static Logger logger = LogManager.getLogger(QueuePageTest.class);
	
	@BeforeTest
	public void initializeReader()
	{
		launchURL();
		homepage=new HomePage(driver);
		SignInPage  signinpage =homepage.gotoLoginPage();
		signinpage.successfullSignIn("sunandab", "sunasdet112");
		
		excelReader = new ExcelReader("Queue", readConfig.getExcelPath());
	}
	
	@Test
	public void TestValidPythoncodeOfImplementationsListPage()
	{
		HomePage homePage=new HomePage(driver);
		QueuePage queuepage = homePage.goToQueuePage();
		queuepage.goToImplementationsListPage();
		logger.info("logger is on implementationqueuelist page");
		queuepage.goToTryEditorPage();
		logger.info("loggeris redirected to tryeditor page");
		queuepage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 0, "pythonCode"));
		String outputmessage=queuepage.getOutputMessage();
		logger.info("after clicking on run button ouput message is:" +outputmessage);
		Assert.assertEquals(outputmessage,excelReader.getGivenColumnFromExcel(0, "Result"));
	}

	@Test
	public void TestInValidPythoncodeOfImplementationListPage()
	{
		HomePage homePage=new HomePage(driver);
		QueuePage queuepage = homePage.goToQueuePage();
		queuepage.goToImplementationsListPage();
		queuepage.goToTryEditorPage();
		queuepage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 1, "pythonCode"));
		String alertMessage=queuepage.getAlertMessage();
		logger.info("after clicking on run button ouput message is:" +alertMessage);
		Assert.assertEquals(alertMessage,excelReader.getGivenColumnFromExcel(1, "Result"));
	}

	@Test
	public void TestValidPythoncodeOfImplementationCollectionsPage()
	{
		HomePage homePage=new HomePage(driver);
		QueuePage queuepage = homePage.goToQueuePage();
		queuepage.goToImplementationCollectionPage();
		logger.info("logger is on implementationcollections page");
		queuepage.goToTryEditorPage();
		logger.info("loggeris redirected to tryeditor page");
		queuepage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 2, "pythonCode"));
		String outputmessage=queuepage.getOutputMessage();
		logger.info("after clicking on run button ouput message is:" +outputmessage);
		Assert.assertEquals(outputmessage,excelReader.getGivenColumnFromExcel(2, "Result"));
	}

	@Test
	public void TestInValidPythoncodeOfImplementationCollectionPage()
	{
		HomePage homePage=new HomePage(driver);
		QueuePage queuepage = homePage.goToQueuePage();
		queuepage.goToImplementationCollectionPage();
		queuepage.goToTryEditorPage();
		queuepage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 1, "pythonCode"));
		String alertMessage=queuepage.getAlertMessage();
		logger.info("after clicking on run button ouput message is:" +alertMessage);
		Assert.assertEquals(alertMessage,excelReader.getGivenColumnFromExcel(1, "Result"));
	}

	@Test
	public void TestValidPythoncodeOfImplementationArrayPage()
	{
		HomePage homePage=new HomePage(driver);
		QueuePage queuepage = homePage.goToQueuePage();
		queuepage.goToImplementationArrayPage();
		logger.info("logger is on implementationarray page");
		queuepage.goToTryEditorPage();
		logger.info("loggeris redirected to tryeditor page");
		queuepage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 0, "pythonCode"));
		String outputmessage=queuepage.getOutputMessage();
		logger.info("after clicking on run button ouput message is:" +outputmessage);
		Assert.assertEquals(outputmessage,excelReader.getGivenColumnFromExcel(0, "Result"));
	}

	@Test
	public void TestInValidPythoncodeOfImplementationArrayPage()
	{
		HomePage homePage=new HomePage(driver);
		QueuePage queuepage = homePage.goToQueuePage();
		queuepage.goToImplementationArrayPage();
		queuepage.goToTryEditorPage();
		queuepage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 1, "pythonCode"));
		String alertMessage=queuepage.getAlertMessage();
		logger.info("after clicking on run button ouput message is:" +alertMessage);
		Assert.assertEquals(alertMessage,excelReader.getGivenColumnFromExcel(1, "Result"));
	}

	@Test
	public void TestValidPythoncodeOfQueueOperationsPage()
	{
		HomePage homePage=new HomePage(driver);
		QueuePage queuepage = homePage.goToQueuePage();
		queuepage.goToQueueOperationsPage();
		logger.info("logger is on queueoperations page");
		queuepage.goToTryEditorPage();
		logger.info("loggeris redirected to tryeditor page");
		queuepage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 0, "pythonCode"));
		String outputmessage=queuepage.getOutputMessage();
		logger.info("after clicking on run button ouput message is:" +outputmessage);
		Assert.assertEquals(outputmessage,excelReader.getGivenColumnFromExcel(0, "Result"));
	}

	@Test
	public void TestInValidPythoncodeOfQueueOperationsPage()
	{
		HomePage homePage=new HomePage(driver);
		QueuePage queuepage = homePage.goToQueuePage();
		queuepage.goToQueueOperationsPage();
		queuepage.goToTryEditorPage();
		queuepage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 1, "pythonCode"));
		String alertMessage=queuepage.getAlertMessage();
		logger.info("after clicking on run button ouput message is:" +alertMessage);
		Assert.assertEquals(alertMessage,excelReader.getGivenColumnFromExcel(1, "Result"));
	}

	@Test
	public void TestpracticeQuestionsPage()
	{
		HomePage homePage=new HomePage(driver);
		QueuePage queuepage = homePage.goToQueuePage();
		queuepage.goToImplementationsListPage();
		queuepage.goToPracticeQuestionsPage();
		String pageTitle=driver.getTitle();
		Assert.assertEquals("Practice Questions",pageTitle);

	}

		
	
}
