package com.crm.qa.testCases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.NewContactPage;
import com.crm.qa.util.TestUtil;

public class NewContactPageTest extends TestBase{
	
	LoginPage LoginPageobj;
	HomePage homePageObj;
	NewContactPage newContactPageObj;
	String sheetName="new contact";
	TestUtil testUtilObj;
	
	public NewContactPageTest() throws IOException {
		super();
		testUtilObj=new TestUtil();
		// TODO Auto-generated constructor stub
	}
	
	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		LoginPageobj=new LoginPage();
		homePageObj=new HomePage();
		newContactPageObj=new NewContactPage();
		homePageObj=LoginPageobj.performLogin("shrutikhungar", "infyinfy");
		
	}
	
	@DataProvider
	public Object[][] getNewContactData() throws Exception {
		Object newContactData[][]=testUtilObj.readXLData(sheetName);
		System.out.println("data is: "+newContactData);
		return newContactData;
	}
	
	@Test(dataProvider="getNewContactData")
	public void validateNewContactSave(String title,String fName,String lName) throws Exception {
		homePageObj.clickNewContactLink();
		newContactPageObj.fillNewContactDetails(title,fName,lName);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
	
}
