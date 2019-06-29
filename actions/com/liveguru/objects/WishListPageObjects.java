package com.liveguru.objects;

import org.openqa.selenium.WebDriver;

import com.liveguru.commons.AbstractPage;
import com.liveguru.commons.PageFactoryManager;

import liveguru.WishListPageUI;

public class WishListPageObjects extends AbstractPage{
	WebDriver driver;

	public WishListPageObjects(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isProductAddedToWishList(String productName) {
		String msg = "%s has been added to your wishlist. Click here to continue shopping.";
		String format = String.format(msg, productName);
		waitForElementVisible(driver, WishListPageUI.ADDED_SUCCESS_MESSAGE);
		return format.contains(getTextElement(driver, WishListPageUI.ADDED_SUCCESS_MESSAGE));
	}

	public void clickToShareWishListButton() {
		waitForElementVisible(driver, WishListPageUI.SHARE_WISHLIST_BUTTON);
		clickToElement(driver, WishListPageUI.SHARE_WISHLIST_BUTTON);
	}

	public void inputEmailAndMessage(String email, String message) {
		waitForElementVisible(driver, WishListPageUI.EMAIL_TEXTAREA);
		sendKeyToElement(driver, WishListPageUI.EMAIL_TEXTAREA, email);
		waitForElementVisible(driver, WishListPageUI.MESSAGE_TEXTAREA);
		sendKeyToElement(driver, WishListPageUI.MESSAGE_TEXTAREA, message);
	}

	public String getTextShareMessageSuccess() {
		waitForElementVisible(driver, WishListPageUI.SHARE_SUCCESS_MESSAGE);
		return getTextElement(driver, WishListPageUI.SHARE_SUCCESS_MESSAGE);
	}

	public CartDetailPageObjects clickAddToCardOnSpecificProduct(String productName) {
		waitForElementVisible(driver, WishListPageUI.DYNAMIC_ADD_PRODUCT_TO_CART, productName);
		clickToElement(driver, WishListPageUI.DYNAMIC_ADD_PRODUCT_TO_CART, productName);
		if (driver.toString().toLowerCase().contains("internet explorer")) {
			sleep(5);
		}
		return PageFactoryManager.getCartDetailPage(driver);
	}
}
