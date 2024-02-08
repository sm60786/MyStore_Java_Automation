package com.store.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
	
	WebDriver ldriver;
	
	public MyAccountPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath = "//a[@title='Women']")
	WebElement linkWomen;
	
	public String checkTitle() {
		return ldriver.getTitle();
	}
	
	public WomenPage clickOnWomenLink() {
		linkWomen.click();
		return new WomenPage(ldriver);
	}
	
}
