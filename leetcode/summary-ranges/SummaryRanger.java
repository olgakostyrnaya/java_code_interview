import java.util.ArrayList;
import java.util.List;


public class SummaryRanger {
    public List<String> summaryRanges(int[] nums) {
        if (nums == null) {
            return null;
        }
        if (nums.length < 1) {
            return new ArrayList<String>();
        }

        if (nums.length == 1) {
            List<String> result = new ArrayList<String>();
            result.add(String.valueOf(nums[0]));

            return result;
        }

        List<String> result = new ArrayList<String>();
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
}