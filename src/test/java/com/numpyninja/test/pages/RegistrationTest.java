package com.numpyninja.test.pages;
import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.RegisterPage;

public class RegistrationTest extends BaseTest
{

	public static Logger logger = LogManager.getLogger(RegistrationTest.class);
	@Test
	public  void validregistrationWithEmptyFeilds()
	{
		HomePage homepage=new HomePage(driver);
		RegisterPage registerPage=homepage.goToRegisterPage();
		registerPage.clickOnRegister();
		logger.info(" user is redirected to register page");
		assertEquals("Please fill out this field.",registerPage.getValidationMessage("userName"));
		
	}
	@Test
	public  void validuserNameWithEmptyPassword()
	{
		HomePage homepage=new HomePage(driver);
		RegisterPage registerPage=homepage.goToRegisterPage();
		registerPage.performRegistrationPage("sunandab","","");
		logger.info("Afetr providing creaentials Alertmessage is:" +registerPage.getValidationMessage("password"));
		assertEquals("Please fill out this field.",registerPage.getValidationMessage("password"));
		
	}
	
	@Test
	public  void ValidRegistrationWithOutConfirmationPassword() throws IOException
	{
		HomePage homepage=new HomePage(driver);
		RegisterPage registerPage=homepage.goToRegisterPage();
		registerPage.performRegistrationPage("sunandab","asss112","");
		logger.info("After providing credentials:" +registerPage.getValidationMessage("confirmationPassword"));
		captureScreenShot(driver, "ValidRegistrationWithOutConfirmationPassword");
		assertEquals("Please fill out this field.",registerPage.getValidationMessage("confirmationPassword"));
		
	}
	//@Test
	public  void ValidRegistrationWithCorrespondingDetails()
	{
		HomePage homepage=new HomePage(driver);
		RegisterPage registerPage=homepage.goToRegisterPage();
		registerPage.performRegistrationPage("sunab5","sunasdet112","sunasdet112");
		logger.info("Afetr providing creaentials Alertmessage is:" +registerPage.getAlertMessage());
		assertEquals("New Account Created. You are logged in as sunab5",homepage.getAlertMessage());
		
	}
	
	@Test
	public void invalidUSerName()
	{
		HomePage homepage=new HomePage(driver);
		RegisterPage registerPage=homepage.goToRegisterPage();
		registerPage.performRegistrationPage("suna@$8","sunasdet112","sunasdet112");
		logger.info("Afetr providing creaentials Alertmessage is:" +registerPage.getAlertMessage());
		assertEquals("password_mismatch:The two password fields didn’t match.",registerPage.getAlertMessage());
		
	}
	
	@Test
	public void USerNameAlreadyExist()
	{
		HomePage homepage=new HomePage(driver);
		RegisterPage registerPage=homepage.goToRegisterPage();
		registerPage.performRegistrationPage("sunandab","sunasdet112","sunasdet112");
		logger.info("Afetr providing creaentials Alertmessage is:" +registerPage.getAlertMessage());
		assertEquals("password_mismatch:The two password fields didn’t match.",registerPage.getAlertMessage());
		
	}

	@Test
	public void ValiadateRegistrationWithDifferentPasswords()
	{
		HomePage homepage=new HomePage(driver);
		RegisterPage registerPage=homepage.goToRegisterPage();
		registerPage.performRegistrationPage("sunandab","sunasdet112","sunasdet111");
		logger.info("Afetr providing creaentials Alertmessage is:" +registerPage.getAlertMessage());
		assertEquals("password_mismatch:The two password fields didn’t match.",registerPage.getAlertMessage());
		
	}
	@Test
	public void ValiadateRegistrationWithMiniumumCharactersOfPassword()
	{
		HomePage homepage=new HomePage(driver);
		RegisterPage registerPage=homepage.goToRegisterPage();
		registerPage.performRegistrationPage("sunandab","suna112","suna112");
		logger.info("Afetr providing creaentials Alertmessage is:" +registerPage.getAlertMessage());
		assertEquals("password_mismatch:The two password fields didn’t match.",registerPage.getAlertMessage());
		
	}
	
	
	@Test
	public void ValiadateRegistrationWithNumericPassword()
	{
		HomePage homepage=new HomePage(driver);
		RegisterPage registerPage=homepage.goToRegisterPage();
		registerPage.performRegistrationPage("sunandab","12345678","12345678");
		logger.info("Afetr providing creaentials Alertmessage is:" +registerPage.getAlertMessage());
		assertEquals("password_mismatch:The two password fields didn’t match.",registerPage.getAlertMessage());
		
	}
	
	@Test
	public void ValiadateRegistrationWithCommonPassword()
	{
		HomePage homepage=new HomePage(driver);
		RegisterPage registerPage=homepage.goToRegisterPage();
		registerPage.performRegistrationPage("sunandab","welcome1","welcome1");
		logger.info("Afetr providing creaentials Alertmessage is:" +registerPage.getAlertMessage());
		assertEquals("password_mismatch:The two password fields didn’t match.",registerPage.getAlertMessage());
		
	}
	
	@Test
	public void ValiadateRegistrationWithsimilarusernameandPassword()
	{
		HomePage homepage=new HomePage(driver);
		RegisterPage registerPage=homepage.goToRegisterPage();
		registerPage.performRegistrationPage("sunandab","sunasdetb","sunasdetb");
		logger.info("Afetr providing creaentials Alertmessage is:" +registerPage.getAlertMessage());
		assertEquals("password_mismatch:The two password fields didn’t match.",registerPage.getAlertMessage());
		
	}
	
	
}
