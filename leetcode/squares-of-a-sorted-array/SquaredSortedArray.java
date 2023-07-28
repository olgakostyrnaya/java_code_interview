public class SquaredSortedArray {

    public int[] sortedSquares(int[] nums) {
        if (nums == null || nums.length < 1) {
            return nums;
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] >= 0) {
                nums[i] = nums[i] * nums[i];
            } else {
                int j = i + 1;
                int tempIndex = i;
                nums[i] = nums[i] * nums[i];
                while (j < nums.length && i < nums.length && nums[i] > nums[j]) {
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                    j++;
                    i++;
                }
                i = tempIndex;
            }
        }

        return nums;
    }

    public int[] sortedSquaresOptimized(int[] nums) {
        if (nums == null || nums.length < 1) {
            return nums;
        }

        int[] result = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        int index = nums.length - 1;
        while (left < right) {
            if (nums[left]*nums[left] > nums[right]*nums[right]) {
                result[index] = nums[left] * nums[left];
                left++;
            } else {
                result[index] = nums[right] * nums[right];
                right--;
            }
            index--;
        }
}
