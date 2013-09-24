package com.company.todos.e2e.pages;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page object for the todos page.
 * @author Daniel Imre
 *
 */
public class TodosPage {
    private final WebDriver driver;

    /**
     * Constructs a todos page object while asserting that we are actually on the todos page.
     * @param driver the driver to use
     */
    public TodosPage(WebDriver driver) {
        this.driver = driver;
        assertEquals("This is not the todos page.", "todos - list", driver.getTitle());
    }

    /**
     * Gets the main title of the page.
     * @return the main title
     */
    public String mainTitle() {
        return driver.findElement(By.cssSelector("header h1")).getText();
    }

    /**
     * Checks if the footer is visible.
     * @return true if the footer visible, otherwise false
     */
    public boolean isFooterVisible() {
        return driver.findElement(By.id("footer")).isDisplayed();
    }
}
