package com.company.todos.stories;

import net.thucydides.core.annotations.Steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import com.company.todos.steps.UserSteps;

/**
 * BDD scenario.
 * @author Daniel Imre
 *
 */
public class ListTodosStory {
    @Steps
    private UserSteps user;

    @Given("the user is on the home page")
    public void givenTheUserIsOnTheHomePage() {
        user.isOnTheHomePage();
    }

    @When("the user clicks the todos link")
    public void whenTheUserClicksTodosLink() {
        user.clicksTodosLink();
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
