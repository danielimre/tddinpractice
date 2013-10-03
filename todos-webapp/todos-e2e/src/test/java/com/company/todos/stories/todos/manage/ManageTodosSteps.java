package com.company.todos.stories.todos.manage;

import net.thucydides.core.annotations.Steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import com.company.todos.steps.ContextSetupSteps;
import com.company.todos.steps.UserSteps;

/**
 * Scenario for adding new todo item to an empty todo list.
 *
 * @author Daniel Imre
 *
 */
public class ManageTodosSteps {
    @Steps
    private UserSteps user;
    @Steps
    private ContextSetupSteps contextSetup;

    @Given("there are no stored todos for '$userName'")
    public void thereAreNoStoredTodosFor(String userName) {
        contextSetup.clearTodosFor(userName);
    }

    @When("the user enters '$todoText' to new todo input field and hits Enter")
    public void theUserEntersTodoText(String todoText) {
        user.addsNewTodo(todoText);
    }

    @Then("they should see '$todoTextAdded' in the todos list")
    public void theyShouldSeeTodoTextAdded(String todoTextAdded) {
        user.shouldSeeTodoInTodoList(todoTextAdded);
    }

    @Then("they should see the new todo ('$todoTextAdded') be marked as incomplete")
    public void theyShouldSeeTheTodoMarkedAsIncomplete(String todoTextAdded) {
        user.shouldSeeTodoAsIncomplete(todoTextAdded);
    }

    @Then("they should see the new todo input field empty")
    public void theyShouldSeeTheNewTodoInputFieldEmpty() {
        user.shouldSeeNewTodoInputFieldEmpty();
    }

    @Then("they should see the footer with status: '$statusText'")
    public void theyShouldSeeTheFooterWithStatus(String statusText) {
        user.shouldSeeFooterWithStatus(statusText);
    }

    @Then("they should see $numberOfTodos todo in the list")
    public void theyShouldSeeXTodoInTheList(Integer numberOfTodos) {
        user.shouldSeeXTodosInTheList(numberOfTodos);
    }

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
