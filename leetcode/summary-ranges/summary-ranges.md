# summary-ranges.md

+ [summary-ranges](#summary-ranges)

## summary-ranges

https://leetcode.com/problems/summary-ranges/

## Размышления
    Мы знаем, что последовательность отсортирована, разбивать ее на интервалы нужно, если числовой ряд прерывается
    Что будем делать:
    Cоздаем 3 индекса - левого элемента интервала и правого элемента интервала и текущий
    индекс левого элемента это индекс чтения по последовательности
    идем циклом while пока модуль разницы = 1 между текущим элементом и правым
    когда вышли из цикла проверяем что левый индекс больше правого. Если нет - значит диапазон из одного элемента, если да - нужно взять элемент из последовательности по левому индексу и склеить со знаком «->» и элементом правого индекса

## Сomplexity

    Time Complexity: O(N) - массив отсортирован, но прийтись нужно по каждому элементу минимум 1 раз
    Memory Complexity: O(N) - вернуть надо новый массив другого типа поэтому также зависим от количества элементов


<details><summary>Test Cases</summary><blockquote>

``` java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SummaryRangerTest {

    private SummaryRanger summaryRanger;

    @BeforeEach
    void setUp() {
        summaryRanger = new SummaryRanger();
    }

    @Test
    void whenNullReturnNull() {
        int[] nums = null;
        List<String> expected = null;

        assertEquals(expected, summaryRanger.summaryRanges(nums));
    }

    @Test
    void whenEmptyReturnEmpty() {
        int[] nums = new int[0];
        List<String> expected = new ArrayList<String>();

        assertEquals(expected, summaryRanger.summaryRanges(nums));
    }

    @Test
    void whenInterruptedNumsReturnRanges() {
        List<String> expected = new ArrayList<>();
        expected.add("0");
        expected.add("2->5");
        expected.add("7");
        expected.add("9");
        int[] nums = {0, 2, 3, 4, 5, 7, 9};
        List<String> actual = summaryRanger.summaryRanges(nums);

        assertEquals(expected, actual);
    }

    @Test
    void whenNumsContainNegativeNumbers() {
        List<String> expected = new ArrayList<>();
        expected.add("-9->-7");
        expected.add("-5->-4");
        expected.add("0->2");
        expected.add("4->5");
        int[] nums = {-9, -8, -7, -5, -4, 0, 1, 2, 4, 5};
        List<String> actual = summaryRanger.summaryRanges(nums);

        assertEquals(expected, actual);
    }

    @Test
    void whenNegativeAndPositiveNumberReturnTwoIntervals() {
        List<String> expected = new ArrayList<>();
        expected.add("-2");
        expected.add("3");
        int[] nums = {-2, 3};

        assertEquals(expected, summaryRanger.summaryRanges(nums));
    }
}

```

</blockquote></details>

``` java
import java.util.ArrayList;
import java.util.List;


public class SummaryRanger {
    public List<String> summaryRanges(int[] nums) {
        if (nums == null) {
            return null;
        }
        if (nums.length < 1) {
            return new ArrayList<String>();
        }

        if (nums.length == 1) {
            List<String> result = new ArrayList<String>();
            result.add(String.valueOf(nums[0]));

            return result;
        }

        List<String> result = new ArrayList<String>();
        int leftIndex = 0;
        int rightIndex = 1;
        int cur = 0;

        while (rightIndex <= nums.length) {
            leftIndex = cur;

            while (rightIndex < nums.length && Math.abs(nums[rightIndex] - nums[cur]) == 1) {
                cur++;
                rightIndex++;
            }

            if (rightIndex - leftIndex == 1) {
                result.add(String.valueOf(nums[leftIndex]));
            } else {
                result.add(nums[leftIndex] + "->" + nums[cur]);
            }

            cur++;
            rightIndex++;
        }

        return result;
    }
}
```