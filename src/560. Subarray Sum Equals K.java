import java.util.HashMap;

class Solution {
    public int subarraySum(int[] nums, int k) {
        int[] prefixSum = new int[nums.length];
        int count = 0;
        prefixSum[0] = nums[0];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] += prefixSum[i - 1] + nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            if (prefixSum[i] == k) {
                count++;
            }
            int val = prefixSum[i] - k;
            if (map.containsKey(val)) {
                count += map.get(val);
            }
            map.put(prefixSum[i], map.getOrDefault(prefixSum[i], 0) + 1);
        }
        return count;
    }
}