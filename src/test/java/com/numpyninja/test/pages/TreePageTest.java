package com.numpyninja.test.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.SignInPage;
import pages.TreePage;
import utilities.ExcelReader;

public class TreePageTest extends BaseTest
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
		
		excelReader = new ExcelReader("Tree", readConfig.getExcelPath());
	}
	
	@Test
	public void TestValidPythoncodeOfOverViewOfTreesPage()
	{
		HomePage homePage=new HomePage(driver);
		TreePage treepage = homePage.goToTreePage();
		treepage.goToOverViewOftreesPage();
		logger.info("logger is on overviewoftrees page");
		treepage.goToTryEditorPage();
		logger.info("loggeris redirected to tryeditor page");
		treepage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 0, "pythonCode"));
		String outputmessage=treepage.getOutputMessage();
		logger.info("after clicking on run button ouput message is:" +outputmessage);
		Assert.assertEquals(outputmessage,excelReader.getGivenColumnFromExcel(0, "Result"));
	}

	@Test
	public void TestInValidPythoncodeOfOverViewOfTreesPage()
	{
		HomePage homePage=new HomePage(driver);
		TreePage treepage = homePage.goToTreePage();
		treepage.goToOverViewOftreesPage();
		treepage.goToTryEditorPage();
		treepage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 1, "pythonCode"));
		String alertMessage=treepage.getAlertMessage();
		logger.info("after clicking on run button ouput message is:" +alertMessage);
		Assert.assertEquals(alertMessage,excelReader.getGivenColumnFromExcel(1, "Result"));
	}


	@Test
	public void TestValidPythoncodeTerminologiesPage()
	{
		HomePage homePage=new HomePage(driver);
		TreePage treepage = homePage.goToTreePage();
		treepage.goToTerminologiesPage();
		logger.info("logger is on terminologies page");
		treepage.goToTryEditorPage();
		logger.info("loggeris redirected to tryeditor page");
		treepage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 0, "pythonCode"));
		String outputmessage=treepage.getOutputMessage();
		logger.info("after clicking on run button ouput message is:" +outputmessage);
		Assert.assertEquals(outputmessage,excelReader.getGivenColumnFromExcel(0, "Result"));
	}

	@Test
	public void TestInValidPythoncodeOfTerminologiesPage()
	{
		HomePage homePage=new HomePage(driver);
		TreePage treepage = homePage.goToTreePage();
		treepage.goToTerminologiesPage();
		treepage.goToTryEditorPage();
		treepage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 1, "pythonCode"));
		String alertMessage=treepage.getAlertMessage();
		logger.info("after clicking on run button ouput message is:" +alertMessage);
		Assert.assertEquals(alertMessage,excelReader.getGivenColumnFromExcel(1, "Result"));
	}


	@Test
	public void TestValidPythoncodeOfTypesOfTreesPage()
	{
		HomePage homePage=new HomePage(driver);
		TreePage treepage = homePage.goToTreePage();
		treepage.goToTypesOfTreesPage();
		logger.info("logger is on typesoftrees page");
		treepage.goToTryEditorPage();
		logger.info("loggeris redirected to tryeditor page");
		treepage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 2, "pythonCode"));
		String outputmessage=treepage.getOutputMessage();
		logger.info("after clicking on run button ouput message is:" +outputmessage);
		Assert.assertEquals(outputmessage,excelReader.getGivenColumnFromExcel(2, "Result"));
	}

	@Test
	public void TestInValidPythoncodeOfTypesOfTreePage()
	{
		HomePage homePage=new HomePage(driver);
		TreePage treepage = homePage.goToTreePage();
		treepage.goToTypesOfTreesPage();
		treepage.goToTryEditorPage();
		treepage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 1, "pythonCode"));
		String alertMessage=treepage.getAlertMessage();
		logger.info("after clicking on run button ouput message is:" +alertMessage);
		Assert.assertEquals(alertMessage,excelReader.getGivenColumnFromExcel(1, "Result"));
	}
	
	
	@Test
	public void TestValidPythoncodeOfTraversalIllustrationPage()
	{
		HomePage homePage=new HomePage(driver);
		TreePage treepage = homePage.goToTreePage();
		treepage.goToTraversalIllustrationPage();
		logger.info("logger is on traversalillustration page");
		treepage.goToTryEditorPage();
		logger.info("loggeris redirected to tryeditor page");
		treepage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 0, "pythonCode"));
		String outputmessage=treepage.getOutputMessage();
		logger.info("after clicking on run button ouput message is:" +outputmessage);
		Assert.assertEquals(outputmessage,excelReader.getGivenColumnFromExcel(0, "Result"));
	}

	@Test
	public void TestInValidPythoncodeOfTraversalIllustrationPage()
	{
		HomePage homePage=new HomePage(driver);
		TreePage treepage = homePage.goToTreePage();
		treepage.goToTraversalIllustrationPage();
		treepage.goToTryEditorPage();
		treepage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 1, "pythonCode"));
		String alertMessage=treepage.getAlertMessage();
		logger.info("after clicking on run button ouput message is:" +alertMessage);
		Assert.assertEquals(alertMessage,excelReader.getGivenColumnFromExcel(1, "Result"));
	}
	
	@Test
	public void TestValidPythoncodeOfBinaryTreesPage()
	{
		HomePage homePage=new HomePage(driver);
		TreePage treepage = homePage.goToTreePage();
		treepage.goToBinaryTreesPage();
		logger.info("logger is on binarytrees page");
		treepage.goToTryEditorPage();
		logger.info("loggeris redirected to tryeditor page");
		treepage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 0, "pythonCode"));
		String outputmessage=treepage.getOutputMessage();
		logger.info("after clicking on run button ouput message is:" +outputmessage);
		Assert.assertEquals(outputmessage,excelReader.getGivenColumnFromExcel(0, "Result"));
	}

	@Test
	public void TestInValidPythoncodeOfBinaryTreesPage()
	{
		HomePage homePage=new HomePage(driver);
		TreePage treepage = homePage.goToTreePage();
		treepage.goToBinaryTreesPage();
		treepage.goToTryEditorPage();
		treepage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 1, "pythonCode"));
		String alertMessage=treepage.getAlertMessage();
		logger.info("after clicking on run button ouput message is:" +alertMessage);
		Assert.assertEquals(alertMessage,excelReader.getGivenColumnFromExcel(1, "Result"));
	}
	
	
	@Test
	public void TestValidPythoncodeOfTypesOfBinaryTreesPage()
	{
		HomePage homePage=new HomePage(driver);
		TreePage treepage = homePage.goToTreePage();
		treepage.goTOTypesOfBinaryTreesPage();
		logger.info("logger is on typesofbinarytrees page");
		treepage.goToTryEditorPage();
		logger.info("loggeris redirected to tryeditor page");
		treepage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 0, "pythonCode"));
		String outputmessage=treepage.getOutputMessage();
		logger.info("after clicking on run button ouput message is:" +outputmessage);
		Assert.assertEquals(outputmessage,excelReader.getGivenColumnFromExcel(0, "Result"));
	}

	@Test
	public void TestInValidPythoncodeOfTypesOfBinaryTreesPage()
	{
		HomePage homePage=new HomePage(driver);
		TreePage treepage = homePage.goToTreePage();
		treepage.goTOTypesOfBinaryTreesPage();
		treepage.goToTryEditorPage();
		treepage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 1, "pythonCode"));
		String alertMessage=treepage.getAlertMessage();
		logger.info("after clicking on run button ouput message is:" +alertMessage);
		Assert.assertEquals(alertMessage,excelReader.getGivenColumnFromExcel(1, "Result"));
	}
	
	
	@Test
	public void TestValidPythoncodeOfImplementationInPythonPage()
	{
		HomePage homePage=new HomePage(driver);
		TreePage treepage = homePage.goToTreePage();
		treepage.goToImplementationinPythonPage();
		logger.info("logger is on implementatationinpython page");
		treepage.goToTryEditorPage();
		logger.info("loggeris redirected to tryeditor page");
		treepage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 0, "pythonCode"));
		String outputmessage=treepage.getOutputMessage();
		logger.info("after clicking on run button ouput message is:" +outputmessage);
		Assert.assertEquals(outputmessage,excelReader.getGivenColumnFromExcel(0, "Result"));
	}

	@Test
	public void TestInValidPythoncodeOfImplementationInPythonPage()
	{
		HomePage homePage=new HomePage(driver);
		TreePage treepage = homePage.goToTreePage();
		treepage.goToImplementationinPythonPage();
		treepage.goToTryEditorPage();
		treepage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 1, "pythonCode"));
		String alertMessage=treepage.getAlertMessage();
		logger.info("after clicking on run button ouput message is:" +alertMessage);
		Assert.assertEquals(alertMessage,excelReader.getGivenColumnFromExcel(1, "Result"));
	}
	
	@Test
	public void TestValidPythoncodeOfTreeTraversalPage()
	{
		HomePage homePage=new HomePage(driver);
		TreePage treepage = homePage.goToTreePage();
		treepage.goToTreeTraversalsPage();
		logger.info("logger is on treetraversal page");
		treepage.goToTryEditorPage();
		logger.info("loggeris redirected to tryeditor page");
		treepage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 0, "pythonCode"));
		String outputmessage=treepage.getOutputMessage();
		logger.info("after clicking on run button ouput message is:" +outputmessage);
		Assert.assertEquals(outputmessage,excelReader.getGivenColumnFromExcel(0, "Result"));
	}

	@Test
	public void TestInValidPythoncodeOfTreeTraversalPage()
	{
		HomePage homePage=new HomePage(driver);
		TreePage treepage = homePage.goToTreePage();
		treepage.goToTreeTraversalsPage();
		treepage.goToTryEditorPage();
		treepage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 1, "pythonCode"));
		String alertMessage=treepage.getAlertMessage();
		logger.info("after clicking on run button ouput message is:" +alertMessage);
		Assert.assertEquals(alertMessage,excelReader.getGivenColumnFromExcel(1, "Result"));
	}
	
	
	@Test
	public void TestValidPythoncodeOfBinaryTreeTraversalPage()
	{
		HomePage homePage=new HomePage(driver);
		TreePage treepage = homePage.goToTreePage();
		treepage.goToBinaryTreeTraversalPage();
		logger.info("logger is on binarytreetraversal page");
		treepage.goToTryEditorPage();
		logger.info("loggeris redirected to tryeditor page");
		treepage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 0, "pythonCode"));
		String outputmessage=treepage.getOutputMessage();
		logger.info("after clicking on run button ouput message is:" +outputmessage);
		Assert.assertEquals(outputmessage,excelReader.getGivenColumnFromExcel(0, "Result"));
	}

	@Test
	public void TestInValidPythoncodeOfBinaryTreeTraversalPage()
	{
		HomePage homePage=new HomePage(driver);
		TreePage treepage = homePage.goToTreePage();
		treepage.goToBinaryTreeTraversalPage();
		treepage.goToTryEditorPage();
		treepage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 1, "pythonCode"));
		String alertMessage=treepage.getAlertMessage();
		logger.info("after clicking on run button ouput message is:" +alertMessage);
		Assert.assertEquals(alertMessage,excelReader.getGivenColumnFromExcel(1, "Result"));
	}
	
	@Test
	public void TestValidPythoncodeOfImplementationOfBinaryTreesPage()
	{
		HomePage homePage=new HomePage(driver);
		TreePage treepage = homePage.goToTreePage();
		treepage.goToImplementationOfBinaryTreesPage();
		logger.info("logger is on implementationofbinarytrees page");
		treepage.goToTryEditorPage();
		logger.info("loggeris redirected to tryeditor page");
		treepage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 0, "pythonCode"));
		String outputmessage=treepage.getOutputMessage();
		logger.info("after clicking on run button ouput message is:" +outputmessage);
		Assert.assertEquals(outputmessage,excelReader.getGivenColumnFromExcel(0, "Result"));
	}

	@Test
	public void TestInValidPythoncodeOfImplementationOfBinaryTreesPage()
	{
		HomePage homePage=new HomePage(driver);
		TreePage treepage = homePage.goToTreePage();
		treepage.goToImplementationOfBinaryTreesPage();
		treepage.goToTryEditorPage();
		treepage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 1, "pythonCode"));
		String alertMessage=treepage.getAlertMessage();
		logger.info("after clicking on run button ouput message is:" +alertMessage);
		Assert.assertEquals(alertMessage,excelReader.getGivenColumnFromExcel(1, "Result"));
	}
	
	
	
	@Test
	public void TestValidPythoncodeOfApplicationOfBinaryTreesPage()
	{
		HomePage homePage=new HomePage(driver);
		TreePage treepage = homePage.goToTreePage();
		treepage.goToApplicationOfBinaryTreespage();
		logger.info("logger is on applicationofbinarytrees page");
		treepage.goToTryEditorPage();
		logger.info("loggeris redirected to tryeditor page");
		treepage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 0, "pythonCode"));
		String outputmessage=treepage.getOutputMessage();
		logger.info("after clicking on run button ouput message is:" +outputmessage);
		Assert.assertEquals(outputmessage,excelReader.getGivenColumnFromExcel(0, "Result"));
	}

	@Test
	public void TestInValidPythoncodeOfApplicationOfBinaryTreesPage()
	{
		HomePage homePage=new HomePage(driver);
		TreePage treepage = homePage.goToTreePage();
		treepage.goToApplicationOfBinaryTreespage();
		treepage.goToTryEditorPage();
		treepage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 1, "pythonCode"));
		String alertMessage=treepage.getAlertMessage();
		logger.info("after clicking on run button ouput message is:" +alertMessage);
		Assert.assertEquals(alertMessage,excelReader.getGivenColumnFromExcel(1, "Result"));
	}
	@Test
	public void TestValidPythoncodeOfBinarySearchTreesPage()
	{
		HomePage homePage=new HomePage(driver);
		TreePage treepage = homePage.goToTreePage();
		treepage.goToApplicationOfBinaryTreespage();
		logger.info("logger is on binarysearchtrees page");
		treepage.goToTryEditorPage();
		logger.info("loggeris redirected to tryeditor page");
		treepage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 0, "pythonCode"));
		String outputmessage=treepage.getOutputMessage();
		logger.info("after clicking on run button ouput message is:" +outputmessage);
		Assert.assertEquals(outputmessage,excelReader.getGivenColumnFromExcel(0, "Result"));
	}

	@Test
	public void TestInValidPythoncodeOfBinarySearchTreesPage()
	{
		HomePage homePage=new HomePage(driver);
		TreePage treepage = homePage.goToTreePage();
		treepage.goToBinarySearchTreesPage();
		treepage.goToTryEditorPage();
		treepage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 1, "pythonCode"));
		String alertMessage=treepage.getAlertMessage();
		logger.info("after clicking on run button ouput message is:" +alertMessage);
		Assert.assertEquals(alertMessage,excelReader.getGivenColumnFromExcel(1, "Result"));
	}
	
	@Test
	public void TestValidPythoncodeOfimplementationOfBSTPage()
	{
		HomePage homePage=new HomePage(driver);
		TreePage treepage = homePage.goToTreePage();
		treepage.goToImplementationOfBSTPage();
		logger.info("logger is on implementationofBst page");
		treepage.goToTryEditorPage();
		logger.info("loggeris redirected to tryeditor page");
		treepage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 0, "pythonCode"));
		String outputmessage=treepage.getOutputMessage();
		logger.info("after clicking on run button ouput message is:" +outputmessage);
		Assert.assertEquals(outputmessage,excelReader.getGivenColumnFromExcel(0, "Result"));
	}

	@Test
	public void TestInValidPythoncodeOfImplentationOfBSTPage()
	{
		HomePage homePage=new HomePage(driver);
		TreePage treepage = homePage.goToTreePage();
		treepage.goToImplementationOfBSTPage();
		treepage.goToTryEditorPage();
		treepage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 1, "pythonCode"));
		String alertMessage=treepage.getAlertMessage();
		logger.info("after clicking on run button ouput message is:" +alertMessage);
		Assert.assertEquals(alertMessage,excelReader.getGivenColumnFromExcel(1, "Result"));
	}
	
	

	@Test
	public void TestpracticeQuestionsPage()
	{
		HomePage homePage=new HomePage(driver);
		TreePage treepage = homePage.goToTreePage();
		treepage.goToOverViewOftreesPage();
		treepage.goToPracticeQuestionsPage();
		String pageTitle=driver.getTitle();
		Assert.assertEquals("Practice Questions",pageTitle);
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
