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
