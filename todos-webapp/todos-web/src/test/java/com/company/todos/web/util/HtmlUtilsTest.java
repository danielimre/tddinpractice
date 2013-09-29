package com.company.todos.web.util;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * Unit test for {@link HtmlUtils}.
 *
 * @author Daniel Imre
 *
 */
@RunWith(value = Parameterized.class)
public class HtmlUtilsTest {
    private final String inputHtml;
    private final String expectedStripTagsResult;

    public HtmlUtilsTest(String inputHtml, String expectedStripTagsResult) {
        this.inputHtml = inputHtml;
        this.expectedStripTagsResult = expectedStripTagsResult;
    }

    @Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] {
            {"nonhtml", "nonhtml"},
            {"some <b>normal</b> html", "some normal html"},
            {"some <b>invalid html", "some invalid html"},
            {"some <veryinvalid html", "some "}
        };
        return Arrays.asList(data);
    }

    @Test
    public void testStripTags() {
        assertEquals(expectedStripTagsResult, HtmlUtils.stripTags(inputHtml));
    }
}
