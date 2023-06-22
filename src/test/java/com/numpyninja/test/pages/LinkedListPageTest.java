package com.numpyninja.test.pages;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.LinkedListpage;
import utilities.ExcelReader;

public class LinkedListPageTest extends BaseTest
{
	
	ExcelReader excelReader;
	
	
	@BeforeTest
	public void initializeReader() {
		excelReader = new ExcelReader("linkedList", readConfig.getExcelPath());
	}
	
@Test
public void validateIntroductionPage()
{
	HomePage homePage=new HomePage(driver);
	LinkedListpage linkedListpage = homePage.goToLinkedListPage();
	linkedListpage.goToIntroductionPage();
	linkedListpage.goToTryEditorPage();
	
	linkedListpage.sendTextToEditorAndRun(excelReader.getGivenColumnFromExcel( 3, "pythonCode"));
	
	Assert.assertEquals(linkedListpage.getOutputMessage(),excelReader.getGivenColumnFromExcel(3, "Result"));
}

}