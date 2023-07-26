# move-zeroes.md

+ [move-zeroes](#move-zeroes)

## move-zeroes

https://leetcode.com/problems/move-zeroes/

## Размышления
    Решение "в лоб": использовать 2 цикла, но TimeComplexity в таком случае будет O(N*N)
    Решение за O(N) - хранить индекс позиции для вставки. Позицей для вставки считаем ту, в которой лежит 0. 
    По умолчанию такая позиция имеет 0 индекс. Идем по массиву исходных данных, если текущий элемент не равен 0, 
    то помешаем его в массив по индексу = позиции для вставки.  А на его место ставим 0. 
    При этом увеличиваем позицию для вставки на 1 и переходим к следующему элементу исходного массива

## Сomplexity
    Time Complexity: O(N) - потому что нужно пройти по массиву символов как минимум один раз
    Memory Complexity: O(1) - т.к. меняем исходный массив, доп память не требуется

<details><summary>Test Cases</summary><blockquote>

``` java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MoveZeroesTest {
    private MoveZeroes moveZeroes;

    @BeforeEach
    void setUp() {
        moveZeroes = new MoveZeroes();
    }

    @Test
    void whenArrayNullOrEmpty() {
        int[] nums = null;
        int[] expected = null;
        moveZeroes.moveZeroes(nums);

        assertArrayEquals(expected, nums);
    }

    @Test
    void whenArrayContainsAllZerosExceptOneElement() {
        int[] nums = {0, -1, 0, 0, 0};
        int[] expected = {-1, 0, 0, 0, 0};
        moveZeroes.moveZeroes(nums);

        assertArrayEquals(expected, nums);
    }


    @Test
    void whenArrayContainsNegativeNumbers() {
        int[] nums = {0, -1, 3, 0, -12};
        int[] expected = {-1, 3, -12, 0, 0};
        moveZeroes.moveZeroes(nums);

        assertArrayEquals(expected, nums);
    }
}
```

</blockquote></details>

``` java
public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int zeroRewritePos = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[zeroRewritePos];
                nums[zeroRewritePos] = temp;
                zeroRewritePos++;
            }
        }
    }
}
```