class Solution{
    public static int maxSubArray(int[] nums){
        int maxSum = nums[0];
        int tempSum = nums[0];
        for(int i=1; i<nums.length; i++){
            tempSum = Math.max(nums[i], tempSum + nums[i]);
            maxSum = Math.max(maxSum, tempSum);
        }
        return maxSum;
    }
}