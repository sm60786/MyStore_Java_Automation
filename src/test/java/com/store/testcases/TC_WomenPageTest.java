package com.store.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.store.Utilities.ReadConfigurationFile;
import com.store.pageobject.FadedShortSleeveProductPage;
import com.store.pageobject.WomenPage;

public class TC_WomenPageTest extends BaseClass {
	
	WomenPage womenPage;
	FadedShortSleeveProductPage fadedShortSleeveProductPage;
	ReadConfigurationFile readConfigFile;
	
	@Test(priority = 1)
	public void verifyWomenPageTitle() {
		womenPage = new WomenPage(driver);
		readConfig = new ReadConfigurationFile();
		Assert.assertEquals(womenPage.getWomenPageTitle(), readConfig.getValue("womenpagetitle"));
		logger.info("Women Page title is displayed as expected");
	}
	
	@Test(priority = 2)
	public void verifyFadedShortSleeveTShirt() {
		womenPage = new WomenPage(driver);
		Assert.assertTrue(womenPage.verifyFadedShortSleeveTShirt());
		logger.info("Faded Short Sleeve T-shirts product is displayed as expected");
	}
	
	@Test(priority = 3)
	public void clickOnFadedShortSleeveTShirt() {
		womenPage = new WomenPage(driver);
		fadedShortSleeveProductPage = womenPage.clickMoreOnFadedShortsSleeveTshirt();
	}
	
}
