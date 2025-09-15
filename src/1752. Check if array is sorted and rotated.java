class Solution {
    public boolean check(int[] nums) {
        int rotationPoints = 0;
        for(int i=1;i<nums.length;i++){
            if(nums[i] >= nums[i-1]){
                continue;
            } else{
                rotationPoints++;
            }
        }
        if(nums[nums.length-1] > nums[0]){
            rotationPoints++;
        }
        return (rotationPoints< 2);
    }
}