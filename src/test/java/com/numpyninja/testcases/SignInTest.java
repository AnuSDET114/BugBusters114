package com.numpyninja.testcases;

import org.testng.annotations.Test;

import com.numpyninja.base.BaseTest;
import com.numpyninja.pages.HomePage;
import com.numpyninja.pages.SignInPage;
import com.numpyninja.utilities.ExcelReader;
import com.numpyninja.utilities.ExtentListener;

import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ExtentListener.class)
public class SignInTest  extends BaseTest
{
	
	ExcelReader excelReader;
	
	public void initialize() {
		excelReader = new ExcelReader("signindata", readConfig.getExcelPath());
		
	}
	public static Logger logger = LogManager.getLogger(SignInTest.class);
	
	@Test(priority = 4)
	public void validateSignInSuccessFully()
	{
		HomePage homePage=new HomePage(driver);
		SignInPage signInPage = homePage.gotoLoginPage();
		signInPage.successfullSignIn("sunandab", "sunasdet112");
		logger.info("Afetr signin Alertmessage is:" +homePage.getAlertMessage());
		AssertJUnit.assertEquals("You are logged in",homePage.getAlertMessage());
		
	}
	@Test (priority =  1)
	public void validateInvalidUserName() {
		initialize();
		HomePage homePage=new HomePage(driver);
		SignInPage signInPage = homePage.gotoLoginPage();
		signInPage.login(excelReader.getGivenColumnFromExcel(3, "username"), excelReader.getGivenColumnFromExcel(3, "password"));
		logger.info("Afetr providing creaentials Alertmessage is:" +signInPage.getAlertMessage());
		AssertJUnit.assertEquals(excelReader.getGivenColumnFromExcel(3, "expectedmessage"),signInPage.getAlertMessage());	
	}
	 
	@Test(priority = 2)
	public void validateInvalidPassWord() {
		HomePage homePage=new HomePage(driver);
		SignInPage signInPage = homePage.gotoLoginPage();
		signInPage.login("sunandab", "sunasdet111");
		logger.info("Afetr providing creaentials Alertmessage is:" +signInPage.getAlertMessage());
		AssertJUnit.assertEquals("Invalid Username and Password",signInPage.getAlertMessage());	
	}
	
	@Test(priority = 3)
	public void performRegisterPageValidation() {
		HomePage homePage=new HomePage(driver);
		SignInPage signInPage = homePage.gotoLoginPage();
		signInPage.goToRegisterPage();
		logger.info("user redirected to register page");
	}
	
}
 
