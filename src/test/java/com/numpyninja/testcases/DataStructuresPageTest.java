package com.numpyninja.testcases;

	
	import org.testng.annotations.Test;

import com.numpyninja.base.BaseTest;
import com.numpyninja.pages.DataStructuresPage;
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
	public class DataStructuresPageTest extends BaseTest
	{
		
		ExcelReader excelReader;
		HomePage homepage;
		DataStructuresPage datastructurespage;
		public static Logger logger = LogManager.getLogger(DataStructuresPageTest.class);
		
		public void initializeReader()
		{
			
			homepage=new HomePage(driver);
			homepage.launchHomePage();
			datastructurespage = homepage.goToDataStructuresPage();
			excelReader = new ExcelReader("DataStructures", readConfig.getExcelPath());
			
		}

		@Test(priority = 1)
		public void TestValidPythoncodeOfTimeComplexityPage()
		{
			initializeReader();
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
