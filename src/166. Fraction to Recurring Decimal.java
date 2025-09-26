import java.util.HashMap;

class Solution {
    public static String fractionToDecimal(int numerator, int denominator) {
       if(numerator == 0){
        return "0";
       }
       StringBuilder fraction = new StringBuilder();
       if(numerator < 0 ^ denominator < 0){
        fraction.append("-");
       }
       long dividend = Math.abs(Long.valueOf(numerator));
       long divisor = Math.abs(Long.valueOf(denominator));
       fraction.append(dividend/divisor);
       long remainder = dividend % divisor;
       if(remainder == 0){
        return fraction.toString();
       }
       fraction.append(".");
       HashMap<Long, Integer> remainderMap = new HashMap<>();
       while(remainder != 0){
        if(remainderMap.containsKey(remainder)){
            fraction.insert(remainderMap.get(remainder), "(");
            fraction.append(")");
        }
        remainderMap.put(remainder, fraction.length());
        remainder *= 10;
        fraction.append(remainder / divisor);
        remainder %= divisor;
       }
       return fraction.toString();
    }
}