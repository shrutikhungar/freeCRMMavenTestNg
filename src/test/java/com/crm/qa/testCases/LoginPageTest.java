package com.crm.qa.testCases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginPageObj;
	HomePage homePageObj;
	
	public LoginPageTest() throws IOException {
		super();		
	}

	@BeforeMethod
	public void setUp() {
		try {
			initialization();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			loginPageObj=new LoginPage();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("exception is: "+e);
		}
	}
	
	/*
	@Test(priority=1)
	public void ValidateloginPageTitleTest() {
		String actualPageTitle=loginPageObj.getLoginPageTitle();
		Assert.assertEquals(actualPageTitle,"Free CRM in the cloud software boosts sales");
	}
	
	@Test(priority=2)
	public void validateCrmLogoTest() {
		boolean imageCRM=loginPageObj.getImageCRM();
		Assert.assertTrue(imageCRM);
	}*/
	
	@Test(priority=3)
	public void validateLoginTest() throws Exception {
		loginPageObj.performLogin("shrutikhungar","infyinfy");
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	

}
