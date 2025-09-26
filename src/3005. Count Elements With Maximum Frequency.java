import java.util.HashMap;

class Solution {
    public static int maxFrequencyElements(int[] nums) {
        int maxFreq = Integer.MIN_VALUE, res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num:nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }
        for(int num : map.keySet()){
            int val = map.get(num);
            if(val>maxFreq){
                res = val;
                maxFreq = val;
            } else if(val == maxFreq){
                res+= val;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        
    }
}