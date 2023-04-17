package com.freeautomation.override;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author chirag.s
 * 
 * This class to override the selenium interface
 *
 */
public class ModifiedRemoteWebDriver {
	
	/**
	 * This method for return override web driver
	 * @author chirag.s
	 * @param object
	 * @return WebDriver
	 */
	public static WebDriver getModifiedDriver(Object obj)
	{
		return (WebDriver)Proxy.newProxyInstance(WebDriver.class.getClassLoader(), new Class[] {WebDriver.class}, (InvocationHandler) obj);
	}
	
	/**
	 * This method for return override web element
	 * @author chirag.s
	 * @param object
	 * @return WebElement
	 */
	public static WebElement getModifiedElement(Object obj)
	{
		return (WebElement)Proxy.newProxyInstance(WebElement.class.getClassLoader(), new Class[] {WebElement.class}, (InvocationHandler) obj);
	}
}
