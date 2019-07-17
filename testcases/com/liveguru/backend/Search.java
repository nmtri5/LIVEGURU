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
import com.liveguru.objects.AdminLoginPageObjects;
import com.liveguru.objects.AdminManageCustomerPageObjects;
import com.liveguru.objects.AdminOrderPageObjects;

public class Search extends AbstractTest {
	WebDriver driver;
	AdminDashboardPageObjects adminDashboardPage;
	AdminLoginPageObjects adminLoginPage;
	AdminOrderPageObjects adminOrderPage;
	AdminManageCustomerPageObjects adminManageCustomerPage;
	
	//data for search
	String ID = "31389",
			name = "Automation FC",
			email = "automationfc.vn@gmail.com",
			telephone = "0123654789",
			zip = "550000",
			country = "Vietnam",
			state = "Cam Le";
			
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browser) {
		driver = openBrowser(browser, Constants.ADMIN_URL);
		adminLoginPage = PageFactoryManager.getAdminLoginPage(driver);

		adminDashboardPage = adminLoginPage.loginToAdminPage(driver, Constants.ADMIN_USER, Constants.ADMIN_PASSWORD);
		adminDashboardPage.closePopup();
	}

	@Test
	public void TC_05_SearchFunction() {
		log.info("Search function - Step 01: Go to Customers -> Manage Customers");
		adminManageCustomerPage = (AdminManageCustomerPageObjects) adminDashboardPage.selectAnyOptionFromMenu("Customers", "Manage Customers");
		
		log.info("Search function - VP: Verify Manage Customers title is displayed");
		adminManageCustomerPage.isAdminPageTitleCorrect(driver, "Manage Customers");
	
		log.info("Search function - Step 02: Input value to ID textbox search criteria");
		adminManageCustomerPage.inputAnySearchTextbox("entity_id[to]", ID);
		
		log.info("Search function - Step 03: Input value to Name textbox search criteria");
		adminManageCustomerPage.inputAnySearchTextbox("name", name);
		
		log.info("Search function - Step 04: Input value to Email textbox search criteria");
		adminManageCustomerPage.inputAnySearchTextbox("email", email);
		
		log.info("Search function - Step 05: Input value to Telephone textbox search criteria");
		adminManageCustomerPage.inputAnySearchTextbox("Telephone", telephone);
		
		log.info("Search function - Step 06: Input value to Zip textbox search criteria");
		adminManageCustomerPage.inputAnySearchTextbox("billing_postcode", zip);
		
		log.info("Search function - Step 07: Choose a value in Country textbox search criteria");
		adminManageCustomerPage.inputAnySearchTextbox("billing_country_id", "Vietnam");
		
		log.info("Search function - Step 08: Input value to State/Province textbox search criteria");
		adminManageCustomerPage.inputAnySearchTextbox("billing_region", state);
		
		log.info("Search function - Step 09: Click Search button");
		adminManageCustomerPage.clickToAnyButtonAdminPage(driver, "Search");
		
		log.info("Search function - Step 10: VP - Verify if the result matchs with the criteria");
		verifyTrue(adminManageCustomerPage.isSearchResultCorrectlyReturned(ID, name, email, telephone, zip, country, state));
	}

	@AfterClass
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
