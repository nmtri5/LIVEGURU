package com.liveguru.frontend;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.liveguru.commons.AbstractTest;
import com.liveguru.commons.PageFactoryManager;
import com.liveguru.objects.CartDetailPageObjects;
import com.liveguru.objects.HomePageObjects;
import com.liveguru.objects.ProductListPageObjects;

public class CompareProduct extends AbstractTest{
	WebDriver driver;
	HomePageObjects homePage;
	ProductListPageObjects productListPage;
	List<String> comparedProduct = new ArrayList<String>();
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browser) {
		driver = openBrowser(browser);
		
		homePage = PageFactoryManager.getHomePage(driver);
	}
	
	@Test 
	public void TC_06_CompareProduct() {
		log.info("Compare 2 products - Step 01: Click on Mobile Menu");
		productListPage = (ProductListPageObjects) homePage.openAnySubPageFromHomePage(driver, "Mobile");
	
		log.info("Compare 2 products - Step 02: Add to Compare first item");
		productListPage.addToCompare("Sony Xperia");
		
		log.info("Compare 2 products - Step 03: Verify first item is in compare waiting list");
		productListPage.isItemInTheCompareList("Sony Xperia");
		comparedProduct.add("Sony Xperia"); //add to list for checking later
		
		log.info("Compare 2 products - Step 04: Add to Compare second item");
		productListPage.addToCompare("Samsung Galaxy");		
		
		log.info("Compare 2 products - Step 05: Verify second item is in compare waiting list");
		productListPage.isItemInTheCompareList("Samsung Galaxy");
		comparedProduct.add("Samsung Galaxy"); //add to list for checking later
		
		log.info("Compare 2 products - Step 06: Click compare button");
		productListPage.clickToCompareButton();
		
		log.info("Compare 2 products - Step 07: Switch to the popup");
		productListPage.switchToCompareTab();
		
		log.info("Compare 2 products - Step 08: Verify if all products are appeared");
		verifyTrue(productListPage.isAllProductDisplayedCompareList(comparedProduct));
		
		log.info("Compare 2 products - Step 09: Close popup");
		productListPage.closePopup();
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}
}
