package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	protected static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<WebDriver>();

	@BeforeMethod
	public void setDriver() {
		WebDriver driver = BaseTest.getBrowserType("chrome", false);
		threadLocalDriver.set(driver);
		//driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

	}
	public static WebDriver getDriver() {
		return threadLocalDriver.get();
	}
	@AfterMethod
	public void removeDriver() {
		getDriver().quit();
		threadLocalDriver.remove();
	}

	/**
	 * @param browserName
	 * @param headless
	 * @return
	 */
	public static WebDriver getBrowserType(String browserName, boolean headless) {
		String browser = browserName.toLowerCase();
		WebDriver driver = null;
		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			if(headless) {
				ChromeOptions co = new ChromeOptions();
				co.addArguments("--headless");
				driver = new ChromeDriver(co);
			} else {
				driver = new ChromeDriver();
			}
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			if(headless) {
				FirefoxOptions fo = new FirefoxOptions();
				fo.addArguments("--headless");
				driver = new FirefoxDriver(fo);
			} else {
				driver = new FirefoxDriver();
			}
			break;

		case "safari":
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
			break;
		
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
			
		default:
			System.out.println("Provide a right input browsers supported are: 'chrome', 'firefox', 'edge', 'safari'");
			
		}
		return driver;
	}


}
