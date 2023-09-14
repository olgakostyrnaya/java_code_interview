# maximum-product.md

+ [maximum-product-of-three-numbers](#maximum-product-of-three-numbers)

## maximum-product-of-three-numbers

https://leetcode.com/problems/maximum-product-of-three-numbers/

## Размышления
    Т.к. отрицательные два отрицательных числа дают при умножении положительное число, 
    нужно учесть их при поиске максимального произведения 3 чисел. 
    Максимумом из массива будет либо: 
    1. произведение 3 максимальных положительных чисел
    2. произведение 2 минимальных (отрицательных чисел) на самое масимальное положительное
    Таким образом, нужно найти 3 максимума и 2 минимума в исходном массиве.
    Чтобы значения точно перезаписались переменные для минимумов инициализируем максимальным числом, 
    а для максимумов - минимальным числом.
    

## Сomplexity
    Time Complexity: O(N), т.к. нужно будет пройтись по массиву как минимум 1 раз.
    Memory Complexity: O(1), т.к. при увеличении массива доп память не потребуется

<details><summary>Test Cases</summary><blockquote>

``` java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaximumProductTest {

    private MaximumProduct maximumProduct;

    @BeforeEach
    void setUp() {
        maximumProduct = new MaximumProduct();
    }

    @Test
    void ifOnlyPositiveNumbersReturnProductsOfMaxs() {
        int[] nums = {2, 15, 3, 1, 4, 20};
        assertEquals(maximumProduct.maximumProduct(nums), 20*15*4);
    }

    @Test
    void ifNegativeNumbersAbsMoreThan2MaxValuesReturnProductsOfMins() {
        int[] nums = {-42, -15, 3, 1, 4, 20, 10};
        int expected = -42 * -15 * 20;
        assertEquals(expected, maximumProduct.maximumProduct(nums) );
    }
}
```

</blockquote></details>

``` java
import java.util.*;

class MaximumProduct {

    public int maximumProduct(int[] nums) {
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;

        for (int n : nums) {
            if (n < min1) {
                min2 = min1;
                min1 = n;
            } else if (n < min2) {
                min2 = n;
            }
            if (n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (n > max2) {
                max3 = max2;
                max2 = n;
            } else if (n > max3) {
                max3 = n;
            }
        }

        return Math.max(max1 * max2 * max3, min1 * min2 * max1);
    }
}
}
```