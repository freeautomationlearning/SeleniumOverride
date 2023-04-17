package com.freeautomation.override;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.freeautomation.utlis.Constants;


/**
 * @author chirag.s
 *
 */
public class CustomizdMethodsImplements implements CustomizeMethods{

	@Override
	public void overrideWebelement(WebDriver driver,Object[] args) {
		Constants.setElementInstance(driver.findElement((By) args[0]));
	}
}
