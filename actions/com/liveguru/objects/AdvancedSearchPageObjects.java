package com.liveguru.objects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.liveguru.commons.AbstractPage;

import liveguru.AdvancedSearchPageUI;
import liveguru.ProductListPageUI;

public class AdvancedSearchPageObjects extends AbstractPage {
	public static boolean onSale;
	WebDriver driver;

	public AdvancedSearchPageObjects(WebDriver driver) {
		this.driver = driver;
	}

	public void inputPriceFrom(int price) {
		waitForElementVisible(driver, AdvancedSearchPageUI.PRICE_FROM_TEXTBOX);
		clearText(driver, AdvancedSearchPageUI.PRICE_FROM_TEXTBOX);
		sendKeyToElement(driver, AdvancedSearchPageUI.PRICE_FROM_TEXTBOX, String.valueOf(price));
	}

	public void inputPriceTo(int price) {
		waitForElementVisible(driver, AdvancedSearchPageUI.PRICE_TO_TEXTBOX);
		clearText(driver, AdvancedSearchPageUI.PRICE_TO_TEXTBOX);
		sendKeyToElement(driver, AdvancedSearchPageUI.PRICE_TO_TEXTBOX, String.valueOf(price));
	}

	public void clickToSearchButton() {
		waitForElementVisible(driver, AdvancedSearchPageUI.SEARCH_BUTTON);
		clickToElement(driver, AdvancedSearchPageUI.SEARCH_BUTTON);
	}

	public boolean isSearchedProductDisplayedCorrectly() {
		Map<String, String> products = new HashMap<String, String>();
		products = getAllProductDisplayedInSearchResult();

		for (String name : products.keySet()) {
			String value = products.get(name);
			System.out.println(name + " " + value);
		}

		return true;
	}

	public Map<String, String> getAllProductDisplayedInSearchResult() {
		List<WebElement> productName = new ArrayList<WebElement>();
		List<WebElement> productPrice = new ArrayList<WebElement>();

		Map<String, String> products = new HashMap<String, String>();
		productName = driver.findElements(By.xpath(AdvancedSearchPageUI.PRODUCT_NAMES));
		productPrice = driver.findElements(By.xpath(AdvancedSearchPageUI.PRODUCT_PRICES));

		for (int i = 0; i < countSearchedProductDisplayed(); i++) {
			products.put(productName.get(i).getText(), productPrice.get(i).getText());
		}

		return products;
	}

	public int countSearchedProductDisplayed() {
		return countElementNumber(driver, AdvancedSearchPageUI.SEARCHED_PRODUCT);
	}

	public void clickOnModifiedYourSearch() {
		waitForElementVisible(driver, AdvancedSearchPageUI.MODIFIER_YOUR_SEARCH_LINK);
		clickToElement(driver, AdvancedSearchPageUI.MODIFIER_YOUR_SEARCH_LINK);
	}

}
