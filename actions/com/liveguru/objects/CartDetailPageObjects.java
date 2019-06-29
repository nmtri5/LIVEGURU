package com.liveguru.objects;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.liveguru.commons.AbstractPage;
import com.liveguru.commons.PageFactoryManager;

import liveguru.CartDetailPageUI;
import liveguru.ProductListPageUI;

public class CartDetailPageObjects extends AbstractPage {
	WebDriver driver;

	public CartDetailPageObjects(WebDriver driver) {
		this.driver = driver;
	}

	public void applyCoupon(String coupon) {
		waitForElementVisible(driver, CartDetailPageUI.COUPON_TEXTBOX);
		sendKeyToElement(driver, CartDetailPageUI.COUPON_TEXTBOX, coupon);

		waitForElementVisible(driver, CartDetailPageUI.APPLY_COUPON_BUTTON);
		clickToElement(driver, CartDetailPageUI.APPLY_COUPON_BUTTON);
	}

	public String getFinalPrice() {
		waitForElementVisible(driver, CartDetailPageUI.GRAND_PRICE_VALUE);
		return getTextElement(driver, CartDetailPageUI.GRAND_PRICE_VALUE).replaceAll("[^.a-zA-Z0-9]", "");
	}

	public String calculateFinalPrice() {
		String discount, subtotal, shipping;
		double sum = 0;
		if (isElementUndispayed(driver, CartDetailPageUI.SHIPPING_VALUE)) {
			discount = getTextElement(driver, CartDetailPageUI.DISCOUNT_VALUE).replaceAll("[^.a-zA-Z0-9]", "");
			subtotal = getTextElement(driver, CartDetailPageUI.SUBTOTAL_VALUE).replaceAll("[^.a-zA-Z0-9]", "");

			sum = Double.parseDouble(subtotal) - Double.parseDouble(discount);
		} else if (isElementUndispayed(driver, CartDetailPageUI.DISCOUNT_VALUE)) {
			shipping = getTextElement(driver, CartDetailPageUI.SHIPPING_VALUE).replaceAll("[^.a-zA-Z0-9]", "");
			subtotal = getTextElement(driver, CartDetailPageUI.SUBTOTAL_VALUE).replaceAll("[^.a-zA-Z0-9]", "");

			sum = Double.parseDouble(subtotal) + Double.parseDouble(shipping);
		}
		String z = String.valueOf(String.format("%.2f", sum));
		return z;

	}

	public boolean isCouponAppliedSuccessfully(String coupon) {
		waitForElementVisible(driver, CartDetailPageUI.APPLY_COUPON_SUCCESS);
		return getTextElement(driver, CartDetailPageUI.APPLY_COUPON_SUCCESS).contains(coupon);
	}

	public boolean isProductAddedToCard(String productName) {
		waitForElementVisible(driver, CartDetailPageUI.DYNAMIC_ITEM_IN_CART, productName);
		return isElementDisplayed(driver, CartDetailPageUI.DYNAMIC_ITEM_IN_CART, productName);
	}

	public void editQualityToProduct(String productName, int quantity) {
		waitForElementVisible(driver, CartDetailPageUI.DYNAMIC_ITEM_IN_CART, productName);
		String sku = getItemSKU(productName);
		clearText(driver, CartDetailPageUI.DYNAMIC_QUANTITY_TEXT_BOX, sku);
		sendKeyToElement(driver, String.valueOf(quantity), CartDetailPageUI.DYNAMIC_QUANTITY_TEXT_BOX, sku);
	}

	public void clickUpdateQuantity(String productName) {
		String sku = getItemSKU(productName);
		waitForElementVisible(driver, CartDetailPageUI.DYNAMIC_UPDATE_QUANTITY_BUTTON, sku);
		clickToElement(driver, CartDetailPageUI.DYNAMIC_UPDATE_QUANTITY_BUTTON, sku);
	}

	private String getItemSKU(String productName) {
		String text = getTextElement(driver, CartDetailPageUI.DYNAMIC_ITEM_SKU, productName).trim();
		return text.substring(5);
	}

	public boolean isErrorMessageDisplayed(String productName) {
		return isElementDisplayed(driver, CartDetailPageUI.DYNAMIC_ERROR_MESSAGE, productName);
	}

	public CheckoutPageObjects clickProceedToCheckOut() {
		waitForElementVisible(driver, CartDetailPageUI.PROCEED_TO_CHECKOUT_BUTTON);
		clickToElement(driver, CartDetailPageUI.PROCEED_TO_CHECKOUT_BUTTON);
		if (driver.toString().toLowerCase().contains("internet explorer")) {
			sleep(5);
		}
		return PageFactoryManager.getCheckoutPage(driver);
	}

	public void clickToUpdateTotal() {
		waitForElementVisible(driver, CartDetailPageUI.UPDATE_TOTAL_BUTTON);
		clickToElement(driver, CartDetailPageUI.UPDATE_TOTAL_BUTTON);
	}

	public void selectCountry(String country) {
		waitForElementVisible(driver, CartDetailPageUI.COUNTRY_DROPDOWN);
		selectItemInHtmlDropdown(driver, CartDetailPageUI.COUNTRY_DROPDOWN, country);
	}

	public void selectRegion(String region) {
		try {
			waitForElementVisible(driver, CartDetailPageUI.STATE_DROPDOWN);
			selectItemInHtmlDropdown(driver, CartDetailPageUI.STATE_DROPDOWN, region);
		} catch (TimeoutException ex) {
			waitForElementVisible(driver, CartDetailPageUI.STATE_TEXTBOX);
			sendKeyToElement(driver, CartDetailPageUI.STATE_TEXTBOX, region);
		}
	}

	public void inputZipCode(String zip) {
		waitForElementVisible(driver, CartDetailPageUI.ZIPCODE_TEXTBOX);
		sendKeyToElement(driver, CartDetailPageUI.ZIPCODE_TEXTBOX, zip);
	}

	public void clickToEstimate() {
		waitForElementVisible(driver, CartDetailPageUI.ESTIMATE_BUTTON);
		clickToElement(driver, CartDetailPageUI.ESTIMATE_BUTTON);
	}

	public boolean isShippingMethodDisplayed() {
		return isElementDisplayed(driver, CartDetailPageUI.SHIPPING_RATE);
	}

	public void selectShippingCost(String option) {
		if(!isElementSelected(driver, CartDetailPageUI.DYNAMIC_SHIPPING_RATE_RADIO, option)) {
			clickToElement(driver, CartDetailPageUI.DYNAMIC_SHIPPING_RATE_RADIO, option);
		}
	}
}
