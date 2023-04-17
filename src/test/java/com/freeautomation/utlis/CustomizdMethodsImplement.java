package com.freeautomation.utlis;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.freeautomation.override.CustomizeMethods;

public class CustomizdMethodsImplement{

	public void closePopUp(WebDriver driver)
	 {
		 System.out.println("ENTERING ON THE CLOSE POP-UP");
		 List<By> list = Arrays.asList(By.className("clickhere"));
		 for(By loc : list)
		 {
			 driver.findElement(loc).click();
		 }			
		 System.out.println("EXISING FROM THE CLOSE POP-UP");
	 }
	
	public void highligthElement(WebDriver driver,WebElement element)
	{
		String orignalStyle = element.getAttribute("style");
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element, "border: 4px solid red");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element, orignalStyle);
	}
}
