package com.crm.qa.testCases;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.NewContactPage;

public class NewContactPageTest extends TestBase{
	
	LoginPage LoginPageobj;
	HomePage homePageObj;
	NewContactPage newContactPageObj;
		
	public NewContactPageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		LoginPageobj=new LoginPage();
		homePageObj=new HomePage();
		newContactPageObj=new NewContactPage();
		homePageObj=LoginPageobj.performLogin("shrutikhungar", "infyinfy");
		Thread.sleep(4000);
	}
	
	@Test
	public void validateNewContactSave() throws Exception {
		homePageObj.clickNewContactLink();
		newContactPageObj.fillNewContactDetails("Miss","Vasvi","Khungar");
	}
	
}
