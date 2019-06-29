package com.liveguru.objects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.liveguru.commons.AbstractPage;
import com.liveguru.commons.AbstractPageUI;
import com.liveguru.commons.PageFactoryManager;

import liveguru.ProductListPageUI;

public class ProductListPageObjects extends AbstractPage {
	WebDriver driver;
	public static boolean onSale = false;

	public ProductListPageObjects(WebDriver driver) {
		this.driver = driver;
	}

	public ProductDetailPageObjects goToProductDetail(WebDriver driver, String productName) {
		clickToElement(driver, ProductListPageUI.DYNAMIC_PRODUCT_NAME, productName);
		if (driver.toString().toLowerCase().contains("internet explorer")) {
			sleep(5);
		}
		return PageFactoryManager.getProductDetailPage(driver);
	}

	public CartDetailPageObjects addItemToCart(WebDriver driver, String productName) {
		waitForElementVisible(driver, ProductListPageUI.DYNAMIC_ADD_TO_CART, productName);
		clickToElement(driver, ProductListPageUI.DYNAMIC_ADD_TO_CART, productName);
		if (driver.toString().toLowerCase().contains("internet explorer")) {
			sleep(5);
		}
		return PageFactoryManager.getCartDetailPage(driver);
	}

	public void addToCompare(String productName) {
		waitForElementVisible(driver, ProductListPageUI.DYNAMIC_ADD_TO_COMPARE, productName);
		clickToElement(driver, ProductListPageUI.DYNAMIC_ADD_TO_COMPARE, productName);
	}

	public WishListPageObjects addToWishlist(String productName) {
		waitForElementVisible(driver, ProductListPageUI.DYNAMIC_ADD_TO_WISHLIST, productName);
		clickToElement(driver, ProductListPageUI.DYNAMIC_ADD_TO_WISHLIST, productName);
		if (driver.toString().toLowerCase().contains("internet explorer")) {
			sleep(5);
		}
		return PageFactoryManager.getWishListPage(driver);
	}

	public boolean isItemInTheCompareList(String productName) {
		boolean flag = false;
		List<String> a = getTextInListOfElement(driver, ProductListPageUI.ADD_TO_COMPARE_LIST);
		for (String items : a) {
			if (items.contains(productName)) {
				flag = true;
			}
		}
		return flag;
	}

	public void clickToCompareButton() {
		waitForElementVisible(driver, ProductListPageUI.COMPARE_BUTTON);
		clickToElement(driver, ProductListPageUI.COMPARE_BUTTON);
	}

	public void switchToCompareTab() {
		String parent = getWindowHandle(driver);
		switchToChildWindow(driver, parent);
	}

	public void closePopup() {
		String parent = getWindowHandle(driver);
		closeAllExceptParentWindows(driver, parent);
	}

	public boolean isAllProductDisplayedCompareList(List<String> comparedProduct) {
		boolean flag = false;
		List<String> productAppeared = getAllProductDisplayedInCompareWindows();
		if (productAppeared.equals(comparedProduct)) {
			flag = true;
		}
		return flag;
	}

	public String getProductPrice(String productName) {
		checkProductOnSale(productName);
		System.out.println(onSale);
		if (onSale == false) {
			return getTextElement(driver, ProductListPageUI.DYNAMIC_PRODUCT_PRICE, productName);
		} else {
			return getTextElement(driver, ProductListPageUI.DYNAMIC_ONSALE_PRODUCT_PRICE, productName);
		}
	}

	public void checkProductOnSale(String productName) {
		if (!isElementUndispayed(driver, ProductListPageUI.DYNAMIC_ONSALE_PRODUCT_PRICE, productName)) {
			onSale = true;
		}
	}

	public List<String> getAllProductDisplayedInCompareWindows() {
		List<WebElement> elements = new ArrayList<WebElement>();
		List<String> productList = new ArrayList<String>();
		elements = driver.findElements(By.xpath(ProductListPageUI.COMPARE_PRODUCT));
		for (WebElement element : elements) {
			productList.add(element.getAttribute("title"));
		}
		return productList;
	}

}
