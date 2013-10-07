package com.company.todos.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.company.todos.dao.TodoDao;
import com.company.todos.domain.Todo;

/**
 * Unit test of {@link TodoServiceImpl}.
 *
 * @author Mate Szvoboda
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class TodoServiceImplTest {

    @Mock
    private TodoDao todoDao;

    private TodoServiceImpl todoServiceImpl;

    @Before
    public void setup() {
        todoServiceImpl = new TodoServiceImpl();
        todoServiceImpl.setTodoDao(todoDao);
    }

    @Test
    public void testIfReturnsAllTodos() {
        List<Todo> todos = Arrays.asList(todo(1L, "Milk"), todo(2L, "Sugar"));
        when(todoDao.getAll()).thenReturn(todos);
        List<Todo> result = todoServiceImpl.getAll();
        assertThat(result, equalTo(todos));
    }

    @Test
    public void testThatDaoIsCalledWhenTodoGetsSaved() {
        Todo todo = todo(1L, "Milk");
        todoServiceImpl.save(todo);
        verify(todoDao).save(Mockito.eq(todo));
    }

    @Test
    public void shouldRemoveAllTodos() {
        todoServiceImpl.removeAll();
        verify(todoDao).removeAll();
    }

    private static Todo todo(Long id, String title) {
        Todo todo = new Todo();
        todo.setId(id);
        todo.setTitle(title);
        return todo;
    }
}
