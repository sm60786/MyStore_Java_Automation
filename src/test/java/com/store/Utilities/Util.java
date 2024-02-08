package com.store.Utilities;

import java.time.LocalDateTime;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.store.testcases.BaseClass;

public class Util extends BaseClass {
	
	// Constants
	public static final int IMPLICTLY_WAIT = 10;
	
	public static Actions actions = new Actions(driver);
	
	/**
	 * 
	 * @param element
	 * @param value
	 */
	public static String getTitle(WebDriver driver) {
		return driver.getTitle();
	}
	
	// Method to handle drop down
	public static void handleDropdownByValue(WebElement element, String value) {
		/**
		 * Parameterized method
		 * Parameters : WebElement & Value on which we want to select
		 */
		Select elementDropdown = new Select(element);
		elementDropdown.selectByValue(value);
	}
	
	public static void handleDropdownByIndex(WebElement element, int index) {
		/**
		 * Parameterized method
		 * Parameters : WebElement & Index of which we want to select
		 */
		Select elementDropdown = new Select(element);
		elementDropdown.selectByIndex(index);
	}
	
	// For generating an new email address each time
	public static String getCurrentTime() {
		LocalDateTime v = LocalDateTime.now();
		String time = v.toString();
		time = time.replaceAll("\\D", "");
		return time;
	}
	
	public static String generateEmailWithDateTime() {
		ReadConfigurationFile readConfig = new ReadConfigurationFile();
		String fName = readConfig.getValue("firstname");
		return fName + getCurrentTime() + "@gmail.com";
	}
	
	public static void hoverOnElement(WebElement element) {
		actions.moveToElement(element).perform();
	}

}
