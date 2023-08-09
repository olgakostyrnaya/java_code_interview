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
        String s = "{";

        assertFalse(validParentheses.isValid(s));
    }

    @Test
    void ifStartsWithClosingReturnFalse() {
        String s = "}}}(){}";

        assertFalse(validParentheses.isValid(s));
    }

}
