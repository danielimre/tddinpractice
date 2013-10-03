package com.company.todos.stories.todos.manage;

import net.thucydides.core.annotations.Steps;

import org.jbehave.core.annotations.When;

import com.company.todos.steps.UserSteps;

/**
 * Login related steps.
 *
 * @author Daniel_Imre
 *
 */
public class LoginSteps {
    @Steps
    private UserSteps user;

    @When("the user logs in with '$username'")
    public void whenTheUserLogsInWith(String username) {
        user.isOnTheHomePage();
        user.logsInWith(username);
    }

    @When("the user logs out")
    public void whenTheUserLogsOut() {
        user.isOnTheHomePage();
    }

}
