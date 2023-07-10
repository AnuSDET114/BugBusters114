package com.numpyninja.testcases;


import org.testng.annotations.Test;

import com.numpyninja.base.BaseTest;
import com.numpyninja.pages.HomePage;
import com.numpyninja.pages.LinkedListpage;
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
public class LinkedListPageTest extends BaseTest
{
	
	ExcelReader excelReader;
	LinkedListpage linkedListpage;
	public static Logger logger = LogManager.getLogger(LinkedListPageTest.class);
	
	@BeforeTest
	public void initializeReader()
	{
		HomePage homepage=new HomePage(driver);
		homepage.launchHomePage();
		linkedListpage=homepage.goToLinkedListPage();
//		SignInPage  signinpage =homepage.gotoLoginPage();
//		signinpage.successfullSignIn("sunandab", "sunasdet112");
		
		excelReader = new ExcelReader("linkedList", readConfig.getExcelPath());
	}
	
@Test(priority=1)
public void TestValidPythoncodeOfIntroductionPage()
{	
	linkedListpage.goToIntroductionPage();
	logger.info("logger is on introduction page");
	linkedListpage.goToTryEditorPage();
	logger.info("loggeris redirected to tryeditor page");
	linkedListpage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 0, "pythonCode"));
	String outputmessage=linkedListpage.getOutputMessage();
	logger.info("after clicking on run button ouput message is:" +outputmessage);
	AssertJUnit.assertEquals(outputmessage,excelReader.getGivenColumnFromExcel(0, "Result"));
}

@Test(priority=2)
public void TestInValidPythoncodeOfIntroductionPage()
{
	//linkedListpage.goToIntroductionPage();
	//linkedListpage.goToTryEditorPage();
	linkedListpage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 1, "pythonCode"));
	String alertMessage=linkedListpage.getAlertMessage();
	logger.info("after clicking on run button ouput message is:" +alertMessage);
	AssertJUnit.assertEquals(alertMessage,excelReader.getGivenColumnFromExcel(1, "Result"));
}


@Test(priority=3)
public void TestValidPythonCodeOfCreateALinkedListsPage()
{
	linkedListpage.launchLinkedlistPage();
	linkedListpage.goToCreateALinkedListPage();
	linkedListpage.goToTryEditorPage();
	linkedListpage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 2, "pythonCode"));
	String outputmessage=linkedListpage.getOutputMessage();
	logger.info("after clicking on run button ouput message is:" +outputmessage);
	AssertJUnit.assertEquals(outputmessage,excelReader.getGivenColumnFromExcel(2, "Result"));
}

@Test(priority=4)
public void TestInValidPythoncodeOfCreateALinkedListPage()
{
	//linkedListpage.goToCreateALinkedListPage();
	//linkedListpage.goToTryEditorPage();
	linkedListpage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 1, "pythonCode"));
	String alertMessage = linkedListpage.getAlertMessage();
	logger.info("after clicking on run button ouput message is:" +alertMessage);
	AssertJUnit.assertEquals(alertMessage,excelReader.getGivenColumnFromExcel(1, "Result"));
}






@Test(priority=5)
public void TestValidPythonCodeOfTypesofLinkedListsPage()
{	
	linkedListpage.launchLinkedlistPage();
	linkedListpage.goToTypesofLinkedListPage();
	linkedListpage.goToTryEditorPage();
	linkedListpage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel(2, "pythonCode"));
	String outputmessage=linkedListpage.getOutputMessage();
	logger.info("after clicking on run button ouput message is:" +outputmessage);
	AssertJUnit.assertEquals(outputmessage,excelReader.getGivenColumnFromExcel(2, "Result"));
}

@Test(priority=6)
public void TestInValidPythoncodeOfTypesofLinkedListPage()
{
	//linkedListpage.goToTypesofLinkedListPage();
	//linkedListpage.goToTryEditorPage();
	linkedListpage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 1, "pythonCode"));
	String alertMessage=linkedListpage.getAlertMessage();
	logger.info("after clicking on run button ouput message is:" +alertMessage);
	AssertJUnit.assertEquals(alertMessage,excelReader.getGivenColumnFromExcel(1, "Result"));
}




@Test(priority=7)
public void TestvalidPhythoncodeOfImplementedLinkedListsPage()
{
	linkedListpage.launchLinkedlistPage();
	linkedListpage.goToImplementedLinkedListPage();
	linkedListpage.goToTryEditorPage();
	linkedListpage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 0, "pythonCode"));
	String outputmessage=linkedListpage.getOutputMessage();
	logger.info("after clicking on run button ouput message is:" +outputmessage);
	AssertJUnit.assertEquals(outputmessage,excelReader.getGivenColumnFromExcel(0, "Result"));
}

@Test(priority=8)
public void TestInValidPythoncodeOfImplementedLinkedListPage()
{
	//linkedListpage.goToImplementedLinkedListPage();
	//linkedListpage.goToTryEditorPage();
	linkedListpage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 1, "pythonCode"));
	String alertMessage=linkedListpage.getAlertMessage();
	logger.info("after clicking on run button ouput message is:" +alertMessage);
	AssertJUnit.assertEquals(alertMessage,excelReader.getGivenColumnFromExcel(1, "Result"));
}


@Test(priority=9)
public void TestValidPhythoncodeOfTraversalLinkedListsPage()
{
	linkedListpage.launchLinkedlistPage();
	linkedListpage.goToTraversalLinkedListPage();
	linkedListpage.goToTryEditorPage();
	linkedListpage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 2, "pythonCode"));
	String outputmessage=linkedListpage.getOutputMessage();
	logger.info("after clicking on run button ouput message is:" +outputmessage);
	AssertJUnit.assertEquals(outputmessage,excelReader.getGivenColumnFromExcel(2, "Result"));
}

@Test(priority=10)
public void TestInValidPythoncodeOfTraversalLinkedListPage()
{
	//linkedListpage.goToTraversalLinkedListPage();
	//linkedListpage.goToTryEditorPage();
	linkedListpage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 3, "pythonCode"));
	String alertMessage=linkedListpage.getAlertMessage();
	logger.info("after clicking on run button ouput message is:" +alertMessage);
	AssertJUnit.assertEquals(alertMessage,excelReader.getGivenColumnFromExcel(3, "Result"));
}


@Test(priority=11)
public void TestValidPythoncodeOfInsertionLinkedListsPage()
{
	linkedListpage.launchLinkedlistPage();
	linkedListpage.goToInsertionLinkedListPage();
	linkedListpage.goToTryEditorPage();
	linkedListpage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel(0, "pythonCode"));
	String outputmessage=linkedListpage.getOutputMessage();
	logger.info("after clicking on run button ouput message is:" +outputmessage);
	AssertJUnit.assertEquals(outputmessage,excelReader.getGivenColumnFromExcel(0, "Result"));
}

@Test(priority=12)
public void TestInValidPythoncodeOfInsertionLinkedListPage()
{
	//linkedListpage.goToInsertionLinkedListPage();
	//linkedListpage.goToTryEditorPage();
	linkedListpage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 3, "pythonCode"));
	String alertMessage=linkedListpage.getAlertMessage();
	logger.info("after clicking on run button ouput message is:" +alertMessage);
	AssertJUnit.assertEquals(alertMessage,excelReader.getGivenColumnFromExcel(3, "Result"));
}


@Test(priority=13)
public void TestValidPhythoncodeOfDeletionLinkedListsPage()
{	
	linkedListpage.launchLinkedlistPage();
	linkedListpage.goToDeletionLinkedListPage();
	linkedListpage.goToTryEditorPage();
	linkedListpage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel(2, "pythonCode"));
	String outputmessage=linkedListpage.getOutputMessage();
	logger.info("after clicking on run button ouput message is:" +outputmessage);
	AssertJUnit.assertEquals(outputmessage,excelReader.getGivenColumnFromExcel(2, "Result"));
}

@Test(priority=14)
public void TestInValidPythoncodeOfDeletionLinkedListPage()
{
	//linkedListpage.goToDeletionLinkedListPage();
	//linkedListpage.goToTryEditorPage();
	linkedListpage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel(3, "pythonCode"));
	String alertMessage=linkedListpage.getAlertMessage();
	logger.info("after clicking on run button ouput message is:" +alertMessage);
	AssertJUnit.assertEquals(alertMessage,excelReader.getGivenColumnFromExcel(3, "Result"));
}
@Test(priority=15)
public void TestpracticeQuestionsPage()
{	
	linkedListpage.launchLinkedlistPage();
	linkedListpage.goToIntroductionPage();
	linkedListpage.goToPracticeQuestionsPage();
	String pageTitle=driver.getTitle();
	AssertJUnit.assertEquals("Practice Questions",pageTitle);

}






}


