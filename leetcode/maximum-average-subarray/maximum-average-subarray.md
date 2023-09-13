# maximum-average-subarray.md

+ [maximum-average-subarray-i](#maximum-average-subarray-i)

## maximum-average-subarray-i

https://leetcode.com/problems/maximum-average-subarray-i/

## Размышления
    Straightforward solution: идти по массиву, складывать по k элементов, если сумма больше предыщущей, 
    то обновляем максимальное значение суммы.
    Максимальное значение суммы приводим к double и делим на k.
    

## Сomplexity
    Time Complexity: O(N*K)
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
        assertEquals(maximumProduct.maximumProduct(nums), -42*-15*20);
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