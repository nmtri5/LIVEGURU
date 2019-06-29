package com.liveguru.objects;

import org.openqa.selenium.WebDriver;

import com.liveguru.commons.AbstractPage;

import liveguru.ProductReviewPageUI;

public class ProductReviewPageObjects extends AbstractPage {
	WebDriver driver;

	public ProductReviewPageObjects(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToLetUsKnowYourThought(String comment) {
		waitForElementVisible(driver, ProductReviewPageUI.THOUGHT_TEXTBOX);
		sendKeyToElement(driver, ProductReviewPageUI.THOUGHT_TEXTBOX, comment);
	}

	public void inputToSummaryReview(String comment) {
		waitForElementVisible(driver, ProductReviewPageUI.SUMMARY_TEXTBOX);
		sendKeyToElement(driver, ProductReviewPageUI.SUMMARY_TEXTBOX, comment);
	}

	public void inputToNickName(String comment) {
		waitForElementVisible(driver, ProductReviewPageUI.NICKNAME_TEXTBOX);
		sendKeyToElement(driver, ProductReviewPageUI.NICKNAME_TEXTBOX, comment);
	}

	public void clickToSubmitReview() {
		waitForElementVisible(driver, ProductReviewPageUI.SUBMIT_REVIEW_BUTTON);
		clickToElement(driver, ProductReviewPageUI.SUBMIT_REVIEW_BUTTON);
	}
	
	public boolean isErrorMessageDisplayedForSpecificTextBox(String textbox) {
		return isElementDisplayed(driver, ProductReviewPageUI.DYNAMIC_ERROR_MESSAGE, textbox);
	}

	public boolean isReviewSuccessMessageDisplayed() {
		return isElementDisplayed(driver, ProductReviewPageUI.SUCCESS_MESSAGE);
	}
	
	public String isReviewSuccessMessageCorrect() {
		return getTextElement(driver, ProductReviewPageUI.SUCCESS_MESSAGE);
	}

}
