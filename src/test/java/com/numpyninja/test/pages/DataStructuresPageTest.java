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
import pages.DataStructuresPage;
	import pages.SignInPage;
	import utilities.ExcelReader;

	public class DataStructuresPageTest extends BaseTest
	{
		
		ExcelReader excelReader;
		HomePage homepage;
		DataStructuresPage datastructurespage;
		public static Logger logger = LogManager.getLogger(DataStructuresPageTest.class);
		
		@BeforeTest
		public void initializeReader()
		{
			
			homepage=new HomePage(driver);
			homepage.launchHomePage();
			datastructurespage = homepage.goToDataStructuresPage();
//			SignInPage  signinpage =homepage.gotoLoginPage();
//			signinpage.successfullSignIn("sunandab", "sunasdet112");
			
			excelReader = new ExcelReader("DataStructures", readConfig.getExcelPath());
			
		}

		@Test(priority = 1)
		public void TestValidPythoncodeOfTimeComplexityPage()
		{
			datastructurespage.goToTimeComplexityPage();
			logger.info("logger is on Timecomplexitypage");
			datastructurespage.goToTryEditorPage();
			logger.info("loggeris redirected to tryeditor page");
			datastructurespage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 0, "pythoncode"));
			String outputmessage=datastructurespage.getOutputMessage();
			logger.info("after clicking on run button ouput message is:" +outputmessage);
			AssertJUnit.assertEquals(outputmessage,excelReader.getGivenColumnFromExcel(0, "Result"));
		}

		@Test(priority = 2)
		public void TestInValidPythoncodeOfTimeComplexityPage()
		{
//			datastructurespage.goToTimeComplexityPage();
//			datastructurespage.goToTryEditorPage();
			datastructurespage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 1, "pythoncode"));
			String alertMessage=datastructurespage.getAlertMessage();
			logger.info("after clicking on run button ouput message is:" +alertMessage);
			AssertJUnit.assertEquals(alertMessage,excelReader.getGivenColumnFromExcel(1, "Result"));
		}
		
		@Test(priority = 3)
		public void TestpracticeQuestionsPage()
		{
			datastructurespage.launchDatastructuresPage();
			datastructurespage.goToTimeComplexityPage();
			datastructurespage.goToPracticeQuestionsPage();
			String pageTitle=driver.getTitle();
			AssertJUnit.assertEquals("Practice Questions",pageTitle);

		}

		
	}
