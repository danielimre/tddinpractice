package com.company.todos.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import com.company.todos.domain.Todo.TodoBuilder;

/**
 * Unit test for {@link Todo}.
 * @author Daniel Imre
 *
 */
public class TodoTest {

    @Test
    public void buildShouldBuildNewButEqualTodoWhenCalledTwice() {
        TodoBuilder builder = new TodoBuilder();
        builder.withId(1L).forUser("user").withTitle("text").completed();

        Todo todoA = builder.build();
        Todo todoB = builder.build();
        assertFalse(todoA == todoB);
        assertEquals(todoA.hashCode(), todoB.hashCode());
        assertEquals(todoA, todoB);
        assertEquals(todoA.toString(), todoB.toString());
    }
}
