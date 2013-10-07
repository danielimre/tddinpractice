package com.company.todos.pages;

import net.thucydides.core.pages.PageObject;

import org.openqa.selenium.WebDriver;

/**
 * Page object for admin page.
 *
 * @author Daniel Imre
 *
 */
public class AdminPage extends PageObject {
    /**
     * Constructs an admin page object.
     *
     * @param driver the driver to use
     */
    public AdminPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Removes all todos from persistent store.
     * TODO: make this aware of userName
     */
    public void purgeTodosFor(String userName) {
        getDriver().navigate().to("http://localhost:8080/admin/api/todo/purge/");
    }
}
