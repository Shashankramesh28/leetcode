import java.util.*;

class Solution {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int maxWindow = 0;
        for(int i=0; i<nums.length-1;i++){
            for(int j=i+1; j<nums.length;j++){
                if (nums[j] - nums[i] == 1) {
                    maxWindow = Math.max(j - i + 1, maxWindow);
                }
            }
        }
        return maxWindow;
    }
}