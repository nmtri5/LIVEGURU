package com.liveguru.frontend;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.liveguru.commons.AbstractTest;
import com.liveguru.commons.Constants;
import com.liveguru.commons.PageFactoryManager;
import com.liveguru.objects.AdvancedSearchPageObjects;
import com.liveguru.objects.HomePageObjects;

public class SearchFunction extends AbstractTest{
	WebDriver driver;
	HomePageObjects homePage;
	AdvancedSearchPageObjects advancedSearch;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browser) {
		log.info("Search Function - Step 01: Go to liveguru page");
		driver = openBrowser(browser, Constants.STAGING_URL);
		homePage = PageFactoryManager.getHomePage(driver);
		
		log.info("Search Function - Step 02: Click on Advanced Search");
		advancedSearch = (AdvancedSearchPageObjects) homePage.openAnySubPageFromHomePage(driver, "Advanced Search");
	}

	@Test
	public void TC_10_SearchFunction() {
		log.info("Search Function - Step 03: Enter range from 0 - 150 in price field and click Search");
		advancedSearch.inputPriceFrom(0);
		
		log.info("Search Function - Step 04: Enter range from 0 - 150 in price field and click Search");
		advancedSearch.inputPriceTo(150);
		
		log.info("Search Function - Step 05: Click Search");
		advancedSearch.clickToSearchButton();
		
		log.info("Search Function - Step 06: Verify products displayed");
		verifyTrue(advancedSearch.isSearchedProductDisplayedCorrectly());
		
		log.info("Search Function - Step 07: Click to Modify your search");
		advancedSearch.clickOnModifiedYourSearch();
		
		log.info("Search Function - Step 08: Enter range from 151 - 1000 in price field and click Search");
		advancedSearch.inputPriceFrom(151);
		
		log.info("Search Function - Step 09: Enter range from 151 - 1000 in price field and click Search");
		advancedSearch.inputPriceTo(1000);
		
		log.info("Search Function - Step 10: Click Search");
		advancedSearch.clickToSearchButton();
		
		log.info("Search Function - Step 11: Verify products displayed");
		verifyTrue(advancedSearch.isSearchedProductDisplayedCorrectly());
	}

  @AfterClass(alwaysRun = true)
  public void afterClass() {
	  closeBrowserAndDriver(driver);
  }

}
