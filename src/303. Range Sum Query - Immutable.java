class NumArray {
    int[] nums;
    int[] sumArr;

    public NumArray(int[] nums) {
        this.nums = nums;
        sumArr = new int[nums.length];
        int sum = nums[0];
        for (int i = 0; i < nums.length - 1; i++) {
            sumArr[i] = sum;
            sum += nums[i + 1];
        }
        sumArr[nums.length - 1] = sum;
    }

    public int sumRange(int left, int right) {
        if (left == 0) {
            return sumArr[right];
        }
        return sumArr[right] - sumArr[left - 1];
    }
}