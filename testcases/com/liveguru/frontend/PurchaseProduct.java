package com.liveguru.frontend;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.liveguru.commons.AbstractTest;
import com.liveguru.commons.PageFactoryManager;
import com.liveguru.objects.AccountDashboardPageObjects;
import com.liveguru.objects.CartDetailPageObjects;
import com.liveguru.objects.CheckoutPageObjects;
import com.liveguru.objects.HomePageObjects;
import com.liveguru.objects.LoginPageObjects;
import com.liveguru.objects.WishListPageObjects;
import com.liveguru.purchase.ShippingInformationJson;

public class PurchaseProduct extends AbstractTest {
	WebDriver driver;
	private ShippingInformationJson data;
	HomePageObjects homePage;
	LoginPageObjects loginPage;
	AccountDashboardPageObjects accountDashboard;
	WishListPageObjects wistlistPage;
	CartDetailPageObjects cartDetailPage;
	CheckoutPageObjects checkoutPage;
	public static String orderID = "";

	@Parameters({"browser" , "shipping"})
	@BeforeClass
	public void beforeClass(String browser, String shippdingData) throws JsonParseException, JsonMappingException, IOException {
		driver = openBrowser(browser);
		data = ShippingInformationJson.get(shippdingData);
		
		homePage = PageFactoryManager.getHomePage(driver);
		loginPage = (LoginPageObjects) homePage.openAnySubPageFromHomePage(driver, "My Account");
		accountDashboard = loginPage.doLogin(Global_RegisterToSystem.email, Global_RegisterToSystem.password);
	}

	@Test
	public void TC_09_PurchaseProduct() {
		log.info("Purchase a Product - Step 01: Click to My Wishlist Page");
		wistlistPage = (WishListPageObjects) accountDashboard.openAnySideMenuBar(driver, "My Wishlist");
		
		log.info("Purchase a Product - Step 02: Add Samsung LCD from Wishlist Page to Cart");
		cartDetailPage = wistlistPage.clickAddToCardOnSpecificProduct("Sony Xperia");
		
		log.info("Purchase a Product - Step 03: Select Canada in Shipping country");
		cartDetailPage.selectCountry("Canada");
		
		log.info("Purchase a Product - Step 04: Select Ontario in Shipping state");
		cartDetailPage.selectRegion("Ontario");
		
		log.info("Purchase a Product - Step 05: Input ZIP code");
		cartDetailPage.inputZipCode("123123");
		
		log.info("Purchase a Product - Step 06: Click Estimate button");
		cartDetailPage.clickToEstimate();
		
		log.info("Purchase a Product - Step 07: Verify if Shipping method displayed");
		verifyTrue(cartDetailPage.isShippingMethodDisplayed());
		
		log.info("Purchase a Product - Step 08: Choose a shipping method (Fixed)");
		cartDetailPage.selectShippingCost("Fixed");
		
		log.info("Purchase a Product - Step 09: Click to Update Total button");
		cartDetailPage.clickToUpdateTotal();
		
		log.info("Purchase a Product - Step 10: Verify if Final price is correctly calculated");
		verifyEquals(cartDetailPage.getFinalPrice(),cartDetailPage.calculateFinalPrice());
		
		log.info("Purchase a Product - Step 11: Click to Proceed to Checkout button");
		checkoutPage = cartDetailPage.clickProceedToCheckOut();
		
		log.info("Purchase a Product - Step 12: VP - Verify if Billing Information section is active");
		verifyTrue(checkoutPage.isSectionActive("Billing Information"));
		System.out.println("isSectionActive: " + checkoutPage.isSectionActive("Billing Information"));
		
		log.info("Purchase a Product - Step 13: Input Billing Information");
		checkoutPage.inputFirstName(data.getFirstName(), "Billing Information");
		checkoutPage.inputMiddleName(data.getMiddleName(), "Billing Information");
		checkoutPage.inputLastName(data.getLastName(), "Billing Information");
		checkoutPage.inputCompany(data.getCompany(), "Billing Information");
		checkoutPage.inputAddress(data.getAddress(), "Billing Information");
		checkoutPage.inputStreetAddress(data.getStreetAddress(), "Billing Information");
		checkoutPage.inputCity(data.getCity(), "Billing Information");
		checkoutPage.selectCountry(data.getCountry(), "Billing Information");
		checkoutPage.selectState(data.getState(), "Billing Information");
		checkoutPage.inputZIP(data.getZip(), "Billing Information");
		checkoutPage.inputTelephone(data.getTelephone(), "Billing Information");
		checkoutPage.inputFax(data.getFax(), "Billing Information");
		checkoutPage.checkToShippingAddressOptions("Ship to different address");
		
		log.info("Purchase a Product - Step 14: Click Continue button");
		checkoutPage.clickToContinueButton("Billing Information");
		
		log.info("Purchase a Product - Step 15: VP - Verify if Shipping Information section is active");
		verifyTrue(checkoutPage.isSectionActive("Billing Information"));
		
		log.info("Purchase a Product - Step 16: Input Shipping Information");
		checkoutPage.inputFirstName(data.getFirstName(), "Shipping Information");
		checkoutPage.inputMiddleName(data.getMiddleName(), "Shipping Information");
		checkoutPage.inputLastName(data.getLastName(), "Shipping Information");
		checkoutPage.inputCompany(data.getCompany(), "Shipping Information");
		checkoutPage.inputAddress(data.getAddress(), "Shipping Information");
		checkoutPage.inputStreetAddress(data.getStreetAddress(), "Shipping Information");
		checkoutPage.inputCity(data.getCity(), "Shipping Information");
		checkoutPage.selectState(data.getState(), "Shipping Information");
		checkoutPage.inputZIP(data.getZip(), "Shipping Information");
		checkoutPage.selectCountry(data.getCountry(), "Shipping Information");
		checkoutPage.inputTelephone(data.getTelephone(), "Shipping Information");
		checkoutPage.inputFax(data.getFax(), "Shipping Information");
		
		log.info("Purchase a Product - Step 17: Click Continue button");
		checkoutPage.clickToContinueButton("Shipping Information");
		
		log.info("Purchase a Product - Step 18: VP - Verify if Shipping Method section is active");
		verifyTrue(checkoutPage.isSectionActive("Shipping Method"));
		
		log.info("Purchase a Product - Step 19: Click Continue");
		checkoutPage.clickToContinueButton("Shipping Method");
		
		log.info("Purchase a Product - Step 20: VP - Verify if Payment Information section is active");
		verifyTrue(checkoutPage.isSectionActive("Payment Information"));
		
		log.info("Purchase a Product - Step 21: Check to Payment option");
		checkoutPage.selectPaymentOption("Check / Money order");
		
		log.info("Purchase a Product - Step 22: Click Continue");
		checkoutPage.clickToContinueButton("Payment Information");
		
		log.info("Purchase a Product - Step 23: VP - Verify if Order Review section is active");
		verifyTrue(checkoutPage.isSectionActive("Order Review"));
		
		log.info("Purchase a Product - Step 24: Click place order button");
		checkoutPage.clickToPlaceOrder();
		
		log.info("Purchase a Product - Step 25: VP - Verify order is generated");
		verifyTrue(checkoutPage.isOrderGenerated());
		orderID = checkoutPage.getOrderID();
	}
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
