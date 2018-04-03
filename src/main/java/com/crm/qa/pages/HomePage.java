package com.crm.qa.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//div[@id='dispAlertMessage']//following-sibling::table//td[@class='headertext'][1]") WebElement userNameText;
	@FindBy(xpath="//a[contains(text(),'Contacts')]") WebElement contactsLink;
	@FindBy(xpath="//a[contains(text(),'Deals')]") WebElement dealsLink;
	@FindBy(xpath="//a[contains(text(),'Tasks')]") WebElement tasksLink;
	@FindBy(xpath="//a[contains(text(),'Logout')]") WebElement logoutButton;
	
	public HomePage() throws IOException, Exception {
		Thread.sleep(2000);
		PageFactory.initElements(driver, this);
		Thread.sleep(2000);
	}
	
	public String getHomePageTitle() {
		String homePageTitle=driver.getTitle();
		return homePageTitle;
	}
	
	public ContactsPage clickContactLink() {
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
		System.out.println("userNameText: " +userNameText);
		List<WebElement> getUserNameLabel=driver.findElements(By.xpath("//div[@id='dispAlertMessage']//following-sibling::table//td[@class='headertext']"));
		WebElement ele=getUserNameLabel.get(0);
		String getUserNameLabelText=ele.getText();
		//String getuserNameText=getUserNameLabel[0];
		return userNameText.isDisplayed();		
	}
	
	public boolean logoutButtonVisible() {
		return logoutButton.isDisplayed();		
	}
	
	public LoginPage performLogout() throws Exception{
		logoutButton.click();
		return new LoginPage();
	}	
}

