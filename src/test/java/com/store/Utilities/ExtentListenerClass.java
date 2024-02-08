package com.store.Utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentListenerClass implements ITestListener {
	
	ExtentTest test;
	ExtentReports reports;
	ExtentSparkReporter htmlReporter;
	
	public void configureReport() {
		ReadConfigurationFile readConfig = new ReadConfigurationFile();
		String timeStamp = new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss").format(new Date());
		String reportName = "MyStoreTestReport-" + timeStamp + ".html";
		htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "\\Reports\\" + reportName);
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);
		
		// Add System information/environment information to reports
		reports.setSystemInfo("Machine : ", "testpc1");
		reports.setSystemInfo("OS : ", "Windows 10");
		reports.setSystemInfo("browser : ", readConfig.getBrowser());
		reports.setSystemInfo("user name : ", "Sibaram");
		
		// Configuration to change look and feel of report
		htmlReporter.config().setDocumentTitle("Extent Listener Report Demo");
		htmlReporter.config().setReportName("This is my first Report");
		htmlReporter.config().setTheme(Theme.DARK);
	}
	
	// OnStart method is called once when any test starts.
	@Override
	public void onStart(ITestContext context) {
		configureReport();
		System.out.println("On Start method invoked.....");
	}
	
	// OnFinish method is called once when test ends.
	@Override
	public void onFinish(ITestContext context) {
		System.out.println("On Finish method invoked.....");
		// its mandatory to call flush method to ensure information is written to started reporter.
		reports.flush();
	}
	
	// When Test case gets failed, this method is called
	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Name of the test method failed : " + result.getName());
		// Create entry in html report
		test = reports.createTest(result.getName()); 
		test.log(Status.FAIL, MarkupHelper.createLabel("Name of the failed test case : " + result.getName(), ExtentColor.RED));
		
		String screenshotPath = System.getProperty("user.dir") + "\\Screenshots\\" + result.getName() + ".png";
		File screenshotFile = new File(screenshotPath);
		if (screenshotFile.exists()) {
			test.fail("Captured Screenshot is below : " + test.addScreenCaptureFromPath(screenshotPath));
		}
	}
	
	// When Test case gets skipped, this method is called
	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Name of the test method skipped : " + result.getName());
		// Create entry in html report
		test = reports.createTest(result.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel("Name of the skipped test case : " + result.getName(), ExtentColor.BLUE));
	}

	// When test case gets started, this method is invoked
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Name of the test method started : " + result.getName());
	}

	// When test case gets passed, this method is invoked
	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Name of the test method successfully executed : " + result.getName());
		test = reports.createTest(result.getName());
		test.log(Status.PASS, MarkupHelper.createLabel("Name of the passed test case : " + result.getName(), ExtentColor.GREEN));
	}
	
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}
	
}
