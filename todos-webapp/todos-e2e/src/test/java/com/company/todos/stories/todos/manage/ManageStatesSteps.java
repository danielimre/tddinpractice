package com.company.todos.stories.todos.manage;

import net.thucydides.core.annotations.Steps;

import org.jbehave.core.annotations.When;

import com.company.todos.steps.UserSteps;

/**
 * Steps for managing todos states.
 *
 * @author Daniel Imre
 *
 */
public class ManageStatesSteps {
    @Steps
    private UserSteps user;

    @When("the user clicks state checkbox on todo #$todoNumber")
    public void theUserClicksStateCheckboxOnTodo(Integer todoNumber) {
        user.clicksStateCheckBox(todoNumber);
    }
}
