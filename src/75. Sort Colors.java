import java.util.HashMap;

class Solution {
    public void sortColors(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }
        int ind = 0;
        for(int num=0;num<3;num++){
            if(map.containsKey(num)){
                for(int j=0;j<map.get(num);j++){
                nums[ind] = num;
                ind++;
            }
            }
        }
    }
}