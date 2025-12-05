package org.example.Utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorTest {

    @Test
    void hasMinLength_shouldPass_whenGivenStringLengthIsGreaterOrEqualTo5 () {

        String givenString = "Hallo";
        boolean expected  = true;

        boolean actual = PasswordValidator.hasMinLength(givenString, 5);

        assertEquals(expected, actual);
    }

    @Test
    void hasMinLength_shouldPass_whenGivenStringLengthIsSmallerThen5 () {

        String givenString = "Hi";
        boolean expected  = true;

        boolean actual = PasswordValidator.hasMinLength(givenString, 5);

        assertNotEquals(expected, actual);
    }

    @Test
    void containsDigit_ShouldPass_whenGivenStringHasDigitAtIndex1 () {

        String givenString = "H4llo";
        boolean expected  = true;

        //boolean actual = Character.isDigit(givenString.toCharArray()[1]);
        boolean actual = PasswordValidator.containsDigit(givenString);

        assertEquals(expected, actual);
    }

    @Test
    void containsDigit_ShouldPass_whenGivenStringHasNoDigit () {

        String givenString = "Hallo";

        boolean expected  = true;

        //boolean actual = Character.isDigit(givenString.toCharArray()[1]);
        boolean actual = PasswordValidator.containsDigit(givenString);

        assertNotEquals(expected, actual);
    }

    @Test
    void containsUpperAndLower_ShouldPass_whenGivenStringHasUpperAtIndex0AndLowerAtIndex1 () {

        String givenString = "Hallo";
        boolean expected  = true;

       boolean actual = Character.isUpperCase(givenString.charAt(0)) && Character.isLowerCase(givenString.charAt(1));

        assertEquals(expected, actual);
    }

    @Test
    void containsUpperAndLower_ShouldPass_whenGivenStringHasOnlyUpper () {

        String givenString = "HALLO";
        boolean expected  = true;

        boolean actual = Character.isUpperCase(givenString.charAt(0)) && Character.isLowerCase(givenString.charAt(1));

        assertNotEquals(expected, actual);
    }

    @Test
    void containsUpperAndLower_ShouldPass_whenGivenStringHasUpperAndLower () {

        String givenString = "Hallo";
        boolean expected  = true;

        boolean actual = PasswordValidator.containsUpperAndLower(givenString);

        assertEquals(expected, actual);
    }

    @Test
    void isCommonPassword_shouldPass_whenGivenStringIsPassword123 () {

        String givenString = "Password123";

        boolean expected  = true;

        boolean actual = givenString.contains("Password123");

        assertEquals(expected, actual);
    }

    @Test
    void isCommonPassword_shouldPass_whenGivenStringIsPartOfList () {

        String givenString = "Password";

        boolean expected  = true;

        boolean actual = PasswordValidator.isCommonPassword(givenString);

        assertEquals(expected, actual);
    }

    @Test
    void isCommonPassword_shouldPass_whenGivenStringIsNotPartOfList () {

        String givenString = "Hallo";

        boolean expected  = false;

        boolean actual = PasswordValidator.isCommonPassword(givenString);

        assertEquals(expected, actual);
    }

    @Test
    void containsSpecialChar_ShouldPass_whenGivenStringContainsSpecialCharHashTagAtIndex0 () {

        String givenString = "#Hallo";

        boolean expected  = false;

        boolean actual = Character.isLetterOrDigit(givenString.charAt(0));

        assertEquals(expected, actual);
    }

    @Test
    void containsSpecialChar_ShouldPass_whenGivenStringContainsNoSpecialAtIndex0 () {

        String givenString = "Hallo";

        boolean expected  = true;

        boolean actual = Character.isLetterOrDigit(givenString.charAt(0));

        assertEquals(expected, actual);
    }

    @Test
    void containsSpecialChar_ShouldPass_whenGivenStringContainsAnyOfTheAllowedSpecialChars () {

        String givenString = "Hallo!";
        String specialChars = "!#*";

        boolean expected  = true;

        boolean actual = PasswordValidator.containsSpecialChar(givenString, specialChars);

        assertEquals(expected, actual);
    }

    @Test
    void containsSpecialChar_ShouldPass_whenGivenStringContainsANoneListedSpecialChar () {

        String givenString = "-Hallo";
        String specialCharsAllowed = "!#*";

        boolean expected  = false;

        boolean actual = PasswordValidator.containsSpecialChar(givenString, specialCharsAllowed);

        assertEquals(expected, actual);
    }


    @Test
    void isValid_shouldPass_whenGivenStringIsNotNullHas8DigitsUpperAndLowerSpecialCharsIsNotCommonPassword () {

        String givenString = "#Hall000";

        boolean expected  = true;

        boolean actual = PasswordValidator.isValid(givenString);

        assertEquals(expected, actual);
    }

    @Test
    void isValid_shouldPass_whenGivenStringHasNoDigit () {

        String givenString = "#Hallooo";

        boolean expected  = false;

        boolean actual = PasswordValidator.isValid(givenString);

        assertEquals(expected, actual);
    }
}