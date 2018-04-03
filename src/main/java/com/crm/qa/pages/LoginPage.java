/**
 * @author D E L L
 *
 */
package com.crm.qa.pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class LoginPage extends TestBase{
	
	//pageFactory loginPage Objects
	@FindBy(name="username") public WebElement userName;
	@FindBy(name="password") public WebElement password;
	@FindBy(xpath="//input[@type='submit']") public WebElement loginButton;
	@FindBy(xpath="//button[contains(text(),'Sign Up')]") public WebElement signUpButton;
	@FindBy(xpath="//img[contains(@class,'img-responsive')]") public WebElement logoFreeCRM;
	
	//Initializing page objects 
	public LoginPage() throws IOException {
		//this refers to the current class objects
		PageFactory.initElements(driver,this);
	}
	
	//Actions: 
	public String getLoginPageTitle(){
		//this refers to the current class objects
		return driver.getTitle();
	}
	
	public boolean getImageCRM(){
		//this refers to the current class objects
		return logoFreeCRM.isDisplayed();
	}
	
	public HomePage performLogin(String uName,String pas) throws Exception{
		//this refers to the current class objects

		userName.clear();
		userName.sendKeys(uName);
		password.clear();
		password.sendKeys(pas);
		loginButton.click();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		//home page is the landing page of login page.
		//login page should return home page objects
		return new HomePage();
	}	
	
}