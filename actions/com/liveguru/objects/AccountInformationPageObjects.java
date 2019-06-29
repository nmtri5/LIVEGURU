package com.liveguru.objects;

import org.openqa.selenium.WebDriver;

import com.liveguru.commons.AbstractPage;
import com.liveguru.commons.AbstractPageUI;

public class AccountInformationPageObjects extends AbstractPage{
	WebDriver driver;
	
	public AccountInformationPageObjects(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getFirstNameInformation() {
		return getAttributeValue(driver, AbstractPageUI.DYNAMIC_TEXTBOX_EDIT_ACCOUNT, "value", "First Name");
	}
	
	public String getLastNameInformation() {
		return getAttributeValue(driver, AbstractPageUI.DYNAMIC_TEXTBOX_EDIT_ACCOUNT, "value", "Last Name");
	}
	
	public String getEmailInformation() {
		return getAttributeValue(driver, AbstractPageUI.DYNAMIC_TEXTBOX_EDIT_ACCOUNT, "value", "Email Address");
	}

}
