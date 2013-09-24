package com.company.todos.e2e.pages;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page object for the home page.
 * @author Daniel Imre
 *
 */
public class HomePage {
    private final WebDriver driver;

    /**
     * Constructs a homepage object while asserting that we are actually on the homepage.
     * @param driver the driver to use
     */
    public HomePage(WebDriver driver) {
        this.driver = driver;
        assertEquals("This is not the homepage.", "todos - home", driver.getTitle());
    }

    /**
     * Gets the main title of the page.
     * @return the main title
     */
    public String mainTitle() {
        return driver.findElement(By.cssSelector("header h1")).getText();
    }

    /**
     * Click the link which leads to the todos page.
     * @return the todo page
     */
    public TodosPage clickTodosLink() {
        driver.findElement(By.linkText("todos")).click();
        return new TodosPage(driver);
    }
}
