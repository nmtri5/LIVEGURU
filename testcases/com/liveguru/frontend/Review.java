package com.liveguru.frontend;

import org.testng.annotations.Test;

import com.liveguru.commons.AbstractTest;
import com.liveguru.commons.PageFactoryManager;
import com.liveguru.objects.AccountDashboardPageObjects;
import com.liveguru.objects.HomePageObjects;
import com.liveguru.objects.LoginPageObjects;
import com.liveguru.objects.ProductDetailPageObjects;
import com.liveguru.objects.ProductListPageObjects;
import com.liveguru.objects.ProductReviewPageObjects;
import com.liveguru.objects.RegisterPageObjects;
import com.liveguru.objects.WishListPageObjects;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class Review extends AbstractTest{
	WebDriver driver;
	HomePageObjects homePage;
	LoginPageObjects loginPage;
	RegisterPageObjects registerPage;
	ProductListPageObjects productListPage;
	ProductReviewPageObjects productReviewPage;
	ProductDetailPageObjects productDetailPage;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browser) {
		driver = openBrowser(browser);
		
		homePage = PageFactoryManager.getHomePage(driver);
	}

	@Test
	public void TC_08_AddReview() {
		log.info("Add Review - Step 01: Open TV");
		productListPage = (ProductListPageObjects) homePage.openAnySubPageFromHomePage(driver, "TV");
		
		log.info("Add Review - Step 02: Choose Samsung LCD");
		productDetailPage = productListPage.goToProductDetail(driver, "Samsung LCD");
		
		log.info("Add Review - Step 03: Click to Add review");
		productReviewPage = productDetailPage.clickToAddReview();
		
		log.info("Add Review - Step 04: Input to Let us know your thought textbox with a blank");
		productReviewPage.inputToLetUsKnowYourThought("");
		
		log.info("Add Review - Step 05: Input to summary review textbox with a blank");
		productReviewPage.inputToSummaryReview("");
		
		log.info("Add Review - Step 06: Input to Nickname textbox with a blank");
		productReviewPage.inputToNickName("");
		
		log.info("Add Review - Step 07: Click Submit Review button");
		productReviewPage.clickToSubmitReview();
		
		log.info("Add Review - Step 08: Verify error message at let us know textbox");
		verifyTrue(productReviewPage.isErrorMessageDisplayedForSpecificTextBox("Let us know your thoughts"));
		
		log.info("Add Review - Step 09: Verify error message at summary textbox");
		verifyTrue(productReviewPage.isErrorMessageDisplayedForSpecificTextBox("Summary of Your Review"));
		
		log.info("Add Review - Step 10: Verify error message at nickname textbox");
		verifyTrue(productReviewPage.isErrorMessageDisplayedForSpecificTextBox("What's your nickname?"));
		
		log.info("Add Review - Step 11: Input to Let us know your thought textbox with proper value");
		productReviewPage.inputToLetUsKnowYourThought("this is good");
		
		log.info("Add Review - Step 12: Input to summary review textbox with proper value");
		productReviewPage.inputToSummaryReview("best");
		
		log.info("Add Review - Step 13: Input to Nickname textbox with proper value");
		productReviewPage.inputToNickName("trnm");
		
		log.info("Add Review - Step 14: Click Submit Review button");
		productReviewPage.clickToSubmitReview();
		
		log.info("Add Review - Step 15: Verify review success message and its content");
		verifyTrue(productReviewPage.isReviewSuccessMessageDisplayed());
		verifyEquals(productReviewPage.isReviewSuccessMessageCorrect(), "Your review has been accepted for moderation.");
	}
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
