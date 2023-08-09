# valid-parentheses.md

+ [valid-parentheses](#valid-parentheses)

## valid-parentheses

https://leetcode.com/problems/valid-parentheses/

## Размышления
    Запишем в мапу соответствия закрывающей и открывающей скобки. Будем идти по строчке посимвольно, 
    если скобка открывающая, сохраняем ее в стек. Если скобка закрывающая - получаем из мапы соответствующую ей открывающую скобку.
    Если в стеке "последняя" скобка не равна открывающей из мапы, значит скобки расставлены некорректно. 
    Если стек пустой, а текущая скобка открывающая - значит скобки расставлены некорректно.
    Если стек пустой, а по всей строке мы уже прошлись - то значит всё корректно.

## Сomplexity

    Time Complexity: O(N) - нужно пройтись по всем символам в строке, в случае если строка содержит корректные скобки
    Memory Complexity: O(N) - ??

<details><summary>Test Cases</summary><blockquote>

``` java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidParenthesesTest {

    private ValidParentheses validParentheses;

    @BeforeEach
    void setUp() {
        validParentheses = new ValidParentheses();
    }


    @Test
    void ifDifferentPairedValidReturnTrue() {
        String s = "()[]{}";

        assertTrue(validParentheses.isValid(s));
    }


    @Test
    void ifDifferentTypesInnerValidReturnTrue() {
        String s = "([{}])";

        assertTrue(validParentheses.isValid(s));
    }

    @Test
    void ifSingleOpeningReturnFalse() {
        String s = "[";

        assertFalse(validParentheses.isValid(s));
    }

    @Test
    void ifStartsWithClosingReturnFalse() {
        String s = "}}}(){}";

        assertFalse(validParentheses.isValid(s));
    }

}
```

</blockquote></details>

``` java
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

    private Map<Character, Character> pairs = new HashMap<Character, Character>();

    ValidParentheses() {
        pairs.put(')', '(');
        pairs.put(']', '[');
        pairs.put('}', '{');
    }

    public boolean isValid(String s) {
        Stack<Character> openings = new Stack<>();

        for (char litera : s.toCharArray()) {
            if (openings.isEmpty() && pairs.containsKey(litera)) {
                return false;
            }
            if (pairs.containsKey(litera)) {
                Character symbol = pairs.get(litera);
                if (!symbol.equals(openings.pop())) {
                    return false;
                }
            } else {
                openings.push(litera);
            }
        }

        if (!openings.isEmpty()) {
            return false;
        }

        return true;
    }
}
```