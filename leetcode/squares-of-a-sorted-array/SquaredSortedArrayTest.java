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
