package com.liveguru.objects;

import org.openqa.selenium.WebDriver;

import com.liveguru.commons.AbstractPage;

import liveguru.CheckoutPageUI;

public class CheckoutPageObjects extends AbstractPage {
	WebDriver driver;

	public CheckoutPageObjects(WebDriver driver) {
		this.driver = driver;
	}

	public void inputFirstName(String firstName, String section) {
		
		switch (section) {
		case "Billing Information":
			clearText(driver, CheckoutPageUI.DYNAMIC_BILLING_INFORMATION_TEXTBOX, "First Name");
			waitForElementVisible(driver, CheckoutPageUI.DYNAMIC_BILLING_INFORMATION_TEXTBOX, "First Name");
			sendKeyToElement(driver, firstName, CheckoutPageUI.DYNAMIC_BILLING_INFORMATION_TEXTBOX, "First Name");
			break;
		case "Shipping Information":
			clearText(driver, CheckoutPageUI.DYNAMIC_SHIPPING_INFORMATION_TEXTBOX, "First Name");
			waitForElementVisible(driver, CheckoutPageUI.DYNAMIC_SHIPPING_INFORMATION_TEXTBOX, "First Name");
			sendKeyToElement(driver, firstName, CheckoutPageUI.DYNAMIC_SHIPPING_INFORMATION_TEXTBOX, "First Name");
			break;
		}
	}

	public void inputMiddleName(String middleName, String section) {
		
		switch (section) {
		case "Billing Information":
			clearText(driver, CheckoutPageUI.DYNAMIC_BILLING_INFORMATION_TEXTBOX, "Middle Name");
			waitForElementVisible(driver, CheckoutPageUI.DYNAMIC_BILLING_INFORMATION_TEXTBOX, "Middle Name");
			sendKeyToElement(driver, middleName, CheckoutPageUI.DYNAMIC_BILLING_INFORMATION_TEXTBOX, "Middle Name");
			break;
		case "Shipping Information":
			clearText(driver, CheckoutPageUI.DYNAMIC_SHIPPING_INFORMATION_TEXTBOX, "Middle Name");
			waitForElementVisible(driver, CheckoutPageUI.DYNAMIC_SHIPPING_INFORMATION_TEXTBOX, "Middle Name");
			sendKeyToElement(driver, middleName, CheckoutPageUI.DYNAMIC_SHIPPING_INFORMATION_TEXTBOX, "Middle Name");
			break;
		}
	}

	public void inputLastName(String lastName, String section) {
		switch (section) {
		case "Billing Information":
			clearText(driver, CheckoutPageUI.DYNAMIC_BILLING_INFORMATION_TEXTBOX, "Last Name");
			waitForElementVisible(driver, CheckoutPageUI.DYNAMIC_BILLING_INFORMATION_TEXTBOX, "Last Name");
			sendKeyToElement(driver, lastName, CheckoutPageUI.DYNAMIC_BILLING_INFORMATION_TEXTBOX, "Last Name");
			break;
		case "Shipping Information":
			clearText(driver, CheckoutPageUI.DYNAMIC_SHIPPING_INFORMATION_TEXTBOX, "Last Name");
			waitForElementVisible(driver, CheckoutPageUI.DYNAMIC_SHIPPING_INFORMATION_TEXTBOX, "Last Name");
			sendKeyToElement(driver, lastName, CheckoutPageUI.DYNAMIC_SHIPPING_INFORMATION_TEXTBOX, "Last Name");
			break;
		}
	}

	public void inputCompany(String company, String section) {
		switch (section) {
		case "Billing Information":
			clearText(driver, CheckoutPageUI.DYNAMIC_BILLING_INFORMATION_TEXTBOX, "Company");
			waitForElementVisible(driver, CheckoutPageUI.DYNAMIC_BILLING_INFORMATION_TEXTBOX, "Company");
			sendKeyToElement(driver, company, CheckoutPageUI.DYNAMIC_BILLING_INFORMATION_TEXTBOX, "Company");
			break;
		case "Shipping Information":
			clearText(driver, CheckoutPageUI.DYNAMIC_SHIPPING_INFORMATION_TEXTBOX, "Company");
			waitForElementVisible(driver, CheckoutPageUI.DYNAMIC_SHIPPING_INFORMATION_TEXTBOX, "Company");
			sendKeyToElement(driver, company, CheckoutPageUI.DYNAMIC_SHIPPING_INFORMATION_TEXTBOX, "Company");
			break;
		}
	}

	public void inputAddress(String address, String section) {
		switch (section) {
		case "Billing Information":
			clearText(driver, CheckoutPageUI.DYNAMIC_BILLING_INFORMATION_TEXTBOX, "Address");
			waitForElementVisible(driver, CheckoutPageUI.DYNAMIC_BILLING_INFORMATION_TEXTBOX, "Address");
			sendKeyToElement(driver, address, CheckoutPageUI.DYNAMIC_BILLING_INFORMATION_TEXTBOX, "Address");
			break;
		case "Shipping Information":
			clearText(driver, CheckoutPageUI.DYNAMIC_SHIPPING_INFORMATION_TEXTBOX, "Address");
			waitForElementVisible(driver, CheckoutPageUI.DYNAMIC_SHIPPING_INFORMATION_TEXTBOX, "Address");
			sendKeyToElement(driver, address, CheckoutPageUI.DYNAMIC_SHIPPING_INFORMATION_TEXTBOX, "Address");
			break;
		}
	}

	public void inputStreetAddress(String streetAddress, String section) {
		switch (section) {
		case "Billing Information":
			clearText(driver, CheckoutPageUI.DYNAMIC_BILLING_INFORMATION_TEXTBOX, "Address 2");
			waitForElementVisible(driver, CheckoutPageUI.DYNAMIC_BILLING_INFORMATION_TEXTBOX, "Address 2");
			sendKeyToElement(driver, streetAddress, CheckoutPageUI.DYNAMIC_BILLING_INFORMATION_TEXTBOX, "Address 2");
			break;
		case "Shipping Information":
			clearText(driver, CheckoutPageUI.DYNAMIC_SHIPPING_INFORMATION_TEXTBOX, "Address 2");
			waitForElementVisible(driver, CheckoutPageUI.DYNAMIC_SHIPPING_INFORMATION_TEXTBOX, "Address 2");
			sendKeyToElement(driver, streetAddress, CheckoutPageUI.DYNAMIC_SHIPPING_INFORMATION_TEXTBOX, "Address 2");
			break;
		}
	}

	public void inputCity(String city, String section) {
		switch (section) {
		case "Billing Information":
			clearText(driver, CheckoutPageUI.DYNAMIC_BILLING_INFORMATION_TEXTBOX, "City");
			waitForElementVisible(driver, CheckoutPageUI.DYNAMIC_BILLING_INFORMATION_TEXTBOX, "City");
			sendKeyToElement(driver, city, CheckoutPageUI.DYNAMIC_BILLING_INFORMATION_TEXTBOX, "City");
			break;
		case "Shipping Information":
			clearText(driver, CheckoutPageUI.DYNAMIC_SHIPPING_INFORMATION_TEXTBOX, "City");
			waitForElementVisible(driver, CheckoutPageUI.DYNAMIC_SHIPPING_INFORMATION_TEXTBOX, "City");
			sendKeyToElement(driver, city, CheckoutPageUI.DYNAMIC_SHIPPING_INFORMATION_TEXTBOX, "City");
			break;
		}
	}

	public void inputZIP(String zip, String section) {
		switch (section) {
		case "Billing Information":
			clearText(driver, CheckoutPageUI.DYNAMIC_BILLING_INFORMATION_TEXTBOX, "Zip");
			waitForElementVisible(driver, CheckoutPageUI.DYNAMIC_BILLING_INFORMATION_TEXTBOX, "Zip");
			sendKeyToElement(driver, zip, CheckoutPageUI.DYNAMIC_BILLING_INFORMATION_TEXTBOX, "Zip");
			break;
		case "Shipping Information":
			clearText(driver, CheckoutPageUI.DYNAMIC_SHIPPING_INFORMATION_TEXTBOX, "Zip");
			waitForElementVisible(driver, CheckoutPageUI.DYNAMIC_SHIPPING_INFORMATION_TEXTBOX, "Zip");
			sendKeyToElement(driver, zip, CheckoutPageUI.DYNAMIC_SHIPPING_INFORMATION_TEXTBOX, "Zip");
			break;
		}
	}

	public void inputFax(String fax, String section) {
		switch (section) {
		case "Billing Information":
			clearText(driver, CheckoutPageUI.DYNAMIC_BILLING_INFORMATION_TEXTBOX, "Fax");
			waitForElementVisible(driver, CheckoutPageUI.DYNAMIC_BILLING_INFORMATION_TEXTBOX, "Fax");
			sendKeyToElement(driver, fax, CheckoutPageUI.DYNAMIC_BILLING_INFORMATION_TEXTBOX, "Fax");
			break;
		case "Shipping Information":
			clearText(driver, CheckoutPageUI.DYNAMIC_SHIPPING_INFORMATION_TEXTBOX, "Fax");
			waitForElementVisible(driver, CheckoutPageUI.DYNAMIC_SHIPPING_INFORMATION_TEXTBOX, "Fax");
			sendKeyToElement(driver, fax, CheckoutPageUI.DYNAMIC_SHIPPING_INFORMATION_TEXTBOX, "Fax");
			break;
		}
	}

	public void inputTelephone(String telephone, String section) {
		switch (section) {
		case "Billing Information":
			clearText(driver, CheckoutPageUI.DYNAMIC_BILLING_INFORMATION_TEXTBOX, "Telephone");
			waitForElementVisible(driver, CheckoutPageUI.DYNAMIC_BILLING_INFORMATION_TEXTBOX, "Telephone");
			sendKeyToElement(driver, telephone, CheckoutPageUI.DYNAMIC_BILLING_INFORMATION_TEXTBOX, "Telephone");
			break;
		case "Shipping Information":
			clearText(driver, CheckoutPageUI.DYNAMIC_SHIPPING_INFORMATION_TEXTBOX, "Telephone");
			waitForElementVisible(driver, CheckoutPageUI.DYNAMIC_SHIPPING_INFORMATION_TEXTBOX, "Telephone");
			sendKeyToElement(driver, telephone, CheckoutPageUI.DYNAMIC_SHIPPING_INFORMATION_TEXTBOX, "Telephone");
			break;
		}
	}

	public void selectCountry(String country, String section) {
		switch (section) {
		case "Billing Information":
			waitForElementVisible(driver, CheckoutPageUI.DYNAMIC_BILLING_INFORMATION_TEXTBOX, "Country");
			selectItemInHtmlDropdown(driver, country, CheckoutPageUI.DYNAMIC_BILLING_INFORMATION_TEXTBOX, "Country");
			break;
		case "Shipping Information":
			waitForElementVisible(driver, CheckoutPageUI.DYNAMIC_SHIPPING_INFORMATION_TEXTBOX, "Country");
			sendKeyToElement(driver, country, CheckoutPageUI.DYNAMIC_SHIPPING_INFORMATION_TEXTBOX, "Country");
			break;
		}
	}

	public void selectState(String state, String section) {
		switch (section) {
		case "Billing Information":
			waitForElementVisible(driver, CheckoutPageUI.DYNAMIC_BILLING_INFORMATION_TEXTBOX, "State");
			selectItemInHtmlDropdown(driver, state, CheckoutPageUI.DYNAMIC_BILLING_INFORMATION_TEXTBOX, "State");
			break;
		case "Shipping Information":
			waitForElementVisible(driver, CheckoutPageUI.DYNAMIC_SHIPPING_INFORMATION_TEXTBOX, "State");
			sendKeyToElement(driver, state, CheckoutPageUI.DYNAMIC_SHIPPING_INFORMATION_TEXTBOX, "State");
			break;
		}
	}
	

	public void clickToContinueButton(String section) {
		switch (section) {
		case "Billing Information":
			waitForElementVisible(driver, CheckoutPageUI.DYNAMIC_CHECKOUT_CONTINUE_BUTTON, "Billing Information");
			clickToElement(driver, CheckoutPageUI.DYNAMIC_CHECKOUT_CONTINUE_BUTTON, "Billing Information");
			break;
		case "Shipping Information":
			waitForElementVisible(driver, CheckoutPageUI.DYNAMIC_CHECKOUT_CONTINUE_BUTTON, "Shipping Information");
			clickToElement(driver, CheckoutPageUI.DYNAMIC_CHECKOUT_CONTINUE_BUTTON, "Shipping Information");
			break;
		case "Shipping Method":
			waitForElementVisible(driver, CheckoutPageUI.DYNAMIC_CHECKOUT_CONTINUE_BUTTON, "Shipping Method");
			clickToElement(driver, CheckoutPageUI.DYNAMIC_CHECKOUT_CONTINUE_BUTTON, "Shipping Method");
			break;
		case "Payment Information":
			waitForElementVisible(driver, CheckoutPageUI.DYNAMIC_CHECKOUT_CONTINUE_BUTTON, "Payment Information");
			clickToElement(driver, CheckoutPageUI.DYNAMIC_CHECKOUT_CONTINUE_BUTTON, "Payment Information");
			break;
		}
		
	}
	
	public boolean isSectionActive(String section) {
		switch (section) {
		case "Billing Information":
			return isElementDisplayed(driver, CheckoutPageUI.DYNAMIC_TAB_ACTIVE, "Billing Information");
		case "Shipping Information":
			return isElementDisplayed(driver, CheckoutPageUI.DYNAMIC_TAB_ACTIVE, "Shipping Information");
		case "Shipping Method":
			return isElementDisplayed(driver, CheckoutPageUI.DYNAMIC_TAB_ACTIVE, "Shipping Method");
		case "Payment Information":
			return isElementDisplayed(driver, CheckoutPageUI.DYNAMIC_TAB_ACTIVE, "Payment Information");
		case "Order Review":
			return isElementDisplayed(driver, CheckoutPageUI.DYNAMIC_TAB_ACTIVE, "Order Review");
		default:
			return isElementDisplayed(driver, CheckoutPageUI.DYNAMIC_TAB_ACTIVE, "Billing Information");
		}
	}

	public void selectPaymentOption(String option) {
		waitForElementVisible(driver, CheckoutPageUI.DYNAMIC_PAYMENT_OPTION, option);
		checkToCheckBox(driver, CheckoutPageUI.DYNAMIC_PAYMENT_OPTION, option);
	}

	public boolean isOrderGenerated() {
		return isElementDisplayed(driver, CheckoutPageUI.SUCCESS_PLACE_ORDER_MESSAGE);
	}

	public void clickToPlaceOrder() {
		waitForElementVisible(driver, CheckoutPageUI.PLACE_ORDER_BUTTON);
		clickToElement(driver, CheckoutPageUI.PLACE_ORDER_BUTTON);
	}	public String getOrderID() {
		return getTextElement(driver, CheckoutPageUI.ORDER_ID);
	}

	public void checkToShippingAddressOptions(String option) {
		waitForElementVisible(driver, CheckoutPageUI.DYNAMIC_SHIPPING_ADDRESS_OPTION, option);
		checkToCheckBox(driver, CheckoutPageUI.DYNAMIC_SHIPPING_ADDRESS_OPTION, option);
	}

}
