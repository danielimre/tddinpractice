package com.company.todos.pages;

import static ch.lambdaj.Lambda.extract;
import static ch.lambdaj.Lambda.on;
import static ch.lambdaj.Lambda.selectFirst;

import java.util.List;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import ch.lambdaj.function.matcher.Predicate;

/**
 * Page object for the todos page.
 *
 * @author Daniel Imre
 *
 */
@DefaultUrl("http://localhost:8080/todos")
public class TodosPage extends PageObject {
    @FindBy(id = "todos-list")
    private WebElement todosList;

    @FindBy(id = "new-todo")
    private WebElement newTodoField;

    @FindBy(id = "todos-count")
    private WebElement status;

    @FindBy(css = "#header h1")
    private WebElement headerTitle;

    /**
     * Constructs a todos page object.
     *
     * @param driver the driver to use
     */
    public TodosPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Checks if the footer is visible.
     *
     * @return true if the footer visible, otherwise false
     */
    public boolean isFooterVisible() {
        return getDriver().findElement(By.id("footer")).isDisplayed();
    }

    /**
     * Returns true if the todos list is empty.
     *
     * @return true if empty, otherwise false
     */
    public boolean isTodosListEmpty() {
        return getTodosInList().size() == 0;
    }

    /**
     * Enters text into new todo field and hits enter.
     *
     * @param todoText the text to be added
     */
    public void addNewTodo(String todoText) {
        $(newTodoField).type(todoText);
        newTodoField.sendKeys(Keys.ENTER);
    }

    /**
     * Gets the text of todos in todos list.
     *
     * @return collection of todo texts
     */
    public List<String> getTodoTexts() {
        return extract(getTodosInList(), on(WebElement.class).getText());
    }

    /**
     * Gets the value of the new todo field.
     *
     * @return the value
     */
    public String getNewTodoFieldText() {
        return $(newTodoField).getTextValue();
    }

    /**
     * Returns true if the todo with the specified text is marked complete.
     *
     * @param todoTextAdded the todo's text
     * @return true if the todo is complete, otherwise false
     */
    public boolean isTodoMarkedComplete(final String todoTextAdded) {
        return $(getTodoWithText(todoTextAdded).findElement(By.cssSelector("input[type=checkbox]"))).isSelected();
    }

    /**
     * Gets the status text in the footer.
     *
     * @return the status text
     */
    public String getStatusText() {
        return $(status).getText();
    }

    /**
     * Gets the text in the header title.
     *
     * @return the title text
     */
    public String getHeaderText() {
        return $(headerTitle).getText();
    }

    /**
     * Clicks the state checkbox of a todo by its ordinal number.
     *
     * @param todoNumber the todo's ordinal number
     */
    public void clickStateCheckbox(Integer todoNumber) {
        getTodosInList().get(todoNumber - 1).findElement(By.cssSelector("input[type=checkbox]")).click();
    }

    /**
     * Modifies a todo located by its text.
     *
     * @param todoText the current text
     * @param updatedText the updated text
     */
    public void modifyTodo(String todoText, String updatedText) {
        WebElement todo = getTodoWithText(todoText);
        doubleClickElement(todo.findElement(By.cssSelector("label")));
        WebElement todoInput = todo.findElement(By.cssSelector("form input"));
        todoInput.clear();
        todoInput.sendKeys(updatedText);
        todoInput.sendKeys(Keys.ENTER);
    }

    private List<WebElement> getTodosInList() {
        return todosList.findElements(By.cssSelector("li"));
    }

    /**
     * Gets the first todo with text.
     * @param todoText the todo's text
     * @return the first todo with the specified text
     */
    private WebElement getTodoWithText(final String todoText) {
        return selectFirst(getTodosInList(), new Predicate<WebElement>() {
            @Override
            public boolean apply(WebElement item) {
                return todoText.equals(item.getText());
            }
        });
    }

    private void doubleClickElement(WebElement element) {
        Actions action = new Actions(getDriver());
        action.doubleClick(element);
        action.perform();
    }

}
