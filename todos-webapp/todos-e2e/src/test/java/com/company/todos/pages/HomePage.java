package com.company.todos.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page object for the home page.
 * @author Daniel Imre
 *
 */
@DefaultUrl("http://localhost:8080/")
public class HomePage extends PageObject {
    @FindBy(linkText = "todos")
    private WebElement todosLink;

    /**
     * Constructs a homepage object.
     * @param driver the driver to use
     */
    public HomePage(WebDriver driver) {
        super(driver);
    }

    /**
     * Gets the main title of the page.
     * @return the main title
     */
    public String mainTitle() {
        return element(By.cssSelector("header h1")).getText();
    }

    /**
     * Click the link which leads to the todos page.
     */
    public void clickTodosLink() {
        todosLink.click();
    }
}
