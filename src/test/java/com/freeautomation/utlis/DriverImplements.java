package com.freeautomation.utlis;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import com.freeautomation.override.CustomizdMethodsImplements;
import com.freeautomation.override.CustomizeMethods;
import com.freeautomation.override.ModifiedRemoteWebDriver;


public class DriverImplements implements InvocationHandler {

	WebDriver driver;
	CustomizeMethods obj;
	
	public DriverImplements(WebDriver driver) {
		this.driver = driver;
		obj = new CustomizdMethodsImplements();
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("============================== DRIVER "+method.getName()+" =============================");
		switch (method.getName()) {
		case "findElement":
			try {
				obj.overrideWebelement(driver, args);
				new CustomizdMethodsImplement().highligthElement(driver,Constants.getElementInstance());
				return ModifiedRemoteWebDriver.getModifiedElement(new WebelementsImplement());
			} catch (NoSuchElementException e) {
				new CustomizdMethodsImplement().closePopUp(driver);
				obj.overrideWebelement(driver, args);
				return ModifiedRemoteWebDriver.getModifiedElement(new WebelementsImplement());
			}
		case "getTitle":
			return "CHIRAG GET TITLE :- " + driver.getTitle();
		case "switchTo":
			System.out.println("CHIRAG AWLAYS switchTo() : ");
			return driver.switchTo();
		default:
			System.out.println("DEFAULT ==  "+method.getName());
			return method.invoke(driver, args);
		}
	}
	
}
