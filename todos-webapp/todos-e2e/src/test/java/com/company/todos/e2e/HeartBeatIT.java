package com.company.todos.e2e;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * E2E test to prove it's working.
 *
 * @author Daniel Imre
 */
public class HeartBeatIT {

    @Test
    public void testApplicationIsUpAndRunning() {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://localhost:8080/");
        String pageSource = driver.getPageSource();
        driver.quit();
        assertTrue(pageSource.contains("Hello World"));
    }
}
