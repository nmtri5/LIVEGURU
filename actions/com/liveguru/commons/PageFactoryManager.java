package com.liveguru.commons;

import org.openqa.selenium.WebDriver;

import com.liveguru.objects.AccountDashboardPageObjects;
import com.liveguru.objects.AccountInformationPageObjects;
import com.liveguru.objects.AdvancedSearchPageObjects;
import com.liveguru.objects.CartDetailPageObjects;
import com.liveguru.objects.CheckoutPageObjects;
import com.liveguru.objects.HomePageObjects;
import com.liveguru.objects.LoginPageObjects;
import com.liveguru.objects.ProductDetailPageObjects;
import com.liveguru.objects.ProductListPageObjects;
import com.liveguru.objects.ProductReviewPageObjects;
import com.liveguru.objects.RegisterPageObjects;
import com.liveguru.objects.WishListPageObjects;

public class PageFactoryManager {

	public static HomePageObjects getHomePage(WebDriver driver) {
		return new HomePageObjects(driver);
	}
	
	public static LoginPageObjects getLoginPage(WebDriver driver) {
		return new LoginPageObjects(driver);
	}
	
	public static RegisterPageObjects getRegisterPage(WebDriver driver) {
		return new RegisterPageObjects(driver);
	}

	public static AccountInformationPageObjects getAccountInformationPage(WebDriver driver) {
		return new AccountInformationPageObjects(driver);
	}

	public static AccountDashboardPageObjects getAccountDashboard(WebDriver driver) {
		return new AccountDashboardPageObjects(driver);
	}
	
	public static ProductDetailPageObjects getProductDetailPage(WebDriver driver) {
		return new ProductDetailPageObjects(driver);
	}

	public static ProductListPageObjects getProductListPage(WebDriver driver) {
		return new ProductListPageObjects(driver);
	}

	public static CartDetailPageObjects getCartDetailPage(WebDriver driver) {
		return new CartDetailPageObjects(driver);
	}

	public static WishListPageObjects getWishListPage(WebDriver driver) {
		return new WishListPageObjects(driver);
	}
	
	public static ProductReviewPageObjects getProductReviewPage(WebDriver driver) {
		return new ProductReviewPageObjects(driver);
	}
	
	public static CheckoutPageObjects getCheckoutPage(WebDriver driver) {
		return new CheckoutPageObjects(driver);
	}
	
	public static AdvancedSearchPageObjects getAdvancedSearchPage(WebDriver driver) {
		return new AdvancedSearchPageObjects(driver);
	}
}
