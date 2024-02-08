package com.store.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.store.pageobject.HomePage;

public class TC_HomePageTest extends BaseClass {
	
	HomePage homePage;
	
	@Test(priority = 0)
	public void verifyMyStoreLogo() {
		homePage = new HomePage(driver);
		Assert.assertTrue(homePage.checkMyStoreLogo());
		logger.info("My Store Logo is displayed Home Page");
	}
	
	@Test(priority = 1)
	public void verifySignInLink() {
		homePage = new HomePage(driver);
		Assert.assertTrue(homePage.checkSignInLink());
		logger.info("Sign In Link is displayed in Home Page");
	}
	
}
