import java.util.HashMap;
import java.util.Map;

class Solution {
    public long countBadPairs(int[] nums) {
        long count=0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<nums.length; i++){
            int diff = i-nums[i];
            int goodPairs = map.getOrDefault(diff, 0);
            count += i-goodPairs;
            map.put(diff, goodPairs+1);
        }
        return count;
    }
}