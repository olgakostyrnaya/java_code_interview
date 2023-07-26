public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int zeroRewritePos = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[zeroRewritePos];
                nums[zeroRewritePos] = temp;
                zeroRewritePos++;
            }
        }
    }
}