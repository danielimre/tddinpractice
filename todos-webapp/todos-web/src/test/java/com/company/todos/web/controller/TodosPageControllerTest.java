package com.company.todos.web.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;


/**
 * Unit test for {@link TodosPageController}.
 *
 * @author Daniel Imre
 *
 */
public class TodosPageControllerTest {
    private final TodosPageController controller = new TodosPageController();

    @Test
    public void testSecondPartOfUrlIsUsedAsUsername() {
        ModelAndView mav = controller.listTodosForUser("John");
        assertEquals("John", mav.getModel().get("username"));
    }

    @Test
    public void testUsernameBecomesSanitizedHtmlInModel() {
        ModelAndView mav = controller.listTodosForUser("John <script>evil</script> Roar");
        assertEquals("John evil Roar", mav.getModel().get("username"));
    }
}
