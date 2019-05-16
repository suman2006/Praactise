package com.cl.utils;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ElementUtils {

	public static void click(WebDriver driver, By locator) throws Exception {
		findObject(driver, locator).click();
	}

	public static void type(WebDriver driver, By locator, String text) throws Exception {
		findObject(driver, locator).sendKeys(text);
	}

	public void clear(WebDriver driver, By locator) throws Exception {
		findObject(driver, locator).clear();
	}

	public void selectValueFromDropdown(WebDriver driver, By locator, String text) throws Exception {
		new Select(findObject(driver, locator)).selectByVisibleText(text);
	}

	public void selectValueFromListBox(WebDriver driver, By locator, String text[]) throws Exception {
		for (int i = 0; i < text.length; i++) {
			new Select(findObject(driver, locator)).selectByVisibleText(text[i]);
		}
	}

	public String captureText(WebDriver driver, By locator) throws Exception {
		return findObject(driver, locator).getText();
	}

	public String captureAttribute(WebDriver driver, By locator, String attribute) throws Exception {
		return findObject(driver, locator).getAttribute(attribute);
	}

	public ArrayList<String> getValuesFromDropDown(WebDriver driver, By locator) throws Exception {
		ArrayList<String> list = new ArrayList<>();
		List<WebElement> options = new Select(findObject(driver, locator)).getOptions();
		for (WebElement ele : options) {
			list.add(ele.getText());

		}
		return list;

	}

	public void deselectValuesList(WebDriver driver, By locator, String values[]) throws Exception {
		for (int i = 0; i < values.length; i++) {
			new Select(findObject(driver, locator)).deselectByVisibleText(values[i]);
		}
	}
	
	public void performMouseAction(WebDriver driver, By locator, String actionType) throws Exception {
		Actions action=new Actions(driver);
		switch (actionType) {
		case "click":
			action.click(findObject(driver, locator)).perform();		
			break;
		case "doubleclick":
			action.doubleClick(findObject(driver, locator)).perform();		
			break;
		case "contextclick":
			action.contextClick(findObject(driver, locator)).perform();		
			break;
		case "movetoelement":
			action.moveToElement(findObject(driver, locator)).perform();		
			break;
		case "clickandhold":
			action.clickAndHold(findObject(driver, locator)).perform();		
			break;
		default:
			System.out.println("please enter correctaction");
			break;
		}
	}
	
	

	private static WebElement findObject(WebDriver driver, By locator) throws Exception {
		WebElement ele = null;
		for (int i = 0; i < 10; i++) {
			try {
				ele = driver.findElement(locator);
				break;
			} catch (Exception e) {
				Thread.sleep(500);
			}
		}
		return ele;
	}

}
