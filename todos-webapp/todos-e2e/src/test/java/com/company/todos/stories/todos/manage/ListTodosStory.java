package com.company.todos.stories.todos.manage;

import net.thucydides.core.annotations.Steps;

import org.jbehave.core.annotations.Then;

import com.company.todos.steps.UserSteps;

/**
 * Scenario for user logging in for the first time.
 *
 * @author Daniel Imre
 *
 */
public class ListTodosStory {
    @Steps
    private UserSteps user;

    @Then("they should see their username ($text) in header")
    public void theyShouldSeeTheirUsernameInHeader(String text) {
        user.shouldSeeTextInHeader(text);
    }

    @Then("they should see empty todos list")
    public void thenTheyShouldSeeEmptyTodosList() {
        user.shouldSeeEmptyTodosList();
    }

    @Then("they should not see the footer")
    public void thenTheyShouldNotSeeTheFooter() {
        user.shouldNotSeeFooter();
    }

}
