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
