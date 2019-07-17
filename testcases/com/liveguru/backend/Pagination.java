package com.liveguru.backend;

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

public class Pagination extends AbstractTest {
	WebDriver driver;
	AdminDashboardPageObjects adminDashboardPage;
	AdminLoginPageObjects adminLoginPage;
	AdminOrderPageObjects adminOrderPage;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browser) {
		driver = openBrowser(browser, Constants.ADMIN_URL);
		adminLoginPage = PageFactoryManager.getAdminLoginPage(driver);

		adminDashboardPage = adminLoginPage.loginToAdminPage(driver, Constants.ADMIN_USER, Constants.ADMIN_PASSWORD);
		adminDashboardPage.closePopup();
	}
	
	@Test
	public void TC_04_CheckPagination() {
		log.info("Pagination - Step 01: Go to Sales -> Invoices menu");
		adminOrderPage = (AdminOrderPageObjects) adminDashboardPage.selectAnyOptionFromMenu("Sales", "Orders");
		
		log.info("Pagination - Step 02: VP - Verify number of item displayed in one page is correct");
		verifyTrue(adminOrderPage.isNumberOfRowCorrected());
		
		log.info("Pagination - Step 03: Change number of item displayed in one page to 30");
		adminOrderPage.selectNumberOfRowAppearedInPage("30");
		
		log.info("Pagination - Step 04: VP - Verify number of item displayed in one page is correct");
		verifyTrue(adminOrderPage.isNumberOfRowCorrected());
		
		log.info("Pagination - Step 05: Change number of item displayed in one page to 50");
		adminOrderPage.selectNumberOfRowAppearedInPage("50");
		
		log.info("Pagination - Step 06: VP - Verify number of item displayed in one page is correct");
		verifyTrue(adminOrderPage.isNumberOfRowCorrected());
		
		log.info("Pagination - Step 07: Change number of item displayed in one page to 100");
		adminOrderPage.selectNumberOfRowAppearedInPage("100");
		
		log.info("Pagination - Step 08: VP - Verify number of item displayed in one page is correct");
		verifyTrue(adminOrderPage.isNumberOfRowCorrected());
		
		log.info("Pagination - Step 09: Change number of item displayed in one page to 200");
		adminOrderPage.selectNumberOfRowAppearedInPage("200");
		
		log.info("Pagination - Step 10: VP - Verify number of item displayed in one page is correct");
		verifyTrue(adminOrderPage.isNumberOfRowCorrected());
	}

	@AfterClass
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
