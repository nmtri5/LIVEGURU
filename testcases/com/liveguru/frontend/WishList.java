package com.liveguru.frontend;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.liveguru.commons.AbstractTest;
import com.liveguru.commons.PageFactoryManager;
import com.liveguru.objects.AccountDashboardPageObjects;
import com.liveguru.objects.HomePageObjects;
import com.liveguru.objects.LoginPageObjects;
import com.liveguru.objects.ProductListPageObjects;
import com.liveguru.objects.RegisterPageObjects;
import com.liveguru.objects.WishListPageObjects;

public class WishList extends AbstractTest{
	WebDriver driver;
	HomePageObjects homePage;
	LoginPageObjects loginPage;
	RegisterPageObjects registerPage;
	ProductListPageObjects productListPage;
	AccountDashboardPageObjects accountDashboard;
	WishListPageObjects wishListPage;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browser) {
		driver = openBrowser(browser);
		
		homePage = PageFactoryManager.getHomePage(driver);
		loginPage = (LoginPageObjects) homePage.openAnySubPageFromHomePage(driver, "My Account");
		accountDashboard = loginPage.doLogin(Global_RegisterToSystem.email, Global_RegisterToSystem.password);
	}
	
  @Test
  public void TC_07_ShareWishList() {
	  log.info("Share Wishlist - Step 01: Click on TV Menu");
	  productListPage = (ProductListPageObjects) accountDashboard.openAnySubPageFromHomePage(driver, "Mobile");
	  
	  log.info("Share Wishlist - Step 02: Add LG LCD product to wishlist");
	  wishListPage = productListPage.addToWishlist("Sony Xperia");
	  
	  log.info("Share Wishlist - Step 03: Verify that product is successfully added to wishlist");
	  verifyTrue(wishListPage.isProductAddedToWishList("Sony Xperia"));
	  
	  log.info("Share Wishlist - Step 04: Click share wishlist button");
	  wishListPage.clickToShareWishListButton();
	  
	  log.info("Share Wishlist - Step 05: Input email and message");
	  wishListPage.inputEmailAndMessage("automation@gmail.com", "test share wishlist");
	  
	  log.info("Share Wishlist - Step 06: Click share wishlist button");
	  wishListPage.clickToShareWishListButton();
	  
	  log.info("Share Wishlist - Step 07: Verify share wishlist message display");
	  verifyEquals(wishListPage.getTextShareMessageSuccess(), "Your Wishlist has been shared.");
  }

  @AfterClass(alwaysRun = true)
  public void afterClass() {
	  closeBrowserAndDriver(driver);
  }

}
