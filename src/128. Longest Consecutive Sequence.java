import java.util.HashSet;

class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int count = 0, temp = 1;
        for (int curVal : nums) {
            if (!set.contains(curVal - 1)) {
                int num = curVal;
                while (set.contains(++num)) {
                    set.remove(num);
                    temp++;
                }
                count = Math.max(count, temp);
                temp = 1;
            }
        }
        return count;
    }
}