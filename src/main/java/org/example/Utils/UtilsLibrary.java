package org.example.Utils;

import java.security.SecureRandom;

/**
 *
 * UtilsLibrary – kurze Beschreibung
 * Author: Deniz Wassmuth
 * Date: 05.12.2025
 * <p>
 * KEEP IN MIND:
 * - check and/or change user and email through GitBash
 * - add /target, *.iml and .idea to gitignore
 * - exclude previously added files from git changes through GitBash (git rm -r) and readd the files needed (git add .)
 */


// prints String with line break before and after the text
public class UtilsLibrary {

    public static void printText(int linesBefore, String text, int linesAfter) {

        char[] before = new char[linesBefore];
        if (before.length > 0) {
            for (int i = 0; i < before.length; i++) {
                System.out.print("\n");
            }
        }

        System.out.println(text);

        char[] after = new char[linesAfter];
        if (after.length > 0) {
            for (int i = 0; i < after.length; i++) {
                System.out.print("\n");
            }
        }
    }


    // von ChatGpt
//    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
//    private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
//    private static final String DIGITS = "0123456789";
//    private static final String SPECIAL = "!@#$%^&*()-_+=?.,;:";
//
//    // alle vier Gruppen erlaubt
//    public static final String ALL_ALLOWED = UPPER + LOWER + DIGITS + SPECIAL;
//
//    private static final SecureRandom SECURE_RANDOM = new SecureRandom();
//
//    public static String generateSecurePassword(int length) {
//        if (length <= 0) {
//            throw new IllegalArgumentException("length must be > 0");
//        }
//
//        StringBuilder sb = new StringBuilder(length);
//
//        for (int i = 0; i < length; i++) {
//            int index = SECURE_RANDOM.nextInt(ALL_ALLOWED.length());
//            char c = ALL_ALLOWED.charAt(index);
//            sb.append(c);
//        }
//
//        return sb.toString();
//    }

}
