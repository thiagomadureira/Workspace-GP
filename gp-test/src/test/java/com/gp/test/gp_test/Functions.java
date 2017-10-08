package com.gp.test.gp_test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Functions {

	public static WebDriver createChromeDriver() {
		String driverPath = "C:\\Workspace-GP\\gp-test\\Webdrivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("test-type");
		options.addArguments("start-maximized");
		options.addArguments("disable-infobars");
		ChromeDriver chromeDriver = new ChromeDriver(options);
		return chromeDriver;
	}

	public static WebDriver createChromeDriverMobile() {
		String driverPath = "C:\\Workspace-GP\\gp-test\\Webdrivers\\chromedriver.exe";

		Map<String, String> mobileEmulation = new HashMap<String, String>();

		mobileEmulation.put("deviceName", "Nexus 5");

		Map<String, Object> chromeOptions = new HashMap<String, Object>();

		chromeOptions.put("mobileEmulation", mobileEmulation);

		chromeOptions.put("args", Arrays.asList("chromeOptions", "test-type", "disable-infobars","start-maximized"));

		DesiredCapabilities capabilities = DesiredCapabilities.chrome();

		capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);

		// WebDriver driver = new ChromeDriver(capabilities);
		System.setProperty("webdriver.chrome.driver", driverPath);

		@SuppressWarnings("deprecation")
		ChromeDriver chromeDriver = new ChromeDriver(capabilities);

		// ChromeOptions options = new ChromeOptions();
		// options.addArguments("test-type");
		// options.addArguments("start-maximized");
		// options.addArguments("disable-infobars");
		// ChromeDriver chromeDriver = new ChromeDriver(options);
		return chromeDriver;
	}
	
	

}
