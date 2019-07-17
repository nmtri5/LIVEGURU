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
import com.liveguru.objects.AdminEditReviewPageObjects;
import com.liveguru.objects.AdminLoginPageObjects;
import com.liveguru.objects.AdminReviewPageObjects;
import com.liveguru.objects.HomePageObjects;
import com.liveguru.objects.ProductDetailPageObjects;
import com.liveguru.objects.ProductListPageObjects;
import com.liveguru.objects.ProductReviewPageObjects;

public class ReviewMechanism extends AbstractTest {
	WebDriver driver;
	HomePageObjects homePage;
	ProductListPageObjects productListPage;
	ProductReviewPageObjects productReviewPage;
	ProductDetailPageObjects productDetailPage;
	AdminLoginPageObjects adminLoginPage;
	AdminDashboardPageObjects adminDashboardPage;
	AdminReviewPageObjects adminReviewPage;
	AdminEditReviewPageObjects adminEditReviewPage;
	
	String nickname = "johncena", 
			review = "This product is really bad", 
			title = "doesnt like",
			success_message = "The review has been saved.";

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browser) {
		driver = openBrowser(browser, Constants.STAGING_URL);

		homePage = PageFactoryManager.getHomePage(driver);

		log.info("Review Mechanism - Precondition - Step 01: Open TV");
		productListPage = (ProductListPageObjects) homePage.openAnySubPageFromHomePage(driver, "TV");

		log.info("Review Mechanism - Precondition - Step 02: Choose Samsung LCD");
		productDetailPage = productListPage.goToProductDetail(driver, "Samsung LCD");
		
		log.info("Review Mechanism - Precondition - Step 03: Click to Add review");
		productReviewPage = productDetailPage.clickToAddReview();
		
		log.info("Review Mechanism - Precondition - Step 04: Input to Let us know your thought textbox with a proper value");
		productReviewPage.inputToLetUsKnowYourThought(review);
		
		log.info("Review Mechanism - Precondition - Step 05: Input to summary review textbox with a proper value");
		productReviewPage.inputToSummaryReview(title);
		
		log.info("Review Mechanism - Precondition - Step 06: Input to Nickname textbox with a proper value");
		productReviewPage.inputToNickName(nickname);
		
		log.info("Review Mechanism - Precondition - Step 07: Click Submit Review button");
		productReviewPage.clickToSubmitReview();
		
		log.info("Review Mechanism - Precondition - Step 08: Go to admin backend page");
		adminLoginPage = (AdminLoginPageObjects) productReviewPage.openAnyUrl(driver, Constants.ADMIN_URL);
		
		adminDashboardPage = adminLoginPage.loginToAdminPage(driver, Constants.ADMIN_USER, Constants.ADMIN_PASSWORD);
		adminDashboardPage.closePopup();
	}

	@Test
	public void TC_02_ProductReviewMechanism() {
		log.info("Review Mechanism - Step 01: Go to Sales -> Order menu");
		adminReviewPage = (AdminReviewPageObjects) adminDashboardPage.selectAnyOptionFromMenu("Catalog", "Reviews and Ratings", "Customer Reviews", "Pending Reviews");
		
		log.info("Review Mechanism - Step 1.1: Verify Pending Reviews title is displayed");
		adminReviewPage.isAdminPageTitleCorrect(driver, "Pending Reviews");

		log.info("Review Mechanism - Step 02: Select the recently posted review");
		adminEditReviewPage = (AdminEditReviewPageObjects) adminReviewPage.selectAnySpecificReview("edit", title, nickname, review);

		log.info("Review Mechanism - Step 03: Change status to Approved and click Submit");
		adminEditReviewPage.changeReviewStatus("Approved");

		log.info("Review Mechanisme - Step 04: Verify success message");
		verifyEquals(adminEditReviewPage.getAdminSystemMessage(driver), success_message);

		log.info("Review Mechanism - Step 05: Go back to staging url");
		homePage = (HomePageObjects) adminEditReviewPage.openAnyUrl(driver, Constants.STAGING_URL);

		log.info("Review Mechanism - Step 06: Change status to Complete then click Search");
		productListPage = (ProductListPageObjects) homePage.openAnySubPageFromHomePage(driver, "TV");
		
		log.info("Review Mechanism - Step 07: Select textbox next to first Order");
		productDetailPage = productListPage.goToProductDetail(driver, "Samsung LCD");

		log.info("Review Mechanism - Step 08: Select action and click Submit");
		productDetailPage.changeTabs("Reviews");

		log.info("Review Mechanism - Step 09: Check if the comment displayed");
		verifyTrue(productDetailPage.isCommentDisplayed(title, nickname, review));
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
