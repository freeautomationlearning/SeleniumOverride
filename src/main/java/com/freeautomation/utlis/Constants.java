package com.freeautomation.utlis;

import org.openqa.selenium.WebElement;

/**
 * @author chirag.s
 *
 */
public class Constants {

	public static ThreadLocal<WebElement> element = new InheritableThreadLocal<WebElement>();
	
	public static WebElement getElementInstance() {
		return element.get();
	}
	
	public static void setElementInstance(WebElement elementValue) {
		element.set(elementValue);
	}
}
