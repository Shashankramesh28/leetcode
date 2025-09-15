class Solution {
    public int findDuplicate(int[] nums) {
        boolean[] visitedNum = new boolean[nums.length];
        for (int n : nums) {
            if (visitedNum[n]) {
                return n;
            } else {
                visitedNum[n] = true;
            }
        }
        return -1;
    }
}