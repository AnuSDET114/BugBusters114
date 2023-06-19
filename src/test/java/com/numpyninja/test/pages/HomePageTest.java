package com.numpyninja.test.pages;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;

public class HomePageTest extends BaseTest
{
	@Test(priority = 2)
	public void performGetStartedWithOutLogin()
	{
		HomePage homePage=new HomePage(driver);
		homePage.goToDataStructuresPage();
		assertEquals("You are not logged in",homePage.getAlertMessage());
	}
	@Test(priority = 3)
	public void performDropDownWithOutLogin()
	{
		HomePage homePage=new HomePage(driver);
		homePage.dropDown();
		homePage.dropDownArray();
		assertEquals("You are not logged in",homePage.getAlertMessage());
	}
	
	@Test(priority = 1)
	public void gotoRegisterPage()
	{
		HomePage homePage = new HomePage(driver);
		homePage.register();
		
	}
	@Test (priority = 4)
	public void login()
	{
		HomePage homePage = new HomePage(driver);
		homePage.gotoLoginPage();
		
	}
	
	
}