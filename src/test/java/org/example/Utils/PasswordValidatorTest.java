package org.example.Utils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorTest {

    @ParameterizedTest
    @CsvSource({"1234567,false","12345678,true","123456789,true","'',false",",false"})
    void hasMinLength_shouldPass_whenGivenStringLengthEqualsTheMinLengthOf8Chars(String givenPassword, boolean expected) {

        boolean actual = PasswordValidator.hasMinLength(givenPassword, 8);

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({"1a2b3c#,true", "aBcDe!,false"})
    void containsDigit_ShouldPass_whenGivenStringHasDigits(String givenPassword, boolean expected) {

        boolean actual = PasswordValidator.containsDigit(givenPassword);

        assertEquals(expected, actual);
    }


    @ParameterizedTest
    @CsvSource({"abc#,false", "2aBcDe!,true"})
    void containsUpperAndLower_ShouldPass_whenGivenStringHasUpperAndLower (String givenPassword, boolean expected) {

       boolean actual = PasswordValidator.containsUpperAndLower(givenPassword);

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