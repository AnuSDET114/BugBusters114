package com.numpyninja.test.pages;

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
		public static Logger logger = LogManager.getLogger(DataStructuresPageTest.class);
		
		@BeforeTest
		public void initializeReader()
		{
			launchURL();
			homepage=new HomePage(driver);
			SignInPage  signinpage =homepage.gotoLoginPage();
			signinpage.successfullSignIn("sunandab", "sunasdet112");
			
			excelReader = new ExcelReader("DataStructures", readConfig.getExcelPath());
		}

		@Test
		public void TestValidPythoncodeOfTimeComplexityPage()
		{
			HomePage homePage=new HomePage(driver);
			DataStructuresPage datastructurespage = homePage.goToDataStructuresPage();
			datastructurespage.goToTimeComplexityPage();
			logger.info("logger is on Timecomplexitypage");
			datastructurespage.goToTryEditorPage();
			logger.info("loggeris redirected to tryeditor page");
			datastructurespage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 0, "pythoncode"));
			String outputmessage=datastructurespage.getOutputMessage();
			logger.info("after clicking on run button ouput message is:" +outputmessage);
			Assert.assertEquals(outputmessage,excelReader.getGivenColumnFromExcel(0, "Result"));
		}

		@Test
		public void TestInValidPythoncodeOfTimeComplexityPage()
		{
			HomePage homePage=new HomePage(driver);
			DataStructuresPage dataStructuresPage = homePage.goToDataStructuresPage();
			dataStructuresPage.goToTimeComplexityPage();
			dataStructuresPage.goToTryEditorPage();
			dataStructuresPage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 1, "pythoncode"));
			String alertMessage=dataStructuresPage.getAlertMessage();
			logger.info("after clicking on run button ouput message is:" +alertMessage);
			Assert.assertEquals(alertMessage,excelReader.getGivenColumnFromExcel(1, "Result"));
		}
		
		
	}
