package com.company.todos.steps;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

import com.company.todos.pages.HomePage;
import com.company.todos.pages.TodosPage;

/**
 * Steps a user can take.
 * @author Daniel Imre
 *
 */
public class UserSteps extends ScenarioSteps {
    private HomePage homePage;
    private TodosPage todosPage;

    public UserSteps(Pages pages) {
        super(pages);
    }

    @Step
    public void clicksTodosLink() {
        homePage.clickTodosLink();
    }

    @Step
    public void shouldNotSeeFooter() {
        assertFalse(todosPage.isFooterVisible());
    }

    @Step
    public void isOnTheHomePage() {
        homePage.open();
    }

    @Step
    public void shouldSeeEmptyTodosList() {
        assertTrue(todosPage.isTodosListEmpty());
    }
}
