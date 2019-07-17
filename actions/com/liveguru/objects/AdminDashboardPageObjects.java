package com.liveguru.objects;

import org.openqa.selenium.WebDriver;

import com.liveguru.commons.AbstractPage;
import com.liveguru.commons.PageFactoryManager;

import liveguru.AdminDashboardPageUI;

public class AdminDashboardPageObjects extends AbstractPage {
	WebDriver driver;

	public AdminDashboardPageObjects(WebDriver driver) {
		this.driver = driver;
	}

	public void closePopup() {
		if (!isElementUndispayed(driver, AdminDashboardPageUI.ADMIN_MESSAGE_POPUP)) {
			waitForElementVisible(driver, AdminDashboardPageUI.ADMIN_MESSAGE_POPUP_CLOSE_ICON);
			clickToElement(driver, AdminDashboardPageUI.ADMIN_MESSAGE_POPUP_CLOSE_ICON);
			sleep(3);
		}
	}

	public AbstractPage selectAnyOptionFromMenu(String menu, String option) {
		waitForElementVisible(driver, AdminDashboardPageUI.DYNAMIC_ADMIN_MENU, menu);
		hoverMouseToElement(driver, AdminDashboardPageUI.DYNAMIC_ADMIN_MENU, menu);
		
		waitForElementVisible(driver, AdminDashboardPageUI.DYNAMIC_ADMIN_SUBMENU, option);
		clickToElement(driver, AdminDashboardPageUI.DYNAMIC_ADMIN_SUBMENU, option);
		switch (option) {
		case "Orders":
			return PageFactoryManager.getOrderPage(driver);
		case "Invoices":
			return PageFactoryManager.getAdminInvoicePage(driver);
		case "Manage Customers":
			return PageFactoryManager.getAdminManageCustomersPage(driver);
		default:
			return PageFactoryManager.getAdminDashboardPage(driver);
		}
	}

	public AbstractPage selectAnyOptionFromMenu(String menu, String option1, String option2, String option3) {
		waitForElementVisible(driver, AdminDashboardPageUI.DYNAMIC_ADMIN_MENU, menu);
		hoverMouseToElement(driver, AdminDashboardPageUI.DYNAMIC_ADMIN_MENU, menu);

		waitForElementVisible(driver, AdminDashboardPageUI.DYNAMIC_ADMIN_SUBMENU, option1);
		hoverMouseToElement(driver, AdminDashboardPageUI.DYNAMIC_ADMIN_SUBMENU, option1);

		waitForElementVisible(driver, AdminDashboardPageUI.DYNAMIC_ADMIN_SUBMENU, option2);
		hoverMouseToElement(driver, AdminDashboardPageUI.DYNAMIC_ADMIN_SUBMENU, option2);

		waitForElementVisible(driver, AdminDashboardPageUI.DYNAMIC_ADMIN_SUBMENU, option3);
		clickToElement(driver, AdminDashboardPageUI.DYNAMIC_ADMIN_SUBMENU, option3);
		switch (option3) {
		case "Pending Reviews":
			return PageFactoryManager.getAdminReviewPage(driver);
		default:
			return PageFactoryManager.getAdminDashboardPage(driver);
		}
	}

}
