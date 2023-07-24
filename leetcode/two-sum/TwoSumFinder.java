import java.util.HashMap;
import java.util.Map;

public class TwoSumFinder {

    public int[] twoSum(int[] nums, int target) {
        if (nums == null) {
            return new int[]{};
        }

        Map<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            Integer complement = target - nums[i];
            if (hashMap.containsKey(complement)) {
                return new int[] {hashMap.get(complement), i};
            } else {
                hashMap.put(nums[i], i);
            }
        }

        return new int[]{};
    }
}
