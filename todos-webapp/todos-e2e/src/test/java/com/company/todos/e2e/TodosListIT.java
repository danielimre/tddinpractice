package com.company.todos.e2e;

import static org.junit.Assert.assertFalse;

import org.junit.Test;

import com.company.todos.e2e.pages.TodosPage;

/**
 * Tests the todo page basic interactions.
 *
 * @author Daniel Imre
 *
 */
public class TodosListIT extends E2EBaseTest {

    /**
     * When there are no todos, footer should be hidden.
     */
    @Test
    public void testTodoListIsInitiallyEmpty() {
        TodosPage todosPage = navigate().toTodosPage();
        assertFalse(todosPage.isFooterVisible());
    }
}
