package com.store.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.store.Utilities.ReadConfigurationFile;
import com.store.Utilities.Util;
import com.store.pageobject.HomePage;

public class TC_HomePageTest extends BaseClass {
	
	HomePage homePage;
	ReadConfigurationFile readConfig;
	
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
	
	@Test(priority = 2)
	public void verifySearchTextField() {
		homePage = new HomePage(driver);
		Assert.assertTrue(homePage.checkSearchTextField());
		logger.info("Search Text Field is displayed in Home Page");
	}
	
	@Test(priority = 3)
	public void verifyWomensLink() {
		homePage = new HomePage(driver);
		Assert.assertTrue(homePage.checkWomensLink());
		logger.info("Womens Link is displayed in Home Page");
	}
	
	@Test(priority = 4)
	public void clickOnSignInLink() {
		homePage = new HomePage(driver);
		readConfig = new ReadConfigurationFile();
		homePage.clickOnSignInLink();
		Assert.assertEquals(Util.getTitle(driver), readConfig.getValue("loginpagetitle"));
		logger.info("Login Page Title is matching with Expected");
	}
	
}
