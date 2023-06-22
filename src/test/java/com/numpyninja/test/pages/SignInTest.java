package com.numpyninja.test.pages;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.SignInPage;
import utilities.ExcelReader;

public class SignInTest  extends BaseTest
{
	
	ExcelReader excelReader;
	
	@BeforeTest
	public void readExcel() {
		excelReader = new ExcelReader("signindata", readConfig.getExcelPath());
		
	}
	
	@Test
	public void validateSignInSuccessFully()
	{
		HomePage homePage=new HomePage(driver);
		SignInPage signInPage = homePage.gotoLoginPage();
		signInPage.successfullSignIn("sunandab", "sunasdet112");
		assertEquals("You are logged in",homePage.getAlertMessage());
		
	}
	@Test
	public void validateInvalidUserName() {
		HomePage homePage=new HomePage(driver);
		SignInPage signInPage = homePage.gotoLoginPage();
		signInPage.login(excelReader.getGivenColumnFromExcel(3, "username"), excelReader.getGivenColumnFromExcel(3, "password"));
		assertEquals(excelReader.getGivenColumnFromExcel(3, "expectedmessage"),signInPage.getAlertMessage());	
	}
	 
	@Test
	public void validateInvalidPassWord() {
		HomePage homePage=new HomePage(driver);
		SignInPage signInPage = homePage.gotoLoginPage();
		signInPage.login("sunandab", "sunasdet111");
		assertEquals("Invalid Username and Password",signInPage.getAlertMessage());	
	}
	
	@Test
	public void performRegisterPageValidation() {
		HomePage homePage=new HomePage(driver);
		SignInPage signInPage = homePage.gotoLoginPage();
		signInPage.goToRegisterPage();
	}
	
}
 
