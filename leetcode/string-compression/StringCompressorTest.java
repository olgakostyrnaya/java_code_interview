import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringCompressorTest {
    private StringCompressor stringCompressor;

    @BeforeEach
    void setUp() {
        stringCompressor = new StringCompressor();
    }

    @Test
    void whenNullReturnZero() {
        int expected = 0;
        assertEquals(expected, stringCompressor.compress(null));
    }

    @Test
    void whenEmptyReturnZero() {
        int expected = 0;
        assertEquals(expected, stringCompressor.compress(new char[0]));
    }

    @Test
    void whenSingleCharReturnCharWithoutCount() {
        int expected = 1;
        char[] chars = {'a'};
        assertEquals(expected, stringCompressor.compress(chars));
    }

    @Test
    void compressWhenHaveRepeatableChars() {
        char [] chars = {'a','a','b','b','c','c','c'};
        int expected = 6;
        assertEquals(expected, stringCompressor.compress(chars));
    }

    @Test
    void compressWhenDoNotHaveRepeatableChars() {
        char [] chars = {'a', 'b', 'a', 'c', 'b'};
        int expected = 5;
        assertEquals(expected, stringCompressor.compress(chars));
    }

    @Test
    void compressWhenOneSingleCharAndManyTimesSecondChar() {
        char [] chars = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        int expected = 4;
        assertEquals(expected, stringCompressor.compress(chars));
    }

    @Test
    void compressCharIsDigit() {
        char [] chars = {1,2,3,3,3,0};
        int expected = 5;
        assertEquals(expected, stringCompressor.compress(chars));
    }
}
