# squares-of-a-sorted-array.md

+ [squares-of-a-sorted-array](#squares-of-a-sorted-array)

## squares-of-a-sorted-array

https://leetcode.com/problems/squares-of-a-sorted-array

## Размышления
    Неоптимальное решение: идем по массиву с последнего элемента до первого элемента, содержащего отрицательное значение. 
    Возводим в квадрат каждый элемент, по которому проходимся. Когда начинаем возводить в квадрат отрицательный числа, 
    используем сортировку пузырьком для размещения элемента в соответствующую позицию. 
    Плюсы: не используем доп память для хранения массива. Минусы: сложность по времени получается порядка O(NlogN)

    Оптимальное решение:
    Создаем пустой массив такого же размера, как исходный. Будем записывать в него элементы начиная с "хвоста" - index.
    Создаем два указателя left и right. 
    Пока left меньше, чем right, записываем по index элемент квадрат, которого больше и сдвигаем соответвующий указатель.

## Сomplexity
    Time Complexity: O(N) - проходим по массиву один раз
    Memory Complexity: O(N+N) - т.к. создаем массив для вывода результата

<details><summary>Test Cases</summary><blockquote>

``` java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class SquaredSortedArrayTest {
    private SquaredSortedArray squaredSortedArray;

    @BeforeEach
    void setUp() {
        squaredSortedArray = new SquaredSortedArray();
    }

    @Test
    void whenNullReturnNull() {
        assertNull(squaredSortedArray.sortedSquares(null));
    }

    @Test
    void whenEmptyReturnEmpty() {
        int[] nums = {};
        assertArrayEquals(nums,squaredSortedArray.sortedSquares(nums));
    }


    @Test
    void whenArrayDontHaveNegativeNumbers() {
        int[] nums = {0,2,5,7};
        int[] expected = {0,4,25,49};

        assertArrayEquals(expected, squaredSortedArray.sortedSquares(nums));
    }

    @Test
    void whenArrayContainsNegativeNumbers() {
        int[] nums = {-4,-1,0,3,10};
        int[] expected = {0, 1, 9, 16, 100};

        assertArrayEquals(expected, squaredSortedArray.sortedSquares(nums));
    }
 }
```

</blockquote></details>

``` java
public class SquaredSortedArray {

    public int[] sortedSquares(int[] nums) {
        if (nums == null || nums.length < 1) {
            return nums;
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] >= 0) {
                nums[i] = nums[i] * nums[i];
            } else {
                int j = i + 1;
                int tempIndex = i;
                nums[i] = nums[i] * nums[i];
                while (j < nums.length && i < nums.length && nums[i] > nums[j]) {
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                    j++;
                    i++;
                }
                i = tempIndex;
            }
        }

        return nums;
    }

    public int[] sortedSquaresOptimized(int[] nums) {
        if (nums == null || nums.length < 1) {
            return nums;
        }

        int[] result = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        int index = nums.length - 1;
        while (left < right) {
            if (nums[left]*nums[left] > nums[right]*nums[right]) {
                result[index] = nums[left] * nums[left];
                left++;
            } else {
                result[index] = nums[right] * nums[right];
                right--;
            }
            index--;
        }
}
```