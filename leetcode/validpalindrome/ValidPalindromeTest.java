import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ValidPalindromeTest {
    private ValidPalindrome validPalindrome;

    @BeforeEach
    void setUp() {
        validPalindrome = new ValidPalindrome();
    }

    @Test
    void whenInputStringNullReturnFalse() {
        assertTrue(validPalindrome.isPalindrome(null));
    }

    @Test
    void whenInputStringEmptyReturnFalse() {
        assertTrue(validPalindrome.isPalindrome(""));
    }

    @Test
    void whenInputStringLengthIsOddNumber() {
        String s = "abaKaba";
        assertTrue(validPalindrome.isPalindrome(s));
    }

    @Test
    void whenInputStringLengthIsEvenNumber() {
        String s = "abba";
        assertTrue(validPalindrome.isPalindrome(s));
    }

    @Test
    void nonValidPalindrome() {
        String s = "Ama Lama Lana Ama";
        assertFalse(validPalindrome.isPalindrome(s));
    }

    @Test
    void whenInputStringContainsNonAlplaNumericSymbols() {
        String s = "A man, a plan, a canal: Panama";
        assertTrue(validPalindrome.isPalindrome(s));
    }
}
