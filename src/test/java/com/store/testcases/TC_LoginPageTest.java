package com.store.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.store.Utilities.ReadConfigurationFile;
import com.store.pageobject.HomePage;
import com.store.pageobject.LoginPage;
import com.store.pageobject.MyAccountPage;

public class TC_LoginPageTest extends BaseClass {
	
	HomePage homePage;
	LoginPage loginPage;
	MyAccountPage myAccPage;
	
	@Test
	public void verifyLoginWithValidCredentials() {
		homePage = new HomePage(driver);
		ReadConfigurationFile readConfig = new ReadConfigurationFile();
		loginPage = homePage.clickOnSignInLink();
		loginPage.enterEmailAddressRegisteredUser(readConfig.getValue("email"));
		loginPage.enterPasswordRegisteredUser(readConfig.getValue("password"));
		myAccPage = loginPage.clickOnSignInButton();
		logger.info("Login Successful with valid credentials");
		Assert.assertEquals(myAccPage.checkTitle(), readConfig.getValue("myaccountpagetitle"));
		logger.info("My Account Page title matches with expected Title");
	}
	
}
