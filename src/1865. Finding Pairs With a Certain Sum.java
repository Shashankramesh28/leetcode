import java.util.*;

class FindSumPairs {

    int[] nums1, nums2;
    Map<Integer, Integer> map;

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        this.map = new HashMap<Integer, Integer>();
        for(int j : nums2){
            this.map.put(j, map.getOrDefault(j ,0) + 1 );
        }
    }
    
    public void add(int index, int val) {
        int oldVal = nums2[index];
        this.map.put(oldVal, map.get(oldVal) - 1);
        this.nums2[index] += val;
        this.map.put(nums2[index], map.getOrDefault(nums2[index] ,0) + 1 );
    }
    
    public int count(int tot) {
        int count = 0;
        for(int i : nums1){
            count+=map.getOrDefault(tot-i, 0);
        }
        return count;
    }
}