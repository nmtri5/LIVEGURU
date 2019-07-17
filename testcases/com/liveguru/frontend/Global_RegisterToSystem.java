package com.liveguru.frontend;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.liveguru.commons.AbstractTest;
import com.liveguru.commons.Constants;
import com.liveguru.commons.PageFactoryManager;
import com.liveguru.objects.AccountDashboardPageObjects;
import com.liveguru.objects.AccountInformationPageObjects;
import com.liveguru.objects.HomePageObjects;
import com.liveguru.objects.LoginPageObjects;
import com.liveguru.objects.RegisterPageObjects;

import liveguru.RegisterPageUI;

public class Global_RegisterToSystem extends AbstractTest {
	WebDriver driver;
	HomePageObjects homePage;
	LoginPageObjects loginPage;
	RegisterPageObjects registerPage;
	AccountDashboardPageObjects accountDashboardPage;
	AccountInformationPageObjects accountInformationPage;
	public static String USERNAME = "";

	//data 
	public static String firstName = "Tri";
	String middleName = "Minh";
	public static String lastName = "Nguyen";
	public static String email = "trinm" + randomNumber() + "@gmail.com";
	public static String password = "123346";
	String confirmPass = "123346";
	
	@Parameters("browser")
	@BeforeClass
	public void beforeTest(String browser) {
		driver = openBrowser(browser, Constants.STAGING_URL);
		
		homePage = PageFactoryManager.getHomePage(driver);
	}
	
	@Test
	public void TC_01_registerToSystemSuccessfully() {
		log.info("Register - Step 01: Hover and click to Register link on header");
		loginPage = (LoginPageObjects) homePage.openAnySubPageFromHomePage(driver, "My Account");
		
		log.info("Register - Step 02: Click to Create an Account");
		registerPage = (RegisterPageObjects) loginPage.clickToButton("Create an Account");
		
		log.info("Register - Step 03: Verify create account page display");
		verifyTrue(registerPage.isCreateAnAccountFormDisplayed());
		
		log.info("Register - Step 04: Fill in valid information and click Submit");
		registerPage.inputToDynamicTextbox(RegisterPageUI.DYNAMIC_TEXTBOX, firstName, "First Name");
		registerPage.inputToDynamicTextbox(RegisterPageUI.DYNAMIC_TEXTBOX, middleName, "Middle Name/Initial");
		registerPage.inputToDynamicTextbox(RegisterPageUI.DYNAMIC_TEXTBOX, lastName, "Last Name");
		registerPage.inputToDynamicTextbox(RegisterPageUI.DYNAMIC_TEXTBOX, email, "Email Address");
		registerPage.inputToDynamicTextbox(RegisterPageUI.DYNAMIC_TEXTBOX, password, "Password");
		registerPage.inputToDynamicTextbox(RegisterPageUI.DYNAMIC_TEXTBOX, confirmPass, "Confirm Password");
		accountDashboardPage = registerPage.clickSubmitButton(driver, "Register");
		
		log.info("Register - Step 05: Verify register message display");
		verifyEquals(accountDashboardPage.isRegisterMessageSuccessDisplay(), "Thank you for registering with Main Website Store.");
		
	}
	
	@Test
	public void TC_02_VerifyUserInformation() {
		log.info("Verify User Information - Step 01: Open Account Information page");
		accountInformationPage = (AccountInformationPageObjects) accountDashboardPage.openAnySideMenuBar(driver, "Account Information");
		
		log.info("Verify User Information - Step 02: Verify firstname");
		verifyEquals(accountInformationPage.getFirstNameInformation(), firstName);
		
		log.info("Verify User Information - Step 03: Verify lastname");
		verifyEquals(accountInformationPage.getLastNameInformation(), lastName);
		
		log.info("Verify User Information - Step 04: Verify email");
		verifyEquals(accountInformationPage.getEmailInformation(), email);
		
	}

	@AfterClass(alwaysRun = true)
	public void afterTest() {
		closeBrowserAndDriver(driver);
	}

	public static int randomNumber() {
		Random ran = new Random();
		return ran.nextInt(9999999);
	}
}
