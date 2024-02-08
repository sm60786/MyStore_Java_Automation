package com.store.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	// New User Web Elements
	@FindBy(xpath = "//input[@id='email_create']")
	WebElement textFieldEmailCreateAcc;
	
	@FindBy(xpath = "//button[@id='SubmitCreate']")
	WebElement buttonCreateAccount;
	
	// Registered User Web Elements
	@FindBy(xpath = "//input[@id='email']")
	WebElement textFieldEmailRegisteredAcc;
	
	@FindBy(xpath = "//input[@id='passwd']")
	WebElement textFieldPasswordRegisteredAcc;
	
	@FindBy(xpath = "//a[contains(text(), 'F')]")
	WebElement linkForgotPassword;
	
	@FindBy(xpath = "//button[@id='SubmitLogin']")
	WebElement buttonSignIn;
	
	
	
	/**
	 * Actions for Creating Account
	 * @param emailAddress
	 */
	public void enterEmailAddressCreateAcc(String emailAddress) {
		textFieldEmailCreateAcc.sendKeys(emailAddress);
	}
	
	public void clickOnCreateAccountButton() {
		buttonCreateAccount.click();
	}
	
	/**
	 * Actions for Signin In
	 * @param emailAddress, password
	 */
	public void enterEmailAddressRegisteredUser(String emailAddress) {
		textFieldEmailRegisteredAcc.sendKeys(emailAddress);
	}
	
	public void enterPasswordRegisteredUser(String password) {
		textFieldPasswordRegisteredAcc.sendKeys(password);
	}
	
	public MyAccountPage clickOnSignInButton() {
		buttonSignIn.click();
		return new MyAccountPage(ldriver);
	}
	
}
