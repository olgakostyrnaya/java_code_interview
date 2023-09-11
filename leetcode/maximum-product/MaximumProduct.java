import java.util.*;

class MaximumProduct {

    public int maximumProduct(int[] nums) {
        //чтобы значения точно перезаписались переменные для минимумов инициализируем максимальным числом
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        //чтобы значения точно перезаписались переменные для максимумов инициализируем минимальным числом
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