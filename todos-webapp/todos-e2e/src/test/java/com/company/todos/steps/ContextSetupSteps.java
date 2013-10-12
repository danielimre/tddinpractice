package com.company.todos.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

import com.company.todos.pages.AdminPage;

/**
 * Steps for preparing test contexts.
 * @author Daniel Imre
 *
 */
public class ContextSetupSteps extends ScenarioSteps {
    private AdminPage adminPage;

    public ContextSetupSteps(Pages pages) {
        super(pages);
    }

    /**
     * Calls backend directly to clear up todos for a specific user.
     * @param userName the user's name
     */
    @Step
    public void clearTodosFor(String userName) {
        adminPage.purgeTodosFor(userName);
    }

    /**
     * Calls backend directly to add a todo for a specific user.
     * @param todoText the todo text to add
     * @param userName the user's name
     */
    @Step
    public void addTodoForUser(String todoText, String userName) {
        adminPage.addTodoForUser(todoText, userName);
    }

}
