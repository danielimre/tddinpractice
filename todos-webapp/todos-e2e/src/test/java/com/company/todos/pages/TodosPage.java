package com.company.todos.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page object for the todos page.
 * @author Daniel Imre
 *
 */
@DefaultUrl("http://localhost:8080/todos")
public class TodosPage extends PageObject {
    @FindBy(id = "todos-list")
    private WebElement todosList;

    /**
     * Constructs a todos page object.
     * @param driver the driver to use
     */
    public TodosPage(WebDriver driver) {
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
     * Checks if the footer is visible.
     * @return true if the footer visible, otherwise false
     */
    public boolean isFooterVisible() {
        return element(By.id("footer")).isDisplayed();
    }

    /**
     * Returns true if the todos list is empty.
     * @return true if empty, otherwise false
     */
    public boolean isTodosListEmpty() {
        return todosList.findElements(By.tagName("li")).size() == 0;
    }
}
