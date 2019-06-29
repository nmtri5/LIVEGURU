package com.liveguru.objects;

import org.openqa.selenium.WebDriver;

import com.liveguru.commons.AbstractPage;

import liveguru.AccountDashboardPageUI;

public class AccountDashboardPageObjects extends AbstractPage {
	WebDriver driver;
	
	public AccountDashboardPageObjects(WebDriver driver) {
		this.driver = driver;
	}

	public String isRegisterMessageSuccessDisplay() {
		return getTextElement(driver, AccountDashboardPageUI.SUCCESS_MESSAGE);
	}
	

}
