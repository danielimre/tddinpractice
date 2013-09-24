package com.company.todos.e2e.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import com.company.todos.e2e.configuration.E2ETestConfiguration;

/**
 * Loads pages.
 *
 * @author Daniel Imre
 *
 */
public class Navigator {
    private final WebDriver driver;

    /**
     * Constructs a navigator.
     */
    public Navigator() {
        driver = E2ETestConfiguration.createDriver();
        driver.manage().timeouts().pageLoadTimeout(E2ETestConfiguration.getPageLoadTimeoutInSeconds(), TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(E2ETestConfiguration.getImplicitWaitInSeconds(), TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(E2ETestConfiguration.getScriptTimeoutInSeconds(), TimeUnit.SECONDS);
    }

    /**
     * Releases the resources used by this navigator instance.
     */
    public void release() {
        if (driver != null) {
            driver.quit();
        }
    }

    /**
     * Goes to homepage.
     *
     * @return the home page object
     */
    public HomePage toHomepage() {
        driver.get(E2ETestConfiguration.getRootUrl());
        return new HomePage(driver);
    }

    /**
     * Goes directly to the todos page.
     *
     * @return the todos page
     */
    public TodosPage toTodosPage() {
        driver.get(E2ETestConfiguration.getRootUrl() + "/todos");
        return new TodosPage(driver);
    }
}
