package com.liveguru.objects;

import org.openqa.selenium.WebDriver;

import com.liveguru.commons.AbstractPage;
import com.liveguru.commons.AbstractPageUI;

import liveguru.RegisterPageUI;

public class RegisterPageObjects extends AbstractPage {
	WebDriver driver;

	public RegisterPageObjects(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isCreateAnAccountFormDisplayed() {
		return isElementDisplayed(driver, AbstractPageUI.DYNAMIC_TITLE, "Create an Account");
	}

	public void inputToDynamicTextbox(String locator, String content, String...options) {
		String dynamicLocator = String.format(locator, (Object[]) options);
		waitForElementVisible(driver, dynamicLocator);
		
		sendKeyToElement(driver, dynamicLocator, content);
	}

	

}
