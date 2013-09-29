package com.company.todos.web.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.company.todos.web.controller.form.LoginForm;

/**
 * Unit test for {@link LoginController}.
 *
 * @author Daniel Imre
 *
 */
public class LoginControllerTest {
    private final LoginController controller = new LoginController();

    @Test
    public void testUserGetsRedirectedToTodosPageAfterSuccessfulLogin() {
        LoginForm form = new LoginForm();
        form.setUsername("john");
        String view = controller.login(form);
        assertEquals("redirect:/todos/john/", view);
    }
}
