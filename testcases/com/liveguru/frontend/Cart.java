package com.liveguru.frontend;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.liveguru.commons.AbstractTest;
import com.liveguru.commons.Constants;
import com.liveguru.commons.PageFactoryManager;
import com.liveguru.objects.CartDetailPageObjects;
import com.liveguru.objects.HomePageObjects;
import com.liveguru.objects.ProductListPageObjects;

public class Cart extends AbstractTest {
	WebDriver driver;
	HomePageObjects homePage;
	ProductListPageObjects productListPage;
	CartDetailPageObjects cartDetailPage;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browser) {
		driver = openBrowser(browser, Constants.STAGING_URL);
		
		homePage = PageFactoryManager.getHomePage(driver);
	}
	
	@Test
	public void TC_04_ApplyCoupon() {
		log.info("Apply Coupon - Step 01: Click on Mobile Menu");
		productListPage = (ProductListPageObjects) homePage.openAnySubPageFromHomePage(driver, "Mobile");
		
		log.info("Apply Coupon - Step 02: Add item to Cart");
		cartDetailPage = productListPage.addItemToCart(driver ,"IPhone");
		
		log.info("Apply Coupon - Step 03: Apply coupon");
		cartDetailPage.applyCoupon("GURU50");
		
		log.info("Apply Coupon - Step 04: Verify coupon applied succesffuly");
		verifyTrue(cartDetailPage.isCouponAppliedSuccessfully("GURU50"));
		
		log.info("Apply Coupon - Step 04: Verify final price");
		verifyEquals(cartDetailPage.getFinalPrice(), cartDetailPage.calculateFinalPrice());
	}
	
	@Test 
	public void TC_05_AddToCartLimitation() {
		log.info("Cart Product Limitation - Step 01: Click on Mobile Menu");
		productListPage = (ProductListPageObjects) cartDetailPage.openAnySubPageFromHomePage(driver, "Mobile");
		
		log.info("Cart Product Limitation - Step 02: Click add to Cart");
		cartDetailPage = productListPage.addItemToCart(driver, "Sony Xperia");
		
		log.info("Cart Product Limitation - Step 03: Verify the items is added successfully");
		verifyTrue(cartDetailPage.isProductAddedToCard("Sony Xperia"));
		
		log.info("Cart Product Limitation - Step 04: Change quantity to 501");
		cartDetailPage.editQualityToProduct("Sony Xperia", 501);
		
		log.info("Cart Product Limitation - Step 05: Click update button");
		cartDetailPage.clickUpdateQuantity("Sony Xperia");
		
		log.info("Cart Product Limitation - Step 06: Check error message display");
		verifyTrue(cartDetailPage.isErrorMessageDisplayed("Sony Xperia"));
		
	}
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
