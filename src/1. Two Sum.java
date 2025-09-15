import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int val = target-nums[i];
            if(numMap.containsKey(val) && numMap.get(val) != i){
                return new int[] {i, numMap.get(val)};
            }
            numMap.put(nums[i], i);
        }
        return null;
    }
}