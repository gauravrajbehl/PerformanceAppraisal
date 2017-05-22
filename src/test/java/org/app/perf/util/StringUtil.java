package org.app.perf.util;

import java.util.Random;

/**
 * Created by gauravbehl on 19/5/17.
 */
public class StringUtil {

    public static String getRandomString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String generatedString = salt.toString();
        return generatedString;


    }

}
