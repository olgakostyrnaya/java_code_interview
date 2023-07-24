# two-sum.md

+ [two-sum](#two-sum)

## two-sum

https://leetcode.com/problems/two-sum/

## Размышления
    Берем первый элемент исходного массива. Вычитаем его из target и проверяем есть ли значение в мапе
    (ключ - значение элемента исходного массива, значение - индекс элемента исходного массива). 
    Если такое число есть в мапе - берем его индекс из мапы по ключу и возвращаем вместе с индексом текущего элемента.
    Если значение не найдено - добавляем в мапу текущий элемент исходного массива и переходим к следующему элементу исходного массива.
    Если target не был найден - записываем     

## Сomplexity

    Time Complexity: O(N) - нужно пройтись по всем элементам исходного массива. Остается вопрос: Какая Big O для выборки из хэшмапы?
    Memory Complexity: O(N) - т.к. используем доп структуру, то и количество памяти зависит от количества элементов

<details><summary>Test Cases</summary><blockquote>

``` java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TwoSumFinderTest {

    private TwoSumFinder twoSumFinder;

    @BeforeEach
    void setUp() {
        twoSumFinder = new TwoSumFinder();
    }

    @Test
    void ifNullReturnEmpty() {
        int[] nums = null;
        int target = 5;
        int[] expected = new int[]{};
        int[] actual = twoSumFinder.twoSum(nums, target);

        assertArrayEquals(expected, actual);
    }

    @Test
    void ifTargetNotFoundReturnEmpty() {
        int[] nums = {1, 12, 5, 2};
        int target = 4;
        int[] expected = new int[]{};
        int[] actual = twoSumFinder.twoSum(nums, target);

        assertArrayEquals(expected, actual);
    }

    @Test
    void ifContainsNegativeNumbersFindTarget() {
        int[] nums = {-8, -5, 3, 0, 14};
        int target = 6;
        int[] expected = {0, 4};
        int[] actual = twoSumFinder.twoSum(nums, target);

        assertArrayEquals(expected, actual);
    }

    @Test
    void ifContainsDoubleElementReturnDifferentIndex() {
        int[] nums = {2, 3, 0, 3};
        int target = 6;
        int[] expected = {1, 3};
        int[] actual = twoSumFinder.twoSum(nums, target);

        assertArrayEquals(expected, actual);
    }
}
```

</blockquote></details>

``` java
import java.util.HashMap;
import java.util.Map;

public class TwoSumFinder {

    public int[] twoSum(int[] nums, int target) {
        if (nums == null) {
            return new int[]{};
        }

        Map<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            Integer complement = target - nums[i];
            if (hashMap.containsKey(complement)) {
                return new int[] {hashMap.get(complement), i};
            } else {
                hashMap.put(nums[i], i);
            }
        }

        return new int[]{};
    }
}
```