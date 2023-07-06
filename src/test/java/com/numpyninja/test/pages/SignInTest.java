package com.numpyninja.test.pages;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
	public static Logger logger = LogManager.getLogger(SignInTest.class);
	
	@Test
	public void validateSignInSuccessFully()
	{
		HomePage homePage=new HomePage(driver);
		SignInPage signInPage = homePage.gotoLoginPage();
		signInPage.successfullSignIn("sunandab", "sunasdet112");
		logger.info("Afetr signin Alertmessage is:" +homePage.getAlertMessage());
		assertEquals("You are logged in",homePage.getAlertMessage());
		
	}
	@Test
	public void validateInvalidUserName() {
		HomePage homePage=new HomePage(driver);
		SignInPage signInPage = homePage.gotoLoginPage();
		signInPage.login(excelReader.getGivenColumnFromExcel(3, "username"), excelReader.getGivenColumnFromExcel(3, "password"));
		logger.info("Afetr providing creaentials Alertmessage is:" +signInPage.getAlertMessage());
		assertEquals(excelReader.getGivenColumnFromExcel(3, "expectedmessage"),signInPage.getAlertMessage());	
	}
	 
	@Test
	public void validateInvalidPassWord() throws IOException {
		HomePage homePage=new HomePage(driver);
		SignInPage signInPage = homePage.gotoLoginPage();
		signInPage.login("sunandab", "sunasdet111");
		logger.info("Afetr providing creaentials Alertmessage is:" +signInPage.getAlertMessage());
		captureScreenShot(driver, "validateInvalidPassWord");
		assertEquals("Invalid Username and Password",signInPage.getAlertMessage());	
	}
	
	@Test
	public void performRegisterPageValidation() {
		HomePage homePage=new HomePage(driver);
		SignInPage signInPage = homePage.gotoLoginPage();
		signInPage.goToRegisterPage();
		logger.info("user redirected to register page");
	}
	
}
 
