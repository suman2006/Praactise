package com.cl.flights.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.cl.utils.AppUtils;
import com.cl.utils.BrowserUtils;
import com.cl.utils.ConstantUtils;
import com.cl.utils.ElementUtils;

public class TestSuite1 {
	public WebDriver driver;
	public static Properties prop;

	@Before
	public void setUp() throws Exception, IOException {
		prop = new Properties();
		prop.load(new FileInputStream(ConstantUtils.configPath));
		driver = BrowserUtils.intailizeBrowser(prop, driver);
		AppUtils.invokeApplication(prop, driver);
		ElementUtils.click(driver, By.id(""));
	}

	@After
	public void tearDown() {
		BrowserUtils.closeAppAndBrowser(driver);
	}

	@Test
	public void test1() throws Exception {

	}

}
