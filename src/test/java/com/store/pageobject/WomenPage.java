package com.store.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.store.Utilities.Util;

public class WomenPage {
	
	WebDriver ldriver;
	
	public WomenPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath = "//img[@title='Faded Short Sleeve T-shirts']")
	WebElement linkFadedShortSleeveTShirts;
	
	@FindBy(xpath = "//ul[@class='product_list grid row']/li[1]/descendant::span[text()='More']")
	WebElement linkMoreFadedShortSleeveTShirts;
	
	public String getWomenPageTitle() {
		return Util.getTitle(ldriver);
	}
	
	public boolean verifyFadedShortSleeveTShirt() {
		return linkFadedShortSleeveTShirts.isDisplayed();
	}
	
	public FadedShortSleeveProductPage clickMoreOnFadedShortsSleeveTshirt() {
		Util.hoverOnElement(linkFadedShortSleeveTShirts);
		linkMoreFadedShortSleeveTShirts.click();
		return new FadedShortSleeveProductPage(ldriver);
	}
	
}
