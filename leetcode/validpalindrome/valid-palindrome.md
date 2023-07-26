# valid-palindrome.md

+ [valid-palindrome](#valid-palindrome)

## valid-palindrome

https://leetcode.com/problems/valid-palindrome/

## Размышления
    Предподготавливаем исходную строку с помощью регулярки и toLowerCase(). 
    Используем два указателя: один с конца, один - с начала исходной строки. 
    Если символы по указателям отличаются - false. Если успешно прошли до середины списка, то возвращаем - true.
    Предподготовка строки - узкое место решения, требуется память и количество операций. Можно было заюзать Character.isLetterOrDigit
    

## Сomplexity
    Time Complexity: O(N) - ?
    Memory Complexity: O(N) - ?

<details><summary>Test Cases</summary><blockquote>

``` java
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
```

</blockquote></details>

``` java
public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        s = prepareInputString(s);

        int j = s.length() - 1;
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            j--;
        }

        return true;
    }

    public String prepareInputString(String s) {
        s = removeNonAlphaNumericSymbols(s);
        return s.toLowerCase();
    }

    public String removeNonAlphaNumericSymbols(String s) {
        return s.replaceAll("[^a-zA-Z0-9]", "");
    }
}
```