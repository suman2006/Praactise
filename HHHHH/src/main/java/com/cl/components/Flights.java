package com.cl.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.cl.utils.ElementUtils;

public class Flights {

	public By radio_Roundtrip = By.id("");

	public void selectRoundTrip(WebDriver driver) throws Exception {
		ElementUtils.click(driver, radio_Roundtrip);
	}

}
