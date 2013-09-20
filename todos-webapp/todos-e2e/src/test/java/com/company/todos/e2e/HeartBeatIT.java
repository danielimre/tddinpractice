package com.company.todos.e2e;

import junit.framework.TestCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HeartBeatIT extends TestCase {

	public void testApplicationIsUpAndRunning() {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://localhost:8080/");
		String pageSource = driver.getPageSource();
		driver.quit();
		assertTrue(pageSource.contains("Hello World"));
	}
}
