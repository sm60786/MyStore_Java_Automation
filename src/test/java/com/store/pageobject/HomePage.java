package com.store.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver ldriver;
	
	public HomePage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath = "//a[@title='My Shop']/child::img")
	WebElement logoMyStore;
	
	@FindBy(xpath = "//a[@class='login']")
	WebElement linkSignIn;
	
	@FindBy(xpath = "//input[@id='search_query_top']")
	WebElement textFieldSearch;
	
	@FindBy(xpath = "//button[@name='submit_search']")
	WebElement buttonSearch;
	
	@FindBy(xpath = "//a[@title='Women']")
	WebElement linkWomen;
	
	@FindBy(xpath = "//a[@title='Women']/parent::li/following-sibling::li[1]")
	WebElement linkDresses;
	
	@FindBy(xpath = "//a[@title='Women']/parent::li/following-sibling::li[2]")
	WebElement linkTShirts;
	
	@FindBy(xpath = "//a[@title='Women']/parent::li/following-sibling::li[3]")
	WebElement linkBlog;
	
	public boolean checkMyStoreLogo() {
		return logoMyStore.isDisplayed();
	}
	
	public boolean checkSignInLink() {
		return linkSignIn.isDisplayed();
	}
	
	public LoginPage clickOnSignInLink() {
		linkSignIn.click();
		return new LoginPage(ldriver);
	}
	
	public boolean checkWomensLink() {
		return linkWomen.isDisplayed();
	}
	
	public boolean checkDressesLink() {
		return linkDresses.isDisplayed();
	}
	
	public boolean checkTShirtsLink() {
		return linkTShirts.isDisplayed();
	}
	
	public boolean checkBlogLink() {
		return linkBlog.isDisplayed();
	}
	
	public boolean checkSearchTextField() {
		return textFieldSearch.isDisplayed();
	}
	
}
