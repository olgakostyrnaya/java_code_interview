import java.util.ArrayList;
import java.util.List;


public class SummaryRanger {
    public List<String> summaryRanges(int[] nums) {
        if (nums == null) {
            return null;
        }
        ArrayList<String> result = new ArrayList<>();
        if (nums.length < 1) {
            return result;
        }

        if (nums.length == 1) {
            result.add(String.valueOf(nums[0]));

            return result;
        }

        int leftIndex = 0;
        int rightIndex = 1;
        int cur = 0;

        while (rightIndex <= nums.length) {
            leftIndex = cur;

            while (rightIndex < nums.length && Math.abs(nums[rightIndex] - nums[cur]) == 1) {
                cur++;
                rightIndex++;
            }

            if (rightIndex - leftIndex == 1) {
                result.add(String.valueOf(nums[leftIndex]));
            } else {
                result.add(nums[leftIndex] + "->" + nums[cur]);
            }

            cur++;
            rightIndex++;
        }

        return result;
    }

        public List<String> summaryRangesOptimized(int[] nums) {
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            final int begin = nums[i];
            while (i + 1 < nums.length && nums[i] == nums[i + 1] - 1)
                ++i;
            final int end = nums[i];
            if (begin == end)
                ans.add("" + begin);
            else
                ans.add("" + begin + "->" + end);
        }
        return ans;
    }
}