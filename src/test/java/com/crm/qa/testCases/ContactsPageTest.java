package com.crm.qa.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{
	
	ContactsPage ContactsPageObj;
	LoginPage loginPageObj;
	TestUtil testUtilObj;
	HomePage homePageObj;
	public ContactsPageTest() throws IOException {
		super();
		
	}
	
	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		loginPageObj=new LoginPage();
		testUtilObj=new TestUtil();
		ContactsPageObj=new  ContactsPage();
		homePageObj=loginPageObj.performLogin("shrutikhungar", "infyinfy");
		testUtilObj.switchToFrame("mainpanel");
		ContactsPageObj=homePageObj.clickContactLink();
	}
	
	@Test
	public void validateContactsLabel() {
		Assert.assertTrue(ContactsPageObj.getContactLabel(),"Contact Label is missing on the page.");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
