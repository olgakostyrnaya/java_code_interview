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
