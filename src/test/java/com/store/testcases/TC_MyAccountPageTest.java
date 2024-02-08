package com.store.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.store.Utilities.ReadConfigurationFile;
import com.store.pageobject.MyAccountPage;
import com.store.pageobject.WomenPage;

public class TC_MyAccountPageTest extends BaseClass {
	
	MyAccountPage myAccountPage;
	WomenPage womenPage;
	
	ReadConfigurationFile readConfigFile;
	
	@Test(priority = 1)
	public void verifyWomenLink() {
		myAccountPage = new MyAccountPage(driver);
		womenPage = new WomenPage(driver);
		readConfig = new ReadConfigurationFile();
		myAccountPage.clickOnWomenLink();
		Assert.assertEquals(womenPage.getWomenPageTitle(), readConfig.getValue("womenpagetitle"));
	}
	
}
