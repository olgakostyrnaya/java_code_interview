# subarray-sum-equals-k.md

+ [subarray-sum-equals-k-i](#subarray-sum-equals-k-i)

## subarray-sum-equals-k-i

https://leetcode.com/problems/subarray-sum-equals-k/

## Размышления
    Не очень разобралась
    https://leetcode.com/problems/subarray-sum-equals-k/solutions/803317/java-solution-with-detailed-explanation/    
    

## Сomplexity
    Time Complexity: O(N), т.к. нужно пройтись по всем элементам исходного массива 1 раз.
    Memory Complexity: O(N), but why??  

<details><summary>Test Cases</summary><blockquote>

``` java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SubarraySumKTest {

    private SubarraySumK subarraySumK;

    @BeforeEach
    void setUp() {
        subarraySumK = new SubarraySumK();
    }

    @Test
    void ifUnsortedAndHaveNegativeNumbers() {
        int [] nums = {-4, 5, -2, 17, 1, 0, 3, 12, -17};
        int k = 15;
        int expected = 4;
        assertEquals(expected, subarraySumK.subarraySum(nums, k));
    }

    @Test
    void ifContainNumberWithDifferentSign() {
        int [] nums = {0,1,-1,-1,2};
        int k = 0;
        int expected = 4;
        assertEquals(expected, subarraySumK.subarraySum(nums, k));
    }
}
```

</blockquote></details>

``` java
 import java.util.HashMap;

class SubarraySumK {

    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
```