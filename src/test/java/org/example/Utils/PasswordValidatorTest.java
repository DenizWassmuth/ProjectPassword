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
    @CsvSource({"1a2b3c#,true","aBcDe!,false"})
    void containsDigit_ShouldPass_whenGivenStringHasDigits(String givenPassword, boolean expected) {

        boolean actual = PasswordValidator.containsDigit(givenPassword);

        assertEquals(expected, actual);
    }


    @ParameterizedTest
    @CsvSource({"abc#,false","2aBcDe!,true"})
    void containsUpperAndLower_ShouldPass_whenGivenStringHasUpperAndLower(String givenPassword, boolean expected) {

       boolean actual = PasswordValidator.containsUpperAndLower(givenPassword);

        assertEquals(expected, actual);
    }


    @ParameterizedTest
    @CsvSource({"abc#,false","Password,true","Password1,true","Password2,true","blubberBlubber,false" })
    void isCommonPassword_shouldPass_whenGivenStringIsPartOfList (String givenPassword, boolean expected) {

        boolean actual = PasswordValidator.isCommonPassword(givenPassword);

        assertEquals(expected, actual);
    }


    @ParameterizedTest
    @CsvSource({"abcDEF123,false","#Password25!,true","Password1%,true","Pa??word20,true","blubber00Blubber,false" })
    void containsSpecialChar_ShouldPass_whenGivenStringContainsAnyOfTheAllowedSpecialChars (String givenPassword, boolean expected) {

        boolean actual = PasswordValidator.containsSpecialChar(givenPassword, PasswordValidator.specialChars);

        assertEquals(expected, actual);
    }


    @ParameterizedTest
    @CsvSource({"abcDEF123,false","#Password25!,true","Password1%,true","Pa??word20,true","bl0B%er,false" })
    void isValid_shouldPass_whenGivenStringIsNotNullHas8DigitsUpperAndLowerSpecialCharsIsNotCommonPassword(String givenPassword, boolean expected) {

        boolean actual = PasswordValidator.isValid(givenPassword);

        assertEquals(expected, actual);
    }
}