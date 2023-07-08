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
import pages.SignInPage;
import pages.TreePage;
import utilities.ExcelReader;

public class TreePageTest extends BaseTest
{
	ExcelReader excelReader;
	TreePage treepage;
	public static Logger logger = LogManager.getLogger(GraphPageTest.class);
	
	@BeforeTest
	public void initializeReader()
	{
		launchURL();
		HomePage homepage=new HomePage(driver);
		treepage=homepage.goToTreePage();
//		SignInPage  signinpage =homepage.gotoLoginPage();
//		signinpage.successfullSignIn("sunandab", "sunasdet112");
		
		excelReader = new ExcelReader("Tree", readConfig.getExcelPath());
	}
	
	@Test(priority=1)
	public void TestValidPythoncodeOfOverViewOfTreesPage()
	{
		treepage.goToOverViewOftreesPage();
		logger.info("logger is on overviewoftrees page");
		treepage.goToTryEditorPage();
		logger.info("loggeris redirected to tryeditor page");
		treepage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 0, "pythonCode"));
		String outputmessage=treepage.getOutputMessage();
		logger.info("after clicking on run button ouput message is:" +outputmessage);
		AssertJUnit.assertEquals(outputmessage,excelReader.getGivenColumnFromExcel(0, "Result"));
	}

	@Test(priority=2)
	public void TestInValidPythoncodeOfOverViewOfTreesPage()
	{
		//treepage.goToOverViewOftreesPage();
		//treepage.goToTryEditorPage();
		treepage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 1, "pythonCode"));
		String alertMessage=treepage.getAlertMessage();
		logger.info("after clicking on run button ouput message is:" +alertMessage);
		AssertJUnit.assertEquals(alertMessage,excelReader.getGivenColumnFromExcel(1, "Result"));
	}


	@Test(priority=3)
	public void TestValidPythoncodeTerminologiesPage()
	{
		treepage.LaunchTreePage();
		treepage.goToTerminologiesPage();
		logger.info("logger is on terminologies page");
		treepage.goToTryEditorPage();
		logger.info("loggeris redirected to tryeditor page");
		treepage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 0, "pythonCode"));
		String outputmessage=treepage.getOutputMessage();
		logger.info("after clicking on run button ouput message is:" +outputmessage);
		AssertJUnit.assertEquals(outputmessage,excelReader.getGivenColumnFromExcel(0, "Result"));
	}

	@Test(priority=4)
	public void TestInValidPythoncodeOfTerminologiesPage()
	{
		//treepage.goToTerminologiesPage();
		//treepage.goToTryEditorPage();
		treepage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 1, "pythonCode"));
		String alertMessage=treepage.getAlertMessage();
		logger.info("after clicking on run button ouput message is:" +alertMessage);
		AssertJUnit.assertEquals(alertMessage,excelReader.getGivenColumnFromExcel(1, "Result"));
	}


	@Test(priority=5)
	public void TestValidPythoncodeOfTypesOfTreesPage()

	{
		treepage.LaunchTreePage();
		treepage.goToTypesOfTreesPage();
		logger.info("logger is on typesoftrees page");
		treepage.goToTryEditorPage();
		logger.info("loggeris redirected to tryeditor page");
		treepage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel(2, "pythonCode"));
		String outputmessage=treepage.getOutputMessage();
		logger.info("after clicking on run button ouput message is:" +outputmessage);
		AssertJUnit.assertEquals(outputmessage,excelReader.getGivenColumnFromExcel(2, "Result"));
	}

	@Test(priority=6)
	public void TestInValidPythoncodeOfTypesOfTreePage()
	{
		//treepage.goToTypesOfTreesPage();
		//treepage.goToTryEditorPage();
		treepage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 1, "pythonCode"));
		String alertMessage=treepage.getAlertMessage();
		logger.info("after clicking on run button ouput message is:" +alertMessage);
		AssertJUnit.assertEquals(alertMessage,excelReader.getGivenColumnFromExcel(1, "Result"));
	}
	
	
	@Test(priority=7)
	public void TestValidPythoncodeOfTraversalIllustrationPage()
	{
		treepage.LaunchTreePage();
		treepage.goToTraversalIllustrationPage();
		logger.info("logger is on traversalillustration page");
		treepage.goToTryEditorPage();
		logger.info("loggeris redirected to tryeditor page");
		treepage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 0, "pythonCode"));
		String outputmessage=treepage.getOutputMessage();
		logger.info("after clicking on run button ouput message is:" +outputmessage);
		AssertJUnit.assertEquals(outputmessage,excelReader.getGivenColumnFromExcel(0, "Result"));
	}

	@Test(priority=8)
	public void TestInValidPythoncodeOfTraversalIllustrationPage()
	{
		//treepage.goToTraversalIllustrationPage();
		//treepage.goToTryEditorPage();
		treepage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 1, "pythonCode"));
		String alertMessage=treepage.getAlertMessage();
		logger.info("after clicking on run button ouput message is:" +alertMessage);
		AssertJUnit.assertEquals(alertMessage,excelReader.getGivenColumnFromExcel(1, "Result"));
	}
	
	@Test(priority=9)
	public void TestValidPythoncodeOfBinaryTreesPage()
	{
		treepage.LaunchTreePage();
		treepage.goToBinaryTreesPage();
		logger.info("logger is on binarytrees page");
		treepage.goToTryEditorPage();
		logger.info("loggeris redirected to tryeditor page");
		treepage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 0, "pythonCode"));
		String outputmessage=treepage.getOutputMessage();
		logger.info("after clicking on run button ouput message is:" +outputmessage);
		AssertJUnit.assertEquals(outputmessage,excelReader.getGivenColumnFromExcel(0, "Result"));
	}

	@Test(priority=10)
	public void TestInValidPythoncodeOfBinaryTreesPage()
	{
		//treepage.goToBinaryTreesPage();
		//treepage.goToTryEditorPage();
		treepage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 1, "pythonCode"));
		String alertMessage=treepage.getAlertMessage();
		logger.info("after clicking on run button ouput message is:" +alertMessage);
		AssertJUnit.assertEquals(alertMessage,excelReader.getGivenColumnFromExcel(1, "Result"));
	}
	
	
	@Test(priority=11)
	public void TestValidPythoncodeOfTypesOfBinaryTreesPage()
	{
		treepage.LaunchTreePage();
		treepage.goTOTypesOfBinaryTreesPage();
		logger.info("logger is on typesofbinarytrees page");
		treepage.goToTryEditorPage();
		logger.info("loggeris redirected to tryeditor page");
		treepage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 0, "pythonCode"));
		String outputmessage=treepage.getOutputMessage();
		logger.info("after clicking on run button ouput message is:" +outputmessage);
		AssertJUnit.assertEquals(outputmessage,excelReader.getGivenColumnFromExcel(0, "Result"));
	}

	@Test(priority=12)
	public void TestInValidPythoncodeOfTypesOfBinaryTreesPage()
	{
		//treepage.goTOTypesOfBinaryTreesPage();
		//treepage.goToTryEditorPage();
		treepage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 1, "pythonCode"));
		String alertMessage=treepage.getAlertMessage();
		logger.info("after clicking on run button ouput message is:" +alertMessage);
		AssertJUnit.assertEquals(alertMessage,excelReader.getGivenColumnFromExcel(1, "Result"));
	}
	
	
	@Test(priority=13)
	public void TestValidPythoncodeOfImplementationInPythonPage()
	{
		treepage.LaunchTreePage();
		treepage.goToImplementationinPythonPage();
		logger.info("logger is on implementatationinpython page");
		treepage.goToTryEditorPage();
		logger.info("loggeris redirected to tryeditor page");
		treepage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 0, "pythonCode"));
		String outputmessage=treepage.getOutputMessage();
		logger.info("after clicking on run button ouput message is:" +outputmessage);
		AssertJUnit.assertEquals(outputmessage,excelReader.getGivenColumnFromExcel(0, "Result"));
	}

	@Test(priority=14)
	public void TestInValidPythoncodeOfImplementationInPythonPage()
	{
		//treepage.goToImplementationinPythonPage();
		//treepage.goToTryEditorPage();
		treepage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 1, "pythonCode"));
		String alertMessage=treepage.getAlertMessage();
		logger.info("after clicking on run button ouput message is:" +alertMessage);
		AssertJUnit.assertEquals(alertMessage,excelReader.getGivenColumnFromExcel(1, "Result"));
	}
	
	@Test(priority=15)
	public void TestValidPythoncodeOfTreeTraversalPage()
	{
		treepage.LaunchTreePage();
		treepage.goToTreeTraversalsPage();
		logger.info("logger is on treetraversal page");
		treepage.goToTryEditorPage();
		logger.info("loggeris redirected to tryeditor page");
		treepage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 0, "pythonCode"));
		String outputmessage=treepage.getOutputMessage();
		logger.info("after clicking on run button ouput message is:" +outputmessage);
		AssertJUnit.assertEquals(outputmessage,excelReader.getGivenColumnFromExcel(0, "Result"));
	}

	@Test(priority=16)
	public void TestInValidPythoncodeOfTreeTraversalPage()
	{
		//treepage.goToTreeTraversalsPage();
		//treepage.goToTryEditorPage();
		treepage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 1, "pythonCode"));
		String alertMessage=treepage.getAlertMessage();
		logger.info("after clicking on run button ouput message is:" +alertMessage);
		AssertJUnit.assertEquals(alertMessage,excelReader.getGivenColumnFromExcel(1, "Result"));
	}
	
	
	@Test(priority=17)
	public void TestValidPythoncodeOfBinaryTreeTraversalPage()
	{
		treepage.LaunchTreePage();
		treepage.goToBinaryTreeTraversalPage();
		logger.info("logger is on binarytreetraversal page");
		treepage.goToTryEditorPage();
		logger.info("loggeris redirected to tryeditor page");
		treepage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 0, "pythonCode"));
		String outputmessage=treepage.getOutputMessage();
		logger.info("after clicking on run button ouput message is:" +outputmessage);
		AssertJUnit.assertEquals(outputmessage,excelReader.getGivenColumnFromExcel(0, "Result"));
	}

	@Test(priority=18)
	public void TestInValidPythoncodeOfBinaryTreeTraversalPage()
	{
		//treepage.goToBinaryTreeTraversalPage();
		//treepage.goToTryEditorPage();
		treepage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 1, "pythonCode"));
		String alertMessage=treepage.getAlertMessage();
		logger.info("after clicking on run button ouput message is:" +alertMessage);
		AssertJUnit.assertEquals(alertMessage,excelReader.getGivenColumnFromExcel(1, "Result"));
	}
	
	@Test(priority=19)
	public void TestValidPythoncodeOfImplementationOfBinaryTreesPage()
	{
		treepage.LaunchTreePage();
		treepage.goToImplementationOfBinaryTreesPage();
		logger.info("logger is on implementationofbinarytrees page");
		treepage.goToTryEditorPage();
		logger.info("loggeris redirected to tryeditor page");
		treepage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 0, "pythonCode"));
		String outputmessage=treepage.getOutputMessage();
		logger.info("after clicking on run button ouput message is:" +outputmessage);
		AssertJUnit.assertEquals(outputmessage,excelReader.getGivenColumnFromExcel(0, "Result"));
	}

	@Test(priority=20)
	public void TestInValidPythoncodeOfImplementationOfBinaryTreesPage()
	{
		//treepage.goToImplementationOfBinaryTreesPage();
		//treepage.goToTryEditorPage();
		treepage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 1, "pythonCode"));
		String alertMessage=treepage.getAlertMessage();
		logger.info("after clicking on run button ouput message is:" +alertMessage);
		AssertJUnit.assertEquals(alertMessage,excelReader.getGivenColumnFromExcel(1, "Result"));
	}
	
	
	
	@Test(priority=21)
	public void TestValidPythoncodeOfApplicationOfBinaryTreesPage()
	{
		treepage.LaunchTreePage();
		treepage.goToApplicationOfBinaryTreespage();
		logger.info("logger is on applicationofbinarytrees page");
		treepage.goToTryEditorPage();
		logger.info("loggeris redirected to tryeditor page");
		treepage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 0, "pythonCode"));
		String outputmessage=treepage.getOutputMessage();
		logger.info("after clicking on run button ouput message is:" +outputmessage);
		AssertJUnit.assertEquals(outputmessage,excelReader.getGivenColumnFromExcel(0, "Result"));
	}

	@Test(priority=22)
	public void TestInValidPythoncodeOfApplicationOfBinaryTreesPage()
	{
		//treepage.goToApplicationOfBinaryTreespage();
		//treepage.goToTryEditorPage();
		treepage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 1, "pythonCode"));
		String alertMessage=treepage.getAlertMessage();
		logger.info("after clicking on run button ouput message is:" +alertMessage);
		AssertJUnit.assertEquals(alertMessage,excelReader.getGivenColumnFromExcel(1, "Result"));
	}
	@Test(priority=23)
	public void TestValidPythoncodeOfBinarySearchTreesPage()
	{
		treepage.LaunchTreePage();
		treepage.goToApplicationOfBinaryTreespage();
		logger.info("logger is on binarysearchtrees page");
		treepage.goToTryEditorPage();
		logger.info("loggeris redirected to tryeditor page");
		treepage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 0, "pythonCode"));
		String outputmessage=treepage.getOutputMessage();
		logger.info("after clicking on run button ouput message is:" +outputmessage);
		AssertJUnit.assertEquals(outputmessage,excelReader.getGivenColumnFromExcel(0, "Result"));
	}

	@Test(priority=24)
	public void TestInValidPythoncodeOfBinarySearchTreesPage()
	{
		//treepage.goToBinarySearchTreesPage();
		//treepage.goToTryEditorPage();
		treepage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 1, "pythonCode"));
		String alertMessage=treepage.getAlertMessage();
		logger.info("after clicking on run button ouput message is:" +alertMessage);
		AssertJUnit.assertEquals(alertMessage,excelReader.getGivenColumnFromExcel(1, "Result"));
	}
	
	@Test(priority=25)
	public void TestValidPythoncodeOfimplementationOfBSTPage()
	{
		treepage.LaunchTreePage();
		treepage.goToImplementationOfBSTPage();
		logger.info("logger is on implementationofBst page");
		treepage.goToTryEditorPage();
		logger.info("loggeris redirected to tryeditor page");
		treepage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 0, "pythonCode"));
		String outputmessage=treepage.getOutputMessage();
		logger.info("after clicking on run button ouput message is:" +outputmessage);
		AssertJUnit.assertEquals(outputmessage,excelReader.getGivenColumnFromExcel(0, "Result"));
	}

	@Test(priority=26)
	public void TestInValidPythoncodeOfImplentationOfBSTPage()
	{
		//treepage.goToImplementationOfBSTPage();
		//treepage.goToTryEditorPage();
		treepage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 1, "pythonCode"));
		String alertMessage=treepage.getAlertMessage();
		logger.info("after clicking on run button ouput message is:" +alertMessage);
		AssertJUnit.assertEquals(alertMessage,excelReader.getGivenColumnFromExcel(1, "Result"));
	}
	
	

	@Test(priority=27)
	public void TestpracticeQuestionsPage()
	{
		treepage.LaunchTreePage();
		treepage.goToOverViewOftreesPage();
		treepage.goToPracticeQuestionsPage();
		String pageTitle=driver.getTitle();
		AssertJUnit.assertEquals("Practice Questions",pageTitle);
	
	}
	
	
	
}
