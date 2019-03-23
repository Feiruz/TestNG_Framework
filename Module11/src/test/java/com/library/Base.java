package com.library;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class Base {
	final static Logger logger = Logger.getLogger(Base.class);

	public static WebDriver driver;
	public static GlobalSeleniumLibrary myLibrary;
	private static JavaPropertiesManager readProperty;
	private static JavaPropertiesManager readProperty2;
	private static String browser;
	private static String demoType;
	private static String isAutoSendEmail;
	private static String isRemote;
	private static String hubURLString;

	@BeforeClass
	public void beforeAllTestStart() {

		readProperty = new JavaPropertiesManager("src/test/resources/config.properties");
		browser = readProperty.readProperty("browserType");
		demoType = readProperty.readProperty("demoMode");
		isAutoSendEmail = readProperty.readProperty("autoEmail");
		isRemote = readProperty.readProperty("isRemoteTest");
		hubURLString = readProperty.readProperty("hubURL");
		// logger.info("hub url from property: [" +hubURLString+ "]");

		myLibrary = new GlobalSeleniumLibrary(driver);
		readProperty2 = new JavaPropertiesManager("src/test/resources/dynamicConfig.properties");
		String tempTime = myLibrary.getCurrentTime();
		readProperty2.setProperty("sessionTime", tempTime);
		logger.info("Session Time: " + tempTime);

		if (demoType.contains("true")) {
			myLibrary.setDemo(true);
			logger.info("Test is running in Demo mode ON...");
		} else {
			logger.info("Test is running in Demo mode OFF...");
		}

		if (isRemote.contains("true")) {
			logger.info("Test is running in RemoteWebDriver mode ON...");
		} else {
			logger.info("Test is running in Local Webdriver...");
		}
	}

	@AfterClass
	public void afterAllTestCompleted() {
		if (driver != null) {
			driver.quit();
		}

		// Sending all the reports, screenshots and log files via email
		List<String> screenshots = new ArrayList<>();
		EmailManager emailSender = new EmailManager();
		emailSender.attachmentFiles.add("target/logs/log4j-selenium.log");
		emailSender.attachmentFiles.add("target/logs/Selenium-Report.html");
		screenshots = myLibrary.automaticallyAttachErrorImgToEmail();
		if (screenshots.size() != 0) {
			for (String attachFile : screenshots) {
				emailSender.attachmentFiles.add(attachFile);
			}
		}
		if (isAutoSendEmail.contains("true")) {
			emailSender.sendEmail(emailSender.attachmentFiles);
		}
	}

	@BeforeMethod
	public void beforeEachTestStart() {
		if (isRemote.contains("true")) {
			myLibrary.startRemoteBrowser(hubURLString, browser);
		} else {
			driver = myLibrary.startLocalBrowser(browser);
		}
	}

	/*
	 * @BeforeMethod public void beforeEachTestStart() { if
	 * (isRemote.contains("true")) { if (!getOSSystemName().contains("windows"))
	 * { driver = myLibrary.startRemoteBrowser(hubURLString, browser); } else {
	 * driver = myLibrary.startLocalBrowser(browser); } } else { driver =
	 * myLibrary.startLocalBrowser(browser); } }
	 *
	 * 
	 * private String getOSSystemName() { String osName = null; osName =
	 * System.getProperty("os.name").toLowerCase(); return osName; }
	 */
	
	
	@AfterMethod
	public void afterEachTestEnd(ITestResult result) {
		try {
			if (ITestResult.FAILURE == result.getStatus()) {
				myLibrary.captureScreenshot(result.getName(), "target/screenshots/");
			}
			Thread.sleep(2 * 1000);

			driver.close(); // close the browser
			driver.quit(); // kills/deletes the driver object

		} catch (Exception e) {
			logger.error("Error: ", e);
		}
	}

}
