package org.example.Utils;

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

public class UtilsLibrary {

   public static void printText(String text, int linesBefore, int linesAfter){

        char[] before = new char[linesBefore];
        if (before.length > 0) {
            for (int i = 0; i < before.length; i++) {
                before[i] = '\n';
            }
        }

        char[] after = new char[linesAfter];
        if (after.length > 0) {
            for (int i = 0; i < after.length; i++) {
                after[i] = '\n';
            }
        }

        System.out.println(before + text + after);
    }

}
