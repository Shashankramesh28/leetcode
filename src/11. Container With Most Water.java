class Solution {
    public int maxArea(int[] height) {
        int maxVol = 0;
        int i = 0, j = height.length - 1;
        while (j > i) {
            int length = j - i, breadth = Math.min(height[i], height[j]);
            maxVol = Math.max(maxVol, length * breadth);
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return maxVol;
    }
}