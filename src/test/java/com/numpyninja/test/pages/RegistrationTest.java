package com.numpyninja.test.pages;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.RegisterPage;

public class RegistrationTest extends BaseTest
{

	public static Logger logger = LogManager.getLogger(RegistrationTest.class);
	
	RegisterPage registerPage = null;
	
	@BeforeTest
	public void initialize() {
		registerPage = new RegisterPage(driver);
	}
	
	@Test(priority = 1)
	public  void validregistrationWithEmptyFeilds()
	{
		registerPage.clickOnRegister();
		logger.info(" user is redirected to register page");
		AssertJUnit.assertEquals("Please fill out this field.",registerPage.getValidationMessage("userName"));
		
	}
	@Test (priority = 2)
	public  void validuserNameWithEmptyPassword()
	{
		registerPage.performRegistrationPage("sunandab","","");
		String validationMessage = registerPage.getValidationMessage("password");
		logger.info("Afetr providing creaentials Alertmessage is:" +validationMessage);
		AssertJUnit.assertEquals("Please fill out this field.",validationMessage);
		
	}
	
	@Test (priority = 3)
	public  void ValidRegistrationWithOutConfirmationPassword()
	{
		registerPage.performRegistrationPage("sunandab","asss112","");
		String validationMessage = registerPage.getValidationMessage("confirmationPassword");
		logger.info("Afetr providing creaentials Alertmessage is:" +validationMessage);
		AssertJUnit.assertEquals("Please fill out this field.",validationMessage);
		
	}
	//@Test(priority = 11)
	public  void ValidRegistrationWithCorrespondingDetails()
	{
		registerPage.performRegistrationPage("sunab5","sunasdet112","sunasdet112");
		logger.info("Afetr providing creaentials Alertmessage is:" +registerPage.getAlertMessage());
		AssertJUnit.assertEquals("New Account Created. You are logged in as sunab5",registerPage.getAlertMessage());
		
	}
	
	@Test(priority = 4)
	public void invalidUSerName()
	{
		registerPage.performRegistrationPage("suna@$8","sunasdet112","sunasdet112");
		logger.info("Afetr providing creaentials Alertmessage is:" +registerPage.getAlertMessage());
		AssertJUnit.assertEquals("password_mismatch:The two password fields didn’t match.",registerPage.getAlertMessage());
		
	}
	
	@Test(priority = 5)
	public void USerNameAlreadyExist()
	{
		registerPage.performRegistrationPage("sunandab","sunasdet112","sunasdet112");
		logger.info("Afetr providing creaentials Alertmessage is:" +registerPage.getAlertMessage());
		AssertJUnit.assertEquals("password_mismatch:The two password fields didn’t match.",registerPage.getAlertMessage());
		
	}

	@Test(priority = 6)
	public void ValiadateRegistrationWithDifferentPasswords()
	{
		registerPage.performRegistrationPage("sunandab","sunasdet112","sunasdet111");
		logger.info("Afetr providing creaentials Alertmessage is:" +registerPage.getAlertMessage());
		AssertJUnit.assertEquals("password_mismatch:The two password fields didn’t match.",registerPage.getAlertMessage());
		
	}
	@Test(priority = 7)
	public void ValiadateRegistrationWithMiniumumCharactersOfPassword()
	{
		registerPage.performRegistrationPage("sunandab","suna112","suna112");
		logger.info("Afetr providing creaentials Alertmessage is:" +registerPage.getAlertMessage());
		AssertJUnit.assertEquals("password_mismatch:The two password fields didn’t match.",registerPage.getAlertMessage());
		
	}
	
	
	@Test(priority = 8)
	public void ValiadateRegistrationWithNumericPassword()
	{
		registerPage.performRegistrationPage("sunandab","12345678","12345678");
		logger.info("Afetr providing creaentials Alertmessage is:" +registerPage.getAlertMessage());
		AssertJUnit.assertEquals("password_mismatch:The two password fields didn’t match.",registerPage.getAlertMessage());
		
	}
	
	@Test(priority = 9)
	public void ValiadateRegistrationWithCommonPassword()
	{
		registerPage.performRegistrationPage("sunandab","welcome1","welcome1");
		logger.info("Afetr providing creaentials Alertmessage is:" +registerPage.getAlertMessage());
		AssertJUnit.assertEquals("password_mismatch:The two password fields didn’t match.",registerPage.getAlertMessage());
		
	}
	
	@Test(priority = 10)
	public void ValiadateRegistrationWithsimilarusernameandPassword()
	{
		registerPage.performRegistrationPage("sunandab","sunasdetb","sunasdetb");
		logger.info("Afetr providing creaentials Alertmessage is:" +registerPage.getAlertMessage());
		AssertJUnit.assertEquals("password_mismatch:The two password fields didn’t match.",registerPage.getAlertMessage());
		
	}
	
	
}
