package com.company.todos.steps;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.Matchers.not;
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
    public void shouldNotSeeTodoInTodoList(String todoText) {
        assertThat(todosPage.getTodoTexts(), not(hasItem(todoText)));
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

    @Step
    public void shouldSeeTextInHeader(String text) {
        assertThat(todosPage.getHeaderText(), containsString(text));
    }

    @Step
    public void shouldSeeXTodosInTheList(Integer expectedNumberOfTodos) {
        assertThat(todosPage.getTodoTexts().size(), equalTo(expectedNumberOfTodos));
    }

    @Step
    public void clicksStateCheckBox(Integer todoNumber) {
        todosPage.clickStateCheckbox(todoNumber);
    }

    @Step
    public void modifyTodo(String todoText, String updatedText) {
        todosPage.modifyTodo(todoText, updatedText);
    }
}
