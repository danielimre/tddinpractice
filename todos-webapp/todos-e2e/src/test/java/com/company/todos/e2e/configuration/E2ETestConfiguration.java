package com.company.todos.e2e.configuration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Provides configuration for E2E tests.
 * @author Daniel Imre
 *
 */
public final class E2ETestConfiguration {

    private E2ETestConfiguration() {
        //utility class
    }

    /**
     * Gets the root URL of the SUT.
     * @return the root URL
     */
    public static String getRootUrl() {
        return "http://localhost:8080";
    }

    /**
     * Creates the {@link WebDriver} instance to be used in the tests.
     * @return the driver
     */
    public static WebDriver createDriver() {
        return new FirefoxDriver();
    }

    /**
     * Get the page load time out in seconds.
     * @return the timeout
     */
    public static long getPageLoadTimeoutInSeconds() {
        return 10;
    }

    /**
     * Get the implicit wait time out in seconds.
     * @return the timeout
     */
    public static long getImplicitWaitInSeconds() {
        return 10;
    }

    /**
     * Get the script time out in seconds.
     * @return the timeout
     */
    public static long getScriptTimeoutInSeconds() {
        return 10;
    }
}
