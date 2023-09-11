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
