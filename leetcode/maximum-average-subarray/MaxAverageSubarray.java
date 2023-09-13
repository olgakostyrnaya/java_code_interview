
class MaxAverageSubarray {
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

        return new Double (max)/k;
    }
}