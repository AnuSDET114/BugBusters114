package com.numpyninja.test.pages;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.SignInPage;

public class SignInTest  extends BaseTest
{
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
		signInPage.login("Sunanda123", "sunasdet112");
		assertEquals("Invalid Username and Password",signInPage.getAlertMessage());	
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
 
