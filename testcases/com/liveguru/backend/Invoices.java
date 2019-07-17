package com.liveguru.backend;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.liveguru.commons.AbstractTest;
import com.liveguru.commons.Constants;
import com.liveguru.commons.PageFactoryManager;
import com.liveguru.objects.AdminDashboardPageObjects;
import com.liveguru.objects.AdminLoginPageObjects;
import com.liveguru.objects.AdminOrderPageObjects;

public class Invoices extends AbstractTest {
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
	public void TC_01_InvoiceCanBePrinted() {
		log.info("Invoice printable - Step 01: Go to Sales -> Order menu");
		orderPage = (AdminOrderPageObjects) adminDashboardPage.selectAnyOptionFromMenu("Sales", "Orders");
		
		log.info("Invoice printable - Step 1.1: Verify Orders title is displayed");
		verifyTrue(orderPage.isAdminPageTitleCorrect(driver, "Orders"));
		
		log.info("Invoice printable - Step 02: Change status to Cancel then click Search");
		orderPage.performSearchAction("Canceled");
		
		log.info("Invoice printable - Step 03: Select textbox next to first Order");
		orderPage.selectFirstOrder();
		
		log.info("Invoice printable - Step 04: Select action and click Submit");
		orderPage.selectAction("Print Invoices");
		
		log.info("Invoice printable - Step 05: Verify error message display");
		verifyEquals(orderPage.getAdminSystemMessage(driver), adminErrorMessage);
		
		log.info("Invoice printable - Step 06: Change status to Complete then click Search");
		orderPage.performSearchAction("Complete");
		
		log.info("Invoice printable - Step 07: Select textbox next to first Order");
		orderPage.selectFirstOrder();
		
		log.info("Invoice printable - Step 08: Select action and click Submit");
		orderPage.selectAction("Print Invoices");
		
		log.info("Invoice printable - Step 09: Check if the file is downloaded successfully");
		verifyTrue(orderPage.isFileDownloaded("C:\\Users\\Admin\\Downloads", "invoice"+getDate()));
	}
	
	@AfterClass
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

	public String getDate() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		return dateFormat.format(date);
	}
}
