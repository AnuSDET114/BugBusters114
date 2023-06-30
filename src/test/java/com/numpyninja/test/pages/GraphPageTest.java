package com.numpyninja.test.pages;

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
	HomePage homepage;
	public static Logger logger = LogManager.getLogger(GraphPageTest.class);
	
	@BeforeTest
	public void initializeReader()
	{
		launchURL();
		homepage=new HomePage(driver);
		SignInPage  signinpage =homepage.gotoLoginPage();
		signinpage.successfullSignIn("sunandab", "sunasdet112");
		
		excelReader = new ExcelReader("Graph", readConfig.getExcelPath());
	}
	
@Test
public void TestValidPythoncodeOfGraphPage()
{
	HomePage homePage=new HomePage(driver);
	GraphPage graphpage = homePage.goToGraphPage();
	graphpage.goToGraphLinkPage();
	logger.info("logger is on graph page");
	graphpage.goToTryEditorPage();
	logger.info("loggeris redirected to tryeditor page");
	graphpage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 0, "pythoncode"));
	String outputmessage=graphpage.getOutputMessage();
	logger.info("after clicking on run button ouput message is:" +outputmessage);
	Assert.assertEquals(outputmessage,excelReader.getGivenColumnFromExcel(0, "Result"));
}

@Test
public void TestInValidPythoncodeOfGraphPage()
{
	HomePage homePage=new HomePage(driver);
	GraphPage graphtpage = homePage.goToGraphPage();
	graphtpage.goToGraphLinkPage();
	graphtpage.goToTryEditorPage();
	graphtpage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 1, "pythoncode"));
	String alertMessage=graphtpage.getAlertMessage();
	logger.info("after clicking on run button ouput message is:" +alertMessage);
	Assert.assertEquals(alertMessage,excelReader.getGivenColumnFromExcel(1, "Result"));
}


public void TestValidPythoncodeOfRepresentationGraphPage()
{
	HomePage homePage=new HomePage(driver);
	GraphPage graphpage = homePage.goToGraphPage();
	graphpage.goToRepresentationGraphPage();
	logger.info("logger is on representationgraph page");
	graphpage.goToTryEditorPage();
	logger.info("loggeris redirected to tryeditor page");
	graphpage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 2, "pythoncode"));
	String outputmessage=graphpage.getOutputMessage();
	logger.info("after clicking on run button ouput message is:" +outputmessage);
	Assert.assertEquals(outputmessage,excelReader.getGivenColumnFromExcel(2, "Result"));
}

@Test
public void TestInValidPythoncodeOfRepresentationGraphPage()
{
	HomePage homePage=new HomePage(driver);
	GraphPage graphtpage = homePage.goToGraphPage();
	graphtpage.goToRepresentationGraphPage();
	graphtpage.goToTryEditorPage();
	graphtpage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 1, "pythoncode"));
	String alertMessage=graphtpage.getAlertMessage();
	logger.info("after clicking on run button ouput message is:" +alertMessage);
	Assert.assertEquals(alertMessage,excelReader.getGivenColumnFromExcel(1, "Result"));
}




	
}
