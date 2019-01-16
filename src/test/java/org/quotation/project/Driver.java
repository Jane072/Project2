package org.quotation.project;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {

	private static WebDriver driver;

	@Parameters({ "browser" })
	@BeforeClass
	public void beforeClass(String browser) {

		switch (browser) {
		case "Firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		default:
			break;
		}

		driver.manage().window().maximize();
		driver.get("http://35.246.18.97/Qoutation/index.php");

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public static WebDriver getDriver() {
		return driver;
	}

}
