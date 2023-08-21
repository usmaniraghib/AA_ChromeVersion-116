package com.raghib.chrome.browser;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChromeBrowser_116 {

	public static ChromeOptions chromeOptions;
	public static WebDriver driver;

	public static String url = "https://www.google.com";
	public static String googleSearchBox = "//*[@id='APjFqb']";
	public static String linkPath = "//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div/div/div[1]/div/a/h3";

	public static void main(String[] args) throws InterruptedException {
		// WAY-1 [THIS WILL WORKING FROM SELENIUM-JAVA VERSION 4.10.0]
//		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Driver-116\\chromedriver.exe");
//		driver = new ChromeDriver();

		// WAY-2 [THIS WILL WORKING FROM SELENIUM-JAVA VERSION 4.11.0]
		chromeOptions = new ChromeOptions();
		chromeOptions.setBrowserVersion("116");
		driver = new ChromeDriver(chromeOptions);

		driver.manage().window().maximize();
		driver.get(url);

		WebElement element = driver.findElement(By.xpath(googleSearchBox));

		Duration duration = Duration.ofSeconds(30);

		WebDriverWait wait = new WebDriverWait(driver, duration);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(googleSearchBox)));

		element.sendKeys("selenium");
		element.sendKeys(Keys.ENTER);

		WebDriverWait wait1 = new WebDriverWait(driver, duration);
		wait1.until(ExpectedConditions.elementToBeClickable((By.xpath(linkPath)))).click();

		Thread.sleep(5000);

		driver.quit();

	}

}
