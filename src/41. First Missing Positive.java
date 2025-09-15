import java.util.HashSet;

class Solution {
    public int firstMissingPositive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int i=1;
        while(i < Integer.MAX_VALUE) {
            if (!set.contains(i)) {
                return i;
            }
            i++;
        }
        return i + 1;
    }
}