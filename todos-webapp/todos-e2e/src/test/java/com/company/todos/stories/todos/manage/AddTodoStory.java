package com.company.todos.stories.todos.manage;

import net.thucydides.core.annotations.Steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import com.company.todos.steps.UserSteps;

/**
 * Scenario for adding new todo item to an empty todo list.
 *
 * @author Daniel Imre
 *
 */
public class AddTodoStory {
    @Steps
    private UserSteps user;

    @Given("the user is on the todos page logged in as '$username' with empty todos list")
    public void userLogsInWith(String username) {
        user.isOnTheHomePage();
        user.logsInWith(username);
    }

    @When("the user enters '$todoText' to new todo input field and hits Enter")
    public void theUserEntersTodoText(String todoText) {
        user.addsNewTodo(todoText);
    }

    @Then("they should see '$todoTextAdded' added to the todos list")
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
}
