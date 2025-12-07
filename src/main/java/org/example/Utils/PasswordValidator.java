package org.example.Utils;

import java.util.Locale;
import java.util.Set;

/**
 *
 * PasswordValidator – kurze Beschreibung
 * Author: Deniz Wassmuth
 * Date: 05.12.2025
 * <p>
 * KEEP IN MIND:
 * - check and/or change user and email through GitBash
 * - add /target, *.iml and .idea to gitignore
 * - exclude previously added files from git changes through GitBash (git rm -r) and readd the files needed (git add .)
 *   -> maven mostly handles this automatically after changing pom.xml
 *
 *  add dependency: junit-jupiter
 *
 *  add plugin: maven-surefire
 *
 *  in GITHUB add Action: ... with maven
 */



public final class PasswordValidator {

    public static Set<String> commonPasswords = Set.of("Password", "Password1", "Password2", "Password3", "Password4",
            "Password5", "Password6", "Password7", "Password8", "Password9", "Password10", "Password123", "AbCdeF");

    public static String specialChars = "!#-**?<>|&%$=)(";
    public static boolean hasMinLength(String password, int min) {

        if (password == null) {
            return false;
        }

        return password.length() >= min;
    }

    public static boolean containsDigit(String password) {

        if (password == null) {
            return false;
        }

        char[] chars = password.toCharArray();
        for (char c : chars) {

            if (Character.isDigit(c)) {
                return true;
            }
        }

        return false;
    }

    public static boolean containsUpperAndLower(String password) {

        if (password == null) {
            return false;
        }

        boolean bHasUpper = false;
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                bHasUpper = true;
                break;
            }
        }

        boolean bHasLower = false;
        for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c)) {
                bHasLower = true;
                break;
            }
        }

        return bHasLower && bHasUpper;
    }

    public static boolean isCommonPassword(String password) {

        // Locale.Root is for language localisation
        password = password == null ? "" : password.trim().toLowerCase(Locale.ROOT);

        for (String commonPassword : commonPasswords) {
            commonPassword = commonPassword.trim().toLowerCase(Locale.ROOT);
            if (password.equals(commonPassword)) {
                return true;
            }
        }

        return false;
    }

    public static boolean containsSpecialChar(String password, String allowed) {

        if (password == null) {
            return false;
        }

        for (char c : password.toCharArray()) {
            if (!Character.isLetterOrDigit(c)) {
                for (char c2 : allowed.toCharArray()) {
                    if (c == c2) {
                        return true;
                    }
                }
            }
        }

        return false;
    }


    public static boolean isValid(String password) {

        if (password == null) {
            UtilsLibrary.printText(1,"no input", 1);
            return false;
        }

        if (!hasMinLength(password, 8)){
            UtilsLibrary.printText(1,"Passwort ist zu kurz! Mindestens 8 Zeichen!", 1);
            return false;
        }

        if (!containsDigit(password)) {
            UtilsLibrary.printText(1,"Passwort enthält keine Zahl!", 1);
            return false;
        }

        if(!containsUpperAndLower(password)) {
            UtilsLibrary.printText(1,"Passwort muss Groß- und Kleinbuchstaben enthalten!", 1);
            return false;
        }

        if (!containsSpecialChar(password, specialChars)) {
            UtilsLibrary.printText(1,"Passwort muss mindestens einen der folgenden Zeichen enthalten: " + specialChars, 1);
            return false;
        }

        if (isCommonPassword(password)) {
            UtilsLibrary.printText(1,"Passwort ist zu einfach", 1);
            return false;
        }

        return true;
    }
}
