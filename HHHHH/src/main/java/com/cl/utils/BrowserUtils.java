package com.cl.utils;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserUtils {

	public static WebDriver intailizeBrowser(Properties prop, WebDriver driver) {
		String browser = prop.getProperty("browser");

		switch (browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", ConstantUtils.chromePath);
			driver = new ChromeDriver();
			break;
		case "ie":
			System.setProperty("webdriver.ie.driver", ConstantUtils.iePath);
			driver = new InternetExplorerDriver();
			break;
		case "gecko":
			System.setProperty("webdriver.gecko.driver", ConstantUtils.geckoPath);
			driver = new FirefoxDriver();
			break;

		default:
			System.out.println("please select or enter correct browser");
			break;
		}

		return driver;
	}

	public static void closeAppAndBrowser(WebDriver driver) {
		driver.quit();
	}

}
