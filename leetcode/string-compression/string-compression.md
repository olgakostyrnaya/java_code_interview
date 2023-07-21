# string-compression.md

+ [string-compression](#string-compression)

## string-compression

https://leetcode.com/problems/string-compression/

## Размышления
    у нас 2 указателя: индекс для записи, индекс для чтения
    берем элемент массива (индекс чтения)
    считаем сколько раз он встречался (счётчик)
    записываем символ по индексу записи
    записываем значение счетчика как массив по индексу записи
    увеличиваем индекс чтения
    когда весь массив прочитан - возвращаем индекс записи

## Сomplexity

    Time Complexity: O(N) - потому что нужно пройти по массиву символов как минимум один раз
    Memory Complexity: O(1) - т.к. меняем исходный массив, доп память не требуется

<details><summary>Test Cases</summary><blockquote>

``` java
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
```

</blockquote></details>

``` java
import java.util.Arrays;

public class StringCompressor {

    public StringCompressor() {
    };

    public static int compress(char[] chars) {
        if (chars == null || chars.length == 0) {
            return 0;
        }

        char element;
        int writePos = 0;
        int counter = 0;
        int readPos = 0;
        while (readPos < chars.length) {
            element = chars[readPos];
            while (counter < chars.length && readPos < chars.length && element == chars[readPos]) {
                readPos++;
                counter++;
            }

            chars[writePos++] = element;

            if (counter > 1) {
                for (char c : String.valueOf(counter).toCharArray()) {
                    chars[writePos++] = c;
                }
            }
            counter = 0;
        }

        return writePos;
    }
}
```