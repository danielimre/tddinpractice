package com.company.todos;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Utility class for URL related functions.
 * @author Daniel Imre
 *
 */
public final class UrlTestUtils {
    private UrlTestUtils() {
        //utility class
    }

    /**
     * URL encodes a string using UTF-8 encoding.
     * @param urlPart the string to encode
     * @return the encoded string
     */
    public static String encodeUrlPart(String urlPart) {
        String encoded;
        try {
            encoded = URLEncoder.encode(urlPart, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException(e);
        }
        return encoded;
    }
}
