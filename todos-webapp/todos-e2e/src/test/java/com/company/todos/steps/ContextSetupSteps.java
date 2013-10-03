package com.company.todos.steps;

import net.thucydides.core.annotations.Step;

/**
 * Steps for preparing test contexts.
 * @author Daniel Imre
 *
 */
public class ContextSetupSteps {

    /**
     * Calls backend directly to clear up todos for a specific user.
     * @param userName the user's name
     */
    @Step
    public void clearTodosFor(String userName) {
        //TODO: add call to backend
    }

}
