package com.liveguru.backend;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;

import com.liveguru.commons.AbstractTest;
import com.liveguru.commons.Constants;
import com.liveguru.commons.PageFactoryManager;
import com.liveguru.objects.AdminDashboardPageObjects;
import com.liveguru.objects.AdminLoginPageObjects;
import com.liveguru.objects.AdminOrderPageObjects;

public class Checkboxes extends AbstractTest {
	WebDriver driver;
	AdminDashboardPageObjects adminDashboardPage;
	AdminLoginPageObjects adminLoginPage;
	AdminOrderPageObjects orderPage;

	String adminErrorMessage = "There are no printable documents related to selected orders.";

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browser) {
		driver = openBrowser(browser, Constants.ADMIN_URL);
		adminLoginPage = PageFactoryManager.getAdminLoginPage(driver);

		adminDashboardPage = adminLoginPage.loginToAdminPage(driver, Constants.ADMIN_USER, Constants.ADMIN_PASSWORD);
		adminDashboardPage.closePopup();
	}

	@Test
	public void TC_06_CheckboxFunction() {
		log.info("Checkbox Function - Step 01: Go to Sales -> Order menu");
		orderPage = (AdminOrderPageObjects) adminDashboardPage.selectAnyOptionFromMenu("Sales", "Orders");
		
		log.info("Checkbox Function - VP: Verify Orders title is displayed");
		verifyTrue(orderPage.isAdminPageTitleCorrect(driver, "Orders"));
		
		log.info("Checkbox Function - Step 02: Click to select visible link");
		orderPage.clickToMassActionLink("Select Visible");
		
		log.info("Checkbox Function - VP: Verify message selected");
		verifyTrue(orderPage.isNumberOfItemSelectedMessageCorrect("Select Visible"));
		
		log.info("Checkbox Function - VP: Verify all checkboxes are checked");
		verifyTrue(orderPage.isAllCheckboxesCheckedOrUnchecked("checked"));
		
		log.info("Checkbox Function - Step 03: Click to unselect visible link");
		orderPage.clickToMassActionLink("Unselect Visible");
		
		log.info("Checkbox Function - VP: Verify message selected");
		verifyTrue(orderPage.isNumberOfItemSelectedMessageCorrect("Unselect Visible"));
		
		log.info("Checkbox Function - VP: Verify all checkboxes are checked");
		verifyTrue(orderPage.isAllCheckboxesCheckedOrUnchecked("unchecked"));
	}
	
	@AfterClass
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
