
class MaxAverageSubarray {

    public double findMaxAverage(int[] nums, int k) {
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
}