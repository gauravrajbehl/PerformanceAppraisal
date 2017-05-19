package org.app.perf.util;

import java.nio.charset.Charset;
import java.util.Random;

/**
 * Created by gauravbehl on 19/5/17.
 */
public class StringUtil {

    public static String getRandomString() {
        byte[] array = new byte[7]; // length is bounded by 7
        new Random().nextBytes(array);
        String generatedString = new String(array, Charset.forName("UTF-8"));

        return generatedString;
    }

}
