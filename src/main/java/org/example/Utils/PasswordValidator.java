package org.example.Utils;

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

    public static boolean hasMinLength(String password, int min){
        return password.length() >= min;
    };

    public static boolean containsDigit(String password){

        if (password == null) { return false; }

        char[] chars = password.toCharArray();
        for(int i = 0; i < chars.length; i++){

            if (Character.isDigit(chars[i])) {

                return true;
            }
        }

        return false;
    };
//    public static boolean containsUpperAndLower(String password);
//    public static boolean isCommonPassword(String password); // kleine interne Liste
//
//    // Bonus:
//    public static boolean containsSpecialChar(String password, String allowed);
//
//    // Optionale Gesamtsicht:
//    public static boolean isValid(String password); // nutzt die obenstehenden Checks
}
