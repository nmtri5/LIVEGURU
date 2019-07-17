package com.liveguru.objects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.liveguru.commons.AbstractPage;
import com.liveguru.commons.AbstractPageUI;

import liveguru.AdminManageCustomerPageUI;

public class AdminManageCustomerPageObjects extends AbstractPage {

	WebDriver driver;

	public AdminManageCustomerPageObjects(WebDriver driver) {
		this.driver = driver;
	}

	public void inputAnySearchTextbox(String criteria, String value) {
		waitForElementInvisible(driver, AbstractPageUI.ADMIN_LOADING_ICON);
		switch (criteria) {
		case "billing_country_id":
			selectItemInHtmlDropdown(driver, AdminManageCustomerPageUI.COUNTRY_DROPDOWN, value);
			break;
		default:
			sendKeyToElement(driver, value, AdminManageCustomerPageUI.DYNAMIC_SEARCH_TEXTBOX, criteria);
			break;
		}
	}

	public boolean isSearchResultCorrectlyReturned(String id, String name, String email, String telephone, String zip,
			String country, String state) {
		waitForElementInvisible(driver, AbstractPageUI.ADMIN_LOADING_ICON);
		List<WebElement> listResult = driver.findElements(By.xpath(AdminManageCustomerPageUI.ADMIN_DISPLAYED_ROWS));
		boolean flag = false;

		if (listResult.size() == 1) {
			if (getTextElement(driver, AdminManageCustomerPageUI.DYNAMIC_COLUMN_SEARCH_RESULT, "2").trim().equals(id)
					&& getTextElement(driver, AdminManageCustomerPageUI.DYNAMIC_COLUMN_SEARCH_RESULT, "3").trim()
							.equals(name)
					&& getTextElement(driver, AdminManageCustomerPageUI.DYNAMIC_COLUMN_SEARCH_RESULT, "4").trim()
							.equals(email)
					&& getTextElement(driver, AdminManageCustomerPageUI.DYNAMIC_COLUMN_SEARCH_RESULT, "6").trim()
							.equals(telephone)
					&& getTextElement(driver, AdminManageCustomerPageUI.DYNAMIC_COLUMN_SEARCH_RESULT, "7").trim()
							.equals(zip)
					&& getTextElement(driver, AdminManageCustomerPageUI.DYNAMIC_COLUMN_SEARCH_RESULT, "8").trim()
							.equals(country)
					&& getTextElement(driver, AdminManageCustomerPageUI.DYNAMIC_COLUMN_SEARCH_RESULT, "9").trim()
							.equals(state)) {
				flag = true;
			}
		}
		return flag;
	}

}
