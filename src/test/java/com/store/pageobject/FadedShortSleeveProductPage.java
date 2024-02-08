package com.store.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.store.Utilities.Util;

public class FadedShortSleeveProductPage {
	
	WebDriver ldriver;
	
	public FadedShortSleeveProductPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	public String verifyProductPageTitle() {
		return Util.getTitle(ldriver);
	}
	
}
