package com.numpyninja.test.pages;


import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.GraphPage;
import pages.HomePage;

import pages.SignInPage;
import utilities.ExcelReader;

public class GraphPageTest extends BaseTest
{

	ExcelReader excelReader;
	GraphPage graphpage;
	public static Logger logger = LogManager.getLogger(GraphPageTest.class);
	
	@BeforeTest
	public void initializeReader()
	{
		HomePage homePage=new HomePage(driver);
		homePage.launchHomePage();
		graphpage=homePage.goToGraphPage();
//		SignInPage  signinpage =homepage.gotoLoginPage();
//		signinpage.successfullSignIn("sunandab", "sunasdet112");
		
		excelReader = new ExcelReader("Graph", readConfig.getExcelPath());
	}
	
@Test(priority=1)
public void TestValidPythoncodeOfGraphPage()
{
	graphpage.goToGraphLinkPage();
	logger.info("logger is on graph page");
	graphpage.goToTryEditorPage();
	logger.info("loggeris redirected to tryeditor page");
	graphpage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 0, "pythoncode"));
	String outputmessage=graphpage.getOutputMessage();
	logger.info("after clicking on run button ouput message is:" +outputmessage);
	AssertJUnit.assertEquals(outputmessage,excelReader.getGivenColumnFromExcel(0, "Result"));
}

@Test(priority=2)
public void TestInValidPythoncodeOfGraphPage()
{
	//graphtpage.goToGraphLinkPage();
	//graphtpage.goToTryEditorPage();
	graphpage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 1, "pythoncode"));
	String alertMessage=graphpage.getAlertMessage();
	logger.info("after clicking on run button ouput message is:" +alertMessage);
	AssertJUnit.assertEquals(alertMessage,excelReader.getGivenColumnFromExcel(1, "Result"));
}

@Test(priority=3)
public void TestValidPythoncodeOfRepresentationGraphPage()
{
	graphpage.LaunchGraphPage();
	graphpage.goToRepresentationGraphPage();
	logger.info("logger is on representationgraph page");
	graphpage.goToTryEditorPage();
	logger.info("loggeris redirected to tryeditor page");
	graphpage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 2, "pythoncode"));
	String outputmessage=graphpage.getOutputMessage();
	logger.info("after clicking on run button ouput message is:" +outputmessage);
	AssertJUnit.assertEquals(outputmessage,excelReader.getGivenColumnFromExcel(2, "Result"));
}

@Test(priority=4)
public void TestInValidPythoncodeOfRepresentationGraphPage()
{
	//graphpage.goToRepresentationGraphPage();
	//graphpage.goToTryEditorPage();
	graphpage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 1, "pythoncode"));
	String alertMessage=graphpage.getAlertMessage();
	logger.info("after clicking on run button ouput message is:" +alertMessage);
	AssertJUnit.assertEquals(alertMessage,excelReader.getGivenColumnFromExcel(1, "Result"));
}
@Test(priority=5)
public void TestpracticeQuestionsPage()
{
	graphpage.LaunchGraphPage();
	graphpage.goToGraphLinkPage();
	graphpage.goToPracticeQuestionsPage();
	String pageTitle=driver.getTitle();
	AssertJUnit.assertEquals("Practice Questions",pageTitle);

}




	
}
