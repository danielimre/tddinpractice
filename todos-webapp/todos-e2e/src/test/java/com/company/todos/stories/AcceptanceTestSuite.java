package com.company.todos.stories;

import net.thucydides.jbehave.ThucydidesJUnitStories;

/**
 * Test suite for acceptance tests.
 *
 * @author Daniel Imre
 *
 */
public class AcceptanceTestSuite extends ThucydidesJUnitStories {
    public AcceptanceTestSuite() {
        runThucydides().inASingleSession();
    }
}
