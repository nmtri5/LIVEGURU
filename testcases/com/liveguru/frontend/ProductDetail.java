	package com.liveguru.frontend;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.liveguru.commons.AbstractTest;
import com.liveguru.commons.Constants;
import com.liveguru.commons.PageFactoryManager;
import com.liveguru.objects.HomePageObjects;
import com.liveguru.objects.ProductDetailPageObjects;
import com.liveguru.objects.ProductListPageObjects;

public class ProductDetail extends AbstractTest {
	WebDriver driver;
	HomePageObjects homePage;
	ProductListPageObjects productListPage;
	ProductDetailPageObjects productDetailPage;
	String productPrice;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeTest(String browser) {
		driver = openBrowser(browser, Constants.STAGING_URL);

		homePage = PageFactoryManager.getHomePage(driver);
	}

	@Test
	public void TC_03_VerifyPriceMatch() {
		log.info("Check matching product price - Step 01: Click Mobile");
		productListPage = (ProductListPageObjects) homePage.openAnySubPageFromHomePage(driver, "Mobile");
		
		log.info("Check matching product price - Step 02: Get price of product Sony Xperia");
		productPrice = productListPage.getProductPrice("IPhone");
		
		log.info("Check matching product price - Step 03: Go to product detail page");
		productDetailPage = productListPage.goToProductDetail(driver, "IPhone");
		
		log.info("Check matching product price - Step 04: Check the product name and price if matched");
		verifyEquals("IPHONE", productDetailPage.getProductName());
		verifyEquals(productPrice, productDetailPage.getProductPrice());
		
	}
	
	@AfterClass(alwaysRun = true)
	public void afterTest() {
		closeBrowserAndDriver(driver);
	}

}
