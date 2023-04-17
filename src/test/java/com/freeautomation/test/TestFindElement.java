package com.freeautomation.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.freeautomation.override.ModifiedRemoteWebDriver;
import com.freeautomation.utlis.DriverImplements;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestFindElement {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		WebDriverManager.firefoxdriver().setup();
		WebDriver d = new FirefoxDriver();
		driver = ModifiedRemoteWebDriver.getModifiedDriver(new DriverImplements(d));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@Test(enabled = false)
	public void myTest() throws InterruptedException {
		driver.get("https://timesofindia.indiatimes.com/defaultinterstitial.cms");
		// Thread.sleep(10000);
		System.out.println("Title :- " + driver.getTitle());
//		Thread.sleep(10000);
		
//		try {
//			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='Sign in with Google Dialogue']")));
//			driver.findElement(By.xpath("//*[@id='close']")).click();
//			driver.switchTo().defaultContent();
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		
//		driver.findElement(By.xpath("//button[text()='Maybe later']")).click();
		System.out.println("Sign In isDisplayed :- " + driver.findElement(By.xpath("//span[text()='Sign In']")).isDisplayed());
		System.out.println("Sign In isEnabled :- " + driver.findElement(By.xpath("//span[text()='Sign In']")).isEnabled());
		System.out.println("Sign In isSelected :- " + driver.findElement(By.xpath("//span[text()='Sign In']")).isSelected());
		driver.findElement(By.xpath("//span[text()='Sign In']")).isDisplayed();
		driver.findElement(By.xpath("//span[text()='Sign In']")).click();
		System.out.println(driver.switchTo().activeElement().getTagName());

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
