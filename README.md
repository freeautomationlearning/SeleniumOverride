
# Selenium Webdriver Overrider

WebDriver Overrider is an open-source Java library that carries out the override WebDriver and WebElements interface.

By using WebDriverOverrider you can override the findElement, getTitle, switchTo and other methods which is in WebDriver Interface.

If you want to override WebElement Interface methods such as click, isDisplayed, isEnabled and other methods you can also do.


## Setup

I have uploaded the WebDriver Overrider as github package. You can customize the Maven setting.xml to downoad this package. All steps are mentioned on the url https://docs.github.com/en/packages/working-with-a-github-packages-registry/working-with-the-apache-maven-registry

```
 <dependency>
  <groupId>com.freeautomation</groupId>
  <artifactId>seleniumoverride</artifactId>
  <version>1.1.0</version>
</dependency>
```
    
## Configuration

Add the below code to override the WebDriver and WebElement methods

### 1. Init driver instance of Custom WebDriver
```
// Create the WebDriver instance
WebDriver d = new FirefoxDriver();

// Create the Customize WebDriver
WebDriver driver = ModifiedRemoteWebDriver.getModifiedDriver(new DriverImplements(d));
```
### 2. Create a Java class to add the Driver Implementation

```
public class DriverImplements implements InvocationHandler {

	WebDriver driver;
	CustomizeMethods obj;
	
	public DriverImplements(WebDriver driver) {
		this.driver = driver;
		obj = new CustomizdMethodsImplements();
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		switch (method.getName()) {
		case "findElement":
				obj.overrideWebelement(driver, args);
				return ModifiedRemoteWebDriver.getModifiedElement(new WebelementsImplement());
		default:
			return method.invoke(driver, args);
		}
	}
	
}
```

### 3. Create a Java class to add the WebElement Implementation

```
public class WebelementsImplement implements InvocationHandler {


	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		switch (method.getName()) {
		case "click":
			Constants.getElementInstance().click();
			return true;
		case "isDisplayed":
			System.out.println("isDisplay :- "+Constants.getElementInstance().isDisplayed());
			return Constants.getElementInstance().isDisplayed();
		case "sendKeys":
			Constants.getElementInstance().sendKeys((CharSequence[])args[0]);
			return true;
		default:
			return method.invoke(Constants.getElementInstance(), args);
		}
	}
```
## Running the tests

### 1. Create any test script to see the outputs
```
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
```


## 🚀 About Me
I am Full Stack Tester. For more info Please go to my channel on YouTube [Free Automation Learning](https://www.youtube.com/channel/UCFs7BfAeJI6MtdqzTXdA9Og)


## 🔗 Links
[![portfolio](https://img.shields.io/badge/my_portfolio-000?style=for-the-badge&logo=ko-fi&logoColor=white)](https://freeautomationlearning.github.io/home/)
[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/chirag-singh-freeautomationlearning/)
[![twitter](https://img.shields.io/badge/twitter-1DA1F2?style=for-the-badge&logo=twitter&logoColor=white)](https://twitter.com/freeautomation)
## License
WebDriver Overrider is a project created and maintained by [Chirag Singh](https://github.com/freeautomationlearning) and licensed under the terms of the
[MIT](https://choosealicense.com/licenses/mit/)
License.