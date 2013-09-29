package com.company.todos.web.controller;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import com.company.todos.web.controller.form.LoginForm;

/**
 * Unit test for {@link HomePageController}.
 *
 * @author Daniel Imre
 *
 */
public class HomePageControllerTest {
    private final HomePageController controller = new HomePageController();

    @Test
    public void testEmptyLoginFormIsUsedAsCommandModel() {
        ModelAndView mav = controller.welcome();
        assertTrue(mav.getModel().get("command") instanceof LoginForm);
        LoginForm form = (LoginForm) mav.getModel().get("command");
        assertNull(form.getUsername());
    }
}
