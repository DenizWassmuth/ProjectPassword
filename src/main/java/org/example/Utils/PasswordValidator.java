package org.example.Utils;

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
 */

public final class PasswordValidator {
    public static boolean hasMinLength(String password, int min) {
        return password.length() >= min;
    }

    public static boolean containsDigit(String password) {

        if (password == null) {
            return false;
        }

        char[] chars = password.toCharArray();
        for (int i = 0; i < chars.length; i++) {

            if (Character.isDigit(chars[i])) {

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
        for (int i = 0; i < password.length(); i++) {
            if (Character.isUpperCase(password.charAt(i))) {
                bHasUpper = true;
                return true;
            }
        }

        boolean bHasLower = false;
        for (int i = 0; i < password.length(); i++) {
            if (Character.isLowerCase(password.charAt(i))) {
                bHasLower = true;
                return true;
            }
        }

        return bHasLower && bHasUpper;
    }


    public static Set<String> commonPasswords = Set.of("Password", "Password1", "Password2", "Password3", "Password4",
            "Password5", "Password6", "Password7", "Password8", "Password9", "Password10", "Password123", "AbCdeF");
    public static boolean isCommonPassword(String password) {

        if (password == null) {
            return false;
        }

        for (String commonPassword : commonPasswords) {
            if (password.trim().toLowerCase().equals(commonPassword.trim().toLowerCase())) {
                return true;
            }
        }

        return false;

    }

    public static boolean containsSpecialChar(String password, String allowed) {

        if (password == null) {
            return false;
        }

        char[] chars = password.toCharArray();

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


    public static String specialChars = "!#-**?<>|&%$=)(";
    public static boolean isValid(String password) {

        if (password == null) {
            UtilsLibrary.printText(1,"no input", 1);
            return false;
        }

        if (!hasMinLength(password, 8)){
            UtilsLibrary.printText(1,"Passwort ist zu kurz!", 1);
            return false;
        }

        if (!containsDigit(password)) {
            UtilsLibrary.printText(1,"Passwort enthält keine Zahl!", 1);
            return false;
        }

        if(!containsUpperAndLower(password)) {
            UtilsLibrary.printText(1,"Passwort muss Groß- und Kleinbuchtsaben enthalten!", 1);
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
