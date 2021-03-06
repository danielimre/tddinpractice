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

    @Given("there are stored todo '$todoText' for user '$userName'")
    public void thereAreStoredTodoForUser(String todoText, String userName) {
        contextSetup.addTodoForUser(todoText, userName);
    }

    @Given("there are stored todos for '$userName': '$todos'")
    public void thereAreStoredTodosForUser(String userName, String todos) {
        thereAreNoStoredTodosFor(userName);
        for (String todo : todos.split("\\|")) {
            thereAreStoredTodoForUser(todo, userName);
        }
    }

    @When("the user enters '$todoText' to new todo input field and hits Enter")
    public void theUserEntersTodoText(String todoText) {
        user.addsNewTodo(todoText);
    }

    @Then("they should see '$todoTextAdded' in the todos list")
    public void theyShouldSeeTodoTextAdded(String todoTextAdded) {
        user.shouldSeeTodoInTodoList(todoTextAdded);
    }

    @Then("they should not see '$todoText' in todos list")
    public void theyShouldNotSeeTodoInTodosList(String todoText) {
        user.shouldNotSeeTodoInTodoList(todoText);
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
    public void theyShouldSeeEmptyTodosList() {
        user.shouldSeeEmptyTodosList();
    }

    @Then("they should not see the footer")
    public void theyShouldNotSeeTheFooter() {
        user.shouldNotSeeFooter();
    }

    @When("the user modifies '$todoText' to '$updatedText'")
    public void userModifiesTodoText(String todoText, String updatedText) {
        user.modifiesTodo(todoText, updatedText);
    }

    @When("the user deletes todo '$todoText'")
    public void userDeletesTodo(String todoText) {
        user.deletesTodo(todoText);
    }
}
