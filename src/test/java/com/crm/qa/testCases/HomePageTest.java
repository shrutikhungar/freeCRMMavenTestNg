package com.crm.qa.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	
	LoginPage loginPageObj;
	HomePage homePageObj;
	ContactsPage contactPageObj;
	DealsPage dealsPageObj;
	TasksPage tasksPageObj;
	
	public HomePageTest() throws IOException {
		super();
	}
	@BeforeMethod
	public void setUp() {
		initialization();
		try {
			loginPageObj=new LoginPage();
			homePageObj=loginPageObj.performLogin("shrutikhungar", "infyinfy");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}/*
	@Test
	public contactPageObj validateContactLinkClickTest() {
		return contactPageObj homePageObj.clickContactLink();
	}
	@Test
	public void validateDealsLinkClickTest() {
		
	}
	@Test
	public void validateTasksLinkClickTest() {
		
	}
	@Test
	public void validateHomePageLabelTest() {
		
	}*/
	
	/*@Test(priority=1)
	public void validateHomePageTitleTest() throws Exception {
		String homePageTitleActual= homePageObj.getHomePageTitle();
		System.out.println("homePageTitleActual:" +homePageTitleActual);
		Assert.assertEquals(homePageTitleActual, "CRMPRO", "Home Page Title Not Match");
	}*/
	
	@Test(priority=2)
	public void validateUserTextTest() {
		Assert.assertTrue(homePageObj.getUserNameHomePageLabel());
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
