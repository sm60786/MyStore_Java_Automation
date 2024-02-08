package com.store.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.store.Utilities.ReadConfigurationFile;
import com.store.Utilities.Util;

public class TC_FadedShortSleeveProductPageTest extends BaseClass {
	
	ReadConfigurationFile readConfig;
	
	@Test(priority = 1)
	public void getPageTitle() {
		readConfig = new ReadConfigurationFile();
		Assert.assertEquals(Util.getTitle(driver), readConfig.getValue("fadedshortsleevetshirtsproductpagetitle"));
		logger.info("FadedShortSleeve Title is as expected");
	}
	
}
