package com.company.todos.pages;

import static com.company.todos.UrlTestUtils.encodeUrlPart;
import net.thucydides.core.pages.PageObject;

import org.openqa.selenium.WebDriver;

/**
 * Page object for admin page.
 *
 * @author Daniel Imre
 *
 */
public class AdminPage extends PageObject {
    private static final String TODOS_API = "http://localhost:8080/admin/api/todos/";

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
     */
    public void purgeTodosFor(String userName) {
        getDriver().navigate().to(TODOS_API + encodeUrlPart(userName) + "/purge/");
    }

    /**
     * Adds a todo for a user.
     * @param todoText the todo text
     * @param userName the userName
     */
    public void addTodoForUser(String todoText, String userName) {
        getDriver().navigate().to(TODOS_API + encodeUrlPart(userName) + "/add/?completed=false&text=" + encodeUrlPart(todoText));
    }
}
