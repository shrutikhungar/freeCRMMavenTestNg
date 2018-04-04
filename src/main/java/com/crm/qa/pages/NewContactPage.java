package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class NewContactPage extends TestBase{

	@FindBy(xpath="//select[@name='title']") WebElement newContactTitle;
	@FindBy(xpath="//input[@id='first_name']") WebElement newContactFName;
	@FindBy(xpath="//input[@id='surname']") WebElement newContactLName;
	@FindBy(xpath="//input[@value='Save']") WebElement newContactSaveBtn;
	
	public NewContactPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	public void fillNewContactDetails(String title,String fName,String lName) {
		Select selectObj = new Select(newContactTitle);
		selectObj.selectByVisibleText(title);
		newContactFName.sendKeys(fName);
		newContactLName.sendKeys(lName);
		newContactSaveBtn.click();
	}

}
