package com.company.todos.steps;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.isEmptyString;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
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
    public void clicksTodosButton() {
        homePage.clickTodosButton();
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

    @Step
    public void entersUsername(String username) {
        homePage.enterUsername(username);
    }

    @Step
    public void logsInWith(String username) {
        entersUsername(username);
        clicksTodosButton();
    }

    @Step
    public void addsNewTodo(String todoText) {
        todosPage.addNewTodo(todoText);
    }

    @Step
    public void shouldSeeTodoInTodoList(String todoTextAdded) {
        assertThat(todosPage.getTodoTexts(), hasItem(todoTextAdded));
    }

    @Step
    public void shouldSeeNewTodoInputFieldEmpty() {
        assertThat(todosPage.getNewTodoFieldText(), isEmptyString());
    }

    @Step
    public void shouldSeeTodoAsIncomplete(String todoTextAdded) {
        assertFalse(todosPage.isTodoMarkedComplete(todoTextAdded));
    }

    @Step
    public void shouldSeeFooterWithStatus(String statusText) {
        assertThat(todosPage.getStatusText(), equalTo(statusText));
    }
}
