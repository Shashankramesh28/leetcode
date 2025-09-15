class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxLength = -1, count = 0;
        for(int num : nums){
            if(num == 1){
                count++;
            }else {
                maxLength = Math.max(maxLength, count);
                count=0;
            }
        }
        maxLength = Math.max(maxLength, count);
        return maxLength;
    }
}