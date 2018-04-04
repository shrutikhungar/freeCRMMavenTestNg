package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{

	@FindBy(xpath="//td[contains(text(),'Contacts')]") WebElement contactsLabel;
	
	public ContactsPage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	public boolean getContactLabel() {
		return contactsLabel.isDisplayed();
	}

}
