# maximum-average-subarray.md

+ [maximum-average-subarray-i](#maximum-average-subarray-i)

## maximum-average-subarray-i

https://leetcode.com/problems/maximum-average-subarray-i/

## Размышления
    Straightforward solution: идти по массиву, складывать по k элементов, если сумма больше предыщущей, 
    то обновляем максимальное значение суммы.
    Максимальное значение суммы приводим к double и делим на k.

    Optimal solution: "sliding window": можем избавится от внутреннего цикла внутри straightforward решения, 
    если не будем подсчитывать сумму каждый раз отдельно для k элементов, а будем сдвигать окошко суммирования.
    Чтобы получить сумму элементов следующего окна - нужно вычесть самый левый элемент от начала окна и прибавить самый правый.
    

## Сomplexity
    Straightforward solution: 
    Time Complexity: O(N*K)
    Memory Complexity: O(1), т.к. при увеличении массива доп память не потребуется
    Optimal solution: 
    Time Complexity: O(N), т.к. нет внутреннего цикла, проходимся 1 раз по исходному массиву.
    Memory Complexity: O(1), т.к. при увеличении массива доп память не потребуется

<details><summary>Test Cases</summary><blockquote>

``` java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaxAverageSubarrayTest {

    private MaxAverageSubarray maxAverageSubarray;

    @BeforeEach
    void setUp() {
        maxAverageSubarray = new MaxAverageSubarray();
    }

    @Test
    void test() {
        int[] nums = {1,12,-5,-6,50,3};
        int k = 4;
        double expected = (double) (12 - 5 - 6 + 50)/ k;
        assertEquals(expected, maxAverageSubarray.findMaxAverage(nums, k));
    }
}
```

</blockquote></details>

``` java
 public static double findMaxAverage(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int left = 0;
        int sum = 0;

        for (int right  = 0; right < nums.length; right++) {
            sum += nums[right];
            if (right >= k-1) {
                max = Math.max(max, sum);
                sum -= nums[left];
                left++;
            }
        }

        return (double) max/k;
    }

    public double findMaxAverageNonOptimal(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int currentIndex = 0;
        int firstIndex = 0;
        int lastIndex = k;
        int sum;

        while (lastIndex <= nums.length) {
            sum = 0;
            while (currentIndex<lastIndex) {
                sum = sum + nums[currentIndex++];
            }
            if (sum > max) {
                max = sum;
            }
            lastIndex++;
            currentIndex = ++firstIndex;
        }

        return (double) max/k;
    }
```