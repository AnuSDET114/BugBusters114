package com.numpyninja.test.pages;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.RegisterPage;

public class RegistrationTest extends BaseTest
{

	@Test
	public  void validregistrationWithEmptyFeilds()
	{
		HomePage homepage=new HomePage(driver);
		RegisterPage registerPage=homepage.goToRegisterPage();
		registerPage.clickOnRegister();
		assertEquals("Please fill out this field.",registerPage.getValidationMessage("userName"));
		
	}
	@Test
	public  void validuserNameWithEmptyPassword()
	{
		HomePage homepage=new HomePage(driver);
		RegisterPage registerPage=homepage.goToRegisterPage();
		registerPage.performRegistrationPage("sunandab","","");
		assertEquals("Please fill out this field.",registerPage.getValidationMessage("password"));
		
	}
	
	@Test
	public  void ValidRegistrationWithOutConfirmationPassword()
	{
		HomePage homepage=new HomePage(driver);
		RegisterPage registerPage=homepage.goToRegisterPage();
		registerPage.performRegistrationPage("sunandab","asss112","");
		assertEquals("Please fill out this field.",registerPage.getValidationMessage("confirmationPassword"));
		
	}
	//@Test
	public  void ValidRegistrationWithCorrespondingDetails()
	{
		HomePage homepage=new HomePage(driver);
		RegisterPage registerPage=homepage.goToRegisterPage();
		registerPage.performRegistrationPage("sunab5","sunasdet112","sunasdet112");
		assertEquals("New Account Created. You are logged in as sunab5",homepage.getAlertMessage());
		
	}
	
	@Test
	public void invalidUSerName()
	{
		HomePage homepage=new HomePage(driver);
		RegisterPage registerPage=homepage.goToRegisterPage();
		registerPage.performRegistrationPage("suna@$8","sunasdet112","sunasdet112");
		assertEquals("password_mismatch:The two password fields didn’t match.",registerPage.getAlertMessage());
		
	}
	
	@Test
	public void USerNameAlreadyExist()
	{
		HomePage homepage=new HomePage(driver);
		RegisterPage registerPage=homepage.goToRegisterPage();
		registerPage.performRegistrationPage("sunandab","sunasdet112","sunasdet112");
		assertEquals("password_mismatch:The two password fields didn’t match.",registerPage.getAlertMessage());
		
	}

	@Test
	public void ValiadateRegistrationWithDifferentPasswords()
	{
		HomePage homepage=new HomePage(driver);
		RegisterPage registerPage=homepage.goToRegisterPage();
		registerPage.performRegistrationPage("sunandab","sunasdet112","sunasdet111");
		assertEquals("password_mismatch:The two password fields didn’t match.",registerPage.getAlertMessage());
		
	}
	@Test
	public void ValiadateRegistrationWithMiniumumCharactersOfPassword()
	{
		HomePage homepage=new HomePage(driver);
		RegisterPage registerPage=homepage.goToRegisterPage();
		registerPage.performRegistrationPage("sunandab","suna112","suna112");
		assertEquals("password_mismatch:The two password fields didn’t match.",registerPage.getAlertMessage());
		
	}
	
	
	@Test
	public void ValiadateRegistrationWithNumericPassword()
	{
		HomePage homepage=new HomePage(driver);
		RegisterPage registerPage=homepage.goToRegisterPage();
		registerPage.performRegistrationPage("sunandab","12345678","12345678");
		assertEquals("password_mismatch:The two password fields didn’t match.",registerPage.getAlertMessage());
		
	}
	
	@Test
	public void ValiadateRegistrationWithCommonPassword()
	{
		HomePage homepage=new HomePage(driver);
		RegisterPage registerPage=homepage.goToRegisterPage();
		registerPage.performRegistrationPage("sunandab","welcome1","welcome1");
		assertEquals("password_mismatch:The two password fields didn’t match.",registerPage.getAlertMessage());
		
	}
	
	@Test
	public void ValiadateRegistrationWithsimilarusernameandPassword()
	{
		HomePage homepage=new HomePage(driver);
		RegisterPage registerPage=homepage.goToRegisterPage();
		registerPage.performRegistrationPage("sunandab","sunasdetb","sunasdetb");
		assertEquals("password_mismatch:The two password fields didn’t match.",registerPage.getAlertMessage());
		
	}
	
	
}
