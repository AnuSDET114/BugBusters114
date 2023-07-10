package com.numpyninja.testcases;

import org.testng.annotations.Test;

import com.numpyninja.base.BaseTest;
import com.numpyninja.pages.HomePage;
import com.numpyninja.pages.QueuePage;
import com.numpyninja.pages.SignInPage;
import com.numpyninja.utilities.ExcelReader;
import com.numpyninja.utilities.ExtentListener;

import org.testng.AssertJUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ExtentListener.class)
public class QueuePageTest extends BaseTest
{
	ExcelReader excelReader;
	QueuePage queuepage;
	public static Logger logger = LogManager.getLogger(QueuePageTest.class);
	
	@BeforeTest
	public void initializeReader()
	{
		HomePage homepage=new HomePage(driver);
		homepage.launchHomePage();
		queuepage=homepage.goToQueuePage();
//		SignInPage  signinpage =homepage.gotoLoginPage();
//		signinpage.successfullSignIn("sunandab", "sunasdet112");
		
		excelReader = new ExcelReader("Queue", readConfig.getExcelPath());
	}
	
	@Test(priority=1)
	public void TestValidPythoncodeOfImplementationsListPage()
	{
		queuepage.goToImplementationsListPage();
		logger.info("logger is on implementationqueuelist page");
		queuepage.goToTryEditorPage();
		logger.info("loggeris redirected to tryeditor page");
		queuepage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 0, "pythonCode"));
		String outputmessage=queuepage.getOutputMessage();
		logger.info("after clicking on run button ouput message is:" +outputmessage);
		AssertJUnit.assertEquals(outputmessage,excelReader.getGivenColumnFromExcel(0, "Result"));
	}

	@Test(priority=2)
	public void TestInValidPythoncodeOfImplementationListPage()
	{
		//queuepage.goToImplementationsListPage();
		//queuepage.goToTryEditorPage();
		queuepage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 1, "pythonCode"));
		String alertMessage=queuepage.getAlertMessage();
		logger.info("after clicking on run button ouput message is:" +alertMessage);
		AssertJUnit.assertEquals(alertMessage,excelReader.getGivenColumnFromExcel(1, "Result"));
	}

	@Test(priority=3)
	public void TestValidPythoncodeOfImplementationCollectionsPage()
	{
		queuepage.LaunchQueuePage();
		queuepage.goToImplementationCollectionPage();
		logger.info("logger is on implementationcollections page");
		queuepage.goToTryEditorPage();
		logger.info("loggeris redirected to tryeditor page");
		queuepage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 2, "pythonCode"));
		String outputmessage=queuepage.getOutputMessage();
		logger.info("after clicking on run button ouput message is:" +outputmessage);
		AssertJUnit.assertEquals(outputmessage,excelReader.getGivenColumnFromExcel(2, "Result"));
	}

	@Test(priority=4)
	public void TestInValidPythoncodeOfImplementationCollectionPage()
	{
		//queuepage.goToImplementationCollectionPage();
		//queuepage.goToTryEditorPage();
		queuepage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 1, "pythonCode"));
		String alertMessage=queuepage.getAlertMessage();
		logger.info("after clicking on run button ouput message is:" +alertMessage);
		AssertJUnit.assertEquals(alertMessage,excelReader.getGivenColumnFromExcel(1, "Result"));
	}

	@Test(priority=5)
	public void TestValidPythoncodeOfImplementationArrayPage()
	{
		queuepage.LaunchQueuePage();
		queuepage.goToImplementationArrayPage();
		logger.info("logger is on implementationarray page");
		queuepage.goToTryEditorPage();
		logger.info("loggeris redirected to tryeditor page");
		queuepage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 0, "pythonCode"));
		String outputmessage=queuepage.getOutputMessage();
		logger.info("after clicking on run button ouput message is:" +outputmessage);
		AssertJUnit.assertEquals(outputmessage,excelReader.getGivenColumnFromExcel(0, "Result"));
	}

	@Test(priority=6)
	public void TestInValidPythoncodeOfImplementationArrayPage()
	{
		//queuepage.goToImplementationArrayPage();
		//queuepage.goToTryEditorPage();
		queuepage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 1, "pythonCode"));
		String alertMessage=queuepage.getAlertMessage();
		logger.info("after clicking on run button ouput message is:" +alertMessage);
		AssertJUnit.assertEquals(alertMessage,excelReader.getGivenColumnFromExcel(1, "Result"));
	}

	@Test(priority=7)
	public void TestValidPythoncodeOfQueueOperationsPage()
	{
		queuepage.LaunchQueuePage();
		queuepage.goToQueueOperationsPage();
		logger.info("logger is on queueoperations page");
		queuepage.goToTryEditorPage();
		logger.info("loggeris redirected to tryeditor page");
		queuepage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 0, "pythonCode"));
		String outputmessage=queuepage.getOutputMessage();
		logger.info("after clicking on run button ouput message is:" +outputmessage);
		AssertJUnit.assertEquals(outputmessage,excelReader.getGivenColumnFromExcel(0, "Result"));
	}

	@Test(priority=8)
	public void TestInValidPythoncodeOfQueueOperationsPage()
	{
		//queuepage.goToQueueOperationsPage();
		//queuepage.goToTryEditorPage();
		queuepage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 1, "pythonCode"));
		String alertMessage=queuepage.getAlertMessage();
		logger.info("after clicking on run button ouput message is:" +alertMessage);
		AssertJUnit.assertEquals(alertMessage,excelReader.getGivenColumnFromExcel(1, "Result"));
	}

	@Test(priority=9)
	public void TestpracticeQuestionsPage()
	{
		queuepage.LaunchQueuePage();
		queuepage.goToImplementationsListPage();
		queuepage.goToPracticeQuestionsPage();
		String pageTitle=driver.getTitle();
		AssertJUnit.assertEquals("Practice Questions",pageTitle);

	}

		
	
}
