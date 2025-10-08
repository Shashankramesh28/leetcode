import java.util.Arrays;

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] res = new int[spells.length];
        for(int i=0; i<spells.length;i++){
            int index = leastIndex(potions, spells[i], success);
            if(index != -1){
                res[i] = potions.length - index;
            }
        }
        return res;
    }

    private int leastIndex(int[] potions, int strength, long success){
        int start = 0, end = potions.length;
        while(start<end){
            int mid = (start+end) >>> 1;
            if((long) potions[mid]*strength < success){
                start = mid+1;
            }else{
                end = mid;
            }
        }
        return start;
    }
}