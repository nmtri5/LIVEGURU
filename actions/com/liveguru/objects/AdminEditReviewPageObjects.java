package com.liveguru.objects;

import org.openqa.selenium.WebDriver;

import com.liveguru.commons.AbstractPage;

import liveguru.AdminEditReviewPageUI;

public class AdminEditReviewPageObjects extends AbstractPage {
	WebDriver driver;

	public AdminEditReviewPageObjects(WebDriver driver) {
		this.driver = driver;
	}

	public void changeReviewStatus(String status) {
		waitForElementVisible(driver, AdminEditReviewPageUI.ADMIN_STATUS_DROPDOWN);
		selectItemInHtmlDropdown(driver, AdminEditReviewPageUI.ADMIN_STATUS_DROPDOWN, status);
		
		//Submit
		clickToAnyButtonAdminPage(driver, "Save Review");
		
	}
}

