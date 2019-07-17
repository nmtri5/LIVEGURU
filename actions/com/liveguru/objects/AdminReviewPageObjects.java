package com.liveguru.objects;

import org.openqa.selenium.WebDriver;

import com.liveguru.commons.AbstractPage;
import com.liveguru.commons.AbstractPageUI;
import com.liveguru.commons.PageFactoryManager;

import liveguru.AdminReviewPageUI;

public class AdminReviewPageObjects extends AbstractPage {
	WebDriver driver;

	public AdminReviewPageObjects(WebDriver driver) {
		this.driver = driver;
	}

	public AbstractPage selectAnySpecificReview(String action, String title, String nickname, String review) {
		switch (action) {
		case "select":
			waitForElementInvisible(driver, AbstractPageUI.ADMIN_LOADING_ICON);
			waitForElementVisible(driver, AdminReviewPageUI.DYNAMIC_ADMIN_REVIEW_SELECT_BOX, title, nickname, review);
			clickToElement(driver, AdminReviewPageUI.DYNAMIC_ADMIN_REVIEW_SELECT_BOX, title, nickname, review);
			return null;
		case "edit":
			waitForElementInvisible(driver, AbstractPageUI.ADMIN_LOADING_ICON);
			waitForElementVisible(driver, AdminReviewPageUI.DYNAMIC_ADMIN_REVIEW_EDIT_LINK, title, nickname, review);
			clickToElement(driver, AdminReviewPageUI.DYNAMIC_ADMIN_REVIEW_EDIT_LINK, title, nickname, review);
			return PageFactoryManager.getAdminEditReviewPage(driver);
		case "click":
			waitForElementInvisible(driver, AbstractPageUI.ADMIN_LOADING_ICON);
			waitForElementVisible(driver, AdminReviewPageUI.DYNAMIC_ADMIN_REVIEW, title, nickname, review);
			clickToElement(driver, AdminReviewPageUI.DYNAMIC_ADMIN_REVIEW, title, nickname, review);
			return PageFactoryManager.getAdminEditReviewPage(driver);
		default:
			return null;
		}

	}
}
