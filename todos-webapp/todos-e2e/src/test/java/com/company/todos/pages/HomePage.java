package com.company.todos.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page object for the home page.
 *
 * @author Daniel Imre
 *
 */
@DefaultUrl("http://localhost:8080/")
public class HomePage extends PageObject {
    @FindBy(id = "todos")
    private WebElement todosLink;

    @FindBy(id = "username")
    private WebElement usernameInput;

    /**
     * Constructs a homepage object.
     *
     * @param driver the driver to use
     */
    public HomePage(WebDriver driver) {
        super(driver);
    }

    /**
     * Clicks the link which posts the login form and leads to the todos page.
     */
    public void clickTodosButton() {
        $(todosLink).click();
    }

    /**
     * Enters username into username field clearing first.
     *
     * @param username the username to enter
     */
    public void enterUsername(String username) {
        $(usernameInput).type(username);
    }
}
