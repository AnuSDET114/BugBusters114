package com.numpyninja.test.pages;
import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.*;
import org.apache.logging.log4j.LogManager;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;

public class HomePageTest extends BaseTest
{
	
	public static Logger logger = LogManager.getLogger(HomePageTest.class);
	
	@Test(priority = 2)
	public void performGetStartedWithOutLogin()
	{
		HomePage homePage=new HomePage(driver);
		homePage.goToDataStructuresPage();
		logger.info("user redirected to datastructurepage");
		assertEquals("You are not logged in",homePage.getAlertMessage());
	}
	@Test(priority = 3)
	public void performDropDownWithOutLogin()
	{
		HomePage homePage=new HomePage(driver);
		homePage.dropDown();
		homePage.dropDownArray();
		logger.info("click on dropdown:" +homePage.getAlertMessage());
		assertEquals("You are not logged in",homePage.getAlertMessage());
	}
	
	@Test(priority = 1)
	public void gotoRegisterPage()
	{
		HomePage homePage = new HomePage(driver);
		logger.info("user redirected to register page");
		homePage.register();
		
	}
	@Test (priority = 4)
	public void login()
	{
		
		HomePage homePage = new HomePage(driver);
		logger.info("User redirecting to login page");
		homePage.gotoLoginPage();
		
	}
	
	
}