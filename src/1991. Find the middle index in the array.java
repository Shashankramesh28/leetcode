class Solution {
    public int findMiddleIndex(int[] arr) {
        if (arr.length == 1) {
            return 0;
        }
        int totalSum = 0;
        for (int i = 0; i < arr.length; i++) {
            totalSum += arr[i];
        }
        int leftSum = 0;
        for (int i = 0; i < arr.length; i++) {
            int rightSum = totalSum - leftSum - arr[i];
            if (rightSum == leftSum) {
                return i;
            } else {
                leftSum += arr[i];
            }
        }
        return -1;
    }
}