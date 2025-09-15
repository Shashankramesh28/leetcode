import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        Arrays.sort(nums);
        List<List<Integer>> sol = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1, k = nums.length - 1;
            if (i > 0 && (nums[i] == nums[i - 1] || nums[i] > 0)) {
                continue;
            }

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum > 0) {
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    sol.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    while (nums[j] == nums[j - 1] && j < k) {
                        j++;
                    }
                }
            }
        }
        return sol;
    }
}