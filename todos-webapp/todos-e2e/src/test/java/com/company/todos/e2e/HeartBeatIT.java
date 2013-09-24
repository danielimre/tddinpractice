package com.company.todos.e2e;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.company.todos.e2e.pages.HomePage;
import com.company.todos.e2e.pages.TodosPage;

/**
 * E2E test to prove it's working.
 *
 * @author Daniel Imre
 */
public class HeartBeatIT extends E2EBaseTest {

    @Test
    public void testApplicationIsUpAndRunning() {
        HomePage homepage = navigate().toHomepage();
        assertEquals("homepage", homepage.mainTitle());
        TodosPage todos = homepage.clickTodosLink();
        assertEquals("todos", todos.mainTitle());
    }
}
