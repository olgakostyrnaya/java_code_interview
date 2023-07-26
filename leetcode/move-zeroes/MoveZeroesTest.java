import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MoveZeroesTest {
    private MoveZeroes moveZeroes;

    @BeforeEach
    void setUp() {
        moveZeroes = new MoveZeroes();
    }

    @Test
    void whenArrayNullOrEmpty() {
        int[] nums = null;
        int[] expected = null;
        moveZeroes.moveZeroes(nums);

        assertArrayEquals(expected, nums);
    }

    @Test
    void whenArrayContainsAllZerosExceptOneElement() {
        int[] nums = {0, -1, 0, 0, 0};
        int[] expected = {-1, 0, 0, 0, 0};
        moveZeroes.moveZeroes(nums);

        assertArrayEquals(expected, nums);
    }


    @Test
    void whenArrayContainsNegativeNumbers() {
        int[] nums = {0, -1, 3, 0, -12};
        int[] expected = {-1, 3, -12, 0, 0};
        moveZeroes.moveZeroes(nums);

        assertArrayEquals(expected, nums);
    }
}