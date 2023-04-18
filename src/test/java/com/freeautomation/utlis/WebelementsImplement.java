package com.freeautomation.utlis;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class WebelementsImplement implements InvocationHandler {


	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		switch (method.getName()) {
		case "click":
			System.out.println("CHIRAG AWLAYS SAYS CLICKED : ");
			Constants.getElementInstance().click();
			return true;
		case "isDisplayed":
			System.out.println("CHIRAG AWLAYS SAYS isDisplayed : ");
			System.out.println("isDisplay :- "+Constants.getElementInstance().isDisplayed());
			return Constants.getElementInstance().isDisplayed();
		case "isEnabled":
			System.out.println("CHIRAG AWLAYS SAYS isEnabled : ");
			System.out.println("isEnabled :- "+Constants.getElementInstance().isEnabled());
			return Constants.getElementInstance().isEnabled();
		case "isSelected":
			System.out.println("CHIRAG AWLAYS SAYS isSelected : ");
			System.out.println("isSelected :- "+Constants.getElementInstance().isSelected());
			return Constants.getElementInstance().isSelected();
		case "sendKeys":
			System.out.println("CHIRAG AWLAYS SAYS sendKeys : ");
			Constants.getElementInstance().sendKeys((CharSequence[])args[0]);
			return true;
		default:
			return method.invoke(Constants.getElementInstance(), args);
		}
		
	}
	
	
}
