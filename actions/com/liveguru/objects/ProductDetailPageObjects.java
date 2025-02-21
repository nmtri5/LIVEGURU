package com.liveguru.objects;

import org.openqa.selenium.WebDriver;

import com.liveguru.commons.AbstractPage;
import com.liveguru.commons.PageFactoryManager;

import liveguru.ProductDetailPageUI;
import liveguru.ProductListPageUI;

public class ProductDetailPageObjects extends AbstractPage {
	WebDriver driver;

	public ProductDetailPageObjects(WebDriver driver) {
		this.driver = driver;
	}

	public String getProductPrice() {
		if (isElementUndispayed(driver, ProductDetailPageUI.PRODUCT_ONSALE)) {
			return getTextElement(driver, ProductDetailPageUI.PRODUCT_PRICE);
		} else {
			return getTextElement(driver, ProductDetailPageUI.PRODUCT_SPECIAL_PRICE);
		}
	}

	public String getProductName() {
		return getTextElement(driver, ProductDetailPageUI.PRODUCT_NAME);
	}

	public ProductReviewPageObjects clickToAddReview() {
		waitForElementVisible(driver, ProductDetailPageUI.ADD_REVIEW);
		clickToElement(driver, ProductDetailPageUI.ADD_REVIEW);
		if (driver.toString().toLowerCase().contains("internet explorer")) {
			sleep(5);
		}
		return PageFactoryManager.getProductReviewPage(driver);
	}

	public void changeTabs(String tab) {
		waitForElementVisible(driver, ProductDetailPageUI.DYNAMIC_PRODUCT_TABS, tab);
		clickToElement(driver, ProductDetailPageUI.DYNAMIC_PRODUCT_TABS, tab);
	}

	public boolean isCommentDisplayed(String title, String nickname, String review) {
		return isElementDisplayed(driver, ProductDetailPageUI.DYNAMIC_REVIEW_WITH_SPECIFIC_NICKNAME, title, nickname, review );
	}

}
