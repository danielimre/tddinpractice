package com.company.todos.web.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.company.todos.domain.Todo;
import com.company.todos.domain.Todo.TodoBuilder;
import com.company.todos.service.TodoService;

/**
 * Unit test for {@link TodoRestController}.
 *
 * @author Daniel Imre
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class TodoRestControllerTest {
    private static final long TODO_ID = 1L;
    private static final String USER_NAME = "user";
    private static final String TITLE = "title";
    private final TodoRestController controller = new TodoRestController();
    @Mock
    private TodoService todoService;

    @Before
    public void initController() {
        controller.setTodoService(todoService);
    }

    @Test
    public void shouldReturnAllTodosForUser() {
        when(todoService.getAllTodosForUser(USER_NAME)).thenReturn(Arrays.asList(aCompleteTodo()));
        List<Todo> todos = controller.getAllForUser(USER_NAME);
        assertEquals(Arrays.asList(aCompleteTodo()), todos);
    }

    @Test
    public void shouldCreateTodoForUser() {
        Todo savedTodo = aTodo().withTitle(TITLE).forUser(USER_NAME).completed().build();
        doNothing().when(todoService).saveTodo(savedTodo);
        Todo returnedTodo = controller.createTodoForUser(aTodo().withTitle(TITLE).completed().build(), USER_NAME);
        assertEquals(savedTodo, returnedTodo);
    }

    @Test
    public void shouldUpdateTodoForUser() {
        Todo savedTodo = aTodo().withId(TODO_ID).withTitle(TITLE).forUser(USER_NAME).completed().build();
        doNothing().when(todoService).saveTodo(savedTodo);
        Todo returnedTodo = controller.updateTodoOfUser(aTodo().withTitle(TITLE).completed().build(), TODO_ID, USER_NAME);
        assertEquals(savedTodo, returnedTodo);
    }

    @Test
    public void shouldDeleteTodoByIdOfUser() {
        when(todoService.deleteTodoById(TODO_ID, USER_NAME)).thenReturn(true);
        controller.deleteTodo(TODO_ID, USER_NAME);
        verify(todoService).deleteTodoById(TODO_ID, USER_NAME);
    }

    private TodoBuilder aTodo() {
        return new TodoBuilder();
    }

    private Todo aCompleteTodo() {
        return aTodo().withId(1L).withTitle(TITLE).forUser(USER_NAME).completed().build();
    }

}
