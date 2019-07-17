package com.liveguru.backend;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.liveguru.commons.AbstractTest;
import com.liveguru.commons.Constants;
import com.liveguru.commons.PageFactoryManager;
import com.liveguru.objects.AdminDashboardPageObjects;
import com.liveguru.objects.AdminInvoicePageObjects;
import com.liveguru.objects.AdminLoginPageObjects;
import com.liveguru.objects.AdminOrderPageObjects;

public class Sorting extends AbstractTest {
	WebDriver driver;
	AdminDashboardPageObjects adminDashboardPage;
	AdminLoginPageObjects adminLoginPage;
	AdminOrderPageObjects orderPage;
	AdminInvoicePageObjects invoicesPage;
	List<String> actualList = new ArrayList<String>();
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browser) {
		driver = openBrowser(browser, Constants.ADMIN_URL);
		adminLoginPage = PageFactoryManager.getAdminLoginPage(driver);
		
		adminDashboardPage = adminLoginPage.loginToAdminPage(driver, Constants.ADMIN_USER, Constants.ADMIN_PASSWORD);
		adminDashboardPage.closePopup();
	}
	
	@Test
	public void TC_03_VerifySortFunction() {
		log.info("Sorting function - Step 01: Go to Sales -> Invoices menu");
		invoicesPage = (AdminInvoicePageObjects) adminDashboardPage.selectAnyOptionFromMenu("Sales", "Invoices");
		
		log.info("Sorting function - Step 1.1: Verify Invoices title is displayed");
		verifyTrue(invoicesPage.isAdminPageTitleCorrect(driver, "Invoices"));
		
		log.info("Sorting function - Step 02: Click on Invoices # heading to sort ascending");
		invoicesPage.clickToAnyHeadings("Invoice #");
		
		log.info("Sorting function - Step 03: Vefify if invoices list is in right order");
		actualList = invoicesPage.getInvoicesList();
		verifyTrue(invoicesPage.isSortingCorrectly("Invoice #", actualList));
		
		log.info("Sorting function - Step 04: Click on Invoices # heading to sort descending");
		invoicesPage.clickToAnyHeadings("Invoice #");
		
		log.info("Sorting function - Step 05: Vefify if invoices list is in right order");
		actualList = invoicesPage.getInvoicesList();	
		verifyTrue(invoicesPage.isSortingCorrectly("Invoice #", actualList));
		
		log.info("Sorting function - Step 06: Click on Order # heading to sort ascending");
		invoicesPage.clickToAnyHeadings("Order #");
		
		log.info("Sorting function - Step 07: Vefify if order list is in right order");
		actualList = invoicesPage.getOrderList();	
		verifyTrue(invoicesPage.isSortingCorrectly("Order #", actualList));
		
		log.info("Sorting function - Step 08: Click on Order # heading to sort descending");
		invoicesPage.clickToAnyHeadings("Order #");
		
		log.info("Sorting function - Step 09: Vefify if order list is in right order");
		actualList = invoicesPage.getOrderList();
		verifyTrue(invoicesPage.isSortingCorrectly("Order #", actualList));
		
		log.info("Sorting function - Step 10: Click on Bill to Name heading to sort ascending");
		invoicesPage.clickToAnyHeadings("Bill to Name");
		
		log.info("Sorting function - Step 11: Vefify if name list is in right order");
		actualList = invoicesPage.getBillToNameList();	
		verifyTrue(invoicesPage.isSortingCorrectly("Bill to Name", actualList));
		
		log.info("Sorting function - Step 12: Click on Bill to Name heading to sort descending");
		invoicesPage.clickToAnyHeadings("Bill to Name");
		
		log.info("Sorting function - Step 13: Vefify if name list is in right order");
		actualList = invoicesPage.getBillToNameList();
		verifyTrue(invoicesPage.isSortingCorrectly("Bill to Name", actualList));
	}
	
	

  @AfterClass
  public void afterClass() {
	  closeBrowserAndDriver(driver);
  }

}
