package com.company.todos.e2e;

import org.junit.AfterClass;
import org.junit.BeforeClass;

import com.company.todos.e2e.pages.Navigator;

/**
 * Base class for E2E tests.
 * Provides navigator to make navigation to pages easier.
 * Can be used only for single-threaded tests.
 *
 * @author Daniel Imre
 *
 */
public class E2EBaseTest {
    private static Navigator navigator;

    /**
     * Initializes the navigator.
     */
    @BeforeClass
    public static void initTest() {
        navigator = new Navigator();
    }

    /**
     * Releases the navigator.
     */
    @AfterClass
    public static void afterTest() {
        navigator.release();
    }

    /**
     * Provides the page loader.
     * @return the page loader
     */
    protected Navigator navigate() {
        return navigator;
    }
}
