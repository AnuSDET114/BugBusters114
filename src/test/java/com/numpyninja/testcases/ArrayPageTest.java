package com.numpyninja.testcases;

import org.testng.annotations.Test;

import com.numpyninja.base.BaseTest;
import com.numpyninja.pages.ArrayPage;
import com.numpyninja.pages.HomePage;
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
public class ArrayPageTest extends BaseTest
{
	ExcelReader excelReader;
	ArrayPage arraypage;
	public static Logger logger = LogManager.getLogger(ArrayPageTest.class);
	
	public void initialize()
	{
		HomePage homePage = new HomePage(driver);
		homePage.launchHomePage();
		arraypage = homePage.goToArrayPage();
		
		excelReader = new ExcelReader("array", readConfig.getExcelPath());
	}
	
	
	@Test(priority=1)
	public void TestValidPythoncodeOfArraysInPythonPage()
	{
		initialize();
		arraypage.goToArraysInPythonPage();
		logger.info("logger is on introduction page");
		arraypage.goToTryEditorPage();
		logger.info("loggeris redirected to tryeditor page");
		arraypage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 0, "pythonCode"),"run");
		String outputmessage=arraypage.getOutputMessage();
		logger.info("after clicking on run button ouput message is:" +outputmessage);
		Assert.assertEquals(outputmessage,excelReader.getGivenColumnFromExcel(0, "Result"));
	}
	
	@Test(priority=2)
	public void TestInValidPythoncodeOfArraysInPythonPage()
	{
		arraypage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 1, "pythonCode"),"run");
		String alertMessage=arraypage.getAlertMessage();
		logger.info("after clicking on run button ouput message is:" +alertMessage);
		Assert.assertEquals(alertMessage,excelReader.getGivenColumnFromExcel(1, "Result"));
	}
	
	@Test(priority=3)
	public void TestValidPythonCodeOfArraysUsingListPage()
	{
		arraypage.launchArrayPage();
		arraypage.goToArraysUsingListPage();
		arraypage.goToTryEditorPage();
		arraypage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 2, "pythonCode"),"run");
		String outputmessage=arraypage.getOutputMessage();
		logger.info("after clicking on run button ouput message is:" +outputmessage);
		Assert.assertEquals(outputmessage,excelReader.getGivenColumnFromExcel(2, "Result"));
	}
	
	@Test(priority=4)
	public void TestInValidPythoncodeOfArraysUsingListPage()
	{
//		arraypage.goToArraysUsingListPage();
//		arraypage.goToTryEditorPage();
		arraypage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 1, "pythonCode"),"run");
		String alertMessage=arraypage.getAlertMessage();
		logger.info("after clicking on run button ouput message is:" +alertMessage);
		Assert.assertEquals(alertMessage,excelReader.getGivenColumnFromExcel(1, "Result"));
	}
	
	@Test(priority=5)
	public void TestValidPythonCodeOfBasicOperationsInListsPage()
	{
		arraypage.launchArrayPage();
		arraypage.goToBasicOperationsInListsPage();
		arraypage.goToTryEditorPage();
		arraypage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel(2, "pythonCode"),"run");
		String outputmessage=arraypage.getOutputMessage();
		logger.info("after clicking on run button ouput message is:" +outputmessage);
		Assert.assertEquals(outputmessage,excelReader.getGivenColumnFromExcel(2, "Result"));
	}
	
	@Test(priority=6)
	public void TestInValidPythoncodeOfBasicOperatinsInListsPage()
	{
//		arraypage.goToBasicOperationsInListsPage();
//		arraypage.goToTryEditorPage();
		arraypage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel(1, "pythonCode"),"run");
		String alertMessage=arraypage.getAlertMessage();
		logger.info("after clicking on run button ouput message is:" +alertMessage);
		Assert.assertEquals(alertMessage,excelReader.getGivenColumnFromExcel(1, "Result"));
	}
	
	@Test(priority=7)
	public void TestvalidPhythoncodeOfApplicationsOfArrayPage()
	{
		arraypage.launchArrayPage();
		arraypage.goToApplicationsOfArrayPage();
		arraypage.goToTryEditorPage();
		
		arraypage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 0, "pythonCode"),"run");
		String outputmessage=arraypage.getOutputMessage();
		logger.info("after clicking on run button ouput message is:" +outputmessage);
		Assert.assertEquals(outputmessage,excelReader.getGivenColumnFromExcel(0, "Result"));
	}
	
	@Test(priority=8)
	public void TestInValidPythoncodeOfApplicationsOfArrayPage()
	{
//		arraypage.goToApplicationsOfArrayPage();
//		arraypage.goToTryEditorPage();
		arraypage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 1, "pythonCode"),"run");
		String alertMessage=arraypage.getAlertMessage();
		logger.info("after clicking on run button ouput message is:" +alertMessage);
		Assert.assertEquals(alertMessage,excelReader.getGivenColumnFromExcel(1, "Result"));
	}

	@Test(priority=9)
	public void TestpracticeQuestionsPage()
	{
		arraypage.launchArrayPage();
		arraypage.goToArraysInPythonPage();
		arraypage.goToPracticeQuestionsPage();
		String pageTitle=driver.getTitle();
		Assert.assertEquals("Practice Questions",pageTitle);

	}
	@Test(priority=10)
	public void TestvalidcodeofsearchthearrayPage()
	{
		arraypage.goToSearchTheArrayPage();
//		arraypage.goToTryEditorPage();
		arraypage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 2, "pythonCode"),"run");
		String outputmessage=arraypage.getOutputMessage();
		logger.info("after clicking on run button ouput message is:" +outputmessage);
		Assert.assertEquals(outputmessage,excelReader.getGivenColumnFromExcel(2, "Result"));
	}
	
	@Test(priority=11)
	public void submitCodeinSearchTheArraypage()
	{
		arraypage.launchPracticeQuestionsPage();
		arraypage.goToSearchTheArrayPage();
		arraypage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 4, "pythonCode"),"submit");
		arraypage.waitUntilElementVisible();
		String outputmessage=arraypage.getOutputMessage();
		logger.info("after clicking on run button ouput message is:" +outputmessage);
		Assert.assertEquals(outputmessage,excelReader.getGivenColumnFromExcel(4, "Result"));
	}
	
	@Test(priority=12)
	public void TestInvalidcodeofsearchthearrayPage()
	{
		arraypage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 1, "pythonCode"),"run");
		String alertMessage=arraypage.getAlertMessage();
		logger.info("after clicking on run button ouput message is:" +alertMessage);
		Assert.assertEquals(alertMessage,excelReader.getGivenColumnFromExcel(1, "Result"));
	}

	@Test(priority=13)
	public void TestvalidcodeofMaxConsecutiveonesPage()
	{
		arraypage.launchPracticeQuestionsPage();
		arraypage.goToMaxConsecutiveOnesPage();
//		arraypage.goToTryEditorPage();
		arraypage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 5, "pythonCode"), "run");
		String outputmessage=arraypage.getOutputMessage();
		logger.info("after clicking on run button ouput message is:" +outputmessage);
		Assert.assertEquals(outputmessage,excelReader.getGivenColumnFromExcel(5, "Result"));
	}
	
	@Test(priority=14)
	public void submitCodeinmaxconsecutiveonespage()
	{
		arraypage.launchPracticeQuestionsPage();
		arraypage.goToMaxConsecutiveOnesPage();
		arraypage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 6, "pythonCode"),"submit");
		arraypage.waitUntilElementVisible();
		String outputmessage=arraypage.getOutputMessage();
		logger.info("after clicking on run button ouput message is:" +outputmessage);
		Assert.assertEquals(outputmessage,excelReader.getGivenColumnFromExcel(6, "Result"));
	}
	
	@Test(priority=15)
	public void TestInvalidcodeofMaxConsecutiveonesPage()
	{
		arraypage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 1, "pythonCode"),"run");
		String alertMessage=arraypage.getAlertMessage();
		logger.info("after clicking on run button ouput message is:" +alertMessage);
		Assert.assertEquals(alertMessage,excelReader.getGivenColumnFromExcel(1, "Result"));
	}
	@Test(priority=16)
	public void TestvalidcodeofFindNumberWithEvenNumberOfDigitsPage()
	{
		arraypage.launchPracticeQuestionsPage();
		arraypage.goToFindNumberWithEvenofDigitsPage();
//		arraypage.goToSearchTheArrayPage();
//		arraypage.goToTryEditorPage();
		arraypage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 7, "pythonCode"),"run");
		String outputmessage=arraypage.getOutputMessage();
		logger.info("after clicking on run button ouput message is:" +outputmessage);
		Assert.assertEquals(outputmessage,excelReader.getGivenColumnFromExcel(7, "Result"));
	}
	
	@Test(priority=17)
	public void submitCodeinfindnumberwithevennumberofdigitswithpage()
	{
		arraypage.launchPracticeQuestionsPage();
		arraypage.goToFindNumberWithEvenofDigitsPage();
		arraypage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 8, "pythonCode"),"submit");
		arraypage.waitUntilElementVisible();
		String outputmessage=arraypage.getOutputMessage();
		logger.info("after clicking on run button ouput message is:" +outputmessage);
		Assert.assertEquals(outputmessage,excelReader.getGivenColumnFromExcel(8, "Result"));
	}
	
	@Test(priority=18)
	public void TestInvalidcodeofFindNumberWithEvenNumberOfDigitsPage()
	{
		arraypage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 1, "pythonCode"),"run");
		String alertMessage=arraypage.getAlertMessage();
		logger.info("after clicking on run button ouput message is:" +alertMessage);
		Assert.assertEquals(alertMessage,excelReader.getGivenColumnFromExcel(1, "Result"));
	}
	@Test(priority=19)
	public void TestvalidcodeofSquaresOfSortedArrayPage()
	{
		arraypage.launchPracticeQuestionsPage();
		arraypage.goToSquaresOfSortedArrayPage();
//		arraypage.goToSearchTheArrayPage();
//		arraypage.goToTryEditorPage();
		arraypage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 9, "pythonCode"),"run");
		arraypage.waitUntilElementVisible();
		String outputmessage=arraypage.getOutputMessage();
		logger.info("after clicking on run button ouput message is:" +outputmessage);
		Assert.assertEquals(outputmessage,excelReader.getGivenColumnFromExcel(9, "Result"));
	}
	
	@Test(priority=20)
	public void submitCodeinsquaresofsortedArraypage()
	{
		arraypage.launchPracticeQuestionsPage();
		arraypage.goToSquaresOfSortedArrayPage();
		arraypage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 10, "pythonCode"),"submit");
		arraypage.waitUntilElementVisible();
		String outputmessage=arraypage.getOutputMessage();
		logger.info("after clicking on run button ouput message is:" +outputmessage);
		Assert.assertEquals(outputmessage,excelReader.getGivenColumnFromExcel(10, "Result"));
	}
	
	@Test(priority=21)
	public void TestInvalidcodeofSquaresOfSortedArrayPage()
	{
		arraypage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 1, "pythonCode"),"run");
		String alertMessage=arraypage.getAlertMessage();
		logger.info("after clicking on run button ouput message is:" +alertMessage);
		Assert.assertEquals(alertMessage,excelReader.getGivenColumnFromExcel(1, "Result"));
	}
	
	
	
	
	
	
}
