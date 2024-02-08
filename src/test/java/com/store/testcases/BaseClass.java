package com.store.testcases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import com.store.Utilities.ReadConfigurationFile;
import com.store.Utilities.Util;

public class BaseClass {
	
	ReadConfigurationFile readConfig = new ReadConfigurationFile();
	
	String url = readConfig.getApplicationUrl();
	String browser = readConfig.getBrowser();
	
	public static WebDriver driver;
	
	public static Logger logger;
	
	@BeforeSuite
	public void setup() {
		
		switch (browser.toLowerCase()) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "D:\\Java_Projects\\MyStoreV1\\Drivers\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			options.addArguments("--disable-notifications");
			driver = new ChromeDriver(options);
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "D:\\Java_Projects\\MyStoreV1\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		case "edge":
			System.setProperty("webdriver.edge.driver", "D:\\Java_Projects\\MyStoreV1\\Drivers\\msedgedriver.exe");
			driver = new EdgeDriver();
			break;
		default:
			driver = null;
			break;
		}
		
		// implicit wait of 10 seconds
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Util.IMPLICTLY_WAIT));
		
		// for maximizing the window
		driver.manage().window().maximize();
		
		// for Logging
		logger = LogManager.getLogger("MyStoreV1");
		
		driver.get(url);
		
	}
	
	@AfterSuite
	public void teardown() {
		driver.quit();
	}
	
	public void captureScreenshot(WebDriver driver, String testName) throws IOException {
		// Convert Web Driver object to TakesScreenshot Interface by TypeCasting
		TakesScreenshot ts = (TakesScreenshot) driver;
		// Call getScreenshotAs() to create temporary image file
		File src = ts.getScreenshotAs(OutputType.FILE);
		// Create a file in which we're gonna store screenshot permanently
		File dest = new File(System.getProperty("user.dir") + "//Screenshots//" + testName + ".png");
		// Now compy the temporary file to permanent file
		FileUtils.copyFile(src, dest);
	}
	
}
