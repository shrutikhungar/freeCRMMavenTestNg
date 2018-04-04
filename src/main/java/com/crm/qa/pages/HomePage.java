package com.crm.qa.pages;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class HomePage extends TestBase{
	TestUtil testUtilObj;
	@FindBy(xpath="//td[contains(text(),'User: shruti khungar')]") WebElement userNameText;
	@FindBy(xpath="//a[contains(text(),'Contacts')]") WebElement contactsLink;
	@FindBy(xpath="//a[contains(text(),'New Contact')]") WebElement newContactLink;
	@FindBy(xpath="//a[contains(text(),'Deals')]") WebElement dealsLink;
	@FindBy(xpath="//a[contains(text(),'Tasks')]") WebElement tasksLink;
	@FindBy(xpath="//a[contains(text(),'Logout')]") WebElement logoutButton;
	
	public HomePage() throws IOException, Exception {
		testUtilObj=new TestUtil();
		PageFactory.initElements(driver, this);
		Thread.sleep(2000);
	}
	
	public String getHomePageTitle() {
		String homePageTitle=driver.getTitle();
		return homePageTitle;
	}
	
	public ContactsPage clickContactLink() throws Exception {
		contactsLink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickDealsLink() {
		dealsLink.click();
		return new DealsPage();
	}
	
	public TasksPage clickTasksLink() {
		tasksLink.click();
		return new TasksPage();
	}
	
	public boolean getUserNameHomePageLabel() {
		
		return 	userNameText.isDisplayed();
	}
	
	public boolean logoutButtonVisible() {
		return logoutButton.isDisplayed();		
	}
	
	public LoginPage performLogout() throws Exception{
		logoutButton.click();
		return new LoginPage();
	}	
	
	public void clickNewContactLink() throws Exception {
		//testUtilObj.switchToFrame("mainpanel");
		Actions actionObj=new Actions(driver);	
		Thread.sleep(3000);
		actionObj.moveToElement(newContactLink).build().perform();
		Thread.sleep(3000);
		newContactLink.click();
	}
}
