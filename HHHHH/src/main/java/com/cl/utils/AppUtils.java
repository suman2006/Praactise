package com.cl.utils;

import java.util.Properties;
import org.openqa.selenium.WebDriver;

public class AppUtils {

	public static void invokeApplication(Properties prop, WebDriver driver) {

		driver.get(prop.getProperty(prop.getProperty("env") + "_url"));
		driver.manage().window().maximize();

	}

}
