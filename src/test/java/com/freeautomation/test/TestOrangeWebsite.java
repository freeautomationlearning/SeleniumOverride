package com.freeautomation.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.freeautomation.override.ModifiedRemoteWebDriver;
import com.freeautomation.utlis.DriverImplements;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestOrangeWebsite {

	WebDriver driver;
	
	@BeforeMethod
	public void setUp()
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver d = new ChromeDriver(options);
		driver = ModifiedRemoteWebDriver.getModifiedDriver(new DriverImplements(d));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	
	@Test(enabled = false)
	public void login()
	{
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[text()=' Login ']")).click();
		driver.findElement(By.xpath("//div[@class='oxd-topbar-header-userarea']//i")).click();
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		System.out.println("USERNAME : "+driver.findElement(By.name("username")).isDisplayed());
		Assert.assertEquals(driver.findElement(By.name("username")).isDisplayed(), true);
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
