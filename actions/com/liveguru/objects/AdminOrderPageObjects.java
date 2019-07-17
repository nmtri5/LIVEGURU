package com.liveguru.objects;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.liveguru.commons.AbstractPage;
import com.liveguru.commons.AbstractPageUI;

import liveguru.AdminOrderPageUI;

public class AdminOrderPageObjects extends AbstractPage {
	WebDriver driver;

	public AdminOrderPageObjects(WebDriver driver) {
		this.driver = driver;
	}

	public void performSearchAction(String action) {
		waitForElementVisible(driver, AdminOrderPageUI.ADMIN_SEARCH_STATUS_DROPDOWN);
		selectItemInHtmlDropdown(driver, AdminOrderPageUI.ADMIN_SEARCH_STATUS_DROPDOWN, action);

		clickToAnyButtonAdminPage(driver, "Search");
	}

	public void selectFirstOrder() {
		waitForElementInvisible(driver, AbstractPageUI.ADMIN_LOADING_ICON);
		waitForElementClickable(driver, AdminOrderPageUI.ADMIN_FIRST_RECORD);
		clickToElement(driver, AdminOrderPageUI.ADMIN_FIRST_RECORD);
	}

	public void selectAction(String action) {
		waitForElementVisible(driver, AdminOrderPageUI.ADMIN_ACTIONS);
		selectItemInHtmlDropdown(driver, AdminOrderPageUI.ADMIN_ACTIONS, action);
		waitForElementVisible(driver, AdminOrderPageUI.ADMIN_ACTIONS_SUBMIT);
		clickToElement(driver, AdminOrderPageUI.ADMIN_ACTIONS_SUBMIT);
	}

	public boolean isFileDownloaded(String downloadPath, String fileName) {
		sleep(5);
		File dir = new File(downloadPath);
		File[] dirContents = dir.listFiles();

		for (int i = 0; i < dirContents.length; i++) {
			if (dirContents[i].getName().contains(fileName)) {
				// File has been found, it can now be deleted:
				dirContents[i].delete();
				return true;
			}
		}
		return false;
	}

	public boolean isNumberOfRowCorrected() {
		waitForElementInvisible(driver, AbstractPageUI.ADMIN_LOADING_ICON);
		int expectedNumberOfItem = Integer
				.parseInt(getCurrentTextInDropdown(driver, AdminOrderPageUI.ADMIN_PAGINATION_DROPDOWN));
		int actualdNumberOfItem = countElementNumber(driver, AdminOrderPageUI.ADMIN_DISPLAYED_ROWS);
		if (expectedNumberOfItem == actualdNumberOfItem) {
			return true;
		} else {
			return false;
		}
	}

	public void selectNumberOfRowAppearedInPage(String number) {
		waitForElementInvisible(driver, AbstractPageUI.ADMIN_LOADING_ICON);
		selectItemInHtmlDropdown(driver, AdminOrderPageUI.ADMIN_PAGINATION_DROPDOWN, number);
	}

	public void clickToMassActionLink(String link) {
		waitForElementInvisible(driver, AbstractPageUI.ADMIN_LOADING_ICON);
		clickToElement(driver, AdminOrderPageUI.DYNAMIC_MASS_ACTION_LINK, link);
	}

	public boolean isNumberOfItemSelectedMessageCorrect(String option) {
		switch (option) {
		case "Select Visible":
			int itemNumber = countElementNumber(driver, AdminOrderPageUI.ADMIN_DISPLAYED_ROWS);
			return getTextElement(driver, AdminOrderPageUI.ADMIN_MASSACTION_COUNT).equals(String.valueOf(itemNumber));

		default:
			return getTextElement(driver, AdminOrderPageUI.ADMIN_MASSACTION_COUNT).equals("0");
		}
	}

	public boolean isAllCheckboxesCheckedOrUnchecked(String option) {
		boolean flag = true;
		List<WebElement> checkboxes = new ArrayList<WebElement>();
		checkboxes = driver.findElements(By.xpath(AdminOrderPageUI.ADMIN_ALL_CHECKBOXES));

		switch (option) {
		case "checked":
			for (WebElement webElement : checkboxes) {
				if (!webElement.isSelected()) {
					flag = false;
					break;
				}
			}
			break;

		default:
			for (WebElement webElement : checkboxes) {
				if (webElement.isSelected()) {
					flag = false;
					break;
				}
			}
		}

		return flag;
	}
}
