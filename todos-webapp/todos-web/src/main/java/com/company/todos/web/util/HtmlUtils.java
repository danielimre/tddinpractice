package com.company.todos.web.util;

import java.util.regex.Pattern;

/**
 * Utility class for HTML related operations.
 *
 * @author Daniel Imre
 *
 */
public final class HtmlUtils {
    private static final Pattern STRIP_TAGS_PATTERN = Pattern.compile("\\<[^>]*(?:>|$)");

    private HtmlUtils() {
        // utility class
    }

    /**
     * Strips html tags from input string.
     *
     * @param html the input string
     * @return the cleaned text
     */
    public static String stripTags(String html) {
        return STRIP_TAGS_PATTERN.matcher(html).replaceAll("");
    }
}
