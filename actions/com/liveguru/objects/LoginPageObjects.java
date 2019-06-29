package com.liveguru.objects;

import org.omg.PortableInterceptor.USER_EXCEPTION;
import org.openqa.selenium.WebDriver;

import com.fasterxml.jackson.databind.util.ConstantValueInstantiator;
import com.liveguru.commons.AbstractPage;
import com.liveguru.commons.AbstractPageUI;
import com.liveguru.commons.PageFactoryManager;

import bsh.org.objectweb.asm.Constants;
import liveguru.LoginPageUI;

public class LoginPageObjects extends AbstractPage {
	WebDriver driver;

	public LoginPageObjects(WebDriver driver) {
		this.driver = driver;
	}
	
	public AbstractPage clickToButton(String button) {
		
		if (driver.toString().toLowerCase().contains("internet explorer")) {
			driver.get(getAttributeValue(driver, AbstractPageUI.DYNAMIC_BUTTON,"href", button));
			sleep(5);
		} else {
			waitForElementVisible(driver, AbstractPageUI.DYNAMIC_BUTTON, button);
			clickToElement(driver,  AbstractPageUI.DYNAMIC_BUTTON, button);
		}
		switch (button) {
		case "Create an Account":
			return PageFactoryManager.getRegisterPage(driver);
		case "Login":
			return PageFactoryManager.getAccountDashboard(driver);
		default:
			return PageFactoryManager.getLoginPage(driver);
		}
	}
	
	public AccountDashboardPageObjects doLogin(String emailAddress, String password) 	{
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, emailAddress);
		sendKeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
		
		return (AccountDashboardPageObjects) clickToButton("Login");
		
	}
}
